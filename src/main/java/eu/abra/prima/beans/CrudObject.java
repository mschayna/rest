package eu.abra.prima.beans;

import java.io.Serializable;
import java.util.UUID;

public class CrudObject<T extends CrudObject<T>> implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id = UUID.randomUUID().toString();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
