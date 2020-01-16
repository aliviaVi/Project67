package de.telran.blog.service;

import static org.junit.jupiter.api.Assertions.*;
import de.telran.blog.dto.AuthorDto;
import de.telran.blog.entity.AuthorEntity;
import de.telran.blog.repository.AuthorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
public class AuthorServiceTest {
    @Autowired
    AuthorService authorService;
    @Autowired
    AuthorRepository authorRepository;


    AuthorDto authorDto;
    @BeforeEach
    public void start(){
        authorDto=new AuthorDto();
        authorDto.setFirstName("anna");
        authorDto.setLastName("boby");
    }
    @Test
    @Transactional
    public void createAuthorTest(){

        Long newUserId = authorService.createAuthor(authorDto);
        AuthorEntity newAuthor = authorRepository.getOne(newUserId);
        assertEquals("anna", newAuthor.getFirstName());
        assertEquals("boby", newAuthor.getLastName());

    }
    @Test
    @Transactional
    public void getAllAuthorsTest(){
        authorService.createAuthor(authorDto);

        List<AuthorDto> allAuthors = authorService.getAllAuthors();
        assertEquals(1,allAuthors.size());


    }

}