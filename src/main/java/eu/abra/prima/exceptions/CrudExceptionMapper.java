package eu.abra.prima.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import eu.abra.prima.beans.ErrorObject;

@Provider
public class CrudExceptionMapper implements ExceptionMapper<CrudException> {

	@Override
	public Response toResponse(CrudException exception) {
		return Response.serverError().entity(new ErrorObject(exception.getMessage())).build();
	}
}
