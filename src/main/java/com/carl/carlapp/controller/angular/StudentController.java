package com.carl.carlapp.controller.angular;

import java.io.Serializable;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StudentController {
	private class Student implements Serializable{
		private static final long serialVersionUID = 1L;
		private String name;
		private String rollNo;
		private String percentage;
		
		public Student(){}
		
		public Student(String name, String rollNo, String percentage) {
			this.name = name;
			this.rollNo = rollNo;
			this.percentage = percentage;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getRollNo() {
			return rollNo;
		}
		public void setRollNo(String rollNo) {
			this.rollNo = rollNo;
		}
		public String getPercentage() {
			return percentage;
		}
		public void setPercentage(String percentage) {
			this.percentage = percentage;
		}
		
	}
	@ResponseBody
	@RequestMapping(value="/getStudents", method=RequestMethod.GET)
	public ArrayList<Student> getStudents(){
		System.out.println("-------------getStudents---------");
		ArrayList<Student> list = new ArrayList<Student>();
		list.add(new Student("Mahesh Parashar","101","80%"));
		list.add(new Student("Dinkar Kad","201","70%"));
		list.add(new Student("Robert","191","75%"));
		list.add(new Student("Julian Joe","111","77%"));
		return list;
	}

}
