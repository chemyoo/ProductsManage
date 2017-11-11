package com.chemyoo.defException;
/**
 * 自定义业务异常
 * @author Administrator
 *
 */
public class BusinessException extends Throwable {

	/**
	 * 类标识
	 */
	private static final long serialVersionUID = 3339459809851112494L;
	
	 public BusinessException() 
	 {
		super("业务异常...");
     }
	 public BusinessException(String message) 
	 {
		super(message);
     }
	 public BusinessException(String message, Throwable cause)
	 {
		 super(message,cause);
	 }
	 public BusinessException(Throwable cause)
	 {
		 super(cause);
	 }

}
