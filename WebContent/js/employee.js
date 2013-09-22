jQuery.noConflict();
function selection(sex,deptList,dept)
{
	if(sex=='M'){
		document.getElementById("sex_m").checked = true;
	}
	if(sex=='F'){
		document.getElementById("sex_f").checked = true;
	}
	
}
function validateOfficalDetailForm()
	{
	var validationStatus=true;
	var errormsg="";
	var grade=document.getElementById("GRADE").value;
	var position=document.getElementById("POSITION").value;
	var firstName=document.getElementById("FIRST_NAME").value;
	var doj=document.getElementById("DOJ").value;
	if (grade==null || grade==""){
	  validationStatus= false;
	  errormsg="Grade is required field";
	  }
	  if (position==null || position==""){
	   errormsg+="<br/>Position is required field";
	  validationStatus= false;
	  }
	  if (firstName==null || firstName==""){
	  errormsg+="<br/>First Name is required field";
	  validationStatus= false;
	  }
	  if (doj==null || doj==""){
	  errormsg+="<br/>Joining Date is required field";
	  validationStatus= false;
	  }
	  if(!validationStatus){
	  	document.getElementById("officialdetail_errormsg").innerHTML=errormsg;
	  	return false;
	  }
	}
	
function validatePersonalDetailForm()
	{
	var validationStatus=true;
	var errorms="";
	var fatherName=document.getElementById("FATHER_NAME").value;
	var motherName=document.getElementById("MOTHER_NAME").value;
	var dob=document.getElementById("EMP_DOB").value;
	if (fatherName==null || fatherName==""){
	  validationStatus= false;
	  errormsg="Father Name is required field.";
	  }
	  if (motherName==null || motherName==""){
	   errormsg+="<br/>Mother Name is required field.";
	  validationStatus= false;
	  }
	  if (dob==null || dob==""){
	  errormsg+="<br/>Date of birth is required field.";
	  validationStatus= false;
	  }
	  if(!validationStatus){
	  	document.getElementById("personaldetails_errormsg").innerHTML=errormsg;
	  	return false;
	  }
	}
	

jQuery(document).ready(function(){
	jQuery( "#DOJ" ).datepicker({ dateFormat: 'yy-mm-dd' });
	jQuery( "#EMP_DOB" ).datepicker({ dateFormat: 'yy-mm-dd' });
	jQuery( "input[name='FROM_C']" ).datepicker({ dateFormat: 'yy-mm-dd' });
	jQuery( "input[name='TO_C']" ).datepicker({ dateFormat: 'yy-mm-dd' });
	
	jQuery("#DEPT_NO").change(function() {
	 	jQuery.ajax({
			type: "post",
			url: "http://localhost:8080/empapp/ajax/dept.html",
			cache: false,	
			data:({DEPT_NO : jQuery("#DEPT_NO").val()}),			
			success:function(response) {
				var json = eval ("(" + response + ")");
				jQuery("#DEPT_DESCRIPTION").val(json.descri);
				jQuery("#DEPT_ADDRESS1").val(json.addr.addr1);
				jQuery("#DEPT_ADDRESS2").val(json.addr.addr2);
				jQuery("#DEPT_CITY").val(json.addr.city);
				jQuery("#DEPT_STATE").val(json.addr.state);
				jQuery("#DEPT_COUNTRY").val(json.addr.country);
				jQuery("#DEPT_ZIP").val(json.addr.zip);
	        },
			error: function(){						
				alert('Error while request..');
			}
		});
	 });
 });