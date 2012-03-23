package eu.abra.prima;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import com.sun.jersey.api.JResponse;
import com.sun.jersey.core.util.MultivaluedMapImpl;
import com.sun.jersey.multipart.BodyPart;
import com.sun.jersey.multipart.FormDataBodyPart;
import com.sun.jersey.multipart.FormDataMultiPart;

import eu.abra.prima.beans.CrudObject;
import eu.abra.prima.exceptions.CrudException;

public abstract class CrudController<T extends CrudObject<T>> implements ICrudController<T> {

	protected abstract T newObject();
	
	@Override
	public JResponse<List<T>> list() {
		List<T> list = new ArrayList<T>();
		list.add(newObject());
		list.add(newObject());
		list.add(newObject());
		return JResponse.ok(list).build();
	}
	
	@Override
	public T get(String id) {
		return newObject();
	}

	@Override
	public T put(T object) {
		return object;
	}

	@Override
	public void delete(String id) {
	}

	@Override
	public T post(String id, T object) {
		return object;
	}
	
	@Path("/error")
	@GET
	public T error() throws CrudException {
		throw new CrudException("Error in error method.");
	}
	
	@Path("/service")
	@Consumes(MediaType.WILDCARD)
	@GET
	public T service(@QueryParam("id") String id) {
		T object = newObject();
		object.setId(id);
		return object;
	}

	@Path("/service")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@POST
	public T service(MultivaluedMap<String, String> formData) {
		return service(formData.getFirst("id"));
	}

	@Path("/service")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@POST
	public T serviceForm(FormDataMultiPart form) {
		return service(convertFormData(form));
	}
	
	private MultivaluedMap<String, String> convertFormData(FormDataMultiPart form) {
		MultivaluedMap<String, String> formData = new MultivaluedMapImpl();
		for (BodyPart part: form.getBodyParts()) {
			FormDataBodyPart data = (FormDataBodyPart) part;
			formData.add(data.getName(), data.getValue());
		}
		return formData;
	}
}
