package net.lerraj.spring.dao;

import java.util.List;

import net.lerraj.spring.model.Students;

public interface StudentsDao {
	
	public void saveOrUpdate(Students student);
	
	public void delete(long studentId);
	
	public Students get(int studentId);
	
	public List<Students> list();
}