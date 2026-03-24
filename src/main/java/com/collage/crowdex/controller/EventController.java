package com.collage.crowdex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.collage.crowdex.domain.Event;
import com.collage.crowdex.domain.EventStatus;
import com.collage.crowdex.services.EventService;
import com.collage.crowdex.services.UserService;
import com.collage.crowdex.services.VenueService;

@RestController
@RequestMapping("/events")
@CrossOrigin(origins = "http://localhost:4200")
public class EventController {
	@Autowired
	private EventService eventService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private VenueService venueService;
	
    @PostMapping("/create")
    public ResponseEntity<Event> createEvent(@RequestBody Event event) {
        return ResponseEntity.ok(eventService.createEvent(event));
    }

    @GetMapping("/getallevents/{userid}")
    public List<Event> getAllEvents(@PathVariable Integer userid) {
        return eventService.getAllEvents(userid);
    }
    
    @GetMapping("/status/{userid}/{status}")
    public List<Event> getEventsByStatus(@PathVariable Integer userid,@PathVariable EventStatus status) {
        return eventService.getEventsByStatus(userid,status);
    }
    
    @DeleteMapping("/delete/{eventId}")
    public ResponseEntity<String> deleteEvent(@PathVariable Long eventId) {
        eventService.deleteEvent(eventId);
        return ResponseEntity.ok("Event deleted successfully");
    }
 
	@DeleteMapping("/deleteuser/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable Integer id) {
	    userService.deleteUser(id);
	    return ResponseEntity.ok("User deleted successfully");
	}

	@DeleteMapping("/venue/{id}")
	public ResponseEntity<String> deleteVenue(@PathVariable Long id) {
		try {
			venueService.deleteVenue(id);
			return ResponseEntity.ok("Venue deleted successfully");
		} catch (DataIntegrityViolationException e) {
			return ResponseEntity.ok("Venue can't be deleted because it is referenced by an event");
		} catch (Exception e) {
			return ResponseEntity.ok("Error deleting venue");
		}
	}
}
