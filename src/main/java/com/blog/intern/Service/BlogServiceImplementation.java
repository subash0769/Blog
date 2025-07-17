package com.blog.intern.Service;

import com.blog.intern.DTO.BlogDTO;
import com.blog.intern.Entity.Blog;
import com.blog.intern.Repository.BlogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class BlogServiceImplementation implements BlogService {

    @Autowired
    private BlogRepo blogRepository;

    @Override
    public List<Blog> getAllBlogs() {
        return blogRepository.findAll();
    }

    @Override
    public Optional<Blog> getBlogById(Integer id) {
        return blogRepository.findById(id);
    }

    @Override
    public Blog postBlog(BlogDTO blogDTO) {
        Blog blog = new Blog();
        blog.setTitle(blogDTO.getTitle());
        blog.setDescription(blogDTO.getDescription());
        blog.setCategory(blogDTO.getCategory());
        return blogRepository.save(blog);
    }

    @Override
    public Optional<Blog> updateBlog(Integer id, BlogDTO blogDTO) {
        return blogRepository.findById(id).map(blog -> {
            blog.setTitle(blogDTO.getTitle());
            blog.setDescription(blogDTO.getDescription());
            blog.setCategory(blogDTO.getCategory());
            return blogRepository.save(blog);
        });
    }
}
