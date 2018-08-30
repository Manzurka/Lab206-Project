package com.lab206.services;

import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.lab206.models.Project;
import com.lab206.repositories.ProjectRepository;

@RunWith(MockitoJUnitRunner.Silent.class)
public class ProjectServiceTest {
	
	private static final Object Project = null;

	@Mock
    private ProjectRepository repository;

    private ProjectService service;

    private Long projectId;
    
    @Before
    public void setUp() {
        service = new ProjectService(repository);

        projectId = 1L;
    }
    
    @Test
    public void testfindProjectByIdSuccessful() {
    	Optional<Project> optional = Optional.of(new Project());
    	Mockito.when(repository.findById(projectId)).thenReturn(optional);
    	Project project = service.findProjectById(projectId);
    	Assert.assertNotNull(project);
    	
    }
    
    @Test
    public void testfindProjectByIdEmpty() {
        Optional<Project> optional = Optional.empty();
        Mockito.when(repository.findById(projectId)).thenReturn(optional);
        Assert.assertNull(Project);
    }

}
