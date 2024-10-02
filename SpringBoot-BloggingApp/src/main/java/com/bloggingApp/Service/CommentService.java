package com.bloggingApp.Service;

import com.bloggingApp.DtoLayers.CommentDto;

public interface CommentService {

	public CommentDto createComments(CommentDto comment,long user_id,long postId);
	
	public void deleteComment(long id);
}
