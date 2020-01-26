package de.telran.blog.service;

import de.telran.blog.exception.StorageFileNotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class StorageService {
    @Value("${upload.path}")
    private String path;



   public void store(MultipartFile file) throws IOException {
       if(file.isEmpty()){
           throw new StorageFileNotFoundException("File is empty");
       }
       try{
           String fileName=file.getOriginalFilename();
           InputStream fileInputStream = file.getInputStream();

           Files.copy(fileInputStream, Paths.get(path+fileName),
                   StandardCopyOption.REPLACE_EXISTING);
       }catch (IOException ex){
           String message= String.format("Failed to store file", file.getName());
           throw new StorageFileNotFoundException(message,ex);
       }
   }

}
