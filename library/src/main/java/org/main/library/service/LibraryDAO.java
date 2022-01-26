package org.main.library.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.main.library.entity.Book;
import org.main.library.entity.Borrows;
import org.main.library.entity.BorrowsDTO;
import org.main.library.entity.Member;
import org.main.library.entity.Publisher;

public class LibraryDAO {

	static SessionFactory factory;
	static Transaction tx = null;

	public static Session initDB() {

		Configuration cfg = new Configuration();
		try {
			cfg.addAnnotatedClass(org.main.library.entity.Book.class);
			cfg.addAnnotatedClass(org.main.library.entity.Publisher.class);
			cfg.addAnnotatedClass(org.main.library.entity.Borrows.class);
			cfg.addAnnotatedClass(org.main.library.entity.Member.class);

			factory = cfg.configure().buildSessionFactory();
			Session session = factory.openSession();

			return session;
		} catch (HibernateException e) {
			System.out.println(e);
		}

		return null;
	}

	public static void insertMember(Member member) {
		Session s = initDB();
		try {
			tx = s.beginTransaction();

			s.save(member);

			tx.commit();
			s.close();

		} catch (HibernateException e) {
			tx.rollback();
			System.out.println(e);
		}

	}

	public static void insertPublisher(Publisher publisher) {
		Session s = initDB();

		try {
			tx = s.beginTransaction();

			s.save(publisher);

			tx.commit();
			s.close();

		} catch (HibernateException e) {
			tx.rollback();
			System.out.println(e);
		}

	}

	public static void insertBook(String id, Book book) {
		Session session = initDB();

		try {

			tx = session.beginTransaction();

			book.setPublisher(getPublisher(id));
			session.save(book);

			tx.commit();
			session.close();

		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		}
	}

	public static void insertBorrows(BorrowsDTO borrowsDTO) {

		Session s = initDB();

		Book book = getBook(borrowsDTO.getBookId());
		Member member = getMember(borrowsDTO.getMemberId());

		try {
			tx = s.beginTransaction();

			long time = System.currentTimeMillis();
			Date initDate = new Date(time);
			Date expireDate = new Date(time);

			expireDate.setDate(initDate.getDay() + 14);

			Borrows borrows = new Borrows(member, book);
			borrows.setIssue(initDate);
			borrows.setDueDate(expireDate);
			borrows.setReturned(false);

			book.setQuantity(book.getQuantity() - 1);

			s.save(borrows);
			s.update(book);

			tx.commit();
			s.close();

		} catch (HibernateException e) {
			tx.rollback();
			System.out.println(e);
		}
	}

	public static void insertReturned(BorrowsDTO borrowsDTO) {

		Book book = getBook(borrowsDTO.getBookId());

		Borrows borrows = getBorrows(borrowsDTO.getMemberId());

		try {
			Session s = initDB();
			tx = s.beginTransaction();

			borrows.setReturned(true);

			book.setQuantity(book.getQuantity() + 1);

			s.update(borrows);
			tx.commit();
			s.close();

			s = initDB();
			tx = s.beginTransaction();
			s.update(book);

			tx.commit();
			s.close();

		} catch (HibernateException e) {
			tx.rollback();
			System.out.println(e);
		}
	}

	public static Borrows getBorrows(String id) {

		List<Borrows> result = new ArrayList<>();

		try {

			Session s = initDB();

			result = s.createNativeQuery("SELECT * FROM Borrows WHERE member_member_id='" + id + "';", Borrows.class)
					.list();

		} catch (HibernateException e) {
			System.out.println(e);
		}
		return result.get(0);
	}

	public static Book getBook(String id) {

		Session s = initDB();

		String hql = "FROM Book b WHERE b.id=:bid";
		Query query = s.createQuery(hql).setParameter("bid", id);

		List<Book> result = query.list();

		return result.get(0);

	}

	public static Member getMember(String id) {

		Session s = initDB();

		String hql = "FROM Member m WHERE m.id=:mid";
		Query query = s.createQuery(hql).setParameter("mid", id);

		List<Member> result = query.list();

		return result.get(0);

	}

	public static Publisher getPublisher(String id) {

		Session session = initDB();

		String hql = "FROM Publisher P WHERE P.id =:pid";
		Query query = session.createQuery(hql);
		query.setParameter("pid", id);

		List<Publisher> results = query.list();

		return results.get(0);

	}

	public static List<Book> getBooks() {

		Session session = initDB();

		try {

			String hql = "FROM Book B";
			Query query = session.createQuery(hql);

			List<Book> books = query.list();

			return books;

		} catch (HibernateException e) {
			e.printStackTrace();
		}

		return null;
	}

	public static List<Member> getMembers() {

		Session session = initDB();

		try {

			String hql = "FROM Members M";
			Query query = session.createQuery(hql);

			List<Member> members = query.list();

			return members;

		} catch (HibernateException e) {
			e.printStackTrace();
		}

		return null;
	}

}
