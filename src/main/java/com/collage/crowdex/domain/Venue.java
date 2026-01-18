package com.collage.crowdex.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "venues")
public class Venue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String venueName;

    @Column(length = 150)
    private String location;

    private Integer totalCapacity;

    private Integer numberOfGates;

    private Boolean active;
    private Long longitude;
    private Long latitude;
    // Venue dimensions (in meters)
    @Column(nullable = false)
    private Double length;

    @Column(nullable = false)
    private Double width;

    // Optional: derived value (not stored in DB)
    @Transient
    public Double getArea() {
        return length * width;
    }

    // Constructors
    public Venue() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getVenueName() {
		return venueName;
	}

	public void setVenueName(String venueName) {
		this.venueName = venueName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Integer getTotalCapacity() {
		return totalCapacity;
	}

	public void setTotalCapacity(Integer totalCapacity) {
		this.totalCapacity = totalCapacity;
	}

	public Integer getNumberOfGates() {
		return numberOfGates;
	}

	public void setNumberOfGates(Integer numberOfGates) {
		this.numberOfGates = numberOfGates;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Double getLength() {
		return length;
	}

	public void setLength(Double length) {
		this.length = length;
	}

	public Double getWidth() {
		return width;
	}

	public void setWidth(Double width) {
		this.width = width;
	}

	public Long getLongitude() {
		return longitude;
	}

	public void setLongitude(Long longitude) {
		this.longitude = longitude;
	}

	public Long getLatitude() {
		return latitude;
	}

	public void setLatitude(Long latitude) {
		this.latitude = latitude;
	}
	
	
}
