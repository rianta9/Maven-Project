package com.rianta9.dao;

import java.util.List;

import com.rianta9.model.NewsModel;

public interface INewsDAO extends GenericDAO<NewsModel>{
	List<NewsModel> getAll();
	long insert(NewsModel news);
	Long save(NewsModel newsModel);
	boolean update(NewsModel news);
	boolean delete(Long id);
	NewsModel find(Long id);
	List<NewsModel> findByCategoryId(Long id);
}
