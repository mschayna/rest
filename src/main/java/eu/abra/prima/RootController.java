package eu.abra.prima;

import javax.ws.rs.Path;

@Path("/")
public class RootController {
	
	@Path("/projects")
	public ProjectsController projects() {
		return new ProjectsController();
	}

	@Path("/timerecords")
	public TimeRecordsController timerecords() {
		return new TimeRecordsController(null);
	}
}
