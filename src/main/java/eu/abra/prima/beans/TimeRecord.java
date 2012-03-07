package eu.abra.prima.beans;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "timerecord")
public class TimeRecord extends CrudObject<TimeRecord> {
	private static final long serialVersionUID = 1L;
	
	private String projectId = null;

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
}
