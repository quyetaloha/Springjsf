package validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import entityDaoImpl.DeptHome;

@FacesValidator("deptnoValidator")
public class DeptnoValidator implements Validator {

	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		// TODO Auto-generated method stub
	    byte deptno = Byte.valueOf(value.toString());
	    System.out.println("deptnoValidator ");
	    System.out.println(deptno);
	    DeptHome deptHome=new DeptHome();
	    if (deptHome.findById(deptno)!=null) {
	      FacesMessage msg = new FacesMessage("mã phòng ban không tồn tại");
	      msg.setSeverity(FacesMessage.SEVERITY_ERROR);
	      throw new ValidatorException(msg);
	    }
	}

}
