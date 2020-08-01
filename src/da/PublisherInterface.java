/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package da;

import bl.Publisher;
import java.util.List;

/**
 *
 * @author Eliona M
 */
public interface PublisherInterface {
    void create(Publisher p) throws LibraryException;
    void edit(Publisher p) throws LibraryException;
    void delete(Publisher p) throws LibraryException;
    List<Publisher> findAll() throws LibraryException;
    Publisher findByID(Integer id);
}
