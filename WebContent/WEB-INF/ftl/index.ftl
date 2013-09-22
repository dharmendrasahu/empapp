<#import "common.ftl" as common>
<#assign cssResources = [
    "/empapp/css/jquery-ui.css",
    "/empapp/css/index.css",
    "/empapp/css/menu.css" 
] />
<#assign jsResources = [
    "/empapp/jquery/jquery-1.9.1.js",
    "/empapp/jquery/jquery-ui.js" ,
    "/empapp/js/common.js",
    "/empapp/js/index.js" 
] />
<#assign title>Employee Registration Page</#assign>

<@common.renderDocType />
<html>
	<@common.renderHeader title cssResources jsResources/>
<body>
<#include "menu.ftl" />
<h3>Insert Employee Details</h3>
<div id="loginForm" class="main">
		  <div id="officialdetail_errormsg"></div>
          <form action="registration.html" method="post" onsubmit="return validateForm();">     
            <div name="dept" class="dept">
            Department 
            	<select name="DEPT_NO" id="dept_no">
    				<@common.deptList model["depts"]/>  		
				</select>
			<table>
				<tr>
					<td>Description </td><td><input type="text" id="dept_description" disabled="true"/></td>
					<td>Address1</td> <td><input type="text" id="dept_address1" disabled="true"/></td>
					<td>Address2 </td><td><input type="text" id="dept_address2" disabled="true"/></td>
				</tr>
				<tr>
					<td>City</td><td> <input type="text" id="dept_city" disabled="true"/></td>
					<td>State</td><td> <input type="text" id="dept_state" disabled="true"/></td>
					<td>ZIP Code</td><td> <input type="text" id="dept_zip" disabled="true"/></td>
				</tr>
				<tr>
					<td>Position </td><td><input type="text" name="POSITION" id="position"/></td>
            		<td>Grade</td><td> <input type="text" name="EMP_GRADE" id="grade"/></td>
            		<td>Joining Date</td><td> <input type="text" name="DOJ" id="doj" title="Date Format:YYYY-MM-DD" readonly/></td>
            	</tr>
            </table>	
            </div>
            <#--personal details-->
            <div name="personal_detail" class="personal_detail">
		    <fieldset id="personalinfo" name="personalinfo">
		    	<legend>Personal Details</legend>
		    <fieldset id="empname"  name="empname" class="empname">
		    <legend>Employee Name</legend>
		    <table>
			    <tr>
			    	<td>First Name</td>
			    	<td><input type="text" name="FIRST_NAME" id="first_name" class="name"/></td>
			    </tr>
			    <tr>
			    	<td>Middle Name</td>
			    	<td><input type="text" name="MIDDLE_NAME" id="middle_name" class="name"/></td>
			    </tr>
			    <tr>
			    	<td>Last Name</td>
			    	<td><input type="text" name="LAST_NAME" id="last_name" class="name"/></td>
			    </tr>
		    </table>
		   </fieldset>
		    <div class="personaldetails">
		    	<table name="personalDetails">
		    		<tr>
					    <td>P.A.N.</td>
					    <td><input type="text" name="PAN" id="pan"/></td>
		    		</tr>
		    		<tr>
					   <@common.sex/>
				    </tr>
				    <tr>
					    <td>D.O.B.</td>
					    <td><input type="text" id="emp_dob" name="DOB" title="Date Format:YYYY-MM-DD" readonly/></td>
				    </tr>
				    <tr>
				    <td>Father Name</td>
				    <td><input type="text" id="father_name" name="FATHER_NAME"/></td>
				    </tr>
				    <tr>
				    <td>Mother Name</td>
				    <td><input type="text" id="mother_name" name="MOTHER_NAME"/></td>
				    </tr>
				    <tr>
					    <td>Phone No </td>
					    <td><input type="text" id="phone_no" name="PHONE_NO"/></td>
				    </tr>
				</table>
		   </div>
           </div>
           		 <table class="address">
            	 <tr>
            		<#assign addressType="Present Address"/>
			        <#assign addressTypePrefix="pres"/>
				    <@common.address addressType addressTypePrefix/>
            		
            	<td class="addressbutton">
            		<input type="button" value=">>" id="sameAddress"/>
	            </td>
	        		<#assign addressType="Permanent Address"/>
		            <#assign addressTypePrefix="perma"/>
			        <@common.address addressType addressTypePrefix/>		           
             </tr>
             </table>
            </fieldset>
            <#--Qualification-->
            <fieldset id="degree" name="degree" class="degree">
            <legend>Qualification Details</legend>
            <table id="tbl_qualification">
            <tr>
					<@common.qualification/>
			</tr>
			<tr>
					<td><input type="text" name="DEGREE" class="qualificationtext"/></td>
					<td><input type="text" name="BOARD" class="qualificationtext"/></td>
					<td><input type="text" name="FROM_Y" class="qualificationtext"/></td>
					<td><input type="text" name="TO_Y" class="qualificationtext"/></td>
					<td><input type="text" name="DURATION" class="qualificationtext" onKeyup="isInteger(this.value)"/></td>
					<td><input type="text" name="GRADE" class="qualificationtext"/></td>
					<td><input type="button" id="btn_add_qualification" value="Add"/></td>
			</tr>
            </table>
            </fieldset>
            <#--Employment history-->
            <fieldset id="employmentDetails" class="employmentDetails">
            <legend>Employment Details</legend>
            <table>
	            <tr>
					<@common.companyHeader/>
				</tr>
				<tr>
					<td><input type="text" name="COMPANY_NAME" class="qualificationtext"/></td>
					<td><input type="text" name="POSITION_HELD" class="qualificationtext"/></td>
					<td><input type="text" name="FROM_C" class="qualificationtext" title="Date Format:YYYY-MM-DD" readonly/></td>
					<td><input type="text" name="TO_C" class="qualificationtext" title="Date Format:YYYY-MM-DD" readonly/></td>
					<td><input type="text" name="REASON_CHANGE" class="qualificationtext"/></td>
				</tr>
				</table>
				<table>
                	<tr>
	                    <td>Address1 </td><td><input type="text" name="COM_ADDR1"/></td>
	                    <td>Address2 </td><td><input type="text" name="COM_ADDR2"/></td>
	                    <td>City </td><td><input type="text" name="COM_CITY"/></td>
	                 </tr>
	                 <tr>  
	                    <td>State </td><td><input type="text" name="COM_STATE"/></td>
	                    <td>Country </td><td><input type="text" name="COM_COUNTRY"/></td>
	                    <td>Pin code </td><td><input type="text" name="COM_ZIP"/></td>
	                    <td><input type="button" id="btn_add_history" value="Add"/></td>
                	</tr>
                </table>
            </fieldset>
                <input id="submitbutton" type="submit" value="Submit"/>
          </form>
</body>
</html>