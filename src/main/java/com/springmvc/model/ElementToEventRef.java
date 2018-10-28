package com.springmvc.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Resembles element to browser event and it's handler function links
 */
@Entity
@Table(name="ELEMENT_TO_EVENT_REF")
public class ElementToEventRef {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Column(name = "ELEMENT_ID", nullable = false)
    private int elementId;

    @NotNull
    @Column(name = "EVENT_TYPE_ID", nullable = false)
    private int eventId;

    @NotNull
    @Column(name = "JAVASCRIPT_FUNCTION_ID", nullable = false)
    private int functionId;

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

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public int getFunctionId() {
        return functionId;
    }

    public void setFunctionId(int functionId) {
        this.functionId = functionId;
    }
}
