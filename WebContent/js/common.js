function stringToDate(dateString) {
	var dateFieldArray=dob.split("-");
	var year = dateFieldArray[0];
	var month = dateFieldArray[1];
	var day = dateFieldArray[2];
	var date = new Date(year, month - 1, day);
	return date;
}


function dateCompare(date1,date2){
if (date1>date2)
  {
  return true;
  }
else
  {
  return false;
  }
}