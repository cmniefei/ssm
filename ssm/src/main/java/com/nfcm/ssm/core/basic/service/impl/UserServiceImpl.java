package com.nfcm.ssm.core.basic.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nfcm.ssm.core.basic.dao.UserDao;
import com.nfcm.ssm.core.basic.pojo.User;
import com.nfcm.ssm.core.basic.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDao;
	
	public List<User> findAllUser(){
		return userDao.findAllUser();
	}

	@Override
	public void addUser(User user) {
		userDao.addUser(user);
		
	}

}
