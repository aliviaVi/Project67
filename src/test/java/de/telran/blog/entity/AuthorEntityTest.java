package de.telran.blog.entity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AuthorEntityTest {
    @Autowired
    AuthorEntity authorEntity;

    @BeforeEach
    public void setUp() throws Exception {
        authorEntity=new AuthorEntity();
    }

    @Test
    public void getId() {
        Long id=2L;
        authorEntity.setId(id);
        assertEquals(id,authorEntity.getId());
    }

    @Test
    public void getFirstName() {
        authorEntity.setFirstName("anna");
        assertEquals("anna",authorEntity.getFirstName());
    }



}