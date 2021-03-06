package eu.abra.prima;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.JResponse;

import eu.abra.prima.beans.CrudObject;

@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public interface ICrudController<T extends CrudObject<T>> {

	// Result must be wrapped by JResponse bucket due lack of serialization of
	// unknown generic types, this is Jersey specific class similar to JAX-RS 
	// GenericEntity class.   
	@GET
	JResponse<List<T>> list();
	
	@Path("/{id}")
	@GET
	T get(@PathParam("id") String id);
	
	@PUT
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	T put(T object);
	
	@Path("/{id}")
	@DELETE
	void delete(@PathParam("id") String id);
	
	@Path("/{id}")
	@POST
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	T post(@PathParam("id") String id, T object);
}
