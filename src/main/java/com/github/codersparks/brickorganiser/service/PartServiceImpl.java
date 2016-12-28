package com.github.codersparks.brickorganiser.service;

import com.github.codersparks.brickorganiser.interfaces.PartService;
import com.github.codersparks.brickorganiser.model.Part;
import com.github.codersparks.brickorganiser.repository.PartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by codersparks on 27/12/2016.
 */
@Service
public class PartServiceImpl implements PartService{

    @Autowired
    private PartRepository partRepository;

    @Override
    public Iterable<Part> getParts() {
        return partRepository.findAll();
    }
}
