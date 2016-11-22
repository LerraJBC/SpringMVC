package net.lerraj.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import net.lerraj.spring.model.Students;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

/**
 * An implementation of the ContactDAO interface.
 * @author www.codejava.net
 *
 */
public class StudentsDaoImpl implements StudentsDao {

	private JdbcTemplate jdbcTemplate;
	
	public StudentsDaoImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public void saveOrUpdate(Students student) {
		if (student.getId() > 0) {
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
		}
		
	}

	public void delete(int studentId) {
		String sql = "DELETE FROM personal_info WHERE id=?";
		jdbcTemplate.update(sql, studentId);
	}

	public List<Students> list() {
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
