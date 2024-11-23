package edu.icet.pms.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ImageService {
    String uploadImageToFileSystem(MultipartFile file, String folderName) throws IOException;
    byte[] downloadImageFromFileSystem(String path) throws IOException;
}
