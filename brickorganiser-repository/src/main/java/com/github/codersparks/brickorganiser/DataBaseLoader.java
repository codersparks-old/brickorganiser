package com.github.codersparks.brickorganiser;

import com.github.codersparks.brickorganiser.model.Part;
import com.github.codersparks.brickorganiser.repository.PartRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Created by codersparks on 27/12/2016.
 */
@Component
public class DataBaseLoader implements CommandLineRunner{

    private static final Logger logger = LoggerFactory.getLogger(DataBaseLoader.class);

    @Autowired
    private PartRepository partRepository;


    @Override
    public void run(String... strings) throws Exception {

        logger.info("Adding test part to DB");
        Part part = new Part("0000", "testItem", 99999999, null, null, null);
        partRepository.save(part);
    }
}
