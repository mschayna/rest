package eu.abra.prima;

import javax.ws.rs.Path;

import eu.abra.prima.beans.Project;

@Path("/projects")
public class ProjectsController extends CrudController<Project> {
	
	@Override
	protected Project newObject() {
		return new Project();
	}
}
