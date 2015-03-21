package com.song.demo.api;

import java.io.Serializable;

/**
 * 基础结果返回
 * @author 张松
 *
 */
public abstract class Result implements Serializable {

	private static final long serialVersionUID = 8230381622936715628L;

	private ErrCode errCode;

	private String errDesc;

	public ErrCode getErrCode() {
		return errCode;
	}

	public void setErrCode(ErrCode errCode) {
		this.errCode = errCode;
	}

	public String getErrDesc() {
		return errDesc;
	}

	public void setErrDesc(String errDesc) {
		this.errDesc = errDesc;
	}
	
	public static enum ErrCode {
		/** 系统异常 */
		ERR_0(0),
		/** URL格式错误 */
		ERR_1(1),
		/** 不支持的链接 */
		ERR_2(2),
		/** 商品不存在 */
		ERR_3(3),
		;
		
		private int errCode;
		
		public int getErrCode() {
			return errCode;
		}
		
		private ErrCode(int errCode) {
			this.errCode = errCode;
		}
	}
}
