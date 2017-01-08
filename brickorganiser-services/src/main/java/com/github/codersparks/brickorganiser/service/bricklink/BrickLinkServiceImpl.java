package com.github.codersparks.brickorganiser.service.bricklink;

import com.github.codersparks.brickorganiser.interfaces.bricklink.BrickLinkService;
import com.github.codersparks.brickorganiser.parser.bricklink.BrickLinkPartParser;
import com.github.codersparks.brickorganiser.repository.bricklink.BrickLinkPartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by markwhiteley on 07/01/2017.
 */
@Service
public class BrickLinkServiceImpl implements BrickLinkService {

    @Autowired
    private BrickLinkPartRepository brickLinkPartRepository;

    @Autowired
    private BrickLinkPartParser brickLinkPartParser;

    @Override
    public void loadBrickLinkPartData(InputStream inputStream) throws IOException {

        brickLinkPartParser.parse(inputStream).stream().forEach(brickLinkPart -> {

            brickLinkPartRepository.save(brickLinkPart);
        });
    }
}
