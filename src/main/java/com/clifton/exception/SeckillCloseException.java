package com.clifton.exception;
/**  
* 秒杀关闭异常，当秒杀结束时用户还要进行秒杀就会出现这个异常
* @author Clifton  
* @date 2019年8月6日 下午2:58:24 
* @project stusys
*/
/**
 * 
 */
public class SeckillCloseException extends SeckillException{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SeckillCloseException(String message) {
        super(message);
    }

    public SeckillCloseException(String message, Throwable cause) {
        super(message, cause);
    }
}
