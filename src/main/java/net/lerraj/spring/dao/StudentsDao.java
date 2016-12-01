package net.lerraj.spring.dao;

import java.util.List;

import net.lerraj.spring.model.Students;

public interface StudentsDao {
	
	public void saveOrUpdate(Students student);
	
	public void delete(long studentId);
	
	public Students get(long studentId);
	
	public List<Students> list();

	public List<Students> getSorted(final String sortValue);
	
	public List<Students> getStudentListByName(String searchValue);
}