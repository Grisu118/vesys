package ch.fhnw.ds.rest.wadl;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Customer {
	private int id; 
	private String name;
	private String prename;

	@SuppressWarnings("unused")
	private Customer() {
	}

	public Customer(int id, String name, String prename) {
		this.id = id;
		this.name = name;
		this.prename = prename;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrename() {
		return prename;
	}

	public void setPrename(String priname) {
		this.prename = priname;
	}

	public int getId() {
		return id;
	}

}
