package com.app.emp.service;

import java.util.List;

import com.app.emp.bean.Address;
import com.app.emp.bean.Employee;
import com.app.emp.bean.EmployeeDetail;
import com.app.emp.bean.EmploymentHistory;
import com.app.emp.bean.Qualification;
import com.app.emp.vo.DeptVO;
import com.app.emp.vo.EmployeeDetailVO;
import com.app.emp.vo.EmployeeVO;
import com.app.emp.vo.EmploymentHistoryVO;
import com.app.emp.vo.QualuficationVO;

public interface EmployeeService {
	public void addDepartment();
	public DeptVO getDepartment(int deptId);
	public List<DeptVO> getDepartment();

	public List<Employee> getEmployeeByDept(int deptNo);
	public List<EmployeeVO> getAllEmployee();
	
	public void insertEmployeeDetails(EmployeeDetail empDetails);
	public void insertQualification(Qualification empDetails);
	
	public void insertEmploymentHistory(EmploymentHistory empHistory);
	
	public EmployeeVO getEmployee(int empId);
	public EmployeeDetailVO getEmployeeDetail(int empId);
	public List<EmploymentHistoryVO> getEmploymentHistory(int empId);
	public List<QualuficationVO> getQualification(int empId);
	
	public void updateEmployee(int empId,int deptNo,String grade,String position,
    		String doj,String firstName, String middleName, String lastName) throws Exception ;
	
	public void updatePersonalDetail(int empId, String fatherName,String motherName, String dob,
    		String pan, String sex,String phoneNo,Address preAddr,Address parmaAddr) throws Exception;
	public void updateQualification(int Id, String degree, String board, String from,
			String to, int duration, String grade);
	public void updateEmploymentHistory(int Id, String comName, String position,
			String from, String to, String changeReason, Address comAddr)
			throws Exception;
	public Employee addEmployee(int deptNo, String firstName, String middleName,
			String lastName, String position, String grade, String doj) throws Exception;
	void insertPersonalDetails(Employee emp, String dob, Address preAddress,
			Address permaAddress, String sex, String phoneNo, String pan,
			String fatherName, String motherName) throws Exception;
	
	public void deleteEmployee(int empId); 
	public int getEmployeeIdbyQualification(int qualification);
	public int getEmployeeIdHistory(int historyId);
}