package com.app.basic;

import java.util.*;

public class Book {
	private int id;
	private String name ;
	private List<Author> authors;
	private String publishers;
	private int pages;
	public EDITION edition;
	//can also add enum genre
	private double cost;
	private Date yop; //year of publishing
	public Book(int id,String name ,List<Author> authors,String publishers,int pages,double cost,EDITION edition,Date yop) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.name = name;
		this.authors = authors;
		this.publishers = publishers;
		this.pages = pages;
		this.edition = edition;
		this.cost = cost;
		this.yop = yop;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}

	public String getPublishers() {
		return publishers;
	}

	public void setPublishers(String publishers) {
		this.publishers = publishers;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public EDITION getEdition() {
		return edition;
	}

	public void setEdition(EDITION edition) {
		this.edition = edition;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public Date getYop() {
		return yop;
	}

	public void setYop(Date yop) {
		this.yop = yop;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
