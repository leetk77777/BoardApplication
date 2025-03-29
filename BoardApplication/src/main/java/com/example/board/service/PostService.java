package com.example.board.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.board.entity.Post;
import com.example.board.repository.PostRepository;

@Service
public class PostService {

	private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public Post getPostById(Long id) {
        return postRepository.findById(id).orElseThrow(() -> new RuntimeException("게시글을 찾을 수 없습니다."));
    }

    @Transactional
    public Post createPost(Post post) throws Exception {
        return postRepository.save(post);
    }

    @Transactional
    public Post updatePost(Long id, Post postDetails) {
        Post post = getPostById(id);
        post.setTitle(postDetails.getTitle());
        post.setContent(postDetails.getContent());
        return post;
    }
    
    // 게시글 수정 : 다른 방법
//    public Post updatePost(Long id, Post updatedPost) {
//        return postRepository.findById(id)
//            .map(post -> {
//                post.setTitle(updatedPost.getTitle());
//                post.setContent(updatedPost.getContent());
//                return postRepository.save(post);
//            })
//            .orElseThrow(() -> new RuntimeException("게시글을 찾을 수 없습니다."));
//    }

    @Transactional
    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }
}
