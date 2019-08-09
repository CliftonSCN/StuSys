package com.clifton.runnable;

import java.util.concurrent.locks.LockSupport;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.clifton.service.UserService;

/**  
* @author Clifton  
* @date 2019年8月7日 上午10:14:01 
* @project stusys
*/
@Component
public class TaskRunnable implements Runnable {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	UserService userService;
	
	Thread thread;
	
	public void setThread(Thread thread) {
		this.thread = thread;
	}

	@Override
	public void run() {
		userService.insertAllStuIntoUser();
		try {
			Thread.sleep(5000);
			LockSupport.unpark(thread);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.info("---------录入被打断");
		}
	}

}
