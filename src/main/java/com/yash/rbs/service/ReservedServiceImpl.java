package com.yash.rbs.service;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import com.yash.rbs.model.Book;
import com.yash.rbs.model.BookedDetails;
import com.yash.rbs.model.Resvered;
import com.yash.rbs.model.Room;
import com.yash.rbs.model.RoomAvaiable;
import com.yash.rbs.model.RoomBookedDetails;
import com.yash.rbs.model.RoomNumber;
import com.yash.rbs.model.RoomType;
import com.yash.rbs.model.SearchBookResult;
import com.yash.rbs.repository.BookRepo;
import com.yash.rbs.repository.ReservedRepo;
import com.yash.rbs.repository.RoomAvaiableRepo;
import com.yash.rbs.repository.RoomRepo;
import com.yash.rbs.repository.RoomTypeRepo;
import com.yash.rbs.util.DateUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservedServiceImpl implements ReservedService {


	@Autowired
	RoomAvaiableRepo roomAvaiablerepo;
	@Autowired
	ReservedRepo reservedRepo;
	
	@Autowired
	RoomRepo roomRepo;
	
	@Autowired
	RoomTypeRepo roomTypeRepo;
	
	@Autowired
	BookRepo bookRepo;

	public RoomBookedDetails bookedRoom(BookedDetails bookDetails) {
		// TODO Auto-generated method stub

		/*
		 * String arriveDate = bookDetails.getCheckIn(); RoomBookedDetails
		 * roomBookedDetails; String departureDate = bookDetails.getCheckOut();
		 * LocalDate start = LocalDate.parse(arriveDate); LocalDate end =
		 * LocalDate.parse(departureDate); LocalDateTime now= LocalDateTime.now(); Date
		 * checkIn = java.sql.Date.valueOf(start); Date checkOut =
		 * java.sql.Date.valueOf(end); List<LocalDate> totalDates = new
		 * ArrayList<LocalDate>(); while (!start.isAfter(end)) { totalDates.add(start);
		 * start = start.plusDays(1); } RoomAvaiable roomAvaiable = null; Integer
		 * tempCount=bookDetails.getRoomCount(); while(tempCount>0) { for (LocalDate t :
		 * totalDates) { Date date = java.sql.Date.valueOf(t); Timestamp
		 * today=java.sql.Timestamp.valueOf(now); roomAvaiable =
		 * roomAvaiablerepo.findByAvaiableDate(date); Integer updatedCount = 0; if
		 * (roomAvaiable.getCount() > 0) { updatedCount = roomAvaiable.getCount() - 1;
		 * 
		 * 
		 * } roomAvaiable.setCount(updatedCount); roomAvaiablerepo.save(roomAvaiable);
		 * Resvered re = new Resvered(); re.setCheckIn(checkIn);
		 * re.setCheckOut(checkOut); re.setRoomAvaiable(roomAvaiable);
		 * re.setBookDate(today); re.setTypeId(bookDetails.getTypeId());
		 * reservedRepo.save(re); } tempCount--; } roomBookedDetails
		 * =allowcateRoom(bookDetails);
		 */
		return null;

	}

	private RoomBookedDetails allowcateRoom(BookedDetails bookDetails) {
		// TODO Auto-generated method stub
		
		/*
		 * RoomType rooType=roomTypeRepo.findByRoomTypeid(bookDetails.getTypeId());
		 * RoomBookedDetails roomBookedDetails=new RoomBookedDetails();
		 * roomBookedDetails.setRoomCount(bookDetails.getRoomCount());
		 * roomBookedDetails.setRoomTypes(rooType.getRoomTypes());
		 * roomBookedDetails.setTotalAmount(rooType.getPrice()*bookDetails.getRoomCount(
		 * )); roomBookedDetails.setRoomCount(bookDetails.getRoomCount());
		 */
		//List<Room> room=roomRepo.findByRoomid(bookDetails.getTypeId(), true);
		/*
		 * Room room=roomRepo.findByRoomType(rooType); if(room!=null) {
		 * room.setStatus(false); roomRepo.save(room); } else { throw new
		 * NullPointerException(); }
		 */
		
		/*Room room=roomRepo.findFirstByOrderByRoom_TypeidAsc(bookDetails.getTypeId());
		System.out.println("RRRRRRRRRrr   :::: "+room.getRoomNumber());
		System.out.println("KKKKKKKKKKKKKK ::"+room.getRoomId());*/
		return null;
	}

	public List<Book> bookRoom(BookedDetails bookedDetails) {
		
		List<RoomNumber> obj=bookedDetails.getList();
		List<Book> bookList = new ArrayList<>();
		LocalDate start;
		String str_date = bookedDetails.getCheckIn();
		String[] array = str_date.split("\\ ");
		start = LocalDate.parse(array[0]);
		Date checkin=DateUtil.getStringtoDate(bookedDetails.getCheckIn());
		Date checkout=DateUtil.getStringtoDate(bookedDetails.getCheckOut());
		long difference=ChronoUnit.DAYS.between(checkin.toInstant(), checkout.toInstant());
		int datediffer=(int)difference+1;
		System.out.println("PPPPP:: "+datediffer);
		LocalDate target = start.plusDays(datediffer);
		while (!start.isEqual(target))
		{	
			System.out.println("start date is::"+start);
		
			
			  for(RoomNumber ob:obj) { Room
			  room=roomRepo.findByRoomNumber(ob.getRoomNumber());
			  
			  if(room!=null) { Book book=new Book();
			  book.setCheckIn(DateUtil.getStringtoDate(bookedDetails.getCheckIn()));
			  book.setCheckOut(DateUtil.getStringtoDate(bookedDetails.getCheckOut()));
			  book.setRoom(room);
			  Date avdate =java.sql.Date.valueOf(start);
			  book.setBookDate(avdate);
			  book.setCreatedDate(DateUtil.getCurrentDateTime());
			  bookRepo.save(book); 
			 bookList.add(book);
			  }
		  }
				start = start.plusDays(1);
			 
		}
		
		return bookList;
	}

	public List<SearchBookResult> searchRoomByDate(BookedDetails bookedDetails) {
		// TODO Auto-generated method stub
		Date checkIn = DateUtil.getStringtoDate(bookedDetails.getCheckIn());
		Date checkout = DateUtil.getStringtoDate(bookedDetails.getCheckOut());
		List<Book> list = bookRepo.getAllDateBetween(checkIn, checkout);
		List<Room> roomList = roomRepo.findAllRoomByType(bookedDetails.getTypeId());
		List<SearchBookResult> searchList = new ArrayList<>();
		List<SearchBookResult> roomNumberList =new ArrayList<>();
		for (Room room : roomList) {
			SearchBookResult search = new SearchBookResult();
			search.setRoomNumber(room.getRoomNumber());
			search.setStatus(true);
			searchList.add(search);
		}
		
		for (SearchBookResult searchObj : searchList) {
			
			for (Book li : list) {
				if (li.getRoom().getRoomNumber() == searchObj.getRoomNumber())
				{
					searchObj.setStatus(false);
					roomNumberList.add(searchObj);
				}
				else
				{
					roomNumberList.add(searchObj);
				}
			}

		}
		List<SearchBookResult> uniqueList = roomNumberList.stream().distinct().collect(Collectors.toList());
		if (!roomNumberList.isEmpty())
			return uniqueList;
		else
			return searchList;
	}
}
