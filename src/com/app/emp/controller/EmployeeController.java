package com.app.emp.controller;

import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.app.emp.bean.Address;
import com.app.emp.bean.Employee;
import com.app.emp.bean.EmploymentHistory;
import com.app.emp.bean.Qualification;
import com.app.emp.service.EmployeeService;
import com.app.emp.util.EmpUtils;
import com.app.emp.vo.DeptVO;
import com.app.emp.vo.EmployeeDetailVO;
import com.app.emp.vo.EmployeeVO;
import com.app.emp.vo.EmploymentHistoryVO;
import com.app.emp.vo.QualuficationVO;

@Controller
public class EmployeeController {
	
	@Autowired
    private EmployeeService employeeService;
	@Autowired
    private EmpUtils empUtil;
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(@ModelAttribute("model") ModelMap model) {
    	List<DeptVO> deptVo = employeeService.getDepartment();
    	model.addAttribute("depts", deptVo);
        return "index";
    }
    
    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView add(@RequestParam("DEPT_NO") String deptno,@RequestParam("DOJ") String doj,@RequestParam("POSITION") String position,@RequestParam("EMP_GRADE") String empGrade,
    		@RequestParam("DOB") String dob,@RequestParam("PAN") String pan,@RequestParam("PHONE_NO") String phoneNo,@RequestParam("SEX") String sex,
    		@RequestParam("FATHER_NAME") String fatherName,@RequestParam("MOTHER_NAME") String motherName,@RequestParam("FIRST_NAME") String firstName,@RequestParam("MIDDLE_NAME") String middleName,@RequestParam("LAST_NAME") String lastName,
    		@RequestParam("PRES_ADDR1") String preAdd1,@RequestParam("PRES_ADDR2") String preAddr2,@RequestParam("PRES_CITY") String preCity,@RequestParam("PRES_STATE") String preState,@RequestParam("PRES_COUNTRY") String preCountry,@RequestParam("PRES_ZIP") String preZip,
    		@RequestParam("PERMA_ADDR1") String permaAdd1,@RequestParam("PERMA_ADDR2") String permaAddr2,@RequestParam("PERMA_CITY") String permaCity,@RequestParam("PERMA_STATE") String permaState,@RequestParam("PERMA_COUNTRY") String permaCountry,@RequestParam("PERMA_ZIP") String permaZip,
    		@RequestParam("DEGREE") List<String> degree,@RequestParam("BOARD") List<String> board,@RequestParam("FROM_Y") List<String> fromY,@RequestParam("TO_Y") List<String> toY,@RequestParam("DURATION") List<String> duration,@RequestParam("GRADE") List<String> grade,
    		@RequestParam("COMPANY_NAME") List<String> comNames,@RequestParam("POSITION_HELD") List<String> positionHelds,@RequestParam("FROM_C") List<String> fromCs,@RequestParam("TO_C") List<String> toCs,@RequestParam("REASON_CHANGE") List<String> reasonChanges,
    		@RequestParam("COM_ADDR1") List<String> comAdd1,@RequestParam("COM_ADDR2") List<String> comAddr2,@RequestParam("COM_CITY") List<String> comCity,@RequestParam("COM_STATE") List<String> comState,@RequestParam("COM_COUNTRY") List<String> comCountry,@RequestParam("COM_ZIP") List<String> comZip
    		) throws Exception {
    	
    	Employee emp=	employeeService.addEmployee(new Integer(deptno), firstName, middleName, lastName, position, empGrade, doj);
    	Address preAddress=empUtil.setAddress(preAdd1, preAddr2, preCity, preState, preCountry, preZip);
    	Address permaAddress=empUtil.setAddress(permaAdd1, permaAddr2, permaCity, permaState, permaCountry, permaZip);
    	
    	employeeService.insertPersonalDetails(emp, dob, preAddress, permaAddress, sex, phoneNo, pan, fatherName, motherName);
    	List<Qualification> qualifications=empUtil.setQualifications(degree, board, fromY, toY, duration, grade);
    	for (Qualification qualification : qualifications) {
			qualification.setEmployee(emp);
			employeeService.insertQualification(qualification);
		}
    	List<EmploymentHistory> empHis=empUtil.setEmploymentHistory(comNames, positionHelds, fromCs, toCs, reasonChanges,
    			comAdd1,comAddr2,comCity, comState, comCountry,comZip);
    	for (EmploymentHistory employmentHistory : empHis) {
    		employmentHistory.setEmpId(emp.getEmpId());
    		employmentHistory.setComAddr(preAddress);
    		employeeService.insertEmploymentHistory(employmentHistory);
		}
    	ModelAndView mav = new ModelAndView("redirect:employee.html");
    	mav.addObject("EMP_ID", emp.getEmpId());
    	mav.addObject("MSG", "Employee record successfully inserted");
    	mav.addObject("MSG_TYPE", "0");
    	return mav;
    }
    
    @RequestMapping(value = "/allemployee", method = RequestMethod.GET)
    public String getAllEmployee(@ModelAttribute("model") ModelMap model) {
    	List<EmployeeVO> emps=employeeService.getAllEmployee();
    	model.addAttribute("emps", emps);
        return "allemployee";
    }
    
    @RequestMapping(value = "/ajax/dept", method = RequestMethod.POST)
    public @ResponseBody String add(@RequestParam(value="DEPT_NO", required=true) String deptNo,
           Model model) {
    		DeptVO deptVo = employeeService.getDepartment(new Integer(deptNo));
    		try {
						String returndata=EmpUtils.fromJavaToJson(deptVo);
						return returndata;
			} catch (JsonGenerationException e) {
				e.printStackTrace();
			} catch (JsonMappingException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
    		return null;
    }
   
    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    public ModelAndView getEmployee(@RequestParam(value="EMP_ID", required=true) String empId,@RequestParam(value="MSG", required=false) String msg,
    		@RequestParam(value="MSG_TYPE", required=false) String msgType,
    		@ModelAttribute("model") ModelMap model) {
    	EmployeeVO empVO=employeeService.getEmployee(new Integer(empId));
    	List<EmploymentHistoryVO> empHisVos=employeeService.getEmploymentHistory(new Integer(empId));
    	EmployeeDetailVO empDetailsVo=employeeService.getEmployeeDetail(new Integer(empId));
    	List<QualuficationVO> qualifiVos=employeeService.getQualification(new Integer(empId));
    	
    	DeptVO deptVO = employeeService.getDepartment(empVO.getDeptId());
    	List<DeptVO> deptVOs = employeeService.getDepartment();
    	
    	ModelAndView mav=new ModelAndView();
    	mav.setViewName("employee");
    	mav.addObject("empVO", empVO);
    	mav.addObject("empHisVos", empHisVos);
        mav.addObject("empDetailsVo", empDetailsVo);
        mav.addObject("qualifiVos", qualifiVos);
        mav.addObject("deptVO", deptVO);
        mav.addObject("deptVOs", deptVOs);   
        mav.addObject("msg", msg);  
        mav.addObject("msgType",msgType);
    	return mav;
    }
    
    
    @RequestMapping(value = "/employeeofficialdetailsupdate", method = RequestMethod.GET)
    public ModelAndView updateOfficalInfo(@RequestParam(value="EMP_ID", required=true) String empId,@RequestParam(value="DEPT_NO", required=true) String deptNo,@RequestParam(value="GRADE", required=true) String grade,@RequestParam(value="POSITION", required=true) String position,
    		@RequestParam(value="DOJ", required=true) String doj,@RequestParam(value="FIRST_NAME", required=true) String firstName,@RequestParam(value="MIDDLE_NAME") String middleName,@RequestParam(value="LAST_NAME") String lastName,@ModelAttribute("model") ModelMap model) {
    	ModelAndView mav = new ModelAndView("redirect:employee.html");
    	mav.addObject("EMP_ID", empId);
		try {
    		employeeService.updateEmployee(new Integer(empId),new Integer(deptNo), grade, position,doj,
					firstName, middleName,lastName);
	    	mav.addObject("MSG", "Employee record successfully updated");
	    	mav.addObject("MSG_TYPE", "0");
	    	return mav;
		} catch (Exception e) {
			e.printStackTrace();
			mav.addObject("MSG", "Error occured during updation");
			mav.addObject("MSG_TYPE", "1");
	    	return mav;
		}
    	
    }
    
    @RequestMapping(value = "/updatepersonaldetails", method = RequestMethod.POST)
    public  ModelAndView updatePersonalDetails(@RequestParam(value="EMP_ID", required=true) String empId,@RequestParam(value="FATHER_NAME", required=true) String fatherName,@RequestParam(value="MOTHER_NAME", required=true) String motherName,@RequestParam(value="EMP_DOB", required=true) String dob,
    		@RequestParam(value="EMP_PAN", required=true) String pan,@RequestParam(value="SEX", required=true) String sex,@RequestParam(value="PHONE_NO") String phoneNo,
    		@RequestParam("PRES_ADDR1") String preAdd1,@RequestParam("PRES_ADDR2") String preAddr2,@RequestParam("PRES_CITY") String preCity,@RequestParam("PRE_STATE") String preState,@RequestParam("PRE_COUNTRY") String preCountry,@RequestParam("PRE_ZIP") String preZip,
    		@RequestParam("PERMA_ADDR1") String permaAdd1,@RequestParam("PERMA_ADDR2") String permaAddr2,@RequestParam("PERMA_CITY") String permaCity,@RequestParam("PERMA_STATE") String permaState,@RequestParam("PERMA_COUNTRY") String permaCountry,@RequestParam("PERMA_ZIP") String permaZip,
    		@ModelAttribute("model") ModelMap model) {
    	ModelAndView mav = new ModelAndView("redirect:employee.html");
    	mav.addObject("EMP_ID", empId);	
    	try {
	    		Address preAddress=empUtil.setAddress(preAdd1, preAddr2, preCity, preState, preCountry, preZip);
	    		Address permaAddress=empUtil.setAddress(permaAdd1, permaAddr2, permaCity, permaState, permaCountry, permaZip);
	    		employeeService.updatePersonalDetail(new Integer(empId), fatherName, motherName, dob, pan, sex, phoneNo, preAddress, permaAddress);
	    		mav.addObject("MSG", "Employee record successfully updated");
	    		mav.addObject("MSG_TYPE", "0");
		    	return mav;
    		} catch (Exception e) {
    			mav.addObject("MSG", "Error occured during updation");
    			mav.addObject("MSG_TYPE", "1");
    	    	return mav;
		}
    }
    
    @RequestMapping(value = "/updateEducationdetails", method = RequestMethod.POST)
    public ModelAndView updateQualification(@RequestParam(value="ID", required=true) String Id,@RequestParam(value="DEGREE", required=true) String degree,
    		@RequestParam(value="BOARD", required=true) String board,@RequestParam(value="FROM", required=true) String from,
    		@RequestParam(value="TO", required=true) String to,@RequestParam(value="DURATION", required=true) String duration,
    		@RequestParam(value="GRADE") String grade,
    		@ModelAttribute("model") ModelMap model) {
    	employeeService.updateQualification(new Integer(Id), degree, board, from, to, new Integer(duration), grade);
    	int empId=employeeService.getEmployeeIdbyQualification(new Integer(Id));
    	ModelAndView mav = new ModelAndView("redirect:employee.html");
    	mav.addObject("EMP_ID", empId);	
    	mav.addObject("MSG", "Employee record successfully updated");
    	mav.addObject("MSG_TYPE", "0");
    	return mav;
    	
    }
    @RequestMapping(value = "/updateemploymenthistory", method = RequestMethod.POST)
    public ModelAndView updateEmploymentHistory(@RequestParam(value="ID", required=true) String Id,@RequestParam(value="COMPANY_NAME", required=true) String comName,
    		@RequestParam(value="POSITION_HELD", required=true) String position,@RequestParam(value="FROM_C", required=true) String from,
    		@RequestParam(value="TO_C", required=true) String to,@RequestParam(value="REASON_CHANGE", required=true) String changeReason,
    		@RequestParam(value="COM_ADDR1") String addr1,@RequestParam(value="COM_ADDR2") String addr2,@RequestParam(value="COM_CITY") String city,@RequestParam(value="COM_STATE") String state,@RequestParam(value="COM_COUNTRY") String country,@RequestParam(value="COM_ZIP") String zip,
    		@ModelAttribute("model") ModelMap model) {
    	Address comAddr=empUtil.setAddress(addr1, addr2, city, state, country, zip);
    	int empId=employeeService.getEmployeeIdbyQualification(new Integer(Id));
    	ModelAndView mav = new ModelAndView("redirect:employee.html");
    	mav.addObject("EMP_ID", empId);	
    	try {
			employeeService.updateEmploymentHistory(new Integer(Id), comName, position, from, to, changeReason, comAddr);
			mav.addObject("MSG", "Employee record successfully updated");
			mav.addObject("MSG_TYPE", "0");
			return mav;
		} catch (Exception e) {
			mav.addObject("MSG", "Error occured during updation");
			mav.addObject("MSG_TYPE", "0");
	    	return mav;
		}
    }
    
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public  ModelAndView deleteEmployee(@RequestParam(value="EMP_ID", required=true) String Id,@ModelAttribute("model") ModelMap model) {
    	employeeService.deleteEmployee(new Integer(Id));
    	ModelAndView mav = new ModelAndView("redirect:allemployee.html");
    	return mav;
    }
}