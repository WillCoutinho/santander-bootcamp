package coutinho.santanderbootcamp.domain.model;

import com.fasterxml.jackson.databind.ser.Serializers;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;

@MappedSuperclass //Extende para Feature e News as annotations
public abstract class BaseItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;
    @NotBlank
    private String icon;
    @Column(unique = true, nullable = false)
    @NotBlank
    private String code;
    @NotBlank
    private String description;

    public BaseItem() {
    }

    public BaseItem(String icon, String code, String description) {
        this.icon = icon;
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Icon: " + icon + " | " +
                "Code: " + code + " | " +
                "Desc: " + description;
    }
}
