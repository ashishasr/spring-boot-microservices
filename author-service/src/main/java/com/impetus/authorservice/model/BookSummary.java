package com.impetus.authorservice.model;

import java.util.List;

public class BookSummary {

	private long authorId;
	private List<Book> bookList;

	public BookSummary() {

	}

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

	@Override
	public String toString() {
		return "BookSummary [authorId=" + authorId + ", bookList=" + bookList + "]";
	}

}
