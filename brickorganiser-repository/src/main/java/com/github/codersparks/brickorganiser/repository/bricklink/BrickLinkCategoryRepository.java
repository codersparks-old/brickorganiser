package com.github.codersparks.brickorganiser.repository.bricklink;

import com.github.codersparks.brickorganiser.model.bricklink.BrickLinkCategory;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by codersparks on 02/01/2017.
 */
public interface BrickLinkCategoryRepository extends MongoRepository<BrickLinkCategory, Integer> {
}
