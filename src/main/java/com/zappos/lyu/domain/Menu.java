package com.zappos.lyu.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
@NoArgsConstructor
public class Menu {

    @Id
    @GeneratedValue
    private Long id;

    private String type;

    private String info;

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", info='" + info + '\'' +
                '}';
    }
}
