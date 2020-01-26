package de.telran.blog.controller;

import de.telran.blog.exception.StorageFileNotFoundException;
import de.telran.blog.service.StorageService;
import lombok.SneakyThrows;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller

public class ImageController {

    private final StorageService storageService;

    public ImageController(StorageService storageService) {
        this.storageService = storageService;
    }

    @PostMapping("/fileupload")
    @SneakyThrows
    @RequestMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String handleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes) {
        storageService.store(file);
        redirectAttributes.addFlashAttribute("message", "File upload is siccessfull"
                + file.getOriginalFilename() + "!");

        return "redirect:/"; // new ResponseEntity<>("file uploaded !" + HttpStatus.OK);//
    }

    @ExceptionHandler(StorageFileNotFoundException.class)
    public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException ex) {
        return ResponseEntity.notFound().build();
    }
}

/*

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
    @GetMapping("/{id}/image")
    public String showUploadForm(@PathVariable String id, Model model){
        PostEntity postEntity=postService.getPost(Long.valueOf(id));
        model.addAttribute("post", postEntity);
        model.addAttribute("imageFile");
        return model.toString();

    }

  @PostMapping("/fileupload")//("/{id}/image/add")
  public String addImage(@PathVariable String id,
                         @RequestParam("imageFile")MultipartFile file
                         ) throws IOException {
        imageService.saveImageFile(Long.valueOf(id),file);
        return "redirect:/post/"+id+"/show";
  }


}
*/
