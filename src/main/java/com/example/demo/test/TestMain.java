package com.example.demo.test;

import org.flowable.engine.RepositoryService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.demo.bean.UserBean;

public class TestMain {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext application=new ClassPathXmlApplicationContext("spring-flowable.xml");
//		RepositoryService repository=(RepositoryService) application.getBean("repositoryService");
//		String deploymentId =repository.createDeployment().addClasspathResource("hello.bpmn20.xml").deploy().getId();
//		System.out.println(deploymentId);
		
		//方式2
		UserBean bean=application.getBean(UserBean.class);
		bean.hello();
	}
}
