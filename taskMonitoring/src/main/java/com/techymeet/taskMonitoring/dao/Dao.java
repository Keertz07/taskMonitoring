package com.techymeet.taskMonitoring.dao;

import com.techymeet.taskMonitoring.entity.LoginVo;
import com.techymeet.taskMonitoring.entity.StudentVo;

public interface Dao {

	LoginVo loginCheck(LoginVo loginVo);

	StudentVo saveUser(StudentVo studentvo);

}
