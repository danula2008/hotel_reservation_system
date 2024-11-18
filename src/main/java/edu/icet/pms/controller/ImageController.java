package edu.icet.pms.controller;

import edu.icet.pms.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/image")
@CrossOrigin
public class ImageController {

    private final ImageService service;

}
