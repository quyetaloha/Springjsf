package entityDaoImpl;
// Generated Apr 3, 2019 10:42:20 AM by Hibernate Tools 5.0.6.Final

import java.util.List;

import javax.ejb.Stateless;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import entity.Emp;
import entity.LocNgay;
import entityDAO.EmpDAO;

/**
 * Home object for domain model class Emp.
 * 
 * @see entity.Emp
 * @author Hibernate Tools
 */
@Stateless
@ManagedBean(name = "empHome", eager = true)
@SessionScoped
@Service
public class EmpHome implements EmpDAO{

	private static final Log log = LogFactory.getLog(EmpHome.class);

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
	EntityManager entityManager = entityManagerFactory.createEntityManager();

	public String persist(Emp transientInstance) {
		entityManager.getTransaction().begin();
		
		log.debug("persisting Emp instance");
		try {
			entityManager.persist(transientInstance);
			entityManager.getTransaction().commit();
			System.out.println("Thêm thành công");
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			System.out.println("ID bị trùng !");
			re.printStackTrace();
			return "error.xhtml?faces-redirect=true";
			
			
		}
		
		return "index.xhtml?faces-redirect=true";
	}

	public String remove(Emp persistentInstance) {
		entityManager.getTransaction().begin();
		
		log.debug("removing Emp instance");
		try {
			entityManager.remove(persistentInstance);
			entityManager.getTransaction().commit();
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
		return "index.xhtml?faces-redirect=true";
	}

	public Emp merge(Emp detachedInstance) {
		log.debug("merging Emp instance");
		try {
			Emp result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Emp findById(short id) {
		log.debug("getting Emp instance with id: " + id);
		try {
			Emp instance = entityManager.find(Emp.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Emp> findAll() {
		return entityManager.createQuery("SELECT c FROM Emp c", Emp.class).getResultList();
	}


	public List<Emp> findEmpByHiredate(LocNgay locNgay) {
		return entityManager.createQuery("SELECT c FROM Emp c where hiredate between ? and ?", Emp.class)
				.setParameter(1, locNgay.getDate1()).setParameter(2, locNgay.getDate2()).getResultList();
	}

	public String getNameDepartmentById(byte id) {
		String ten = (String) entityManager.createQuery("SELECT c.dname FROM Dept c where c.deptno = ?")
				.setParameter(1,id).getSingleResult();
		return ten;
	}

	

}
