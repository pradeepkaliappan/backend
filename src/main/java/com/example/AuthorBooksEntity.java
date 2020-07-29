package com.example;

import java.time.LocalDate;

public class AuthorBooksEntity {

	public String authorname;
	public String bookname;
	public String price;
	public LocalDate createddate;
	public LocalDate publishdate;
	public int id;
	public String valuee;
	
	public AuthorBooksEntity() {}
	public AuthorBooksEntity(String authorname,String bookname,String price,
			LocalDate createddate,LocalDate publishdate,int id,String valuee) {
		this.authorname = authorname;
		this.bookname = bookname;
		this.price = price;
		this.createddate = createddate;
		this.publishdate = publishdate;
		this.id= id;
		this.valuee = valuee;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAuthorname() {
		return authorname;
	}
	public void setAuthorname(String authorname) {
		this.authorname = authorname;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public LocalDate getCreateddate() {
		return createddate;
	}
	public void setCreateddate(LocalDate createddate) {
		this.createddate = createddate;
	}
	public LocalDate getPublishdate() {
		return publishdate;
	}
	public void setPublishdate(LocalDate publishdate) {
		this.publishdate = publishdate;
	}
	public String getValuee() {
		return valuee;
	}
	public void setValuee(String valuee) {
		this.valuee = valuee;
	}
}
