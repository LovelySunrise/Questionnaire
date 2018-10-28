package com.springmvc.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Reflects JavaScript functions
 * value - javascript function name in main js source or entire function itself
 */
@Entity
@Table(name="JAVASCRIPT_FUNCTION")
public class JavascriptFunction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Size(max=500)
    @Column(name = "VALUE", nullable = false)
    private String value;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
