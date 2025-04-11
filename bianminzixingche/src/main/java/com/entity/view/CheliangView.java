package com.entity.view;

import com.entity.CheliangEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 车辆
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("cheliang")
public class CheliangView extends CheliangEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 车辆类型的值
		*/
		private String cheliangValue;
		/**
		* 车辆状态的值
		*/
		private String cheziValue;
		/**
		* 租用状态的值
		*/
		private String zuyongValue;
		/**
		* 是否上架的值
		*/
		private String shangxiaValue;



	public CheliangView() {

	}

	public CheliangView(CheliangEntity cheliangEntity) {
		try {
			BeanUtils.copyProperties(this, cheliangEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 车辆类型的值
			*/
			public String getCheliangValue() {
				return cheliangValue;
			}
			/**
			* 设置： 车辆类型的值
			*/
			public void setCheliangValue(String cheliangValue) {
				this.cheliangValue = cheliangValue;
			}
			/**
			* 获取： 车辆状态的值
			*/
			public String getCheziValue() {
				return cheziValue;
			}
			/**
			* 设置： 车辆状态的值
			*/
			public void setCheziValue(String cheziValue) {
				this.cheziValue = cheziValue;
			}
			/**
			* 获取： 租用状态的值
			*/
			public String getZuyongValue() {
				return zuyongValue;
			}
			/**
			* 设置： 租用状态的值
			*/
			public void setZuyongValue(String zuyongValue) {
				this.zuyongValue = zuyongValue;
			}
			/**
			* 获取： 是否上架的值
			*/
			public String getShangxiaValue() {
				return shangxiaValue;
			}
			/**
			* 设置： 是否上架的值
			*/
			public void setShangxiaValue(String shangxiaValue) {
				this.shangxiaValue = shangxiaValue;
			}









}
