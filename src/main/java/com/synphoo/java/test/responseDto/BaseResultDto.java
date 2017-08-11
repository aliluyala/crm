/**
 * 
 */
/**
 * @author wangmingfeng
 *
 */
package com.synphoo.java.test.responseDto;

/**
 * 返回对象的父类
 * @author wangmingfeng
 *
 */
public class BaseResultDto{
	private Boolean result;
	private String status;
	private String msg;
	
	public BaseResultDto(){
		
	}
	
	public BaseResultDto(Boolean result, String status, String msg) {
		super();
		this.result = result;
		this.status = status;
		this.msg = msg;
	}
	
	public Boolean getResult() {
		return result;
	}
	public void setResult(Boolean result) {
		this.result = result;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "BaseResultDto [result=" + result + ", status=" + status
				+ ", msg=" + msg + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((msg == null) ? 0 : msg.hashCode());
		result = prime * result
				+ ((this.result == null) ? 0 : this.result.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BaseResultDto other = (BaseResultDto) obj;
		if (msg == null) {
			if (other.msg != null)
				return false;
		} else if (!msg.equals(other.msg))
			return false;
		if (result == null) {
			if (other.result != null)
				return false;
		} else if (!result.equals(other.result))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}
	
	
	
	
}