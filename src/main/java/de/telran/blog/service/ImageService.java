package de.telran.blog.service;

import de.telran.blog.entity.PostEntity;
import de.telran.blog.repository.PostRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@Slf4j
public class ImageService implements ImageServiceInterface {

@Autowired
PostRepository postRepository;

    @Override
    @Transactional
    public void saveImageFile(Long postId, MultipartFile file) throws IOException {
        PostEntity postEntity= postRepository.findById(postId).get();
        Byte[] bytesOfImage= new Byte[file.getBytes().length];
        int i=0;
        for (byte b: file.getBytes()){
            bytesOfImage[i++]=b;
        }
        postEntity.setImage(bytesOfImage);
        postRepository.save(postEntity);
    }

}
