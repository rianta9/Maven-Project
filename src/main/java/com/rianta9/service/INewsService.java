package com.rianta9.service;

import java.util.List;

import com.rianta9.model.NewsModel;

public interface INewsService {

	NewsModel save(NewsModel newModel);
	List<NewsModel> findByNewsId(Long newsId);
}
