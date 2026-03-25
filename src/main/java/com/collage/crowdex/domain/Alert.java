package com.collage.crowdex.domain;

import jakarta.persistence.*;

@Entity
public class Alert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Relationship with Event
    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    // Relationship with User
    @ManyToOne
    @JoinColumn(name = "user_id")
    private MyUser user;

    private String riskStatus; // LOW, MEDIUM, HIGH

    private String message;

    private Boolean isOpen;

    private Boolean isActive;

    // Getters & Setters

    public Long getId() {
        return id;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MyUser getUser() {
        return user;
    }

    public void setUser(MyUser user) {
        this.user = user;
    }

    public String getRiskStatus() {
        return riskStatus;
    }

    public void setRiskStatus(String riskStatus) {
        this.riskStatus = riskStatus;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getIsOpen() {
        return isOpen;
    }

    public void setIsOpen(Boolean isOpen) {
        this.isOpen = isOpen;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }
}