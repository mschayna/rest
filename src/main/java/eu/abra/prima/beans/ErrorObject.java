package eu.abra.prima.beans;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="error")
public class ErrorObject implements Serializable {
	private static final long serialVersionUID = 1L;

	private String message;
	
	public ErrorObject() {
		this("Unknown error.");
	}
	
	public ErrorObject(String message) {
		this.message = message;
	}

	@XmlElement(name="message")
	public String getMessage() {
		return message;
	}
}
