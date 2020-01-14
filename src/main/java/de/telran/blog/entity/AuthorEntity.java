package de.telran.blog.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Data
@Entity

public class AuthorEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;

    @OneToMany(targetEntity = PostEntity.class)
    private Set<PostEntity> postEntities;
}
