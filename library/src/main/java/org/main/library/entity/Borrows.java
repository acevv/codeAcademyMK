package org.main.library.entity;

import java.sql.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "Borrows")
public class Borrows {

	@EmbeddedId
	private BorrowsId borrowsId;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@MapsId("memberId")
	private Member member;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@MapsId("bookId")
	private Book book;
	
	@Column(name  = "dueDate")
	private Date dueDate;
	
	@Column(name = "issueDate")
	private Date issueDate;
	
	public Borrows() {
		super();
	}

	public Borrows(Member member, Book book, Date issueDate) {
		super();
		this.member=member;
		this.book=book;
		this.issueDate = issueDate;
		this.borrowsId = new BorrowsId(member.getId(),book.getId());
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Date getIssueDate() {
		return this.issueDate;
	}

	public void setIssue(Date issue) {
		this.issueDate = issue;
	}	
	
}

