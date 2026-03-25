package com.collage.crowdex.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.collage.crowdex.domain.Alert;

public interface AlertDao extends JpaRepository<Alert, Long>{
	   List<Alert> findByUserId(int userId);
}
