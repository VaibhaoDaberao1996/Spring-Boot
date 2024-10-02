package com.bloggingApp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bloggingApp.DtoLayers.CommentDto;
import com.bloggingApp.Response.ApiResponse;
import com.bloggingApp.Service.CommentService;

@RestController
@RequestMapping("/api")
public class CommentController {

	@Autowired
	private CommentService comment_service;
	
	
	@PostMapping("users/{user_id}/posts/{postId}/comments")
	public ResponseEntity<CommentDto> add_Comment(@RequestBody CommentDto comment,
												  @PathVariable long user_id,
												  @PathVariable long postId){
		
		CommentDto addComment = this.comment_service.createComments(comment,user_id,postId);
		
		return new ResponseEntity<CommentDto>(addComment,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/comments/{id}")
	public ResponseEntity<ApiResponse> delete_Comment(@PathVariable long id){
		
	       this.comment_service.deleteComment(id);
	       
	    return new ResponseEntity<ApiResponse>(new ApiResponse("comment is deleted succefully with id "+id, true),HttpStatus.OK);
	}
}
