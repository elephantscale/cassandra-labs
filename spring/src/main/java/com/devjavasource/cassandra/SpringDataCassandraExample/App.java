package com.devjavasource.cassandra.SpringDataCassandraExample;

import java.util.List;

import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.data.cassandra.core.CassandraTemplate;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.datastax.driver.core.querybuilder.Select;

import com.devjavasource.cassandra.dto.Poet;

public class App {
	private static Cluster cluster;
	private static Session session;

	public static void main(String[] args) {

		try {

			cluster = Cluster.builder().addContactPoint("127.0.0.1").build();

			session = cluster.connect("myflix");

			CassandraOperations cassandraOps = new CassandraTemplate(session);

			final String[] columns = new String[] { "id", "address", "name" };

			Select select = QueryBuilder.select(columns).from("poets");
			select.where(QueryBuilder.eq("id", 1));

			final List<Poet> results = cassandraOps.select(select, Poet.class);

			System.out.println("Spring Data Cassandra Example");
			System.out.println("==============================");

			for (Poet poets : results) {
				System.out.println("Poet Id is: " + poets.getId());
				System.out.println("Poet Address is: " + poets.getAddress());
				System.out.println("Poet Name is: " + poets.getName());
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			cluster.close();
		}
	}
}
