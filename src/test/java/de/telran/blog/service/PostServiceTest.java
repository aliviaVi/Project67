package de.telran.blog.service;

import static org.junit.jupiter.api.Assertions.*;

import de.telran.blog.dto.AuthorDto;
import de.telran.blog.dto.PostDto;
import de.telran.blog.entity.PostEntity;
import de.telran.blog.repository.AuthorRepository;
import de.telran.blog.repository.PostRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class PostServiceTest {
    @Autowired
    PostService postService;
    @Autowired
    PostRepository postRepository;
    @Autowired
    AuthorRepository authorRepository;
    @Autowired
    AuthorService authorService;


    AuthorDto authorDto;
    PostDto postDto;

    @BeforeEach
    public void start(){
        authorDto=new AuthorDto();
        authorDto.setFirstName("anna");
        authorDto.setLastName("boby");

        postDto=new PostDto();
        postDto.setBody("body");
        postDto.setTitle("title");
        Date date=new Date(2020-16-01);
        postDto.setDate(date);
    }

    @Test
    @Transactional
    void createPost() {
        Long newUserId = authorService.createAuthor(authorDto);

        postDto.setAuthorId(newUserId);

        Long postId = postService.createPost(postDto);
        PostEntity postEntityRepo = postRepository.getOne(postId);

        assertEquals("body",postEntityRepo.getBody());
        assertEquals("title",postEntityRepo.getTitle());
    }

    @Test
    @Transactional
    void getPost() {

        Long newUserId = authorService.createAuthor(authorDto);

        postDto.setAuthorId(newUserId);
        Long postId = postService.createPost(postDto);
        PostEntity postEntityRepo = postRepository.getOne(postId);

        assertEquals("body",postEntityRepo.getBody());
    }
    @Test
    @Transactional
    public void gelAllPostsTest(){

        Long newUserId = authorService.createAuthor(authorDto);

        postDto.setAuthorId(newUserId);
        Long postId = postService.createPost(postDto);
        List<PostDto> allPosts = postService.getAllPosts();
        assertEquals(1,allPosts.size());


    }
}