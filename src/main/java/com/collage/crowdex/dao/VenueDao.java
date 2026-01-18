package com.collage.crowdex.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.collage.crowdex.domain.Venue;

public interface VenueDao extends JpaRepository<Venue, Long> {

    // Optional custom queries (future use)
    // List<Venue> findByActive(Boolean active);
}