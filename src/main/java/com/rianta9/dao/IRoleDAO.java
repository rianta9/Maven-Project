package com.rianta9.dao;

import java.util.List;

import com.rianta9.model.RoleModel;

public interface IRoleDAO {
	public List<RoleModel> getAll();
	public long insert(RoleModel role);
	public boolean update(RoleModel role);
	public boolean delete(Long id);
	public RoleModel find(Long id);
}
