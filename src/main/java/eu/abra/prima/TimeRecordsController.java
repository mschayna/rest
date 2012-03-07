package eu.abra.prima;

import eu.abra.prima.beans.TimeRecord;

public class TimeRecordsController extends CrudController<TimeRecord> {

	private String projectId = null;
	
	public TimeRecordsController(String projectId) {
		this.projectId = projectId;
	}
	
	@Override
	protected TimeRecord newObject() {
		TimeRecord object = new TimeRecord();
		object.setProjectId(this.projectId);
		return object;
	}

}
