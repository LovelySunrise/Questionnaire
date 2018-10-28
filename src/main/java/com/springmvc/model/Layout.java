package com.springmvc.model;

import javax.persistence.*;
import javax.validation.constraints.Size;

/**
 * Resembles layouts which consist of elements
 * name - layout name
 * note - layout description
 */
@Entity
@Table(name="LAYOUT")
public class Layout {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Size(max=100)
    @Column(name = "NAME", nullable = true)
    private String name;

    @Size(max=1000)
    @Column(name = "NOTE", nullable = true)
    private String note;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
