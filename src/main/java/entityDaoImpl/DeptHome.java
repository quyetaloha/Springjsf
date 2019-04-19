package entityDaoImpl;
// Generated Apr 11, 2019 4:14:10 PM by Hibernate Tools 5.0.6.Final

import javax.ejb.Stateless;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import entity.Dept;
import entityDAO.DeptDAO;

/**
 * Home object for domain model class Dept.
 * @see dm.Dept
 * @author Hibernate Tools
 */
@Stateless
@ManagedBean(name = "deptHome", eager = true)
@SessionScoped
@Service
public class DeptHome implements DeptDAO{

	private static final Log log = LogFactory.getLog(DeptHome.class);

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
	EntityManager entityManager = entityManagerFactory.createEntityManager();


	public void persist(Dept transientInstance) {
		log.debug("persisting Dept instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Dept persistentInstance) {
		log.debug("removing Dept instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Dept merge(Dept detachedInstance) {
		log.debug("merging Dept instance");
		try {
			Dept result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Dept findById(byte id) {
		System.out.println("findById: "+id);
		log.debug("getting Dept instance with id: " + id);
		try {
			Dept instance = entityManager.find(Dept.class, id);
			log.debug("get successful");
			if(instance==null) System.out.println("deptno "+id+" không tồn tài ==> null");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
