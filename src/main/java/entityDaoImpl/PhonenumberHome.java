package entityDaoImpl;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

//default package
//Generated Apr 17, 2019 11:57:40 AM by Hibernate Tools 5.0.6.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transaction;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.jdbc.Work;
import org.primefaces.model.UploadedFile;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import entity.Phonenumber;

/**
 * Home object for domain model class Phonenumber.
 * 
 * @see .Phonenumber
 * @author Hibernate Tools
 */
@Stateless
@Repository
public class PhonenumberHome {

	private static final Log log = LogFactory.getLog(PhonenumberHome.class);

	
	  EntityManagerFactory entityManagerFactory =
	  Persistence.createEntityManagerFactory("persistence"); EntityManager
	  entityManager = entityManagerFactory.createEntityManager();
	 
	
	
	/*
	 * public void them( final ArrayList<String> phones) { long start=new
	 * Date().getTime(); log.debug("persisting Phonenumber instance");
	 * 
	 * try {
	 * 
	 * int n = 0; for (String phone : phones) {
	 * 
	 * 
	 * 
	 * entityManager.persist(new Phonenumber(phone)); System.out.println(n); n++; if
	 * (n % 200 == 0) { entityManager.getTransaction().commit();
	 * entityManager.getTransaction().begin(); entityManager.clear(); } }
	 * 
	 * entityManager.getTransaction().commit();
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * log.debug("persist successful"); } catch (RuntimeException re) {
	 * log.error("persist failed", re); throw re; }
	 * 
	 * entityManager.getTransaction().begin(); Session session =
	 * entityManager.unwrap(Session.class); session.doWork(new Work() {
	 * 
	 * @Override public void execute(Connection connection) throws SQLException {
	 * connection.setAutoCommit(false); String
	 * sql="insert into phonenumber(id,phone) values(phone_seq.nextval,?)";
	 * PreparedStatement preparedStatement=connection.prepareStatement(sql); int
	 * count=1; for(String phone:phones) { preparedStatement.setString(1, phone);
	 * preparedStatement.addBatch(); count++;System.out.println("count:"+count);
	 * if(count%1000==0) { preparedStatement.addBatch(); } }
	 * preparedStatement.executeBatch(); connection.commit();
	 * 
	 * } }); System.out.println("hi"); session.getTransaction().commit(); long
	 * end=new Date().getTime(); System.out.println("thoi gian:"+(end-start));
	 * 
	 * 
	 * 
	 * }
	 */

	public void them(final UploadedFile file) {
		long start = new Date().getTime();
		entityManager.getTransaction().begin();
		Session session = entityManager.unwrap(Session.class);
		try (InputStream input = file.getInputstream()) {

			session.doWork(new Work() {

				@Override
				public void execute(Connection connection) throws SQLException {
					connection.setAutoCommit(false);
					String sql = "insert into phonenumber(id,phone) values(phone_seq.nextval,?)";
					PreparedStatement preparedStatement = connection.prepareStatement(sql);
					int count = 0;
					InputStream fileInputStream;
					try {
						fileInputStream = file.getInputstream();
						BufferedReader br = new BufferedReader(new InputStreamReader(fileInputStream));
						String phone;
						while ((phone = br.readLine()) != null) {
							preparedStatement.setString(1, phone);
							count++;
							System.out.println("count:" + count);
							if (count % 1000 == 0) {
								preparedStatement.addBatch();
							}

						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					preparedStatement.executeBatch();
					connection.commit();

				}
			});

		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("hi");
		session.getTransaction().commit();
		long end = new Date().getTime();
		System.out.println("thoi gian:" + (end - start));

	}

	public void remove(Phonenumber persistentInstance) {
		log.debug("removing Phonenumber instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Phonenumber merge(Phonenumber detachedInstance) {
		log.debug("merging Phonenumber instance");
		try {
			Phonenumber result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Phonenumber findById(long id) {
		log.debug("getting Phonenumber instance with id: " + id);
		try {
			Phonenumber instance = entityManager.find(Phonenumber.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
