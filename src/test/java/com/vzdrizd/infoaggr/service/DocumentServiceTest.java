/**
 * 
 */
package com.vzdrizd.infoaggr.service;

import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.vzdrizd.infoaggr.AbstractTest;
import com.vzdrizd.infoaggr.model.BusinessObject;
import com.vzdrizd.infoaggr.model.Document;
import com.vzdrizd.infoaggr.model.DocumentType;
import com.vzdrizd.infoaggr.model.Project;

/**
 * @author V.Budovskiy
 *
 */
public class DocumentServiceTest extends AbstractTest{

	@Autowired
	private ProjectService projectService; 
	
	@Autowired
	private BusinessObjectService businessObjectService;
	
	@Autowired
	private DocumentService documentService;
	
	Project project;
	BusinessObject bo;
	
	 @Before
	 public void initEnvironment(){
		 project = projectService.create(new Project("testName", "testDescr"));
		 bo=businessObjectService.create(new BusinessObject("testName","Test Descrip",project));

	 }
	 
	 @Test
	 public void testService()
	 {
		 Document document=new Document();
		 document.setName("Test name");
		 document.setDescription("test Descrip");
		 document.setDocumentType(DocumentType.DOCUMENTATION);
		 document.setLocation("Test Loc");
		 document.setVersion(1);
		 document.addBusinessObject(bo);
		 Document savedDocument=documentService.create(document);
		 Assert.assertNotNull("failure - expected not null", savedDocument);
		 BusinessObject updateBo=businessObjectService.update(bo);
		 Set <Document> documents = updateBo.getDocuments();
		Document documentFromSet =documents.iterator().next();
		 Assert.assertNotNull("failure - expected not null", updateBo);
	 }
}


