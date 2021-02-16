package com.rianta9.dao;

import java.util.List;

import com.rianta9.model.UserModel;

public interface IUserDAO {
	public List<UserModel> getAll();
	public long insert(UserModel user);
	public boolean update(UserModel user);
	public boolean delete(Long id);
	public UserModel find(Long id);
}
