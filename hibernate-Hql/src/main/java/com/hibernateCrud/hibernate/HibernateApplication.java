package com.hibernateCrud.hibernate;

import com.hibernateCrud.hibernate.model.Student;
import com.hibernateCrud.hibernate.repository.StudentRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;


public class HibernateApplication {

	public static void main(String[] args) {
		StudentRepository studentRepository=new StudentRepository();
		Student student=new Student("abdulvahap","Önen","javapicaso@gmail.com");
		studentRepository.saveStudent(student);
		student.setAd("abdulvaha güncel");
		studentRepository.updateStudent(student);
		 Student studentById=new Student();
		studentById= studentRepository.findStudentById(1);
		System.out.println("student by ıd");
		System.out.println(studentById);
	List<Student> allStudent=studentRepository.getAllStudents();
		System.out.println("all student");
		 allStudent.forEach(student1 -> System.out.println(student1.getAd()));
	//studentRepository.deleteStudent(student.getId());

		List< Student> studentByName=studentRepository.getStudentByName("abdulvaha güncel");
		System.out.println("  student by name");
		studentByName.forEach(student1 -> System.out.println(student1.getAd()));
	}

}
