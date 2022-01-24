package org.main.library.service;

import java.sql.Date;
import java.time.LocalDate;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

import org.main.library.entity.Book;
import org.main.library.entity.Member;
import org.main.library.entity.Publisher;

@Path("/service")
public class LibraryService {

	@POST
	@Path("/createMember")
	@Consumes(MediaType.APPLICATION_JSON)
	public String createMember(Member member) {

		try {
			long time = System.currentTimeMillis();
			Date initDate = new Date(time);
			Date expireDate = new Date(time);

			expireDate.setMonth(initDate.getMonth() + 1);

			member.setInitDate(initDate);
			member.setExpireDate(expireDate);

			LibraryDAO.insertMember(member);
			return "Member with id: " + member.getId() + " was added sucessfully!";

		} catch (Exception e) {
			return "Member was not created";
		}

	}

	@POST
	@Path("/createPublisher")
	@Consumes(MediaType.APPLICATION_JSON)
	public String createPublisher(Publisher publisher) {

		try {
			LibraryDAO.insertPublisher(publisher);
			return "Publisher with id: " + publisher.getId() + " was added sucessfully!";
		} catch (Exception e) {
			System.out.println(e);
		}
		return "Publisher was not created!";

	}

	@POST
	@Path("/createBook/publisherId/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public String createBook(@PathParam("id") String id, Book book) {

		try {
			LibraryDAO.insertBook(id, book);
			return "Member with id: was sucessfuly inserted (smiley)";
		} catch (Exception e) {
			return "Member with id: was NOT sucessfuly inserted (sad)";
		}
	}

	

//	@POST
//	@Path("/insertBorrows/mid={id}")
//	@Consumes(MediaType.APPLICATION_JSON)
	public String insertBorrows(String memberId, String bookId) {

		try {

			LibraryDAO.insertBorrows(memberId, bookId);

			return "Member ID: " + memberId + " borrowed book with iD: " + bookId;
		} catch (Exception e) {
			System.out.println(e);
		}
		return "No book or member with that ID found!";

	}

	@GET
	@Path("/hello")
	public String hello() {

		long m = System.currentTimeMillis();
		Date d = new Date(m);
		LocalDate ld = LocalDate.now();
		return "Hello, World!  " + d.toString();
	}

}
