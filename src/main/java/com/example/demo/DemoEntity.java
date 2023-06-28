package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class DemoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    String demoValue;

    public Integer getId() {
        return id;
    }

    public String getDemoValue() {
        return demoValue;
    }

    public void setDemoValue(String demoValue) {
        this.demoValue = demoValue;
    }
}
