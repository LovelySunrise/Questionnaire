package com.springmvc.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Records consisted of data transmitted by form submit
 */
@Entity
@Table(name="FORM_RECORD")
public class FormRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Column(name = "LAYOUT_ID", nullable = false)
    private int layoutId;

    @NotNull
    @Size(max=1000)
    @Column(name = "VALUE", nullable = false)
    private String value;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLayoutId() {
        return layoutId;
    }

    public void setLayoutId(int layoutId) {
        this.layoutId = layoutId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
