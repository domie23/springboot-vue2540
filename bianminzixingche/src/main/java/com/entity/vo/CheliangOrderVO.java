package com.entity.vo;

import com.entity.CheliangOrderEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 车辆订单
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("cheliang_order")
public class CheliangOrderVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 订单号
     */

    @TableField(value = "cheliang_order_uuid_number")
    private String cheliangOrderUuidNumber;


    /**
     * 车辆
     */

    @TableField(value = "cheliang_id")
    private Integer cheliangId;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 骑行时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 结束时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "jieshu_time")
    private Date jieshuTime;


    /**
     * 骑行时长(小时)
     */

    @TableField(value = "xiaoshi")
    private Double xiaoshi;


    /**
     * 支付金额
     */

    @TableField(value = "zhifu_money")
    private Double zhifuMoney;


    /**
     * 订单类型
     */

    @TableField(value = "cheliang_order_types")
    private Integer cheliangOrderTypes;


    /**
     * 支付类型
     */

    @TableField(value = "cheliang_order_payment_types")
    private Integer cheliangOrderPaymentTypes;


    /**
     * 创建时间 show3
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：订单号
	 */
    public String getCheliangOrderUuidNumber() {
        return cheliangOrderUuidNumber;
    }


    /**
	 * 获取：订单号
	 */

    public void setCheliangOrderUuidNumber(String cheliangOrderUuidNumber) {
        this.cheliangOrderUuidNumber = cheliangOrderUuidNumber;
    }
    /**
	 * 设置：车辆
	 */
    public Integer getCheliangId() {
        return cheliangId;
    }


    /**
	 * 获取：车辆
	 */

    public void setCheliangId(Integer cheliangId) {
        this.cheliangId = cheliangId;
    }
    /**
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：骑行时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：骑行时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：结束时间
	 */
    public Date getJieshuTime() {
        return jieshuTime;
    }


    /**
	 * 获取：结束时间
	 */

    public void setJieshuTime(Date jieshuTime) {
        this.jieshuTime = jieshuTime;
    }
    /**
	 * 设置：骑行时长(小时)
	 */
    public Double getXiaoshi() {
        return xiaoshi;
    }


    /**
	 * 获取：骑行时长(小时)
	 */

    public void setXiaoshi(Double xiaoshi) {
        this.xiaoshi = xiaoshi;
    }
    /**
	 * 设置：支付金额
	 */
    public Double getZhifuMoney() {
        return zhifuMoney;
    }


    /**
	 * 获取：支付金额
	 */

    public void setZhifuMoney(Double zhifuMoney) {
        this.zhifuMoney = zhifuMoney;
    }
    /**
	 * 设置：订单类型
	 */
    public Integer getCheliangOrderTypes() {
        return cheliangOrderTypes;
    }


    /**
	 * 获取：订单类型
	 */

    public void setCheliangOrderTypes(Integer cheliangOrderTypes) {
        this.cheliangOrderTypes = cheliangOrderTypes;
    }
    /**
	 * 设置：支付类型
	 */
    public Integer getCheliangOrderPaymentTypes() {
        return cheliangOrderPaymentTypes;
    }


    /**
	 * 获取：支付类型
	 */

    public void setCheliangOrderPaymentTypes(Integer cheliangOrderPaymentTypes) {
        this.cheliangOrderPaymentTypes = cheliangOrderPaymentTypes;
    }
    /**
	 * 设置：创建时间 show3
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show3
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
