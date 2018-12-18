package com.devjavasource.cassandra.dto;

import java.util.Date;

import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

@Table
public class Feature {
	@PrimaryKey
	private String code;

	private String name;
	private String type;
	private Date release_date;

	public Feature(String code, String name, String type, Date release_date) {
		this.code = code;
		this.name = name;
		this.type = type;
		this.release_date = release_date;
	}

	public String getCode() {
		return code;
	}



	public void setCode(String code) {
		this.code = code;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	public Date getReleaseDate() {
		return release_date;
	}



	public void setReleaseDate(Date releaseDate) {
		this.release_date = releaseDate;
	}



	@Override
	public String toString() {
		return "Feature [code=" + code + ", name=" + name + ", type=" + type
				+ ", release date=" + release_date + "]";
	}
}
