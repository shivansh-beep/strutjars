package com.test;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Table;

@Entity
public class Employee implements Serializable {

	@Id
//	@GenericGenerator(name = "auto", strategy = "increment")
//	@GeneratedValue(generator = "auto")
	int eid;
	
	
	String ename;
	String Salary;
	String desg;
	

	public String getSalary() {
		return Salary;
	}

	public void setSalary(String Salary) {
		this.Salary = Salary;
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getDesg() {
		return desg;
	}

	public void setDesg(String desg) {
		this.desg = desg;
	}

}
