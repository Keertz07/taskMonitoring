package com.techymeet.taskMonitoring.service;

import com.techymeet.taskMonitoring.bo.LoginBo;
import com.techymeet.taskMonitoring.bo.StudentBo;

public interface TaskService {

	LoginBo loginCheck(LoginBo login);

	StudentBo saveUser(StudentBo student);

}
