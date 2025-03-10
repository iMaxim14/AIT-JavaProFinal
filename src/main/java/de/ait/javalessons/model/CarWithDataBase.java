package de.ait.javalessons.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class CarWithDataBase {

    @Id
    private String id;
    private String name;

    public CarWithDataBase() {
    }

    public CarWithDataBase(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}