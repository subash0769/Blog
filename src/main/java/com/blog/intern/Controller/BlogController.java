package com.blog.intern.Controller;

import com.blog.intern.DTO.BlogDTO;
import com.blog.intern.Entity.Blog;
import com.blog.intern.Service.BlogService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blogs")
public class BlogController {
    @Autowired
    private BlogService blogService;

    @GetMapping("/list")
    public List<Blog> getAllBlogs() {
        return blogService.getAllBlogs();
    }

    @GetMapping("/{id}")
    public Blog getBlogById(@PathVariable Integer id) {
        return blogService.getBlogById(id)
                .orElseThrow(() -> new RuntimeException("Blog not found with id " + id));
    }

    @PostMapping("/save")
    public String postBlog( @Valid @RequestBody BlogDTO blogDTO) {
         blogService.postBlog(blogDTO);
         return "Blog has been posted successfully.";
    }

    @PutMapping("/update/{id}")
    public String updateBlog(@PathVariable Integer id, @RequestBody BlogDTO blogDTO) {
         blogService.updateBlog(id, blogDTO)
                .orElseThrow(() -> new RuntimeException("Blog not found with id " + id));
         return "Blog has been updated successfully.";
    }}
