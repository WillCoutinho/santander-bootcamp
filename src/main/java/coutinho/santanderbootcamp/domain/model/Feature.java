package coutinho.santanderbootcamp.domain.model;

import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;

@Entity(name = "tb_feature")
public class Feature extends BaseItem {

    public Feature(){

    }

    public Feature(String icon, String code, String description) {
        super(icon, code, description);
    }
}
