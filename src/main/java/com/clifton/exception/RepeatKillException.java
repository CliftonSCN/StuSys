package com.clifton.exception;
/**  
* 重复秒杀异常，是一个运行期异常，不需要我们手动try catch
* Mysql只支持运行期异常的回滚操作
* @author Clifton  
* @date 2019年8月6日 下午2:53:18 
* @project stusys
*/
public class RepeatKillException extends SeckillException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RepeatKillException(String message) {
        super(message);
    }

    public RepeatKillException(String message, Throwable cause) {
        super(message, cause);
    }
}
