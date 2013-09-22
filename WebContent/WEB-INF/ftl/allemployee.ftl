<#import "common.ftl" as common>
<#assign cssResources = [
    "/empapp/css/jquery-ui.css",
    "/empapp/css/allemployee.css",
    "/empapp/css/menu.css" 
] />
<#assign jsResources = [
    "/empapp/jquery/jquery-1.9.1.js",
    "/empapp/jquery/jquery-ui.js"
] />
<#assign title>Employees detail Page</#assign>

<@common.renderDocType />
<html>
	<@common.renderHeader title cssResources jsResources/>
<body>
<#include "menu.ftl" />
<h3>All Employees </h3>
<table border="1px" id="maintable">
	<tr>
    	<th colspan="2">DEPARTMENT</th>
		<th colspan="7">EMPLOYEE</th>
	</tr>
	<tr>
    	<th>NUMBER</th>
		<th>NAME</th>
    	<th>ID</th>
    	<th>FIRST NAME</th>
    	<th>MIDDLE NAME</th>
    	<th>LAST NAME</th>
    	<th>GRADE</th>
    	<th>POSITION</th>
		<th>JOINING DATE</th>
		<th colspan="3">ACTION</th>    	
    </tr>
    
<#list model["emps"] as emp>
    <tr>
    	<td align="center">${emp.deptId}</td>
    	<td>${emp.deptName}</td>
    	<td align="center">${emp.empId}</td>
    	<td>${emp.firstName}</td>
    	<td>${emp.middleName}</td>
    	<td>${emp.lastName}</td>
    	<td>${emp.grade}</td>
    	<td>${emp.position}</td>
    	<td>${emp.doj?string("yyyy-MM-dd")}</td>
    	<td><a href="${rc.getContextPath()}/employee.html?EMP_ID=${emp.empId}">View</a></td>
    	<td><a href="${rc.getContextPath()}/employee.html?EMP_ID=${emp.empId}">Update</a></td>
    	<td><a href="${rc.getContextPath()}/delete.html?EMP_ID=${emp.empId}">Delete</a></td>
    </tr>
</#list>