package com.app.emp.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.emp.bean.Address;
import com.app.emp.bean.Department;
import com.app.emp.bean.Employee;
import com.app.emp.bean.EmployeeDetail;
import com.app.emp.bean.EmploymentHistory;
import com.app.emp.bean.Qualification;
import com.app.emp.dao.EmployeeDAO;
import com.app.emp.vo.DeptVO;
import com.app.emp.vo.EmployeeDetailVO;
import com.app.emp.vo.EmployeeVO;
import com.app.emp.vo.EmploymentHistoryVO;
import com.app.emp.vo.QualuficationVO;
@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
    private EmployeeDAO employeeDAO;
    
	@Transactional
	public void addDepartment() {
	//defualt inserted department
	}
	@Transactional
	@Override
	public DeptVO getDepartment(int deptId) {
		Department dept=employeeDAO.getDepartment(deptId);
		
		DeptVO deptVo= new DeptVO();
		deptVo.setDeptId(dept.getDeptId());
		deptVo.setName(dept.getName());
		deptVo.setAddr(dept.getAddr());
		deptVo.setDescri(dept.getDescri());
		return deptVo;
	}

	@Transactional
	@Override
	public List<DeptVO> getDepartment() {
		
		List<Department> depts=employeeDAO.getDepartments();
		List<DeptVO> deptVos=new ArrayList<DeptVO>();
		for (Department department : depts) {
			DeptVO deptVo= new DeptVO();
			deptVo.setDeptId(department.getDeptId());
			deptVo.setName(department.getName());
			deptVo.setAddr(department.getAddr());
			deptVo.setDescri(department.getDescri());
			deptVos.add(deptVo);
		}
		return deptVos;
		
	}

	@Transactional
	@Override
	public Employee addEmployee(int deptNo,String firstName,String middleName,String lastName,String position,String grade,String doj) throws Exception {
		Department dept = employeeDAO.getDepartment(new Integer(deptNo));
    	Employee emp=new Employee();
    	emp.setDepartment(dept);
    	emp.setFirstName(firstName);
    	emp.setMiddleName(middleName);
    	emp.setLastName(lastName);
    	emp.setGrade(grade);
    	emp.setPosition(position);
    	emp.setDoj(getFormmatter(doj));
		emp =employeeDAO.insertEmployee(emp);
		return emp;
	}

	@Override
	public List<Employee> getEmployeeByDept(int deptNo) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Transactional
	@Override
	public List<EmployeeVO> getAllEmployee() {
		List<Employee> emps= employeeDAO.getEmployees();
		List<EmployeeVO> empvos=new ArrayList<EmployeeVO>();
		for (Employee emp : emps) {
			EmployeeVO empvo=new EmployeeVO(emp.getEmpId(), emp.getFirstName(), emp.getMiddleName(), emp.getLastName(), emp.getDepartment().getName(), emp.getDepartment().getDeptId(), emp.getDoj(), emp.getGrade(),emp.getPosition());
			empvos.add(empvo);
		}
		return empvos;
	}

	@Transactional
	@Override
	public void insertEmployeeDetails(EmployeeDetail empDetails) {
		employeeDAO.insertEmployeeDetails(empDetails);
	}
	@Transactional
	@Override
	public void insertQualification(Qualification qualifcation) {
		employeeDAO.insertQualification(qualifcation);
		
	}
	@Transactional
	@Override
	public void insertEmploymentHistory(EmploymentHistory empHistory) {
		employeeDAO.insertEmploymentHistory(empHistory);
	}
	@Transactional
	@Override
	public EmployeeDetailVO getEmployeeDetail(int empId) {
		EmployeeDetail details=employeeDAO.getEmployeeDetail(empId);
		EmployeeDetailVO empdetailsVO = new EmployeeDetailVO(details.getEmployeeId(),  details.getDOB(), details.getPan(), details.getPhoneNo(), details.getSex(), details.getPresAddr(), details.getPermaAddr(),details.getFatherName(),details.getMotherName());
		return empdetailsVO;
	}
	@Transactional
	@Override
	public List<EmploymentHistoryVO> getEmploymentHistory(int empId) {
		List<EmploymentHistory> empHisties=employeeDAO.getEmploymentHistory(empId);
		List<EmploymentHistoryVO> empHisVOs= new ArrayList<EmploymentHistoryVO>();
		for (EmploymentHistory employmentHistory : empHisties) {
			EmploymentHistoryVO emphistyVO=new EmploymentHistoryVO(employmentHistory.getId(), employmentHistory.getComName(), employmentHistory.getComAddr(), employmentHistory.getPosition(), employmentHistory.getFromDt(), employmentHistory.getToDt(),  new Integer(employmentHistory.getEmpId()),employmentHistory.getChangeReason());
			empHisVOs.add(emphistyVO);
		}
		
		return empHisVOs;
	}
	@Transactional
	@Override
	public List<QualuficationVO> getQualification(int empId) {
		List<Qualification> qualifications =employeeDAO.getQualification(empId);
		List<QualuficationVO> qualifiVOs= new ArrayList<QualuficationVO>();
		for (Qualification qualification : qualifications) {
			QualuficationVO qualificationVO=new QualuficationVO(qualification.getId(), qualification.getDegree(), qualification.getBoard(), qualification.getFromYr(), qualification.getToYr(), qualification.getDuration(), qualification.getGrade(), qualification.getEmployee().getEmpId());
			qualifiVOs.add(qualificationVO);
		}
		return qualifiVOs;
	}
	@Transactional
	@Override
	public EmployeeVO getEmployee(int empId) {
		Employee employee=employeeDAO.getEmployee(empId);
		return new EmployeeVO(employee.getEmpId(), employee.getFirstName(), employee.getMiddleName(), employee.getLastName(), employee.getDepartment().getName(), employee.getDepartment().getDeptId(), employee.getDoj(), employee.getGrade(),employee.getPosition());
	}
	
	@Transactional
	@Override
	public void updateEmployee(int empId,int deptNo,String grade,String position,
    		String doj,String firstName, String middleName, String lastName) throws Exception {
		
		Employee employee=employeeDAO.getEmployee(empId);
		Department dept=employeeDAO.getDepartment(deptNo);
		
    	employee.setDepartment(dept);
		employee.setDoj(getFormmatter(doj));
		employee.setGrade(grade);
		employee.setPosition(position);
		employee.setFirstName(firstName);
		employee.setMiddleName(middleName);
		employee.setLastName(lastName);
		employeeDAO.updateEmployee(employee);
	}
	@Transactional
	@Override
	public void updatePersonalDetail(int empId, String fatherName,String motherName, String dob,
    		String pan, String sex,String phoneNo,Address preAddr,Address parmaAddr) throws Exception{
		EmployeeDetail empDetails=employeeDAO.getEmployeeDetail(empId);
		empDetails.setFatherName(fatherName);
		empDetails.setMotherName(motherName);
		empDetails.setPan(pan);
		empDetails.setPhoneNo(phoneNo);
		empDetails.setPermaAddr(parmaAddr);
		empDetails.setPresAddr(preAddr);
		empDetails.setSex(sex);
		empDetails.setDOB(getFormmatter(dob));
		employeeDAO.updatePersonalDetail(empDetails);
	}
	@Override
	@Transactional
	public void updateQualification( int Id,String degree,String board,String from, String to,int duration,String grade){
		Qualification qualification=employeeDAO.getQualificationById(Id);
		qualification.setBoard(board);
		qualification.setDegree(degree);
		qualification.setDuration(duration);
		qualification.setGrade(grade);
		qualification.setFromYr(from);
		qualification.setToYr(to);
		employeeDAO.updateQualification(qualification);
	}
	@Transactional
	@Override
	public void updateEmploymentHistory(int Id, String comName,String position, String from,
    		String to, String changeReason,
    		Address comAddr) throws Exception{
		EmploymentHistory history=employeeDAO.getEmploymentHistoryById(Id);
		history.setComName(comName);
		history.setComAddr(comAddr);
		history.setPosition(position);
		history.setFromDt(getFormmatter(from));
		history.setToDt(getFormmatter(to));
		employeeDAO.updateEmployementHistory(history);
		
	}
	@Transactional
	@Override
	public void insertPersonalDetails(Employee emp,String dob,Address preAddress,Address permaAddress,
			String sex,String phoneNo,String pan,String fatherName,String motherName) throws Exception{
		EmployeeDetail empdetails=new EmployeeDetail();
    	empdetails.setEmployee(emp);
    	empdetails.setDOB(getFormmatter(dob));
    	empdetails.setPresAddr(preAddress);
    	empdetails.setPermaAddr(permaAddress);
    	empdetails.setSex(sex);
    	empdetails.setPhoneNo(phoneNo);
    	empdetails.setEmployeeId(emp.getEmpId());
    	empdetails.setPan(pan);
    	empdetails.setFatherName(fatherName);
    	empdetails.setMotherName(motherName);
    	employeeDAO.insertEmployeeDetails(empdetails);
	}
	@Transactional
	@Override
	public void deleteEmployee(int empId) {
		Employee emp=employeeDAO.getEmployee(empId);
		Set<EmploymentHistory> histories=emp.getEmpHsty();
		Set<Qualification>qualificats=emp.getQualifi();
		EmployeeDetail details=employeeDAO.getEmployeeDetail(empId);
		for (Qualification qualification : qualificats) {
			employeeDAO.deleteQualification(qualification);
		}
		for (EmploymentHistory history : histories) {
			employeeDAO.deleteEmploymentHistory(history);
		}
		employeeDAO.deleteEmployeeDetails(details);
		employeeDAO.deleteEmployee(emp);
	}
	
	@Transactional
	@Override
	public int getEmployeeIdbyQualification(int qualification) {
		return employeeDAO.getQualificationById(qualification).getEmployee().getEmpId();
	}
	@Transactional
	@Override
	public int getEmployeeIdHistory(int historyId) {
		return employeeDAO.getEmploymentHistoryById(historyId).getEmpId();
	}
	private Date getFormmatter(String date) throws Exception{ 
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
		 return dateFormat.parse(date);
	}
	
}