
package Controller;
 
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Produces;
import javax.ws.rs.*;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import Model.Users;
import java.util.Date;

 
/**
 * REST Web Service
 */
@Path("service")
public class DBService {
 
    @EJB
    private DBControl dbc;
 
    /**
     * Creates a new instance of DBService
     */
    public DBService() {
    }
 
    /**
     * Retrieves representation of an instance of Controller.DBService
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)

    public List<Users> getJson() {
      
        return dbc.getAll();
    }
 
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("setpass")
    public Users post(@FormParam("username") String name, @FormParam("password") String pass) {
        
        
       Users u = new Users();
       u.setUsername(name);
       u.setPasswrd(pass);
        
        return dbc.insert(u);
        
    }
       
    /**
     * PUT method for updating or creating an instance of DBService
     * @param content representation for the resource
     */
    //@PUT
    //@Consumes(MediaType.APPLICATION_JSON)
    //public void putJson(String content) {
    //}
}
 

