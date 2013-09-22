package com.app.emp.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.emp.bean.Department;
import com.app.emp.bean.Employee;
import com.app.emp.bean.EmployeeDetail;
import com.app.emp.bean.EmploymentHistory;
import com.app.emp.bean.Qualification;
@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	@Autowired
    private SessionFactory sessionFactory;
	
	@Override
	public void insertDept(Department dept) {
		sessionFactory.getCurrentSession().save(dept);
	}

	@Override
	public Department getDepartment(int deptNo) {
		 return (Department) sessionFactory.getCurrentSession().get(Department.class, deptNo);
	}

	@Override
	public List<Department> getDepartments() {
		List<Department> depts=(List<Department>)sessionFactory.getCurrentSession().createQuery("from Department")
                .list();
		return depts;
	}

	@Override
	public Employee insertEmployee(Employee emp) {
		sessionFactory.getCurrentSession().save(emp);
		return emp;
	}

	@Override
	public Employee getEmployee(int empId) {
		 return (Employee) sessionFactory.getCurrentSession().get(Employee.class, empId);
	}

	@Override
	public List<Employee> getEmployees() {
		List<Employee> employees=(List<Employee>)sessionFactory.getCurrentSession().createQuery("from Employee")
                .list();
		return employees;
	}
	
	@Override
	public List<Employee> getEmployeesByDeparment(int deptNo) {
		return null;
	}

	@Override
	public void updateEmployee(Employee emp) {
		sessionFactory.getCurrentSession().update(emp);
	}
	@Override
	public void deleteEmployee(int dept) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertEmployeeDetails(EmployeeDetail empDetails) {
		sessionFactory.getCurrentSession().save(empDetails);
	}

	@Override
	public void insertQualification(Qualification qualifcation) {
		sessionFactory.getCurrentSession().save(qualifcation);
	}

	@Override
	public void insertEmploymentHistory(EmploymentHistory empHistory) {
		sessionFactory.getCurrentSession().save(empHistory);		
	}

	@Override
	public void deleteDepartment(int deptId) {
	}

	@Override
	public void updateDepartment(Department dept) {
		
	}

	@Override
	public EmployeeDetail getEmployeeDetail(int empId) {
		 return (EmployeeDetail) sessionFactory.getCurrentSession().get(EmployeeDetail.class, empId);
	}

	@Override
	public List<EmploymentHistory> getEmploymentHistory(int empId) {
		String query="from EmploymentHistory where employee.empId="+new Integer(empId).toString();
		List<EmploymentHistory> empHistries=(List<EmploymentHistory>)sessionFactory.getCurrentSession().createQuery(query)
                .list();
		
		return empHistries;
	}

	@Override
	public List<Qualification> getQualification(int empId) {
		String query="from Qualification where employee.empId="+empId;
		List<Qualification> qualifications=(List<Qualification>)sessionFactory.getCurrentSession().createQuery(query)
                .list();
		System.out.println("Numberof Record:"+qualifications.size());
		return qualifications;
	}

	@Override
	public void updatePersonalDetail(EmployeeDetail empDetails) {
		sessionFactory.getCurrentSession().update(empDetails);
		
	}
	@Override
	public void updateQualification(Qualification qualification) {
		sessionFactory.getCurrentSession().update(qualification);
	}

	@Override
	public Qualification getQualificationById(int Id) {
		 return (Qualification) sessionFactory.getCurrentSession().get(Qualification.class, Id);
	}

	@Override
	public void updateEmployementHistory(EmploymentHistory employmentHistory) {
		sessionFactory.getCurrentSession().update(employmentHistory);
	}

	@Override
	public EmploymentHistory getEmploymentHistoryById(int Id) {
		return (EmploymentHistory) sessionFactory.getCurrentSession().get(EmploymentHistory.class, Id);
	}

	@Override
	public void deleteEmployee(Employee employee) {
		sessionFactory.getCurrentSession().delete(employee);
	}

	@Override
	public void deleteEmployeeDetails(EmployeeDetail employeeDetails) {
		sessionFactory.getCurrentSession().delete(employeeDetails);
	}

	@Override
	public void deleteQualification(Qualification qualification) {
		sessionFactory.getCurrentSession().delete(qualification);
	}

	@Override
	public void deleteEmploymentHistory(EmploymentHistory history) {
		sessionFactory.getCurrentSession().delete(history);
	}
}