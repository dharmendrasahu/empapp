<#import "common.ftl" as common>
<#assign cssResources = [
    "/empapp/css/jquery-ui.css",
    "/empapp/css/employee.css" ,
    "/empapp/css/menu.css" 
] />
<#assign jsResources = [
    "/empapp/jquery/jquery-1.9.1.js",
    "/empapp/jquery/jquery-ui.js" ,
    "/empapp/js/employee.js"
      
] />
<#assign title>Employee Details Page"</#assign>

<#assign sex>${empDetailsVo.sex}</#assign>
<#assign servermsg>${msg!}</#assign>
<#assign msgType>${MSG_TYPE!}</#assign>
<@common.renderDocType />
<html>
	<@common.renderHeader title cssResources jsResources/>
<body onload=selection("${sex}");>
<#include "menu.ftl" />
<h3>Employee Details:</h3>
<div name="employee_details">
	<div id="officialdetail_errormsg"></div>
	<!--<div id="server_msg">${servermsg!}</div>-->
	<@common.message servermsg msgType/>
	<form name="officialdetail" id="officialdetail" action="employeeofficialdetailsupdate.html" class="officialdetail" onsubmit="return validateOfficalDetailForm();">
		    <table>
			    <tr>
			    	<td>Employee ID </td>
			    	<td>
			    		<input type="text" name="EMP_ID" value="${empVO.empId}" disabled="true"/>
			    	</td>
			    	<td>Grade</td>
			    	<td><input type="text" name="GRADE" id="GRADE" value="${empVO.grade}"/></td>
			    </tr>
			    <tr>
			    	<td>Position</td>
			    	<td><input type="text" name="POSITION" id="POSITION" value="${empVO.position}" class="required"/></td>
			    	<td>Date of joining</td>
			    	<td><input type="text" name="DOJ" id="DOJ" value="${empVO.doj?string("yyyy-MM-dd")}" readonly/></td>
			    </tr>
		    </table>
		    
		    <fieldset id="empname"  name="empname" class="empname">
		    <legend>Employee Name</legend>
		    <table>
			    <tr>
			    	<td>First Name</td>
			    	<td><input type="text" name="FIRST_NAME" id="FIRST_NAME" class="name" value="${empVO.firstName}"/></td>
			    </tr>
			    <tr>
			    	<td>Middle Name</td>
			    	<td><input type="text" name="MIDDLE_NAME" id="MIDDLE_NAME" class="name" value="${empVO.middleName}"/></td>
			    </tr>
			    <tr>
			    	<td>Last Name</td>
			    	<td><input type="text" name="LAST_NAME"/ id="LAST_NAME" class="name" value="${empVO.lastName}"/></td>
			    </tr>
		    </table>
		</fieldset>
		    <table name="dept" class="dept">
			    <tr>
			    	<td>Department Name</td>
			    	<td>
			    		<select name="DEPT_NO" id="DEPT_NO">
  							<#list deptVOs as dept> 
  									<#if "${dept.deptId}" == "${empVO.deptId}">
  										<option value="${dept.deptId}" selected>${dept.name}</option>
									<#else>
  										<option value="${dept.deptId}">${dept.name}</option>
									</#if>  
    						</#list>  		
						</select>
				</td>
			    	<td>DESCRIPTION</td>
			    	<td><input type="text" name="DEPT_DESCRIPTION" id="DEPT_DESCRIPTION" value="${deptVO.descri}" disabled="true"/></td>
			    </tr>
			    <tr>
			    	<td>Address1</td>
			    	<td><input type="text" name="DEPT_ADDRESS1" id="DEPT_ADDRESS1" value="${deptVO.addr.addr1}" disabled="true"/></td>
			    	<td>Address2</td>
			    	<td><input type="text" name="DEPT_ADDRESS2" id="DEPT_ADDRESS2" value="${deptVO.addr.addr2}" disabled="true"/></td>
			    </tr>
			    <tr>
			    	<td>City</td>
			    	<td><input type="text" name="DEPT_CITY" id="DEPT_CITY" value="${deptVO.addr.city}" disabled="true"/></td>
			    	<td>State</td>
			    	<td><input type="text" name="DEPT_STATE" id="DEPT_STATE" value="${deptVO.addr.state}" disabled="true"/></td>
			    </tr>
			     <tr>
			    	<td>Country</td>
			    	<td><input type="text" name="DEPT_COUNTRY" id="DEPT_COUNTRY" value="${deptVO.addr.country}" disabled="true"/></td>
			    	<td>Zip code</td>
			    	<td><input type="text" name="DEPT_ZIP" id="DEPT_ZIP" value="${deptVO.addr.zip}" disabled="true"/></td>
			    </tr>
		    </table>
		    <input type="hidden" name="EMP_ID" value="${empVO.empId}"/>
		    <input type="submit" class="officialdetailSubmitButton" id="officialdetailSubmitButton" value="update official details"/>
		</form>
		<div id="personaldetails_errormsg"></div>
		<form name="personaldetails" action="updatepersonaldetails.html" method="post" onsubmit="return validatePersonalDetailForm();">
			<fieldset id="personalinfo" name="personalinfo">
		    	<legend>Personal Details</legend>
			<table>
			    <tr>
			    	<td>Father Name</td>
			    	<td><input type="text" name="FATHER_NAME" id="FATHER_NAME" value="${empDetailsVo.fatherName}"/></td>
			    	<td>PAN</td>
			    	<td><input type="text" name="EMP_PAN" id="EMP_PAN" value="${empDetailsVo.pan}"/></td>
			    	<td>Date of Birth</td>
			    	<td><input type="text" name="EMP_DOB" id="EMP_DOB" class="name" value="${empDetailsVo.DOB?string("yyyy-MM-dd")}" readonly/></td>
			    </tr>
			    <tr>
			    	<td>Mother Name</td>
			    	<td><input type="text" name="MOTHER_NAME" id="MOTHER_NAME" value="${empDetailsVo.motherName}"/></td>
			    	<@common.sex/>
			    	<td>Phone Number</td>
			    	<td><input type="text" name="PHONE_NO" id="PHONE_NO" value="${empDetailsVo.phoneNo}"/></td>
			    	</tr>
		    </table>
		    	  <fieldset id="preaddr" class="address">
				            <legend>Present Address</legend>
				            <table>
				                <tr>
				                    <td>Address1 </td><td><input type="text" id="PERS_ADDR1" name="PRES_ADDR1" value="${empDetailsVo.presAddr.addr1}"/></td>
				                    <td>Address2 </td><td><input type="text" id="PRES_ADDR2" name="PRES_ADDR2" value="${empDetailsVo.presAddr.addr2}"/></td>
				                    <td>City </td><td><input type="text" id="PRES_CITY" name="PRES_CITY" value="${empDetailsVo.presAddr.city}"/></td>
				                </tr>
				                <tr>
				                    <td>State </td><td><input type="text" id="PRES_STATE" name="PRE_STATE" value="${empDetailsVo.presAddr.state}"/></td>
				                    <td>Country </td><td><input type="text" id="PRES_STATE" name="PRE_COUNTRY"value="${empDetailsVo.presAddr.country}"/></td>
				                    <td>Pin code </td><td><input type="text" id="PRES_ZIP" name="PRE_ZIP" value="${empDetailsVo.presAddr.zip}"/></td>
				                </tr>
				            </table>
            			</fieldset>
            		</td>
	            <td class="address">
		            <fieldset id="permaaddr" class="address">
		            <legend>Permanent Address</legend>
		            <table>
		                <tr>
		                    <td>Address1 </td><td><input type="text" name="PERMA_ADDR1" value="${empDetailsVo.permaAddr.addr1}"/></td>
		                    <td>Address1 </td><td><input type="text" name="PERMA_ADDR2"value="${empDetailsVo.permaAddr.addr1}"/></td>
		                    <td>City </td><td><input type="text" name="PERMA_CITY" value="${empDetailsVo.permaAddr.addr1}"/></td>
		                </tr>
		                <tr>
		                    <td>State </td><td><input type="text" name="PERMA_STATE" value="${empDetailsVo.permaAddr.addr1}"/></td>
		                    <td>Country </td><td><input type="text" name="PERMA_COUNTRY" value="${empDetailsVo.permaAddr.addr1}"/></td>
		                    <td>Pin code </td><td><input type="text" name="PERMA_ZIP" value="${empDetailsVo.permaAddr.addr1}"/></td>
		                </tr>
		            </table>
            </fieldset>
		<input type="hidden" name="EMP_ID" value="${empVO.empId}"/>
		<input type="submit" value="Update personal details"/>
		</fieldset>	
	</form>
	<fieldset id="personalinfo" name="personalinfo">
		    	<legend>Educational details</legend>
			<table id="tbl_qualification">
            	<tr>
					<@common.qualification/>
				</tr>
				<#list qualifiVos as qualifiVo>
				<tr>
					<form name="First Education" action="updateEducationdetails.html" method="post">
						<td><input type="text" name="DEGREE" class="qualificationtext" value="${qualifiVo.degree}"/></td>
						<td><input type="text" name="BOARD" class="qualificationtext" value="${qualifiVo.board}"/></td>
						<td><input type="text" name="FROM" class="qualificationtext" value="${qualifiVo.fromYr}"/></td>
						<td><input type="text" name="TO" class="qualificationtext" value="${qualifiVo.toYr}"/></td>
						<td><input type="text" name="DURATION" class="qualificationtext" value="${qualifiVo.duration}"/></td>
						<td><input type="text" name="GRADE" class="qualificationtext" value="${qualifiVo.grade}"/></td>
						<td><input type="submit"  value="update"/></td>
						<input type="hidden"  name="ID" value="${qualifiVo.id}"/>
					</form>
				</tr>
				</#list>
            </table>
	</fieldset>
	<fieldset id="personalinfo" name="personalinfo">
		    	<legend>Employment Details</legend>
				<#list empHisVos as empHisVo>
				<form name="employmentHistory" action="updateemploymenthistory.html" method="post">
					<table>	
	 					<tr>
							<@common.companyHeader/>
						</tr>
						<tr>
							<td><input type="text" name="COMPANY_NAME" class="empdetailstext" value="${empHisVo.comName}"/></td>
							<td><input type="text" name="POSITION_HELD" class="empdetailstext" value="${empHisVo.position}"/></td>
							<td><input type="text" name="FROM_C" class="empdetailstext" value="${empHisVo.fromDt?string("yyyy-MM-dd")}" readonly/></td>
							<td><input type="text" name="TO_C" class="empdetailstext" value="${empHisVo.toDt?string("yyyy-MM-dd")}" readonly/></td>
							<td><input type="text" name="REASON_CHANGE" class="empdetailstext" value="${empHisVo.changeReason}"/></td>
						</tr>
					</table>
					<table>
		                <tr>
		                    <td>Address1 </td><td><input type="text" name="COM_ADDR1" value="${empHisVo.comAddr.addr1}"/></td>
		                    <td>Address2 </td><td><input type="text" name="COM_ADDR2" value="${empHisVo.comAddr.addr2}"/></td>
		                    <td>City </td><td><input type="text" name="COM_CITY" value="${empHisVo.comAddr.city}"/></td>
		                </tr>
		                <tr>
		                    <td>State </td><td><input type="text" name="COM_STATE" value="${empHisVo.comAddr.state}"/></td>
		                    <td>Country </td><td><input type="text" name="COM_COUNTRY" value="${empHisVo.comAddr.country}"/></td>
		                    <td>Pin code </td><td><input type="text" name="COM_ZIP" value="${empHisVo.comAddr.zip}"/></td>
		                </tr>
                	</table>
                	<input type="hidden" name="ID" value="${empHisVo.id}"/>
	            	<input type="submit" value="update employment history"/>
                </form>
                </#list>
          </table>
</div>
</body>
</html>