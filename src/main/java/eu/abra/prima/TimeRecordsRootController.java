package eu.abra.prima;

import javax.ws.rs.Path;

@Path("/timerecords")
public class TimeRecordsRootController extends TimeRecordsController {

	public TimeRecordsRootController() {
		super(null);
	}
}
