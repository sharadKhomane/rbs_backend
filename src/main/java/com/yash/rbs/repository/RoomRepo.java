package com.yash.rbs.repository;

import java.util.List;

import com.yash.rbs.model.Room;
import com.yash.rbs.model.RoomTypeJoinDTO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RoomRepo extends JpaRepository<Room, Integer> {

	List<Room> findByRoomNumber(Integer roomNumber);
	
	
	/*
	 * @Query("Select a from Room a  left join Room_type b on a.room_typeid=b.room_typeid"
	 * ) List<Room> findAllData();
	 */
	
}
