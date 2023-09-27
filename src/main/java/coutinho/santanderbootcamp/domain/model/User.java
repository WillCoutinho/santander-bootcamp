package coutinho.santanderbootcamp.domain.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Entity(name = "tb_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String name;

    @OneToOne(cascade = CascadeType.ALL) //Deleta o que tiver vinculado à conta quando essa conta for deletada
    private Account account;

    @OneToOne(cascade = CascadeType.ALL)
    private Card card;

    //Toda vez que buscar um usuário no banco, vai trazer a lista também pois será utilizado
//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<String> features;

//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<String> news;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public List<String> getFeatures() {
        return features;
    }

    public void setFeatures(List<String> features) {
        this.features = features;
    }

    public List<String> getNews() {
        return news;
    }

    public void setNews(List<String> news) {
        this.news = news;
    }
}
