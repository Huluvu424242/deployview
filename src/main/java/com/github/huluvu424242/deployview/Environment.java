package com.github.huluvu424242.deployview;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Environment implements Serializable {

    @Id
    protected String id;

    public Environment(String id) {
        super();
        this.id = id;
    }

    public String getId() {
        return id;
    }
}