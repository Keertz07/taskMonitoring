package com.techymeet.taskMonitoring.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techymeet.taskMonitoring.bo.LoginBo;
import com.techymeet.taskMonitoring.bo.StudentBo;
import com.techymeet.taskMonitoring.dao.Dao;
import com.techymeet.taskMonitoring.entity.LoginVo;
import com.techymeet.taskMonitoring.entity.StudentVo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class TaskServiceImpl implements TaskService{
	
	@Autowired
	Dao dao;

	@Override
	public LoginBo loginCheck(LoginBo loginBo) {
		try {
			LoginVo loginVo=new LoginVo();
			BeanUtils.copyProperties(loginBo, loginVo);
			loginVo=dao.loginCheck(loginVo);
			if(null!=loginVo) {
				BeanUtils.copyProperties(loginVo, loginBo);
			}
			return loginBo;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public StudentBo saveUser(StudentBo student) {
		try {
			StudentVo studentvo=new StudentVo();
			BeanUtils.copyProperties(student, studentvo);
			
			studentvo=dao.saveUser(studentvo);
			if(null!=studentvo) {
				student.setId(studentvo.getId());
				return student;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	
	
	
	
	
}
