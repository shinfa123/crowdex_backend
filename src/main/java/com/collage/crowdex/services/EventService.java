package com.collage.crowdex.services;

import java.util.ArrayList;
import java.util.List;

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
    public ArrayList<Event> getAllEvents() {
    	return (ArrayList<Event>) eventDao.findAll();
	}
    public List<Event> getEventsByStatus(EventStatus status) {
        return eventDao.findByStatus(status);
    }
}
