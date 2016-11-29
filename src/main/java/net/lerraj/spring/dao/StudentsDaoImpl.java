package net.lerraj.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import net.lerraj.spring.model.Students;
import net.lerraj.spring.util.JSONFileUtil;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonStructure;
import javax.json.JsonWriter;
import javax.json.JsonWriterFactory;
import javax.json.stream.JsonGenerator;


public class StudentsDaoImpl implements StudentsDao {

	private JdbcTemplate jdbcTemplate;
	
	private JSONFileUtil fileUtil = new JSONFileUtil();
	
	public StudentsDaoImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	

	public void saveOrUpdate(Students student) {
		if (student.getId() > 0) {
			try{
				JSONObject jsonObject = fileUtil.getFileJSONObject();
				JSONArray arr = (JSONArray) jsonObject.get("Students");
				
				Iterator itr = arr.iterator();
		        while (itr.hasNext()) {
		            JSONObject obj = (JSONObject) itr.next();
		            if (obj.get("id").equals(student.getId())) {
		            	obj.put("firstname", student.getFirstname());
		            	obj.put("lastname", student.getLastname());
		            	obj.put("age", student.getAge());
		            	obj.put("gender", student.getGender());
		            	obj.put("contact", student.getContact());
		            	obj.put("address", student.getAddress());

		            }
		            fileUtil.writeToFile(jsonObject);
		        }
				
			}
			catch(Exception e){
				
			}
			
		}
		else{
		try{
			  	
			  	JSONObject jsonObject = fileUtil.getFileJSONObject();
		        
			    JSONObject newJSON = new JSONObject();
			    
			    student.setId(fileUtil.incrementId());		    
			    newJSON.put("id", student.getId());
			    newJSON.put("firstname", student.getFirstname());
			    newJSON.put("lastname", student.getLastname());
			    newJSON.put("age", student.getAge());
			    newJSON.put("gender", student.getGender());
			    newJSON.put("contact", student.getContact());
			    newJSON.put("address", student.getAddress());

			    fileUtil.appendToList(jsonObject, newJSON);
			    fileUtil.writeToFile(jsonObject);
		
		
		}
		catch (Exception e)
	    {
	      
	    }
		}
		
		
		/**if (student.getId() > 0) {
			// update
			String sql = "UPDATE personal_info SET firstname=?, lastname=?, age=?, "
						+ "gender=?, contact=?, address=? WHERE id=?";
			jdbcTemplate.update(sql, student.getFirstname(), student.getLastname(),
					student.getAge(), student.getGender(), student.getContact(), student.getAddress(),student.getId());
		} else {
			// insert
			String sql = "INSERT INTO personal_info (firstname, lastname, age, gender, contact, address)"
						+ " VALUES (?, ?, ?, ?, ?, ?)";
			jdbcTemplate.update(sql, student.getFirstname(), student.getLastname(),
					student.getAge(), student.getGender(), student.getContact(), student.getAddress());
		}**/
		
	}

	public void delete(long studentId) {
		
		JSONObject jsonObject = fileUtil.getFileJSONObject();
		JSONArray arr = (JSONArray) jsonObject.get("Students");
		
		Iterator itr = arr.iterator();
        while (itr.hasNext()) {
            JSONObject obj = (JSONObject) itr.next();
            if (obj.get("id").equals(studentId)) {
                itr.remove();
            }
            fileUtil.writeToFile(jsonObject);
        }
        
        
		
		/**String sql = "DELETE FROM personal_info WHERE id=?";
		jdbcTemplate.update(sql, studentId);
	**/
		}

	public List<Students> list() {
		
		List<Students> listStudents = new ArrayList<Students>();
		JSONObject jsonObj = JSONFileUtil.getFileJSONObject();
		
		try{
		
		for (Object key : jsonObj.keySet()) {
            JSONObject jsonObject = (JSONObject) key;
            Students student = new Students();

            student.setId((Long) jsonObject.get("id"));
            student.setFirstname((String) jsonObject.get("firstname"));
            student.setLastname((String) jsonObject.get("lastname"));
            student.setAge((int) jsonObject.get("age"));
            student.setGender((String) jsonObject.get("gender"));
            student.setContact((String) jsonObject.get("contact"));
            student.setAddress((String) jsonObject.get("address"));

            listStudents.add(student);
        }
		}
		catch(Exception e){
			
		}
		/**
		String sql = "SELECT * FROM personal_info";
		List<Students> listStudents = jdbcTemplate.query(sql, new RowMapper<Students>() {

			public Students mapRow(ResultSet rs, int rowNum) throws SQLException {
				Students aStudent = new Students();
	
				aStudent.setId(rs.getInt("id"));
				aStudent.setFirstname(rs.getString("firstname"));
				aStudent.setLastname(rs.getString("lastname"));
				aStudent.setAge(rs.getInt("age"));
				aStudent.setGender(rs.getString("gender"));
				aStudent.setContact(rs.getString("contact"));
				aStudent.setAddress(rs.getString("address"));
				return aStudent;
				
			}
			
		});
		**/
		return listStudents;
	}

	public Students get(int studentId) {
		String sql = "SELECT * FROM personal_info WHERE id=" + studentId;
		return jdbcTemplate.query(sql, new ResultSetExtractor<Students>() {

			public Students extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				if (rs.next()) {
					Students student = new Students();
					student.setId(rs.getInt("id"));
					student.setFirstname(rs.getString("firstname"));
					student.setLastname(rs.getString("lastname"));
					student.setAge(rs.getInt("age"));
					student.setGender(rs.getString("gender"));
					student.setContact(rs.getString("contact"));
					student.setAddress(rs.getString("address"));
					return student;
				}
				
				return null;
			}
			
		});
	}
	
}
