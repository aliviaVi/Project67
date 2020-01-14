package de.telran.blog.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ImageServiceInterface {
    void saveImageFile(Long postId, MultipartFile file) throws IOException;
}
