package com.app.emp.util;

import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.emp.bean.Address;
import com.app.emp.bean.EmploymentHistory;
import com.app.emp.bean.Qualification;
@Service
public class EmpUtils {
	public List<Qualification> setQualifications(List<String> degree, List<String> board, List<String> fromY, List<String> toY,List<String> duration,List<String> grade){
        List<Qualification> qualifications=new ArrayList<Qualification>();
        int size=degree.size();
        for (int index = 0; index < size; index++) {
            Qualification qualification=new Qualification();
            qualification.setDegree(degree.get(index));
            if(board!=null && index<=(board.size()-1))
                qualification.setBoard(board.get(index));
            if(duration!=null && index<=(duration.size()-1))
                qualification.setDuration(new Integer(duration.get(index)));
            if(grade!=null && index<=(grade.size()-1))
                qualification.setGrade(grade.get(index));
            if(fromY!=null && index<=(fromY.size()-1))
                qualification.setFromYr(fromY.get(index));
            if(toY!=null && index<=(toY.size()-1))
                qualification.setToYr(toY.get(index));
            qualifications.add(qualification);
        }
        return qualifications;
    }
    
    public List<EmploymentHistory> setEmploymentHistory(List<String> comNames,List<String> positionHelds, List<String> fromCs,List<String> toCs, List<String> reasonChanges,
            List<String> comAdd1,List<String> comAdd2,List<String> comCity, List<String> comState,List<String> comCountry,List<String> comZip
            ) throws ParseException{
        List<EmploymentHistory> empHistorys=new ArrayList<EmploymentHistory>();
        int size=comNames.size();
        for (int index = 0; index < size; index++) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
            
            EmploymentHistory empHis=new EmploymentHistory();
            Address address=new Address();
            if(comAdd1!=null && index<=(comAdd1.size()-1))
                address.setAddr1(comAdd1.get(index));;
            if(comAdd2!=null && index<=(comAdd2.size()-1))
                address.setAddr1(comAdd2.get(index));;
            if(comCity!=null && index<=(comCity.size()-1))
                address.setCity(comCity.get(index));
            if(comState!=null && index<=(comState.size()-1))
                address.setState(comState.get(index));
            if(comCountry!=null && index<=(comCountry.size()-1))
                address.setCountry(comCountry.get(index));
            if(comZip!=null && index<=(comZip.size()-1))
                address.setZip(comZip.get(index));
            if(comNames!=null && index<=(comNames.size()-1))
                empHis.setComName(comNames.get(index));
            if(fromCs!=null && index<=(fromCs.size()-1)){
                Date joingDt=dateFormat.parse(fromCs.get(index));
                empHis.setFromDt(joingDt);
                }
            if(toCs!=null && index<=(toCs.size()-1)){
                Date resignDt=dateFormat.parse(toCs.get(index));
                empHis.setToDt(resignDt);
                }
            if(positionHelds!=null && index<=(positionHelds.size()-1))
                empHis.setPosition(positionHelds.get(index));
            if(reasonChanges!=null && index<=(reasonChanges.size()-1))
                empHis.setChangeReason(reasonChanges.get(index));

                empHis.setComAddr(address);
           empHistorys.add(empHis);
        }
        return empHistorys;
    }

	public Address setAddress(String addr1,String addr2, String city,String state, String country,String zip){
		Address addr=new Address();
		addr.setAddr1(addr1);
		addr.setAddr2(addr2);
		addr.setCity(city);
		addr.setState(state);
		addr.setCountry(country);
		addr.setZip(zip);
		return addr;
	}
	public static String fromJavaToJson(Serializable object)
			throws JsonGenerationException, JsonMappingException, IOException {
		    ObjectMapper jsonMapper = new ObjectMapper();
		    return jsonMapper.writeValueAsString(object);
		}

	public static Object fromJsonToJava(String json, Class type) throws JsonParseException,
			JsonMappingException, IOException {
	     ObjectMapper jsonMapper = new ObjectMapper();
	     return jsonMapper.readValue(json, type);
	}
}
