
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 车辆订单
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/cheliangOrder")
public class CheliangOrderController {
    private static final Logger logger = LoggerFactory.getLogger(CheliangOrderController.class);

    @Autowired
    private CheliangOrderService cheliangOrderService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private CheliangService cheliangService;
    @Autowired
    private YonghuService yonghuService;



    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = cheliangOrderService.queryPage(params);

        //字典表数据转换
        List<CheliangOrderView> list =(List<CheliangOrderView>)page.getList();
        for(CheliangOrderView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        CheliangOrderEntity cheliangOrder = cheliangOrderService.selectById(id);
        if(cheliangOrder !=null){
            //entity转view
            CheliangOrderView view = new CheliangOrderView();
            BeanUtils.copyProperties( cheliangOrder , view );//把实体数据重构到view中

                //级联表
                CheliangEntity cheliang = cheliangService.selectById(cheliangOrder.getCheliangId());
                if(cheliang != null){
                    BeanUtils.copyProperties( cheliang , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setCheliangId(cheliang.getId());
                }
                //级联表
                YonghuEntity yonghu = yonghuService.selectById(cheliangOrder.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody CheliangOrderEntity cheliangOrder, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,cheliangOrder:{}",this.getClass().getName(),cheliangOrder.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            cheliangOrder.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        cheliangOrder.setInsertTime(new Date());
        cheliangOrder.setCreateTime(new Date());
        cheliangOrderService.insert(cheliangOrder);
        return R.ok();
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody CheliangOrderEntity cheliangOrder, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,cheliangOrder:{}",this.getClass().getName(),cheliangOrder.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            cheliangOrder.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<CheliangOrderEntity> queryWrapper = new EntityWrapper<CheliangOrderEntity>()
            .eq("id",0)
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        CheliangOrderEntity cheliangOrderEntity = cheliangOrderService.selectOne(queryWrapper);
        if(cheliangOrderEntity==null){
            cheliangOrderService.updateById(cheliangOrder);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        cheliangOrderService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        try {
            List<CheliangOrderEntity> cheliangOrderList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            CheliangOrderEntity cheliangOrderEntity = new CheliangOrderEntity();
//                            cheliangOrderEntity.setCheliangOrderUuidNumber(data.get(0));                    //订单号 要改的
//                            cheliangOrderEntity.setCheliangId(Integer.valueOf(data.get(0)));   //车辆 要改的
//                            cheliangOrderEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            cheliangOrderEntity.setInsertTime(date);//时间
//                            cheliangOrderEntity.setJieshuTime(new Date(data.get(0)));          //结束时间 要改的
//                            cheliangOrderEntity.setXiaoshi(data.get(0));                    //骑行时长(小时) 要改的
//                            cheliangOrderEntity.setZhifuMoney(data.get(0));                    //支付金额 要改的
//                            cheliangOrderEntity.setCheliangOrderTypes(Integer.valueOf(data.get(0)));   //订单类型 要改的
//                            cheliangOrderEntity.setCheliangOrderPaymentTypes(Integer.valueOf(data.get(0)));   //支付类型 要改的
//                            cheliangOrderEntity.setCreateTime(date);//时间
                            cheliangOrderList.add(cheliangOrderEntity);


                            //把要查询是否重复的字段放入map中
                                //订单号
                                if(seachFields.containsKey("cheliangOrderUuidNumber")){
                                    List<String> cheliangOrderUuidNumber = seachFields.get("cheliangOrderUuidNumber");
                                    cheliangOrderUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> cheliangOrderUuidNumber = new ArrayList<>();
                                    cheliangOrderUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("cheliangOrderUuidNumber",cheliangOrderUuidNumber);
                                }
                        }

                        //查询是否重复
                         //订单号
                        List<CheliangOrderEntity> cheliangOrderEntities_cheliangOrderUuidNumber = cheliangOrderService.selectList(new EntityWrapper<CheliangOrderEntity>().in("cheliang_order_uuid_number", seachFields.get("cheliangOrderUuidNumber")));
                        if(cheliangOrderEntities_cheliangOrderUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(CheliangOrderEntity s:cheliangOrderEntities_cheliangOrderUuidNumber){
                                repeatFields.add(s.getCheliangOrderUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [订单号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        cheliangOrderService.insertBatch(cheliangOrderList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }





    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        // 没有指定排序字段就默认id倒序
        if(StringUtil.isEmpty(String.valueOf(params.get("orderBy")))){
            params.put("orderBy","id");
        }
        PageUtils page = cheliangOrderService.queryPage(params);

        //字典表数据转换
        List<CheliangOrderView> list =(List<CheliangOrderView>)page.getList();
        for(CheliangOrderView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段
        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        CheliangOrderEntity cheliangOrder = cheliangOrderService.selectById(id);
            if(cheliangOrder !=null){


                //entity转view
                CheliangOrderView view = new CheliangOrderView();
                BeanUtils.copyProperties( cheliangOrder , view );//把实体数据重构到view中

                //级联表
                    CheliangEntity cheliang = cheliangService.selectById(cheliangOrder.getCheliangId());
                if(cheliang != null){
                    BeanUtils.copyProperties( cheliang , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setCheliangId(cheliang.getId());
                }
                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(cheliangOrder.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody CheliangOrderEntity cheliangOrder, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,cheliangOrder:{}",this.getClass().getName(),cheliangOrder.toString());
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if("用户".equals(role)){
            CheliangEntity cheliangEntity = cheliangService.selectById(cheliangOrder.getCheliangId());
            if(cheliangEntity == null){
                return R.error(511,"查不到该车辆");
            }
            // Double cheliangNewMoney = cheliangEntity.getCheliangNewMoney();

            if(false){
            }
            else if(cheliangEntity.getCheliangNewMoney() == null){
                return R.error(511,"车辆价格不能为空");
            }

            YonghuEntity yonghuEntity = yonghuService.selectById(cheliangOrder.getYonghuId());
            if(yonghuEntity == null)
                return R.error(511,"用户不能为空");
            if(yonghuEntity.getNewMoney() == null)
                return R.error(511,"用户金额不能为空");
            double balance = yonghuEntity.getNewMoney() - 100;//余额
            if(balance<0)
                return R.error(511,"余额不够100,请充值后再租用车辆");

            cheliangOrder.setCheliangOrderUuidNumber(String.valueOf(new Date().getTime()));
            cheliangOrder.setInsertTime(new Date());
            cheliangOrder.setCheliangOrderPaymentTypes(1);
            cheliangOrder.setCheliangOrderTypes(1);
            cheliangOrder.setCreateTime(new Date());
            cheliangOrderService.insert(cheliangOrder);//新增订单


            cheliangEntity.setZuyongTypes(2);
            cheliangService.updateById(cheliangEntity);

            return R.ok();
        }else{
            return R.error(511,"您没有权限支付订单");
        }
    }



    /**
     * 还车
     */
    @RequestMapping("/huanche")
    public R huanche(@RequestBody CheliangOrderEntity cheliangOrder, HttpServletRequest request){
        logger.debug("huanche方法:,,Controller:{},,cheliangOrder:{}",this.getClass().getName(),cheliangOrder.toString());
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if("用户".equals(role)){
            cheliangOrder = cheliangOrderService.selectById(cheliangOrder.getId());
            CheliangEntity cheliangEntity = cheliangService.selectById(cheliangOrder.getCheliangId());
            if(cheliangEntity == null){
                return R.error(511,"查不到该车辆");
            }
            // Double cheliangNewMoney = cheliangEntity.getCheliangNewMoney();

            if(cheliangEntity.getCheliangNewMoney() == null){
                return R.error(511,"车辆价格不能为空");
            }
            long diff = new Date().getTime() - cheliangOrder.getInsertTime().getTime();

            long day = diff / (24 * 60 * 60 * 1000);
            long hour = (diff / (60 * 60 * 1000) - day * 24);
            long min = ((diff / (60 * 1000)) - day * 24 * 60 - hour * 60);


            double xiaoshi = Double.valueOf(diff / (60 * 60 * 1000))+1;
            cheliangOrder.setXiaoshi(xiaoshi);

            double jine = xiaoshi * cheliangEntity.getCheliangNewMoney();


            YonghuEntity yonghuEntity = yonghuService.selectById(cheliangOrder.getYonghuId());
            if(yonghuEntity == null)
                return R.error(511,"用户不能为空");
            if(yonghuEntity.getNewMoney() == null)
                return R.error(511,"用户金额不能为空");
            double balance = yonghuEntity.getNewMoney() - jine;//余额
            if(balance<0)
                return R.error(511,"余额不够还车,本次需扣费"+jine+"元钱");


            cheliangOrder.setZhifuMoney(jine);
            cheliangOrder.setJieshuTime(new Date());
            cheliangOrder.setCheliangOrderTypes(2);
            cheliangOrderService.updateById(cheliangOrder);//新增订单


            cheliangEntity.setZuyongTypes(1);
            cheliangService.updateById(cheliangEntity);

            yonghuEntity.setNewMoney(balance);
            yonghuService.updateById(yonghuEntity);
            return R.ok();
        }else{
            return R.error(511,"您没有权限还车");
        }
    }











}
