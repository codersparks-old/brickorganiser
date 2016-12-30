package com.github.codersparks.brickorganiser.model.bricklink;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by codersparks on 30/12/2016.
 */
@Data
@NoArgsConstructor
@XmlRootElement(name="CATALOG")
@XmlAccessorType(XmlAccessType.FIELD)
public class BrickLinkCatalog {


    @XmlElement(name = "ITEM")
    private final List<BrickLinkItem> items = new ArrayList<>();

    public void setItems(List<BrickLinkItem> items) {
        this.items.clear();
        this.items.addAll(items);
    }
}
