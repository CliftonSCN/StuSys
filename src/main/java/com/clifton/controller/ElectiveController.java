package com.clifton.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.clifton.dto.Exposer;
import com.clifton.dto.SeckillExecution;
import com.clifton.dto.SeckillResult;
import com.clifton.enums.SeckillStatEnum;
import com.clifton.exception.RepeatKillException;
import com.clifton.exception.SeckillCloseException;
import com.clifton.pojo.Elective;
import com.clifton.service.ElectiveService;

/**
 * @author Clifton
 * @date 2019年8月6日 下午4:25:11
 * @project stusys
 */
@Controller
@RequestMapping("/elective")
public class ElectiveController {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	ElectiveService electiveService;

	@GetMapping("/toList")
	public String toList() {
		return "elective/ElectiveList";
	}

	@GetMapping("/list")
	@ResponseBody
	public List<Elective> list(@RequestParam(value = "order", defaultValue = "") String order, Model model) {
		// 获取列表页
		List<Elective> list = electiveService.getElectiveList(order);
		return list;
	}

	/**
	 * 查询选课是否存在，存在则跳到详情页
	 * 
	 * @param electiveId
	 * @param model
	 * @return
	 */
	@GetMapping("/{electiveId}/detail")
	public String detail(@PathVariable("electiveId") Integer electiveId, Model model) {
		if (electiveId == null) {
			return "redirect:/elective/list";
		}

		Elective elective = electiveService.getById(electiveId);
		if (elective == null) {
			return "forward:/elective/list";
		}

		model.addAttribute("elective", elective);

		return "detail";
	}

	// ajax ,json暴露秒杀接口的方法
	@GetMapping(value = "/{electiveId}/exposer", produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public SeckillResult<Exposer> exposer(@PathVariable("electiveId") Integer electiveId, HttpSession session) {
		SeckillResult<Exposer> result;
		try {
			// 在秒杀开启时输出秒杀接口的地址，否则输出系统时间和秒杀时间
			Exposer exposer = electiveService.exportSeckillUrl(electiveId);
			result = new SeckillResult<Exposer>(true, exposer);
		} catch (Exception e) {
			e.printStackTrace();
			result = new SeckillResult<Exposer>(false, e.getMessage());
		}

		return result;
	}

	/**
	 * 处理秒杀请求
	 * 
	 * @param electiveId
	 * @param md5
	 * @param session
	 * @return
	 */
	@PostMapping(value = "/{electiveId}/{md5}/execution", produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public SeckillResult<SeckillExecution> execute(@PathVariable("electiveId") Integer electiveId,
			@PathVariable("md5") String md5, HttpSession session) {
		String stuNum = (String) session.getAttribute("userName");
		if (stuNum == null) {
			logger.info("stuNum is null~~~~~~~~~~~~~~~");
		}

		try {
			SeckillExecution execution = electiveService.executeSeckill(electiveId, Integer.valueOf(stuNum), md5);
			return new SeckillResult<SeckillExecution>(true, execution);
		} catch (RepeatKillException e1) {
			SeckillExecution execution = new SeckillExecution(electiveId, SeckillStatEnum.REPEAT_KILL);
			return new SeckillResult<SeckillExecution>(true, execution);
		} catch (SeckillCloseException e2) {
			SeckillExecution execution = new SeckillExecution(electiveId, SeckillStatEnum.END);
			return new SeckillResult<SeckillExecution>(true, execution);
		} catch (Exception e) {
			SeckillExecution execution = new SeckillExecution(electiveId, SeckillStatEnum.INNER_ERROR);
			return new SeckillResult<SeckillExecution>(true, execution);
		}
	}

	/**
	 * 获取系统时间
	 * 
	 * @return
	 */
	@GetMapping("/time/now")
	@ResponseBody
	public SeckillResult<Long> time() {
		Date now = new Date();
		return new SeckillResult<Long>(true, now.getTime());
	}

}
