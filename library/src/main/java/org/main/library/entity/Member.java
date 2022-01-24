package org.main.library.entity;

import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name = "members")
public class Member {

	@Id
	@Column(name = "member_id")
	private String id;

	@Column(name = "fullname")
	private String fullname;

	@Column(name = "address")
	private String address;

	@Column(name = "init_date")
	private Date initDate;

	@Column(name = "expire_date")
	private Date expireDate;

	public Date getInitDate() {
		return initDate;
	}

	public void setInitDate(Date initDate) {
		this.initDate = initDate;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}


	public Member() {
		super();
	}

	public Member(String id, String fullname, String address, Date expireDate) {
		super();
		this.id = id;
		this.fullname = fullname;
		this.address = address;
		this.expireDate = expireDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullame(String fullname) {
		this.fullname = fullname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(Date expireDate) {

		this.expireDate = expireDate;
	}

	public Member(String id, String fullname, String address, Date initDate, Date expireDate) {
		super();
		this.id = id;
		this.fullname = fullname;
		this.address = address;
		this.initDate = initDate;
		this.expireDate = expireDate;
	}

}
