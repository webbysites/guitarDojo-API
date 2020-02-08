package com.guitardojo.api.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "staff-member")
public class StaffMember {
	@Id
	private String id;
	private String name;
	private String title;
	private String bio;
	private String img;
	
	public StaffMember(String id, String name, String title, String bio, String img) {
		this.id = id;
		this.name = name;
		this.title = title;
		this.bio = bio;
		this.img = img;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}
	
	
}
