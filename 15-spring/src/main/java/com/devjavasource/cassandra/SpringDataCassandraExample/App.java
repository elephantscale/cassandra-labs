package com.devjavasource.cassandra.SpringDataCassandraExample;

import java.util.List;

import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.data.cassandra.core.CassandraTemplate;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.datastax.driver.core.querybuilder.Select;
import com.devjavasource.cassandra.dto.Feature;

public class App {
	private static Cluster cluster;
	private static Session session;

	public static void main(String[] args) {

		try {

			cluster = Cluster.builder().addContactPoint("127.0.0.1").build();

			session = cluster.connect("myflix");

			CassandraOperations cassandraOps = new CassandraTemplate(session);

			final String[] columns = new String[] { "code", "name", "type", "release_date" };

			Select select = QueryBuilder.select(columns).from("features");
//			select.where(QueryBuilder.eq("code", 'madmen'));

			final List<Feature> results = cassandraOps.select(select, Feature.class);

			System.out.println("Spring Data Cassandra Example");
			System.out.println("==============================");

			int counter = 0;
			for (Feature feature : results) {
				counter ++;
				System.out.println(counter + " : " + feature);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			cluster.close();
		}
	}
}
