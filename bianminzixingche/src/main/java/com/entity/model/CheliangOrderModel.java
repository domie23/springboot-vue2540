package com.entity.model;

import com.entity.CheliangOrderEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 车辆订单
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class CheliangOrderModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 订单号
     */
    private String cheliangOrderUuidNumber;


    /**
     * 车辆
     */
    private Integer cheliangId;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 骑行时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 结束时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date jieshuTime;


    /**
     * 骑行时长(小时)
     */
    private Double xiaoshi;


    /**
     * 支付金额
     */
    private Double zhifuMoney;


    /**
     * 订单类型
     */
    private Integer cheliangOrderTypes;


    /**
     * 支付类型
     */
    private Integer cheliangOrderPaymentTypes;


    /**
     * 创建时间 show3
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：订单号
	 */
    public String getCheliangOrderUuidNumber() {
        return cheliangOrderUuidNumber;
    }


    /**
	 * 设置：订单号
	 */
    public void setCheliangOrderUuidNumber(String cheliangOrderUuidNumber) {
        this.cheliangOrderUuidNumber = cheliangOrderUuidNumber;
    }
    /**
	 * 获取：车辆
	 */
    public Integer getCheliangId() {
        return cheliangId;
    }


    /**
	 * 设置：车辆
	 */
    public void setCheliangId(Integer cheliangId) {
        this.cheliangId = cheliangId;
    }
    /**
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 设置：用户
	 */
    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：骑行时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：骑行时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：结束时间
	 */
    public Date getJieshuTime() {
        return jieshuTime;
    }


    /**
	 * 设置：结束时间
	 */
    public void setJieshuTime(Date jieshuTime) {
        this.jieshuTime = jieshuTime;
    }
    /**
	 * 获取：骑行时长(小时)
	 */
    public Double getXiaoshi() {
        return xiaoshi;
    }


    /**
	 * 设置：骑行时长(小时)
	 */
    public void setXiaoshi(Double xiaoshi) {
        this.xiaoshi = xiaoshi;
    }
    /**
	 * 获取：支付金额
	 */
    public Double getZhifuMoney() {
        return zhifuMoney;
    }


    /**
	 * 设置：支付金额
	 */
    public void setZhifuMoney(Double zhifuMoney) {
        this.zhifuMoney = zhifuMoney;
    }
    /**
	 * 获取：订单类型
	 */
    public Integer getCheliangOrderTypes() {
        return cheliangOrderTypes;
    }


    /**
	 * 设置：订单类型
	 */
    public void setCheliangOrderTypes(Integer cheliangOrderTypes) {
        this.cheliangOrderTypes = cheliangOrderTypes;
    }
    /**
	 * 获取：支付类型
	 */
    public Integer getCheliangOrderPaymentTypes() {
        return cheliangOrderPaymentTypes;
    }


    /**
	 * 设置：支付类型
	 */
    public void setCheliangOrderPaymentTypes(Integer cheliangOrderPaymentTypes) {
        this.cheliangOrderPaymentTypes = cheliangOrderPaymentTypes;
    }
    /**
	 * 获取：创建时间 show3
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show3
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
