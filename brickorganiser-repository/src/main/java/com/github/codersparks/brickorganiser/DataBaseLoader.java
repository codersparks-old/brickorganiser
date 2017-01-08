package com.github.codersparks.brickorganiser;

import com.github.codersparks.brickorganiser.model.Part;
import com.github.codersparks.brickorganiser.model.bricklink.BrickLinkCategory;
import com.github.codersparks.brickorganiser.repository.PartRepository;
import com.github.codersparks.brickorganiser.repository.bricklink.BrickLinkCategoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * Created by codersparks on 27/12/2016.
 */
@Component
public class DataBaseLoader implements CommandLineRunner{

    private static final Logger logger = LoggerFactory.getLogger(DataBaseLoader.class);

    @Autowired
    private PartRepository partRepository;

    @Autowired
    private BrickLinkCategoryRepository brickLinkCategoryRepository;


    @Override
    public void run(String... strings) throws Exception {

        logger.info("Adding category to database");
        BrickLinkCategory brickLinkCategory = new BrickLinkCategory(Integer.MAX_VALUE, "testCategory");
        brickLinkCategoryRepository.save(brickLinkCategory);

        logger.info("Adding test part to DB");
        Part part = new Part("0000", "testItem", "testCategory", null, null, null, null);
        partRepository.save(part);
    }
}
