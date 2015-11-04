package com.devjavasource.cassandra.SpringDataCassandraExample;

import java.util.List;

import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.data.cassandra.core.CassandraTemplate;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.datastax.driver.core.querybuilder.Select;
import com.devjavasource.cassandra.dto.User;

public class App {
	private static Cluster cluster;
	private static Session session;

	public static void main(String[] args) {

		try {

			cluster = Cluster.builder().addContactPoint("127.0.0.1").build();

			session = cluster.connect("devjavasource");

			CassandraOperations cassandraOps = new CassandraTemplate(session);

			final String[] columns = new String[] { "id", "address", "name" };

			Select select = QueryBuilder.select(columns).from("users");
			select.where(QueryBuilder.eq("id", 1));

			final List<User> results = cassandraOps.select(select, User.class);

			System.out.println("Spring Data Cassandra Example");
			System.out.println("==============================");

			for (User user : results) {
				System.out.println("User Id is: " + user.getId());
				System.out.println("User Address is: " + user.getAddress());
				System.out.println("User Name is: " + user.getName());
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			cluster.close();
		}
	}
}
