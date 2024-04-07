package com.techymeet.taskMonitoring.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.techymeet.taskMonitoring.entity.LoginVo;
import com.techymeet.taskMonitoring.entity.StudentVo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

@Repository
public class DaoImpl implements Dao {
	@Autowired
	private EntityManager entity;
	

	@Override
	public LoginVo loginCheck(LoginVo loginVo) {
		try {
			CriteriaBuilder criteriaBuilder=entity.getCriteriaBuilder();
			CriteriaQuery<LoginVo> criteriaQuery=criteriaBuilder.createQuery(LoginVo.class);
			Root<LoginVo> root=criteriaQuery.from(LoginVo.class);
			 criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("username"), loginVo.getUsername()),criteriaBuilder.equal(root.get("password"), loginVo.getPassword()));
			 
			 Query query=entity.createQuery(criteriaQuery);
			 LoginVo login=(LoginVo) query.getSingleResult();
			 if(null!=login.getUsername()) {
				 return login;
			 }
			 
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public StudentVo saveUser(StudentVo studentvo) {
		try {
			entity.persist(studentvo);
			if (studentvo.getId() != 0) {
	            LoginVo loginVo = new LoginVo();
	            loginVo.setUsername(studentvo.getUsername());
	            loginVo.setPassword(studentvo.getPassword());
	            loginVo.setUserType(studentvo.getUsertype());
	            entity.persist(loginVo);
	            
	            return studentvo;
	        }
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	}

