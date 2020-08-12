package com.impetus.bookservice.dao.BookStoreDAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.impetus.bookservice.dao.IBookStoreDAO;
import com.impetus.bookservice.model.Book;

@Transactional
@Repository
public class BookStoreDAO implements IBookStoreDAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	/**
	 * this method is to get all books availabe in database and return it as List<Book>
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Book> getBooks() {
		// TODO Auto-generated method stub
		String sql = "FROM Book as b ORDER BY b.id";
		return (List<Book>) entityManager.createQuery(sql).getResultList();
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public List<Book> getBooks(long authorId) {
		// TODO Auto-generated method stub
		String sql = "FROM Book as b where b.author_id = " + authorId;
		return (List<Book>) entityManager.createQuery(sql).getResultList();
	}
	
	
	/**
	 * This methiod is responsible to get a particular book detail for a given book id
	 */
	@Override
	public Book getBook(int bookId) {
		// TODO Auto-generated method stub
		return entityManager.find(Book.class, bookId);
	}

	/**
	 * This method is to create a new book in database
	 */
	@Override
	public Book createBook(Book book) {
		// TODO Auto-generated method stub
		 entityManager.persist(book);
		 Book b = getLastinsertedBook();
		 return b;
		 
	}
	
	
	/**
	 * This method will get teh latest inserted record in database and return the Book object
	 * @return
	 */

	private Book getLastinsertedBook() {
		// TODO Auto-generated method stub
		String sql  = "from Book order by id DESC";
		Query query = entityManager.createQuery(sql);
		Book book = (Book)query.setMaxResults(1).getSingleResult();
		return book;
		
	}

	@Override
	public Book updateBook(int bookId, Book book) {
		// TODO Auto-generated method stub
		//first retreive the book  detail from DB by given book id and then updating 
		//detail with provided book object
		Book bookFromDB = getBook(bookId);
		bookFromDB.setName(book.getName());
		//bookFromDB.setAuthor(book.getAuthor());
		bookFromDB.setPrice(book.getPrice());
		bookFromDB.setCategory(book.getCategory());
		
		entityManager.flush();
		Book updatedBook =  getBook(bookId);
		
		return updatedBook;
	}

	/*private Book getBook(int bookId) {
		// TODO Auto-generated method stub
		String sql = "from Book";
		entityManager.createQuery(qlString);
		return null;
		
	}*/

	@Override
	public boolean deleteBook(int bookId) {
		// TODO Auto-generated method stub
		Book bookToRemove = getBook(bookId);
		entityManager.remove(bookToRemove);
		
		boolean status = entityManager.contains(bookToRemove);
		if(status) {
			return false;
		}
		
		return true;
	}

}
