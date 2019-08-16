package com.clifton.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clifton.dao.AppraiseMapper;
import com.clifton.dao.TeacherMapper;
import com.clifton.dto.TeacherFin;
import com.clifton.pojo.Appraise;
import com.clifton.pojo.AppraiseExample;
import com.clifton.pojo.AppraiseExample.Criteria;
import com.clifton.service.TeacherService;

/**  
* @author Clifton  
* @date 2019年8月15日 下午2:48:45 
* @project stusys
*/
@Service
public class TeacherServiceImpl implements TeacherService {
	
	@Autowired
	TeacherMapper teacherMapper;
	
	@Autowired
	AppraiseMapper appraiseMapper;

	@Override
	public List<TeacherFin> getTeacherList(String stuNum) {
		return teacherMapper.selectByStuNum(stuNum);
	}

	@Override
	public void saveAppraise(Map map, int id) {
		Appraise appraise = new Appraise();
		appraise.setStuId((String) SecurityUtils.getSubject().getPrincipal());
		appraise.setTcId(String.valueOf(id));
		double param1 = Double.valueOf((String) map.get("param1"));
		double param2 = Double.valueOf((String) map.get("param2"));
		appraise.setOption1(param1);
		appraise.setOption2(param2);
		double avg = (param1+param2)/2;
		appraise.setAvg(avg);
		appraiseMapper.insertSelective(appraise);
	}

	@Override
	public Appraise getGradeById(String id) {
		AppraiseExample appraiseExample = new AppraiseExample();
		Criteria criteria = appraiseExample.createCriteria();
		criteria.andTcIdEqualTo(id);
		criteria.andStuIdEqualTo((String) SecurityUtils.getSubject().getPrincipal());
		List<Appraise> list = appraiseMapper.selectByExample(appraiseExample);
		return list.get(0);
	}

}
