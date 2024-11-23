package edu.icet.pms.controller;

import edu.icet.pms.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/image")
@CrossOrigin
public class ImageController {

    private final ImageService service;

    @PostMapping("/{folderName}")
    public ResponseEntity<String> uploadImageToFileSystem(@RequestParam("image") MultipartFile file,
                                                          @PathVariable String folderName) throws IOException {
        String filePath = service.uploadImageToFileSystem(file, folderName);
        return ResponseEntity.status(HttpStatus.CREATED).body(filePath);
    }

    @GetMapping("")
    public ResponseEntity<byte []> downloadImageFromFileSystem(@RequestParam String fileName) throws IOException {
        byte[] imageData = service.downloadImageFromFileSystem(fileName);

        String contentType = "image/png";
        if (fileName.endsWith(".jpg") || fileName.endsWith(".jpeg")) {
            contentType = "image/jpeg";
        } else if (fileName.endsWith(".gif")) {
            contentType = "image/gif";
        } else if (fileName.endsWith(".bmp")) {
            contentType = "image/bmp";
        }

        return ResponseEntity.status(HttpStatus.OK)
                .contentType(org.springframework.http.MediaType.valueOf(contentType))
                .body(imageData);
    }
}
