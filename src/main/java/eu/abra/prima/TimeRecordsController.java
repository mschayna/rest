package eu.abra.prima;

import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import eu.abra.prima.beans.TimeRecord;

@Path("/projects/{id}/timerecords")
public class TimeRecordsController extends CrudController<TimeRecord> {

	private String projectId = null;
	
	public TimeRecordsController(@QueryParam("id") String projectId) {
		this.projectId = projectId;
	}
	
	@Override
	protected TimeRecord newObject() {
		TimeRecord object = new TimeRecord();
		object.setProjectId(this.projectId);
		return object;
	}
}
