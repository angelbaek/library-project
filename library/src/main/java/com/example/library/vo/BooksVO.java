package com.example.library.vo;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class BooksVO {
	
	Integer uniqueNumber;
	String name;
	String genre;
	String author;
	boolean isUse;

	public boolean isUse() {
		return isUse;
	}

	public void setUse(boolean isUse) {
		this.isUse = isUse;
	}

	public Integer getUniqueNumber() {
		return uniqueNumber;
	}

	public void setUniqueNumber(Integer uniqueNumber) {
		this.uniqueNumber = uniqueNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
}