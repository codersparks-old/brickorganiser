package com.github.codersparks.brickorganiser.api;

import com.github.codersparks.brickorganiser.interfaces.PartService;
import com.github.codersparks.brickorganiser.model.Part;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by codersparks on 27/12/2016.
 */
@RestController
@RequestMapping(path = "/api/part/")
public class PartController {

    private static final Logger logger = LoggerFactory.getLogger(PartController.class);

    @Autowired
    private PartService partService;

    @RequestMapping(path = "/", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Iterable<Part>> getAllParts() {

        Iterable<Part> parts = partService.getParts();

        logger.debug("Parts returned: " + parts);
        return ResponseEntity.ok(partService.getParts());
    }
}
