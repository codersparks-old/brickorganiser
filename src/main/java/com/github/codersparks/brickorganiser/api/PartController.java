package com.github.codersparks.brickorganiser.api;

import com.github.codersparks.brickorganiser.interfaces.PartService;
import com.github.codersparks.brickorganiser.model.Part;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by codersparks on 27/12/2016.
 */
@RestController
@RequestMapping(path = "/api/part")
public class PartController {

    @Autowired
    private PartService partService;

    @RequestMapping(path = "/", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<List<Part>> getAllParts() {
        return ResponseEntity.ok(partService.getParts());
    }
}
