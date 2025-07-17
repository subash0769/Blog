package com.blog.intern.Service;

import com.blog.intern.DTO.BlogDTO;
import com.blog.intern.Entity.Blog;

import java.util.List;
import java.util.Optional;

public interface BlogService {

    List<Blog> getAllBlogs();

    Optional<Blog> getBlogById(Integer id);

    Blog postBlog(BlogDTO blogDTO);

    Optional<Blog> updateBlog(Integer id, BlogDTO blogDTO);
}