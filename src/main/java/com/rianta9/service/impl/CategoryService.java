package com.rianta9.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.rianta9.dao.ICategoryDAO;
import com.rianta9.model.CategoryModel;
import com.rianta9.service.ICategoryService;

public class CategoryService implements ICategoryService{
	@Inject
	private ICategoryDAO categoryDao;

	
	@Override
	public List<CategoryModel> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
