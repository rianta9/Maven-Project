package com.rianta9.dao;

import java.util.List;

import com.rianta9.model.CategoryModel;

public interface ICategoryDAO extends GenericDAO<CategoryModel>{
	public List<CategoryModel> getAll();
	public long insert(CategoryModel category);
	public boolean update(CategoryModel category);
	public boolean delete(Long id);
	public CategoryModel find(Long id);
}
