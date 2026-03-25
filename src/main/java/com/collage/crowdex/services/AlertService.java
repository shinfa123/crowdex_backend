package com.collage.crowdex.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collage.crowdex.dao.AlertDao;
import com.collage.crowdex.domain.Alert;
import com.collage.crowdex.domain.Event;
import com.collage.crowdex.domain.MyUser;

@Service
public class AlertService {

    @Autowired
    private AlertDao alertRepository;

    @Autowired
    private UserService userService;
    
    @Autowired
    private EventService eventService;
    
    // Save Alert
	public Alert saveAlert(Alert alert) {
		if(!alert.getIsOpen()) {
		Event event = eventService.getEventById(alert.getEvent().getId());
		List<Integer> userIds = event.getUserIds();
		for (Integer userId : userIds) {
			Alert not = new Alert();
			not.setEvent(event);
			not.setIsActive(true);
			not.setMessage(alert.getMessage());
			not.setRiskStatus(alert.getRiskStatus());
			MyUser myUser = userService.getUserById(userId);
			not.setUser(myUser);
			alertRepository.save(not);
		}
		}else {
			alertRepository.save(alert);
		}
		return alert;
	}

    // Delete Alert
    public String deleteAlert(Long id) {
        Optional<Alert> alert = alertRepository.findById(id);

        if (alert.isPresent()) {
            alertRepository.deleteById(id);
            return "Alert deleted successfully";
        } else {
            return "Alert not found";
        }
    }
    
    public List<Alert> getAlertsByUserId(int userId) {
        return alertRepository.findByUserId(userId);
    }
}