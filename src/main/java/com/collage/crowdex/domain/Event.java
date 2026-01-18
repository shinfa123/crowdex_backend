package com.collage.crowdex.domain;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Event {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String eventName;

	    private String eventType;

	    private LocalDate eventDate;

	    private LocalTime startTime;

	    private LocalTime endTime;

	    private Integer expectedCrowd;

	    private Integer maxCapacity;

	    private Boolean monitoringEnabled;

	    @ManyToOne
	    @JoinColumn(name = "venue_id")
	    private Venue venue;

	    @Enumerated(EnumType.STRING)
	    private EventStatus status; // PLANNED, LIVE, COMPLETED

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getEventName() {
			return eventName;
		}

		public void setEventName(String eventName) {
			this.eventName = eventName;
		}

		public String getEventType() {
			return eventType;
		}

		public void setEventType(String eventType) {
			this.eventType = eventType;
		}

		public LocalDate getEventDate() {
			return eventDate;
		}

		public void setEventDate(LocalDate eventDate) {
			this.eventDate = eventDate;
		}

		public LocalTime getStartTime() {
			return startTime;
		}

		public void setStartTime(LocalTime startTime) {
			this.startTime = startTime;
		}

		public LocalTime getEndTime() {
			return endTime;
		}

		public void setEndTime(LocalTime endTime) {
			this.endTime = endTime;
		}

		public Integer getExpectedCrowd() {
			return expectedCrowd;
		}

		public void setExpectedCrowd(Integer expectedCrowd) {
			this.expectedCrowd = expectedCrowd;
		}

		public Integer getMaxCapacity() {
			return maxCapacity;
		}

		public void setMaxCapacity(Integer maxCapacity) {
			this.maxCapacity = maxCapacity;
		}

		public Boolean getMonitoringEnabled() {
			return monitoringEnabled;
		}

		public void setMonitoringEnabled(Boolean monitoringEnabled) {
			this.monitoringEnabled = monitoringEnabled;
		}

		public Venue getVenue() {
			return venue;
		}

		public void setVenue(Venue venue) {
			this.venue = venue;
		}

		public EventStatus getStatus() {
			return status;
		}

		public void setStatus(EventStatus status) {
			this.status = status;
		}

}
