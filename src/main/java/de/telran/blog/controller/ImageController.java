package de.telran.blog.controller;

import de.telran.blog.service.ImageService;
import de.telran.blog.service.PostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/post")
@Slf4j
public class ImageController {
    private final ImageService imageService;
    private final PostService postService;


    public ImageController(ImageService imageService, PostService postService) {
        this.imageService = imageService;
        this.postService = postService;
    }
   /* @GetMapping("/{id}/image")
    public String showUploadForm(@PathVariable String id, Model model){
        PostEntity postEntity=postService.getPost(Long.valueOf(id);
        model.addAttribute("post", postEntity);
        model.addAttribute("imageFile",)

    }*/

  @PostMapping("/{id}/image/add")
  public String addImage(@PathVariable String id,
                         @RequestParam("imageFile")MultipartFile file
                         ) throws IOException {
        imageService.saveImageFile(Long.valueOf(id),file);
        return "redirect:/post/"+id+"/show";
  }

}
