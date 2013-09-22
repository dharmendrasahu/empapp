package com.app.emp.dao;

import java.util.List;

import com.app.emp.bean.Department;
import com.app.emp.bean.Employee;
import com.app.emp.bean.EmployeeDetail;
import com.app.emp.bean.EmploymentHistory;
import com.app.emp.bean.Qualification;

public interface EmployeeDAO {
	public void insertDept(Department dept);
	public Department getDepartment(int deptNo);
	public void deleteDepartment(int deptId);
	public void updateDepartment(Department dept);
	public List<Department> getDepartments();
	
	public Employee insertEmployee(Employee emp);
	public Employee getEmployee(int empid);
	public List<Employee> getEmployees();
	public List<Employee> getEmployeesByDeparment(int deptNo);
	public void updateEmployee(Employee emp);
	
	public void deleteEmployee(int dept);
	public void insertEmployeeDetails(EmployeeDetail empDetails);
	public void insertQualification(Qualification qualifcation);
	public void insertEmploymentHistory(EmploymentHistory empHistory);
	
	public EmployeeDetail getEmployeeDetail(int empId);
	public List<EmploymentHistory> getEmploymentHistory(int empId);
	public List<Qualification> getQualification(int empId);
	public void updatePersonalDetail(EmployeeDetail empDetails);
	public void updateQualification(Qualification qualification);
	public Qualification getQualificationById(int Id);
	
	public void updateEmployementHistory(EmploymentHistory qualification);
	public EmploymentHistory getEmploymentHistoryById(int Id);
	public void deleteEmployee(Employee employee);
	public void deleteEmployeeDetails(EmployeeDetail employeeDetails);
	public void deleteQualification(Qualification qualification);
	public void deleteEmploymentHistory( EmploymentHistory history);
}