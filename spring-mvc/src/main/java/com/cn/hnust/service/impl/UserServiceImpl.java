package com.cn.hnust.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cn.hnust.dao.IUserDao;
import com.cn.hnust.pojo.User;
import com.cn.hnust.service.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService {
	@Resource
	private IUserDao userDao;
	@Override
	public User getUserById(int userId) {
		// TODO Auto-generated method stub
		return this.userDao.selectByPrimaryKey(userId);
	}
	
	/**
	 * 事务处理必须抛出异常，Spring才会帮助事务回滚
	 * @param users
	 */
	
	@Transactional
	public void insertUser(List<User> users) {
		for (int i = 0; i < users.size(); i++) {
			if(i<2){
				this.userDao.insert(users.get(i));
			}
			else {
				throw new RuntimeException();
			}
		}
	}

}
