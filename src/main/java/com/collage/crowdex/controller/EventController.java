package com.collage.crowdex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.collage.crowdex.domain.Event;
import com.collage.crowdex.domain.EventStatus;
import com.collage.crowdex.services.EventService;

@RestController
@RequestMapping("/events")
@CrossOrigin(origins = "http://localhost:4200")
public class EventController {
	@Autowired
	private EventService eventService;
	
    @PostMapping("/create")
    public ResponseEntity<Event> createEvent(@RequestBody Event event) {
        return ResponseEntity.ok(eventService.createEvent(event));
    }

    @GetMapping("/getallevents")
    public List<Event> getAllEvents() {
        return eventService.getAllEvents();
    }
    
    @GetMapping("/status/{status}")
    public List<Event> getEventsByStatus(@PathVariable EventStatus status) {
        return eventService.getEventsByStatus(status);
    }
    
    
 
}
