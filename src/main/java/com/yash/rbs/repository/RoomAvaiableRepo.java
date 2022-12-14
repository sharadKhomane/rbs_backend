package com.yash.rbs.repository;

import java.util.Date;
import java.util.Optional;

import com.yash.rbs.model.RoomAvaiable;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomAvaiableRepo extends JpaRepository<RoomAvaiable, Integer> {

	RoomAvaiable findByAvaiableDate(Date date);

	//RoomAvaiable findTopByOrderByIdDesc();
	
	Optional<RoomAvaiable> findTopByOrderByIdDesc();
}
