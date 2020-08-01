/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package da;

import bl.Book;
import java.util.List;

/**
 *
 * @author Gjyli
 */
public interface BookInterface {
    void create(Book b) throws LibraryException;
    void edit(Book b) throws LibraryException;
    void delete(Book b) throws LibraryException;
    List<Book> findAll() throws LibraryException;
    Book findByID(Integer id);
    List<Book> searchMatch(String title) throws LibraryException;
}
