package com.github.codersparks.brickorganiser.repository.bricklink;

import com.github.codersparks.brickorganiser.model.bricklink.BrickLinkPart;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by markwhiteley on 07/01/2017.
 */
public interface BrickLinkPartRepository extends MongoRepository<BrickLinkPart, String> {
}
