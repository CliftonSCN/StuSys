package com.clifton.exception;
/**  
* 秒杀相关的所有业务异常
* @author Clifton  
* @date 2019年8月6日 下午2:51:18 
* @project stusys
*/
public class SeckillException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SeckillException(String message) {
        super(message);
    }

    public SeckillException(String message, Throwable cause) {
        super(message, cause);
    }
}
