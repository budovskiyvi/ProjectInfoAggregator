package com.vzdrizd.infoaggr.service;

import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.orm.jpa.*;
import org.springframework.test.context.junit4.SpringRunner;

import com.vzdrizd.infoaggr.model.Project;



import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ProjectServiceTest {

	@Autowired
	private TestEntityManager entityManager;


	private ProjectService projectService;
	
	@Autowired(required=true)
	@Qualifier(value = "projectService")
	public void setProjectService(ProjectService projectService) {
        this.projectService = projectService;
    }

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
