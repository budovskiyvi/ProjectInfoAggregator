package com.vzdrizd.infoaggr.dao;

import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.orm.jpa.*;
import org.springframework.test.context.junit4.SpringRunner;

import com.vzdrizd.infoaggr.model.Project;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ProjectDaoTest {
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	ProjectDao projectDao;
		
	private Project project = new Project();

	@Before
	public void init() {
		project.setName("TEST");
		project.setDescription("TEST PROJECT");
	}
	
	@Test
	public void testSaveProject(){
		//bookService.addProject(project);
	}
}
