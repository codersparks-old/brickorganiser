package com.github.codersparks.brickorganiser.repository;

import com.github.codersparks.brickorganiser.model.Part;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by codersparks on 27/12/2016.
 */
public interface PartRepository extends MongoRepository<Part, String> {

    List<Part> findByCategory(int category);
}
