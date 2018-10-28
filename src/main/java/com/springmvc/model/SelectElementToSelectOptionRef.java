package com.springmvc.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Resembles select element to it's options references
 */
@Entity
@Table(name="SELECT_ELEMENT_TO_SELECT_OPTION_REF")
public class SelectElementToSelectOptionRef {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Column(name = "ELEMENT_ID", nullable = false)
    private int elementId;

    @NotNull
    @Column(name = "SELECT_OPTION_ID", nullable = false)
    private int selectId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getElementId() {
        return elementId;
    }

    public void setElementId(int elementId) {
        this.elementId = elementId;
    }

    public int getSelectId() {
        return selectId;
    }

    public void setSelectId(int selectId) {
        this.selectId = selectId;
    }
}
