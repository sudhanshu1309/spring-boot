package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {

			// createStudent(studentDAO);

			createMultipleStudent(studentDAO);

			// readStudent(studentDAO);

			// queryForStudents(studentDAO);

			// queryForStudentsByLastName(studentDAO);

			// updateStudent(studentDAO);

			// deleteStudent(studentDAO);

			// deleteAllStudent(studentDAO);
		};
	}

	private void deleteAllStudent(StudentDAO studentDAO) {
		System.out.println("Deleting all students");
		int numberOfRowsDeleted = studentDAO.deleteAll();
		System.out.println("Deleted " + numberOfRowsDeleted + " students");
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 3;
		System.out.println("Deleting student id: " + studentId);
		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {

		// retrieve student based on the id: primary key
		int studentId = 1;
		System.out.println("Getting student with id: " + studentId);
		Student student = studentDAO.findById(studentId);

		// change first name to "Jatin"
		System.out.println("Updating student with id: " + studentId);
		student.setFirstName("Sudhanshu");

		// update the student
		studentDAO.update(student);

		// display the updated student
		System.out.println("Updated student: " + student);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {

		// get a list of students
		List<Student> students = studentDAO.findByLastName("tripathi");

		// display list of students
		for (Student student : students) {
			System.out.println(student);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {

		// get a list of students
		List<Student> students = studentDAO.findAll();

		// display list of students
		for (Student student : students) {
			System.out.println(student);
		}
	}

	private void readStudent(StudentDAO studentDAO) {

		// create a student
		System.out.println("Creating new student object...");
		Student student = new Student("Chetan", "Rawat", "chetan@email.com");

		// save the student
		System.out.println("Saving the student object...");
		studentDAO.save(student);

		// display id of the saved student
		int id = student.getId();
		System.out.println("Saved student with ID: " + id);

		// retrieve student based on the id: primary key
		System.out.println("Retrieving student with ID: " + id);
		Student retrievedStudent = studentDAO.findById(id);

		// display student
		System.out.println("Retrieved student: " + retrievedStudent);
	}

	private void createMultipleStudent(StudentDAO studentDAO) {

		// create multiple students
		System.out.println("Creating student...");
		Student student1 = new Student("Sudhanshu", "Tripathi", "sudhanshu@gmail.com");
		Student student2 = new Student("Prashant", "Dwivedi", "prashant@gmail.com");
		Student student3 = new Student("Arihant", "Jain", "arihant@gmail.com");

		// save the student objects
		System.out.println("Saving students...");
		studentDAO.save(student1);
		studentDAO.save(student2);
		studentDAO.save(student3);
	}

	private void createStudent(StudentDAO studentDAO) {

		// create the student object
		System.out.println("Creating student...");
		Student student = new Student("Sudhanshu", "Tripathi", "sudhanshu@gmail.com");

		// save the student object
		System.out.println("Saving student...");
		studentDAO.save(student);

		// display the id of the saved student
		System.out.println("Saving student. Generated id: " + student.getId());
	}
}
