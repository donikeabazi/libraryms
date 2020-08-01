/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package da;

import bl.Book;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Gjyli
 */
public class BookRepository extends EntMngClass implements BookInterface{
    
    @Override
    public void create(Book b) throws LibraryException {
        try{
            em.getTransaction().begin();
            em.persist(b);
            em.getTransaction().commit();
        }catch(Exception e){
            throw new LibraryException("Error: \n"+ e.getMessage());
        }
    }

    @Override
    public void edit(Book b) throws LibraryException {
        try{
            em.getTransaction().begin();
            em.merge(b);
            em.getTransaction().commit();
        }catch(Exception e){
            throw new LibraryException("Error: \n" + e.getMessage());
        }
    }

    @Override
    public void delete(Book b) throws LibraryException {
        try{
            em.getTransaction().begin();
            em.remove(b);
            em.getTransaction().commit();
        }catch(Exception e){
            throw new LibraryException("Error: \n" + e.getMessage());
        }
    }

    @Override
    public List<Book> findAll() throws LibraryException {
        try{
            return em.createNamedQuery("Book.findAll").getResultList();
        }catch(Exception e){
            throw new LibraryException("Error: \n" + e.getMessage());
        }
    }
    
    @Override
    public Book findByID(Integer id){
        Query query = em.createQuery("SELECT b FROM Book b WHERE b.ID = :id");
        query.setParameter("id",id);
        return (Book)query.getSingleResult();
    }

    @Override
    public List<Book> searchMatch(String title) throws LibraryException{
        try{
            Query query = em.createQuery("SELECT b FROM Book b WHERE b.title like '%" + title + "%'");
            //query.setParameter("title",title);
            return query.getResultList();
        }catch(Exception e){
            throw new LibraryException("Error: \n" + e.getMessage());
        }
    }
}
