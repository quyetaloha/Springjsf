package entityDaoImpl;

import java.util.ArrayList;

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

import entity.Phonenumber;

/**
 * Home object for domain model class Phonenumber.
 * 
 * @see .Phonenumber
 * @author Hibernate Tools
 */
@Stateless
public class PhonenumberHome {

	private static final Log log = LogFactory.getLog(PhonenumberHome.class);

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
	EntityManager entityManager = entityManagerFactory.createEntityManager();

	public void them(ArrayList<String> phones) {
		entityManager.getTransaction().begin();
		log.debug("persisting Phonenumber instance");
		try {
			
			/*
			 * Query query=entityManager.
			 * createNativeQuery("insert into Phonenumber (phone) values(?)");
			 */
			  int n=0;
			  for(String phone:phones) {
			  
				  
				/*
				 * query.setParameter(1, phone); query.executeUpdate(); System.out.println(n);
				 */
				  entityManager.persist(new Phonenumber(phone));
				  System.out.println(n);
				  n++;
				  if(n%500==0) {
					  entityManager.getTransaction().commit();
					  entityManager.getTransaction().begin();
					  entityManager.clear();
				  }
			  }
				  
			entityManager.getTransaction().commit();
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
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
