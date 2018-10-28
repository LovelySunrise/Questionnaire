package com.springmvc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Resembles customized html tags (like input, select, button etc.)
 * type - tag name
 * name - name parameter
 * style - style parameter
 * classId - css class (ref to dictionary table CssClass)
 */
@Entity
@Table(name="ELEMENT")
public class Element {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Size(max=100)
    @Column(name = "TYPE", nullable = false)
    private String type;

    @Size(max=100)
    @Column(name = "NAME", nullable = true)
    private String name;

    @Size(max=1000)
    @Column(name = "STYLE", nullable = true)
    private String style;

    @Column(name = "CSS_CLASS_ID", nullable = true)
    private int classId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    @Override
    public String toString() {
        return "<" + type +
                " name = \"" + name + "\"" +
                " style=\"" + style + "\"" +
                " class=\"[class name]\"" +
                ">" +
                "[nested code]" +
                "</" + type +
                ">";
    }
}
