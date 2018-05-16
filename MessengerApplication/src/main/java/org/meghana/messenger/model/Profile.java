package org.meghana.messenger.model;

import java.util.Date;

public class Profile {

	private long id;
	private String profilename;
	private String fname;
	private String lname;
	private Date created;
	
	public Profile(long id, String profilename, String fname, String lname, Date created) {
		super();
		this.id = id;
		this.profilename = profilename;
		this.fname = fname;
		this.lname = lname;
		this.created = created;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getProfilename() {
		return profilename;
	}

	public void setProfilename(String profilename) {
		this.profilename = profilename;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	} 
	
	
}
