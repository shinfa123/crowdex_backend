package com.collage.crowdex.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collage.crowdex.dao.EventDao;
import com.collage.crowdex.domain.Event;
import com.collage.crowdex.domain.EventStatus;
import com.collage.crowdex.domain.MyUser;

@Service
public class EventService {
	@Autowired
	private EventDao eventDao;
	
    public Event createEvent(Event event) {
    	if(event.getActualCrowd()!=null) {
    		event.setExpectedCrowd(event.getActualCrowd());
    	}
        return eventDao.save(event);
    }
    public List<Event> getAllEvents(Integer userId) {

        List<Event> events = eventDao.findAll();
        if (userId == 1) {
            return events;
        }
        return events.stream().filter(event -> event.getUserIds() != null && !event.getUserIds().isEmpty())
                .filter(event ->event.getUserIds().contains(userId))
                .collect(Collectors.toList());
    }
    public List<Event> getEventsByStatus(Integer userId,EventStatus status) {
        
        List<Event> events = eventDao.findByStatus(status);
        if (userId == 1) {
            return events;
        }
        return events.stream().filter(event -> event.getUserIds() != null && !event.getUserIds().isEmpty())
                .filter(event ->event.getUserIds().contains(userId))
                .collect(Collectors.toList());
    }
    
    public void deleteEvent(Long eventId) {
        eventDao.deleteById(eventId);
    }
}
