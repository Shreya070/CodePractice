package com.springdata.jpql;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.springdata.jpql.Entity.Student;
import com.springdata.jpql.Repository.StudentRepository;


@RunWith(SpringRunner.class)
@SpringBootTest
class JpqlApplicationTests {

	
	@Autowired
	StudentRepository repository;

	@Test
	public void testStudentCreate() {
		Student student = new Student();
		student.setFirstName("shreya");
		student.setLastName("Gupta");
		student.setScore(98);

		Student student2 = new Student();
		student2.setFirstName("rashi");
		student2.setLastName("Gates");
		student2.setScore(95);

		repository.save(student);
		repository.save(student2);
	}

	
	

	@Test
	public void testFindAllStudentsPartial() {
		List<Object[]> partialData = repository.findAllStudentsPartialData();
		for (Object[] objects : partialData) {
			System.out.println(objects[0]);
			System.out.println(objects[1]);
		}
	}

	@Test
	public void testFindAllStudentsByFirstName() {
		System.out.println(repository.findAllStudentsByFirstName("rashi"));
	}

	@Test
	public void testFindAllStudentsByScores() {
		System.out.println(repository.findStudentsForGivenScores(80, 90));
	}

	@Test
	@Transactional
	@Rollback(false)
	public void testDeleteStudentsByFirstName() {
		repository.deleteStudentsByFirstName("rashi");
	}

	@Test
	public void testFindAllStudentNQ() {
		System.out.println(repository.findAllStudentNQ());
	}
	
	@Test
	public void testFindByFirstNameNQ() {
		System.out.println(repository.findByFirstNQ("shreya"));
	}

}








