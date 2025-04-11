package com.entity.model;

import com.entity.CheliangEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 车辆
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class CheliangModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 车辆编号
     */
    private String cheliangUuidNumber;


    /**
     * 车辆名称
     */
    private String cheliangName;


    /**
     * 车辆照片
     */
    private String cheliangPhoto;


    /**
     * 车辆类型
     */
    private Integer cheliangTypes;


    /**
     * 租用原价/小时
     */
    private Double cheliangOldMoney;


    /**
     * 现价/小时
     */
    private Double cheliangNewMoney;


    /**
     * 点击次数
     */
    private Integer cheliangClicknum;


    /**
     * 车辆位置
     */
    private String cheliangAddress;


    /**
     * 车辆状态
     */
    private Integer cheziTypes;


    /**
     * 租用状态
     */
    private Integer zuyongTypes;


    /**
     * 车辆详情
     */
    private String cheliangContent;


    /**
     * 是否上架
     */
    private Integer shangxiaTypes;


    /**
     * 逻辑删除
     */
    private Integer cheliangDelete;


    /**
     * 创建时间  show1 show2 photoShow
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
	 * 获取：车辆编号
	 */
    public String getCheliangUuidNumber() {
        return cheliangUuidNumber;
    }


    /**
	 * 设置：车辆编号
	 */
    public void setCheliangUuidNumber(String cheliangUuidNumber) {
        this.cheliangUuidNumber = cheliangUuidNumber;
    }
    /**
	 * 获取：车辆名称
	 */
    public String getCheliangName() {
        return cheliangName;
    }


    /**
	 * 设置：车辆名称
	 */
    public void setCheliangName(String cheliangName) {
        this.cheliangName = cheliangName;
    }
    /**
	 * 获取：车辆照片
	 */
    public String getCheliangPhoto() {
        return cheliangPhoto;
    }


    /**
	 * 设置：车辆照片
	 */
    public void setCheliangPhoto(String cheliangPhoto) {
        this.cheliangPhoto = cheliangPhoto;
    }
    /**
	 * 获取：车辆类型
	 */
    public Integer getCheliangTypes() {
        return cheliangTypes;
    }


    /**
	 * 设置：车辆类型
	 */
    public void setCheliangTypes(Integer cheliangTypes) {
        this.cheliangTypes = cheliangTypes;
    }
    /**
	 * 获取：租用原价/小时
	 */
    public Double getCheliangOldMoney() {
        return cheliangOldMoney;
    }


    /**
	 * 设置：租用原价/小时
	 */
    public void setCheliangOldMoney(Double cheliangOldMoney) {
        this.cheliangOldMoney = cheliangOldMoney;
    }
    /**
	 * 获取：现价/小时
	 */
    public Double getCheliangNewMoney() {
        return cheliangNewMoney;
    }


    /**
	 * 设置：现价/小时
	 */
    public void setCheliangNewMoney(Double cheliangNewMoney) {
        this.cheliangNewMoney = cheliangNewMoney;
    }
    /**
	 * 获取：点击次数
	 */
    public Integer getCheliangClicknum() {
        return cheliangClicknum;
    }


    /**
	 * 设置：点击次数
	 */
    public void setCheliangClicknum(Integer cheliangClicknum) {
        this.cheliangClicknum = cheliangClicknum;
    }
    /**
	 * 获取：车辆位置
	 */
    public String getCheliangAddress() {
        return cheliangAddress;
    }


    /**
	 * 设置：车辆位置
	 */
    public void setCheliangAddress(String cheliangAddress) {
        this.cheliangAddress = cheliangAddress;
    }
    /**
	 * 获取：车辆状态
	 */
    public Integer getCheziTypes() {
        return cheziTypes;
    }


    /**
	 * 设置：车辆状态
	 */
    public void setCheziTypes(Integer cheziTypes) {
        this.cheziTypes = cheziTypes;
    }
    /**
	 * 获取：租用状态
	 */
    public Integer getZuyongTypes() {
        return zuyongTypes;
    }


    /**
	 * 设置：租用状态
	 */
    public void setZuyongTypes(Integer zuyongTypes) {
        this.zuyongTypes = zuyongTypes;
    }
    /**
	 * 获取：车辆详情
	 */
    public String getCheliangContent() {
        return cheliangContent;
    }


    /**
	 * 设置：车辆详情
	 */
    public void setCheliangContent(String cheliangContent) {
        this.cheliangContent = cheliangContent;
    }
    /**
	 * 获取：是否上架
	 */
    public Integer getShangxiaTypes() {
        return shangxiaTypes;
    }


    /**
	 * 设置：是否上架
	 */
    public void setShangxiaTypes(Integer shangxiaTypes) {
        this.shangxiaTypes = shangxiaTypes;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getCheliangDelete() {
        return cheliangDelete;
    }


    /**
	 * 设置：逻辑删除
	 */
    public void setCheliangDelete(Integer cheliangDelete) {
        this.cheliangDelete = cheliangDelete;
    }
    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
