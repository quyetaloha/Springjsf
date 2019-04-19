package entity;
// Generated Apr 3, 2019 10:42:20 AM by Hibernate Tools 5.0.6.Final

import java.math.BigDecimal;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;



/**
 * Emp generated by hbm2java
 */
@ManagedBean(name = "emp", eager = true)
@RequestScoped
@Entity
@Table(name = "EMP", schema = "SCOTT")
public class Emp implements java.io.Serializable {
	public static boolean edit=false;
	
	@Override
	public String toString() {
		return "Emp [editable=" + editable + ", empno=" + empno + ", dept=" + dept + ", ename=" + ename + ", job=" + job
				+ ", mgr=" + mgr + ", hiredate=" + hiredate + ", sal=" + sal + ", comm=" + comm + ", isEditable()="
				+ isEditable() + ", getEmpno()=" + getEmpno() + ", getDept()=" + getDept() + ", getEname()="
				+ getEname() + ", getJob()=" + getJob() + ", getMgr()=" + getMgr() + ", getHiredate()=" + getHiredate()
				+ ", getSal()=" + getSal() + ", getComm()=" + getComm() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}

	public static boolean isEdit() {
		return edit;
	}

	public static void setEdit(boolean edit) {
		Emp.edit = edit;
	}
	
	private boolean editable = false;

	
	@Transient
	public boolean isEditable() {
		return editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}
	
	

	private short empno;
	private Dept dept;
	private String ename;
	private String job;
	private Short mgr;
	private Date hiredate;
	private BigDecimal sal;
	private BigDecimal comm;

	
	
	public Emp() {
	}

	public Emp(short empno) {
		this.empno = empno;
	}

	public Emp(short empno, Dept dept, String ename, String job, Short mgr, Date hiredate, BigDecimal sal,
			BigDecimal comm) {
		this.empno = empno;
		this.dept = dept;
		this.ename = ename;
		this.job = job;
		this.mgr = mgr;
		this.hiredate = hiredate;
		this.sal = sal;
		this.comm = comm;
		editable = false;
	}

	@Id

	@Column(name = "EMPNO", unique = true, nullable = false, precision = 4, scale = 0)
	public short getEmpno() {
		return this.empno;
	}

	public void setEmpno(short empno) {
		this.empno = empno;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DEPTNO")
	public Dept getDept() {
		return this.dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	@Column(name = "ENAME", length = 10)
	public String getEname() {
		return this.ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	@Column(name = "JOB", length = 9)
	public String getJob() {
		return this.job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	@Column(name = "MGR", precision = 4, scale = 0)
	public Short getMgr() {
		return this.mgr;
	}

	public void setMgr(Short mgr) {
		this.mgr = mgr;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "HIREDATE", length = 7)
	public Date getHiredate() {
		return this.hiredate;
	}

	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}

	@Column(name = "SAL", precision = 7)
	public BigDecimal getSal() {
		return this.sal;
	}

	public void setSal(BigDecimal sal) {
		this.sal = sal;
	}

	@Column(name = "COMM", precision = 7)
	public BigDecimal getComm() {
		return this.comm;
	}

	public void setComm(BigDecimal comm) {
		this.comm = comm;
	}
	
	
	
}