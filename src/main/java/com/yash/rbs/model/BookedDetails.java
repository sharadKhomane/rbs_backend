package com.yash.rbs.model;

import java.util.Date;
import java.util.List;

public class BookedDetails {
	
	private List<RoomNumber> list;
	private String checkIn;
	private String checkOut;
	private Date bookDate;
	private Integer dateRange;
	private Integer typeId;
	
	public Integer getTypeId() {
		return typeId;
	}
	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}
	public Integer getDateRange() {
		return dateRange;
	}
	public void setDateRange(Integer dateRange) {
		this.dateRange = dateRange;
	}
	public Date getBookDate() {
		return bookDate;
	}
	public void setBookDate(Date bookDate) {
		this.bookDate = bookDate;
	}
	public String getCheckIn() {
		return checkIn;
	}
	public void setCheckIn(String checkIn) {
		this.checkIn = checkIn;
	}
	public String getCheckOut() {
		return checkOut;
	}
	public void setCheckOut(String checkOut) {
		this.checkOut = checkOut;
	}
	public List<RoomNumber> getList() {
		return list;
	}
	public void setList(List<RoomNumber> list) {
		this.list = list;
	}
	
	
	

}
