package com.collage.crowdex.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.collage.crowdex.domain.Event;
import com.collage.crowdex.domain.EventStatus;

public interface EventDao extends JpaRepository<Event, Long> {
    List<Event> findByStatus(EventStatus status);
}
