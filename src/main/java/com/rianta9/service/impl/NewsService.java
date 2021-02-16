package com.rianta9.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.rianta9.dao.INewsDAO;
import com.rianta9.model.NewsModel;
import com.rianta9.service.INewsService;

public class NewsService implements INewsService{
	@Inject
	private INewsDAO newsDao;
	
	@Override
	public NewsModel save(NewsModel newModel) {
		Long newId = newsDao.insert(newModel);
		return newsDao.find(newId);
	}

	@Override
	public List<NewsModel> findByNewsId(Long newsId) {
		return newsDao.findByCategoryId(newsId);
	}

}
