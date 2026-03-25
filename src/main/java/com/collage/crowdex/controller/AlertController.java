package com.collage.crowdex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.collage.crowdex.domain.Alert;
import com.collage.crowdex.services.AlertService;

@RestController
@RequestMapping("/alerts")
public class AlertController {

	@Autowired
	private AlertService alertService;

	@PostMapping("/save")
	public Alert saveAlert(@RequestBody Alert alert) {
		return alertService.saveAlert(alert);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteAlert(@PathVariable Long id) {
		return alertService.deleteAlert(id);
	}

	@GetMapping("/getallalert/{userid}")
	public List<Alert> getAllAlerts(@PathVariable int userid) {
		return alertService.getAlertsByUserId(userid);
	}
}
