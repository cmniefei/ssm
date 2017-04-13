package com.nfcm.ssm.core.basic.service;

import java.util.List;

import com.nfcm.ssm.core.basic.pojo.User;

public interface UserService {
	
	public List<User> findAllUser();

	public void addUser(User user);
}
