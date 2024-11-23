package edu.icet.pms.service.impl;

import edu.icet.pms.service.ImageService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
public class ImageServiceImpl implements ImageService {

    private final String FOLDER_PATH = "D:\\Danula\\ICET\\Final Project\\Dev\\HRS_Database\\UploadedImages\\";

    public String uploadImageToFileSystem(MultipartFile file, String folderName) throws IOException {
        String pathOfImage = "%s%s\\%s".formatted(FOLDER_PATH, folderName, file.getOriginalFilename().replace(" ", "_"));
        file.transferTo(new File(pathOfImage));
        return folderName + "/" +
                "" + file.getOriginalFilename().replace(" ", "_");
    }


    public byte[] downloadImageFromFileSystem(String path) throws IOException {
        String filePath = FOLDER_PATH + path;

        File imageFile = new File(filePath);
        if (imageFile.exists()) {
            return Files.readAllBytes(imageFile.toPath());
        } else {
            throw new IOException("File not found at the specified path: " + filePath);
        }
    }
}
