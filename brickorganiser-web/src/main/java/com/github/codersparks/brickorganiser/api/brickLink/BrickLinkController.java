package com.github.codersparks.brickorganiser.api.brickLink;

import com.github.codersparks.brickorganiser.interfaces.bricklink.BrickLinkService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Created by codersparks on 29/12/2016.
 */
@RestController
@RequestMapping("/api/bricklink/")
public class BrickLinkController {

    private static final Logger logger = LoggerFactory.getLogger(BrickLinkController.class);

    @Autowired
    private BrickLinkService brickLinkService;


    @RequestMapping(path = "/part/", method = RequestMethod.POST)
    public ResponseEntity<Void> uploadBrickLinkCSVFile(@RequestParam("file") MultipartFile uploadedFile) {


        if (!uploadedFile.isEmpty()) {
            try {
                logger.info("Attempting to load brick link part data from file: {}", uploadedFile.getName());
                brickLinkService.loadBrickLinkPartData(uploadedFile.getInputStream());
                logger.info("Brick Link data uploaded");
                return ResponseEntity.noContent().build();
            } catch (IOException e) {
                return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).header("failure.reason", "IOException caught when parsing BrickLink Data, message : " + e.getLocalizedMessage()).build();
            }
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).header("failure.reason", "No file supplied").build();
        }
    }
}
