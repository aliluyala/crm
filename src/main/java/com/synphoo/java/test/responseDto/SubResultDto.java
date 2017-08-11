package com.synphoo.java.test.responseDto;

import java.math.BigDecimal;

/**
 * 
 * 结果对象
 * @author wangmingfeng
 *
 */
public class SubResultDto extends BaseResultDto{
	private Boolean isValid;
	private String name;
	private BigDecimal amount;
	
	public Boolean getIsValid() {
		return isValid;
	}
	public void setIsValid(Boolean isValid) {
		this.isValid = isValid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "SubResultDto [isValid=" + isValid + ", name=" + name
				+ ", amount=" + amount + "]";
	}
	
	
	
	
}
