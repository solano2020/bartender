package com.bar.bartender.bartender.entity;

import javax.persistence.*;

@Entity
@Table(name = "cups", schema = "public")
public class Cups {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "input_array")
    private String inputArray;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInputArray() {
        return inputArray;
    }

    public void setInputArray(String inputArray) {
        this.inputArray = inputArray;
    }
}
