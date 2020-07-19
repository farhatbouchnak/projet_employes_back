package com.example.demo.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employees")
public class Employee implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private double salary;
	private int hireday;
	private int hiremonth;
	private int hireyear;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public int getHireday() {
		return hireday;
	}

	public void setHireday(int hireday) {
		this.hireday = hireday;
	}

	public int getHiremonth() {
		return hiremonth;
	}

	public void setHiremonth(int hiremonth) {
		this.hiremonth = hiremonth;
	}

	public int getHireyear() {
		return hireyear;
	}

	public void setHireyear(int hireyear) {
		this.hireyear = hireyear;
	}
	
	
	@Override
	public String toString() {
		return "Employee{" + "id=" + id + ", name='" + name + '\'' + ", salary='" + salary + '\'' + ", hireday='"
				+ hireday + '\'' + ", hiremonth='" + hiremonth + '\'' + ", hireyear='" + hireyear + '\'' + '}';
	}
	
}
