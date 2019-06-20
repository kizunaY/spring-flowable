package com.example.demo.bean;

import org.flowable.engine.RuntimeService;
import org.springframework.transaction.annotation.Transactional;

public class UserBean {
	 /** 已经由Spring注入 */
	  private RuntimeService runtimeService;

	  @Transactional
	  public void hello() {
	    // 可以在你的领域模型（domain model）中进行事务操作，
	    // 它会与Flowable RuntimeService的startProcessInstanceByKey
	    // 合并在同一个事务里
	    runtimeService.startProcessInstanceByKey("helloProcess");
	  }

	  public void setRuntimeService(RuntimeService runtimeService) {
	    this.runtimeService = runtimeService;
	  }
}
