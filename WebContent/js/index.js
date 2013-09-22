jQuery.noConflict();
function validateForm(){
	var validationStatus=true;
	var errormsg="";
	document.getElementById("officialdetail_errormsg").innerHTML="";
	var grade=document.getElementById("grade").value;
	var position=document.getElementById("position").value;
	var doj=document.getElementById("doj").value;
	var firstName=document.getElementById("first_name").value;
	
	var dob=document.getElementById("emp_dob").value;
	var fatherName=document.getElementById("father_name").value;
	var motherName=document.getElementById("mother_name").value;
	var sexM=document.getElementById("sex_m").checked;
	var sexF=document.getElementById("sex_f").checked;
	
	var degree=document.getElementsByName("DEGREE");
	var board=document.getElementsByName("BOARD");
	var from=document.getElementsByName("FROM_Y");
	var to=document.getElementsByName("TO_Y");
	var duration=document.getElementsByName("DURATION");
	var percent=document.getElementsByName("GRADE");
	if (grade==null || grade==""){
	  validationStatus= false;
	  errormsg+="Grade is required field.";
	  }
	if (grade!=null || grade!=""){
		if(grade.length>3){
			  validationStatus= false;
			  errormsg+="Grade length should be 2 characters.";		  
		  }
	}
	  if (position==null || position==""){
	  errormsg+="<br/>Position is required field.";
	  validationStatus= false;
	  }
	  if (doj==null || doj==""){
	  errormsg+="<br/>Date of joining is required field.";
	  validationStatus= false;
	  }
	  //checking date of birth is greater then 14 year
	  /*if (dob!=null || dob!=""){
		  var dateArray=dob.split("-");
		  var year = new Date().getFullYear();
		  if((year-dateArray[0])<14){
			  errormsg+="<br/>Date of birth shoud be greater than 14 years.";
			  validationStatus= false;
	  }
	  }*/
	  if (firstName==null || firstName==""){
	  errormsg+="<br/>First Name is required field.";
	  validationStatus= false;
	  }
	  if ((sexM==false || sexF==false) && !(sexM==true || sexF==true)){
		  errormsg+="<br/>Sex is required field.";
		  validationStatus= false;
		  }
	  if (fatherName==null || fatherName==""){
	  validationStatus= false;
	  errormsg+="<br/>Father Name is required field.";
	  }
	  if (motherName==null || motherName==""){
	   errormsg+="<br/>Mother Name is required field.";
	  validationStatus= false;
	  }
	  if (dob==null || dob==""){
	  errormsg+="<br/>Date of birth is required field.";
	  validationStatus= false;
	  }
	
	  for(var index=0;index<degree.length;index++){
		  if (degree[index]==null || degree[index]==""){
			  errormsg+="<br/>Degree is required field.";
			  validationStatus= false;
		  }
		  if(board!=null && degree.length){
			  if (board[index]==null || board[index]==""){
				  errormsg+="<br/>Board is required field.";
				  validationStatus= false;
			  }
		  }else{
			  errormsg+="<br/>Board is required field.";
			  validationStatus= false;
		  }
		  if(from!=null && degree.length){
			  if (from[index]==null || from[index]==""){
				  errormsg+="<br/>From is required field.";
				  validationStatus= false;
			  }
		  }else{
			  errormsg+="<br/>Board is required field.";
			  validationStatus= false;
		  }
		  if(to!=null && degree.length){
			  if (to[index]==null || to[index]==""){
				  errormsg+="<br/>To is required field.";
				  validationStatus= false;
			  }
		  }else{
			  errormsg+="<br/>Board is required field.";
			  validationStatus= false;
		  }
		  if(duration!=null && degree.length){
			  if (duration[index]==null || duration[index]==""){
				  errormsg+="<br/>Duration is required field.";
				  validationStatus= false;
			  }
		  }else{
			  errormsg+="<br/>Board is required field.";
			  validationStatus= false;
		  }
		  if(percent!=null && degree.length){
		  if (percent[index]==null || percent[index]==""){
			  errormsg+="<br/>percent is required field.";
			  validationStatus= false;
		  }
		  }else{
			  errormsg+="<br/>Board is required field.";
			  validationStatus= false;
		  }
	  }
	  if(!validationStatus){
	  	document.getElementById("officialdetail_errormsg").innerHTML=errormsg;
	  	return false;
	  }
	}
function isInteger(s)
{
      var i;
	  s = s.toString();
      for (i = 0; i < s.length; i++)
      {
         var c = s.charAt(i);
         if (isNaN(c)) 
	   {
		alert("Duration should be numeric  value");
		return false;
	   }
      }
      return true;
}
jQuery(document).ready(function(){

 jQuery( "#doj" ).datepicker({ dateFormat: 'yy-mm-dd' });
 jQuery( "#emp_dob" ).datepicker({ dateFormat: 'yy-mm-dd' });
 jQuery( "input[name='FROM_C']" ).datepicker({ dateFormat: 'yy-mm-dd' });
 jQuery( "input[name='TO_C']" ).datepicker({ dateFormat: 'yy-mm-dd' });

  jQuery("#dept_no").change(function() {
 	jQuery.ajax({
		type: "post",
		url: "http://localhost:8080/empapp/ajax/dept.html",
		cache: false,	
		data:({DEPT_NO : jQuery("#dept_no").val()}),			
		success:function(response) {
			var json = eval ("(" + response + ")");
			jQuery("#dept_description").val(json.descri);
			jQuery("#dept_address1").val(json.addr.addr1);
			jQuery("#dept_address2").val(json.addr.addr2);
			jQuery("#dept_city").val(json.addr.city);
			jQuery("#dept_state").val(json.addr.state);
			jQuery("#dept_country").val(json.addr.country);
			jQuery("#dept_zip").val(json.addr.zip);
        },
		error: function(){						
			alert('Error while request..');
		}
	});
  });

  jQuery("#sameAddress").click(function(){
		jQuery("#perma_addr1").val(jQuery("#pres_addr1").val());
		jQuery("#perma_addr2").val(jQuery("#pres_addr2").val());
		jQuery("#perma_city").val(jQuery("#pres_city").val());
		jQuery("#perma_state").val(jQuery("#pres_state").val());
		jQuery("#perma_country").val(jQuery("#pres_country").val());
		jQuery("#perma_zip").val(jQuery("#pres_zip").val());
  });
  jQuery("#btn_add_qualification").click(function(){
	  	jQuery("Add").hide();
	 	jQuery("#tbl_qualification").append("<tr><td><input type=\"text\" " +
	 			"class=\"qualificationtext\" name=\"DEGREE\"/></td><td><input type=\"text\" " +
	 			"class=\"qualificationtext\" name=\"BOARD\"/></td><td><input type=\"text\" " +
	 			"class=\"qualificationtext\" name=\"FROM_Y\"/></td><td>" +
	 			"<input class=\"qualificationtext\" type=\"text\" name=\"TO_Y\"/>" +
	 			"</td><td><input type=\"text\" class=\"qualificationtext\" name=\"DURATION\" onKeyup=\"isInteger(this.value)\"/>" +
	 			"</td><td><input type=\"text\" class=\"qualificationtext\" name=\"GRADE\"/></td></tr>");
  });
  jQuery("#btn_add_history").click(function(){
	  	jQuery("Add").hide();
	 	jQuery("#employmentDetails").append("<table><tr><td class=\"qualification\">Company name</td>" +
	 			"<td class=\"qualification\">Position held</td><td class=\"qualification\">From</td>" +
	 			"<td class=\"qualification\">To</td><td class=\"qualification\">Reason for change</td>" +
	 			"</tr><tr><td><input type=\"text\" class=\"qualificationtext\" name=\"COMPANY_NAME\"/>" +
	 			"</td><td><input type=\"text\" class=\"qualificationtext\" name=\"POSITION_HELD\"/>" +
	 			"</td><td><input type=\"text\" class=\"qualificationtext\" name=\"FROM_C\" readonly/></td>" +
	 			"<td><input type=\"text\" class=\"qualificationtext\" name=\"TO_C\" readonly/>" +
	 			"</td><td><input type=\"text\" class=\"qualificationtext\" name=\"REASON_CHANGE\"/>" +
	 			"</td></tr></table><table><tr><td>Address1 </td><td>" +
	 			"<input type=\"text\" name=\"COM_ADDR1\"/></td><td>Address2 </td><td>" +
	 			"<input type=\"text\" name=\"COM_ADDR2\"/></td><td>City </td><td>" +
	 			"<input type=\"text\" name=\"COM_CITY\"/></td></tr><tr><td>State </td>" +
	 			"<td><input type=\"text\" name=\"COM_STATE\"/></td><td>Country </td><td>" +
	 			"<input type=\"text\" name=\"COM_COUNTRY\"/></td><td>Pin code </td><td>" +
	 			"<input type=\"text\" name=\"COM_ZIP\"/></td></tr></table>");
	 	jQuery( "input[name='FROM_C']" ).datepicker({ dateFormat: 'yy-mm-dd' });
	 	jQuery( "input[name='TO_C']" ).datepicker({ dateFormat: 'yy-mm-dd' });
 	});
});