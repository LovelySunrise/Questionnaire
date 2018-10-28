package com.springmvc.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Reflects element to layout links
 */
@Entity
@Table(name="ELEMENT_TO_LAYOUT_REF")
public class ElementToLayoutRef {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //Layout chunk without layout id provided makes no sense thus layout id field set as not null
    @NotNull
    @Column(name = "LAYOUT_ID", nullable = false)
    private int layoutId;

    //Considering that there is no benefit in creating empty layouts and storing layout chunk records
    //with no provided element makes no sense - element id field is set as not null value
    @NotNull
    @Column(name = "ELEMENT_ID", nullable = false)
    private int elementId;

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

    public int getElementId() {
        return elementId;
    }

    public void setElementId(int elementId) {
        this.elementId = elementId;
    }
}
