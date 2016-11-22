package net.lerraj.spring.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;


import net.lerraj.spring.dao.StudentsDao;
import net.lerraj.spring.model.Students;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@Autowired
	private StudentsDao studentsDao;
	
	@RequestMapping(value="/")
	public ModelAndView listStudents(ModelAndView model) throws IOException{
		List<Students> listStudents = studentsDao.list();
		model.addObject("listStudents", listStudents);
		model.setViewName("home");
		
		return model;
	}
	
	@RequestMapping(value = "/newStudent", method = RequestMethod.GET)
	public ModelAndView newStudent(ModelAndView model) {
		Students newStudent = new Students();
		model.addObject("student", newStudent);
		model.setViewName("StudentForm");
		return model;
	}
	
	@RequestMapping(value = "/saveStudent", method = RequestMethod.POST)
	public ModelAndView saveStudent(@ModelAttribute Students student) {
		studentsDao.saveOrUpdate(student);		
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value = "/deleteStudent", method = RequestMethod.GET)
	public ModelAndView deleteStudent(HttpServletRequest request) {
		int studentId = Integer.parseInt(request.getParameter("id"));
		studentsDao.delete(studentId);
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value = "/editStudent", method = RequestMethod.GET)
	public ModelAndView editStudent(HttpServletRequest request) {
		int studentId = Integer.parseInt(request.getParameter("id"));
		Students student = studentsDao.get(studentId);
		ModelAndView model = new ModelAndView("StudentForm");
		model.addObject("student", student);
		
		return model;
	}
}
