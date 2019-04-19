package entityDAO;

import entity.Dept;

public interface DeptDAO {
	public void persist(Dept transientInstance);
	public void remove(Dept persistentInstance);
	public Dept merge(Dept detachedInstance);
	public Dept findById(byte id);
}
