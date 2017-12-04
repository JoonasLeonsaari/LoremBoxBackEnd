
package Controller;
 
import Model.Users;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

 
/**
 *
 
 */
@Stateless
public class DBControl {
   
    @PersistenceContext
    private EntityManager em;
 
    public DBControl() {
    }
    public List<Users> getAll(){
       List<Users> lst = em.createNamedQuery("User.findAll").getResultList(); 
       return lst;
        //em.createNamedQuery("users.findAll").getResultList();
        //List<User> lst = em.createNamedQuery("User.findAll").getResultList(); return lst;
    }
    public String getUser(Users u) {
    
        return em.createNamedQuery("users.findByName").toString();
    }
    
    //asking user object, because we don't now that user id yet
    public Users insert (Users u){
        em.persist(u);
        return u;
    }
}
    
    
    

/*    void getAll(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}*/