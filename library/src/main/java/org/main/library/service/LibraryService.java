package org.main.library.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.main.library.entity.Book;
import org.main.library.entity.BorrowsDTO;
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

	@POST
	@Path("/createBorrows")
	@Consumes(MediaType.APPLICATION_JSON)
	public String insertBorrows(BorrowsDTO borrowsDTO) {

		try {

			LibraryDAO.insertBorrows(borrowsDTO);

			return "Member ID: " + borrowsDTO.getMemberId() + " borrowed book with iD: " + borrowsDTO.getBookId();
		} catch (Exception e) {
			System.out.println(e);
		}
		return "No book or member with that ID found!";

	}

	@POST
	@Path("/createReturned")
	@Consumes(MediaType.APPLICATION_JSON)
	public String createReturns(BorrowsDTO borrowsDTO) {

		try {

			LibraryDAO.insertReturned(borrowsDTO);

			return "Member : " + LibraryDAO.getMember(borrowsDTO.getMemberId()).getFullname()
					+ " returned book with title: " + LibraryDAO.getBook(borrowsDTO.getBookId()).getTitle();
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

	@GET
	@Path("/getAllBooks")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Book> getAllBooks() {

		List<Book> books = LibraryDAO.getBooks();

		return books;

	}

	@GET
	@Path("/getAllMembers")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Member> getAllMembers() {

		List<Member> members = LibraryDAO.getMembers();

		return members;

	}

}
