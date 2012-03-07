package eu.abra.prima;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import eu.abra.prima.beans.Project;

public class ProjectsController extends CrudController<Project> {
	
	@Override
	protected Project newObject() {
		return new Project();
	}
	
	@Path("/{id}/timerecords")
	public Object timerecords(@PathParam("id") String id) {
		return new TimeRecordsController(id);
	}
}
