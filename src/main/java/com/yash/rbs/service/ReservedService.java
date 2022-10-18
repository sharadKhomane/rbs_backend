package com.yash.rbs.service;

import com.yash.rbs.model.BookedDetails;
import com.yash.rbs.model.RoomBookedDetails;

public interface ReservedService {
	
	RoomBookedDetails bookedRoom(BookedDetails obj);
}
