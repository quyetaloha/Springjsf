package Controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import entity.Emp;
import entityDaoImpl.EmpHome;

@ManagedBean(name = "controller", eager = true)
@SessionScoped
public class Controller {
	
	
	EmpHome empHome=new EmpHome();
	public String saveAction(List<Emp> emps) {
		Emp.edit = false;
		for (Emp emp : emps) {
			if (emp.isEditable()) {
				empHome.merge(emp);
			}
			emp.setEditable(false);
		}
		return "index?faces-redirect=true";
	}

	public String saveActionLoc(List<Emp> emps) {
		Emp.edit = false;
		for (Emp emp : emps) {
			if (emp.isEditable()) {
				empHome.merge(emp);
			}
			emp.setEditable(false);
		}
		return "filter?faces-redirect=true";
	}
	
	public String editAction(Emp emp) {
		emp.setEditable(true);
		Emp.edit=true;
		return "index?faces-redirect=true";
	}
	
	public String editAction(Emp emp,String s) {
		emp.setEditable(true);
		Emp.edit=true;
		return s;
	}
	
}
