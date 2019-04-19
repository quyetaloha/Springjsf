package entityDAO;

import java.util.List;

import entity.Emp;
import entity.LocNgay;

public interface EmpDAO {
	public String persist(Emp transientInstance);
	public String remove(Emp persistentInstance);
	public Emp merge(Emp detachedInstance);
	public Emp findById(short id);
	public List<Emp> findAll();
	public List<Emp> findEmpByHiredate(LocNgay locNgay);
	public String getNameDepartmentById(byte id);
}
