/**
 * 
 */
/**
 * @author wangmingfeng
 *
 */
package com.synphoo.java.test.interface_;
/**
 * 封装返回数据的接口
 * @author wangmingfeng
 *
 * @param <T>
 */
public interface IResult<T>{
	
	/**
	 * 操作是否成功
	 * @return
	 */
	Boolean isSuccess();
	
	/**
	 * 返回提示信息
	 * @return
	 */
	String getMessage();
	
	/**
	 * 返回对象
	 * @return
	 */
	T getData();
	
	
}