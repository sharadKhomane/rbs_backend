package com.yash.rbs.service;

import java.util.List;

import com.yash.rbs.model.RegisterResponseModel;
import com.yash.rbs.model.Room;
import com.yash.rbs.model.RoomDto;

public interface RoomService {
	
	List<Room> findAllRoom();
	//List<Room> findRoomNumber(Integer roomNumber);
	RegisterResponseModel saveRoom(RoomDto roomdto);
	Boolean delete(Integer roomId);

}
