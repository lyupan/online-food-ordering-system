package com.zappos.lyu.domain;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Data
@NoArgsConstructor
public class Restaurant {

    @GeneratedValue
    @Id
    private Long id;

    private String name;

    private String location;

    @JsonManagedReference
    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private List<Menu> menus;

    @JsonCreator
    public Restaurant(@JsonProperty("id") Long id, @JsonProperty("name") String name, @JsonProperty("location") String location, @JsonProperty("menus") List<Menu> menus) {
        this.name = name;
        this.location = location;
        if (menus != null ) {
            this.menus = menus;
            for (Menu menu : menus)
                menu.setRestaurant(this);
        }
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", menus=" + menus +
                '}';
    }
}
