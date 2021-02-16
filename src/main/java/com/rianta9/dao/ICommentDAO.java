package com.rianta9.dao;

import java.util.List;

import com.rianta9.model.CommentModel;

public interface ICommentDAO {
	public List<CommentModel> getAll();
	public long insert(CommentModel comment);
	public boolean update(CommentModel comment);
	public boolean delete(Long id);
	public CommentModel find(Long id);
}
