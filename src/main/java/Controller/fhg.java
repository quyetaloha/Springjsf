package Controller;

import java.io.File;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entity.Phonenumber;

public class fhg {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		//entityManager.createNativeQuery("insert all into Phonenumber (phone) values('haha1') into Phonenumber (phone) values('haha2') SELECT * FROM dual").executeUpdate();
		Phonenumber phonenumber=new Phonenumber("bcc");
		System.out.println(phonenumber.getId());
		entityManager.persist(phonenumber);
		System.out.println(phonenumber.getId());
		entityManager.getTransaction().commit();
	}

}
