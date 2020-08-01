/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package da;

import bl.Publisher;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Eliona M
 */
public class PublisherRepository extends EntMngClass implements PublisherInterface{

    @Override
    public void create(Publisher p) throws LibraryException {
        try{
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
        }catch(Exception e){
            throw new LibraryException("Error: \n"+ e.getMessage());
        }
    }

    @Override
    public void edit(Publisher p) throws LibraryException {
        try{
            em.getTransaction().begin();
            em.merge(p);
            em.getTransaction().commit();
        }catch(Exception e){
            throw new LibraryException("Error: \n" + e.getMessage());
        }
    }

    @Override
    public void delete(Publisher p) throws LibraryException {
        try{
            em.getTransaction().begin();
            em.remove(p);
            em.getTransaction().commit();
        }catch(Exception e){
            throw new LibraryException("Error: \n" + e.getMessage());
        }
    }

    @Override
    public List<Publisher> findAll() throws LibraryException {
        try{
            return em.createNamedQuery("Publisher.findAll").getResultList();
        }catch(Exception e){
            throw new LibraryException("Error: \n" + e.getMessage());
        }
    }

    @Override
    public Publisher findByID(Integer id){
        Query query = em.createQuery("SELECT p FROM Publisher p WHERE p.ID = :id");
        query.setParameter("id",id);
        return (Publisher)query.getSingleResult();
    }

    
}
