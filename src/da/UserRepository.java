/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package da;

import bl.Users;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author D Abazi
 */
public class UserRepository extends EntMngClass implements UserInterface{

    @Override
    public void create(Users u) throws LibraryException {
        try{
            em.getTransaction().begin();
            em.persist(u);
            em.getTransaction().commit();
        }catch(Exception e){
            throw new LibraryException("Error: \n"+ e.getMessage());
        }
    }

    @Override
    public void edit(Users u) throws LibraryException {
        try{
            em.getTransaction().begin();
            em.merge(u);
            em.getTransaction().commit();
        }catch(Exception e){
            throw new LibraryException("Error: \n" + e.getMessage());
        }
    }

    @Override
    public void delete(Users u) throws LibraryException {
        try{
            em.getTransaction().begin();
            em.remove(u);
            em.getTransaction().commit();
        }catch(Exception e){
            throw new LibraryException("Error: \n" + e.getMessage());
        }
    }

    @Override
    public List<Users> findAll() throws LibraryException {
        try{
            return em.createNamedQuery("Users.findAll").getResultList();
        }catch(Exception e){
            throw new LibraryException("Error: \n" + e.getMessage());
        }
    }

    @Override
    public Users findByID(Integer id){
        Query query = em.createQuery("SELECT u FROM Users u WHERE u.ID = :id");
        query.setParameter("id",id);
        return (Users)query.getSingleResult();
    }

    @Override
    public Users loginByUsernameAndPassword(String u, String p) throws LibraryException {
        try {
            Query query = em.createQuery("SELECT u FROM Users u WHERE u.username=:us AND u.password=:psw");
            query.setParameter("us", u);
            query.setParameter("psw", p);
            return (Users) query.getSingleResult();
        } catch (Exception e) {
            throw new LibraryException("Msg! \n" + e.getMessage());
        }

    }
}
