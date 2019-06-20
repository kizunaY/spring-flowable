package com.example.demo;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.flowable.engine.RepositoryService;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.flowable.engine.repository.ProcessDefinition;
import org.flowable.engine.test.Deployment;
import org.flowable.engine.test.FlowableRule;
import org.flowable.task.api.Task;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-flowable.xml")
public class ProcessEngineSpringApplicationTests {
	@Autowired
	private RuntimeService runtimeService;
	@Autowired
	private TaskService taskService;
	@Autowired
	@Rule
	public FlowableRule flowableSpringRule;
	@Autowired
	private RepositoryService repositoryService;
	
	@Test
	@Deployment(resources = "hello.bpmn20.xml")
	public void hello() {
	    ProcessDefinition processDefinition=repositoryService.createProcessDefinitionQuery().singleResult();
		runtimeService.startProcessInstanceById(processDefinition.getId());
		Task task=taskService.createTaskQuery().singleResult();
		if(task!=null) {
			assertEquals("My Task", task.getName());
			taskService.complete(task.getId());
		}else {
			System.out.println("My Task is NULL");
		}
	    assertEquals(0, runtimeService.createProcessInstanceQuery().count());
	}
	
}
