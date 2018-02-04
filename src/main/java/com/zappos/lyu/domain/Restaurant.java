package com.zappos.lyu.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Restaurant {

    @GeneratedValue
    @Id
    private Long id;

    private String name;

    private String location;

    public String toString() {
        return "Restaurant[id=" + id + ", name=" + name + ", location=" + location + "]";
    }
}
