/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package da;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author D Abazi
 */
public abstract class EntMngClass {
    EntityManager em = Persistence.createEntityManagerFactory("LibraryMSPU").createEntityManager();
}
