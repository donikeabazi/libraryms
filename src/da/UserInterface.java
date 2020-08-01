/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package da;

import bl.Users;
import java.util.List;

/**
 *
 * @author D Abazi
 */
public interface UserInterface {
    void create(Users u) throws LibraryException;
    void edit(Users u) throws LibraryException;
    void delete(Users u) throws LibraryException;
    List<Users> findAll() throws LibraryException;
    Users findByID(Integer id);
    Users loginByUsernameAndPassword(String u, String p) throws LibraryException;
}
