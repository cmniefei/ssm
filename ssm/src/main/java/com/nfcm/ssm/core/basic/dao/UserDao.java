package com.nfcm.ssm.core.basic.dao;

import java.util.List;

import com.nfcm.ssm.core.basic.pojo.User;

public interface UserDao {

	
	public List<User> findAllUser();

	public void addUser(User user);
}
