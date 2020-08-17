package com.impetus.authorservice.model;

public class CatalogItem {

	private long bookId;
	private String bookNmae;
	private String category;
	private double price;

	public CatalogItem() {

	}

	public CatalogItem(long bookId, String bookNmae, String category, double price) {

		this.bookId = bookId;
		this.bookNmae = bookNmae;
		this.category = category;
		this.price = price;
	}

	public String getBookNmae() {
		return bookNmae;
	}

	public void setBookNmae(String bookNmae) {
		this.bookNmae = bookNmae;
	}

	public long getBookId() {
		return bookId;
	}

	public void setBookId(long bookId) {
		this.bookId = bookId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "CatalogItem [bookId=" + bookId + ", bookNmae=" + bookNmae + ", category=" + category + ", price="
				+ price + "]";
	}

	
}
