package com.impetus.authorservice.model;

import java.util.List;

public class BookInfoForAuthor {

	private long authorId;
	private List<Book> bookList;
	
	public long getAuthorId() {
		return authorId;
	}
	public void setAuthorId(long authorId) {
		this.authorId = authorId;
	}
	public List<Book> getBookList() {
		return bookList;
	}
	public void setBookList(List<Book> bookList) {
		this.bookList = bookList;
	}
	
	
}
