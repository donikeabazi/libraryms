/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package da;

import bl.Author;
import java.util.List;

/**
 *
 * @author D Abazi
 */
public interface AuthorInterface {
    void create(Author a) throws LibraryException;
    void edit(Author a) throws LibraryException;
    void delete(Author a) throws LibraryException;
    List<Author> findAll() throws LibraryException;
    Author findByID(Integer id);
}
