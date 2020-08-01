/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package da;

import bl.Author;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author D Abazi
 */
public class AuthorRepository extends EntMngClass implements AuthorInterface{
    
    @Override
    public void create(Author a) throws LibraryException {
        try{
            em.getTransaction().begin();
            em.persist(a);
            em.getTransaction().commit();
        }catch(Exception e){
            throw new LibraryException("Error: \n"+ e.getMessage());
        }
    }

    @Override
    public void edit(Author a) throws LibraryException {
        try{
            em.getTransaction().begin();
            em.merge(a);
            em.getTransaction().commit();
        }catch(Exception e){
            throw new LibraryException("Error: \n" + e.getMessage());
        }
    }

    @Override
    public void delete(Author a) throws LibraryException {
        try{
            em.getTransaction().begin();
            em.remove(a);
            em.getTransaction().commit();
        }catch(Exception e){
            throw new LibraryException("Error: \n" + e.getMessage());
        }
    }

    @Override
    public List<Author> findAll() throws LibraryException {
        try{
            return em.createNamedQuery("Author.findAll").getResultList();
        }catch(Exception e){
            throw new LibraryException("Error: \n" + e.getMessage());
        }
    }

    @Override
    public Author findByID(Integer id){
        Query query = em.createQuery("SELECT a FROM Author a WHERE a.ID = :id");
        query.setParameter("id",id);
        return (Author)query.getSingleResult();
    }
}
