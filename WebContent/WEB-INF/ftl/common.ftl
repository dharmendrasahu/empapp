<#macro includeCssResources resources>
	<#if resources?has_content>
 		<#list resources as uri>
 			<link href="${uri}" rel="stylesheet" type="text/css">
 		</#list>
	</#if>
</#macro>

<#macro includeJsResources resources>
	<#if resources?has_content>
 		<#list resources as resource>
 			<script type="text/javascript" src="${resource}"></script>
 		</#list>
	</#if>
</#macro>

<#macro renderDocType>
	<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
</#macro>

<#macro renderHeader title cssResources={} jsResources={}>
    <head>
		<@includeCssResources cssResources />
		<@includeJsResources jsResources />
        <title>${title}</title>
    </head>
</#macro>

<#macro deptList depts>
	<#list model["depts"] as dept>
    		<option value="${dept.deptId}">${dept.name}</option>
    </#list>
</#macro> 
 
 <#macro address addressType addressTypePreID>
        <td class="address">
			 <fieldset id="${addressTypePreID}addr" class="address">
			 	<legend>${addressType} </legend>
		        <table>
		            <tr>
		                <td>Address1 </td><td><input type="text" name="${addressTypePreID?upper_case}_ADDR1" id="${addressTypePreID}_addr1" class="name"/></td>
		            </tr>
		            <tr>
		                <td>Address2 </td><td><input type="text" name="${addressTypePreID?upper_case}_ADDR2" id="${addressTypePreID}_addr2"/></td>
		            </tr>
		            <tr>
		                <td>City </td><td><input type="text" name="${addressTypePreID?upper_case}_CITY" id="${addressTypePreID}_city"/></td>
		            </tr>
		            <tr>
		                <td>State </td><td><input type="text" name="${addressTypePreID?upper_case}_STATE" id="${addressTypePreID}_state"/></td>
		            </tr>
		            <tr>
		                <td>Country </td><td><input type="text" name="${addressTypePreID?upper_case}_COUNTRY" id="${addressTypePreID}_country"/></td>
		            </tr>
		            <tr>
		                <td>Pin code </td><td><input type="text" name="${addressTypePreID?upper_case}_ZIP" id="${addressTypePreID}_zip"/></td>
		            </tr>
		        </table>
		     </fieldset>
		</td>
 </#macro>
 <#macro sex>
 	<td>Sex</td>
	<td>
		<input type="radio" name="SEX" id="sex_m" value="M"/>Male
		<input type="radio" name="SEX" id="sex_f" value="F"/>Female
	</td>
 </#macro>
  <#macro sexselection sex>
 	<td>Sex</td>
	<td>
		<input type="radio" name="SEX" id="sex_m" value="M" checked="checked"/>Male
		<input type="radio" name="SEX" id="sex_f" value="F" checked="checked"/>Female
	</td>
 </#macro>
 
 <#macro companyHeader>
 	<td class="qualification">Company name</td>
	<td class="qualification">Position held</td>
	<td class="qualification">From</td>
	<td class="qualification">To</td>
	<td class="qualification">Reason for change</td>
</#macro>

<#macro qualification>
    <td class="qualification">Degree</td>
    <td class="qualification">University</td>
    <td class="qualification">From</td>
    <td class="qualification">To</td>
    <td class="qualification">Duration(in Month)</td>
    <td class="qualification">Grade</td>
</#macro>
<#-- need to work not proper functioning-->
<#macro showAddress addressType addressTypePrefix addressValue>
	<fieldset id="presaddr" class="address">
        <legend>${addressType}</legend>
        <table>
            <tr>
                <td>Address1 </td><td><input type="text" id="${addressTypePrefix?upper_case}_ADDR1" name="${addressTypePrefix?upper_case}_ADDR1" value="${addressValue.addr1}"/></td>
                <td>Address2 </td><td><input type="text" id="${addressTypePrefix?upper_case}_ADDR2" name="${addressTypePrefix?upper_case}_ADDR2" value="${addressValue.addr2}"/></td>
                <td>City </td><td><input type="text" id="${addressTypePrefix?upper_case}_CITY" name="${addressTypePrefix?upper_case}_CITY" value="${addressValue.city}"/></td>
            </tr>
            <tr>
                <td>State </td><td><input type="text" id="${addressTypePrefix?upper_case}_STATE" name="${addressTypePrefix?upper_case}_STATE" value="${addressValue.state}"/></td>
                <td>Country </td><td><input type="text" id="${addressTypePrefix?upper_case}_STATE" name="${addressTypePrefix?upper_case}_COUNTRY"value="${addressValue.country}"/></td>
                <td>Pin code </td><td><input type="text" id="${addressTypePrefix?upper_case}_ZIP" name="${addressTypePrefix?upper_case}_ZIP" value="${addressValue.zip}"/></td>
            </tr>
        </table>
    </fieldset>
 </#macro>
 <#macro message msg msgType>
 	<#if msg?has_content>
 	<#--need to check if condition-->
 		<#if msgType=="0">
 			<div id="server_msg" class="green">${msg!}</div>
 		</#if>
 		<#if msgType=="1">
 			<div id="server_msg" class="red">${msg!}</div>
 		</#if>
 		<div id="server_msg" class="red">${msg!}</div>
 	</#if>	
 </#macro>