package com.github.huluvu424242.deployview;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Environment implements Serializable {

    @Id
    protected String value;

    public Environment(String value) {
        super();
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}