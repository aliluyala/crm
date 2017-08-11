package com.synphoo.java.test.interface_;

/**
 * 返回对象IResult接口的实现类
 * @author wangmingfeng
 * @param <T>
 *
 */
public class DefaultResult<T> implements IResult<T> {
	
	private Boolean isSuccess;
	private String message;
	private T Data;
	
	
	/**
	 * 带参数的构造方法
	 * @param isSuccess
	 * @param message
	 * @param data
	 */
	public DefaultResult(Boolean isSuccess, String message, T data) {
		super();
		this.isSuccess = isSuccess;
		this.message = message;
		Data = data;
	}

	@Override
	public Boolean isSuccess() {
		return isSuccess;
	}

	@Override
	public String getMessage() {
		return message;
	}

	@Override
	public T getData() {
		return Data;
	}
	
	/**
	 * 自定义的操作成功的方法
	 */
	
	public static<T>  IResult<T> success(T data){
		return new DefaultResult<T>(true,"操作成功",data);
	}
	public static<T>  IResult<T> success(String msg){
		return new DefaultResult<T>(true,msg,null);
	}
	
	/**
	 * 自定义的操作失败的方法
	 */
	
	public static<T>  IResult<T> fail(String msg){
		return new DefaultResult<T>(false,msg,null);
	}
	public static<T>  IResult<T> fail(String msg,T data){
		return new DefaultResult<T>(false,msg,data);
	}

}
