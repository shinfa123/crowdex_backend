package com.collage.crowdex.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collage.crowdex.dao.VenueDao;
import com.collage.crowdex.domain.Venue;

@Service
public class VenueService {
	@Autowired
    private VenueDao venueDao;

    public Venue createVenue(Venue venue) {
        venue.setActive(true);
        return venueDao.save(venue);
    }

    public List<Venue> getAllVenues() {
        return venueDao.findAll();
    }

    public Venue getVenueById(Long id) {
        return venueDao.findById(id)
                .orElseThrow(() -> new RuntimeException("Venue not found with id: " + id));
    }

    public Venue updateVenue(Long id, Venue updatedVenue) {
        Venue existingVenue = getVenueById(id);

        existingVenue.setVenueName(updatedVenue.getVenueName());
        existingVenue.setLocation(updatedVenue.getLocation());
        existingVenue.setTotalCapacity(updatedVenue.getTotalCapacity());
        existingVenue.setNumberOfGates(updatedVenue.getNumberOfGates());
        existingVenue.setLength(updatedVenue.getLength());
        existingVenue.setWidth(updatedVenue.getWidth());

        return venueDao.save(existingVenue);
    }

    public void updateVenueStatus(Long id, Boolean active) {
        Venue venue = getVenueById(id);
        venue.setActive(active);
        venueDao.save(venue);
    }

    public void deleteVenue(Long id) {
        venueDao.deleteById(id);
    }
}
