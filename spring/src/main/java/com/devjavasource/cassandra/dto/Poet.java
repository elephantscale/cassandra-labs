package com.devjavasource.cassandra.dto;

import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

@Table
public class Poet {
	@PrimaryKey
	private int id;

	private String address;
	private String name;

	public Poet(int id, String address, String name) {
		this.id = id;
		this.address = address;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getAddress() {
		return address;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Poet [id=" + id + ", address=" + address + ", name=" + name
				+ "]";
	}
}
