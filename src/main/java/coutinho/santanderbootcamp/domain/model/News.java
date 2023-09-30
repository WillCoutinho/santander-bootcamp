package coutinho.santanderbootcamp.domain.model;

import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;

@Entity(name = "tb_news")
public class News extends BaseItem {

    public News() {

    }

    public News(String icon, String code, String description) {
        super(icon, code, description);
    }
}
