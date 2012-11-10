package com.lmv.tools.service;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 * 
 */
public class ToolsServiceManager {

    private static Logger LOG = Logger.getLogger(ToolsServiceManager.class);

    private ApplicationContext mSpringContext;

    public ToolsServiceManager(String springConfigFilePath) {
	super();
	this.setSpringContext(new ClassPathXmlApplicationContext(springConfigFilePath));
    }

    public static void main(String[] args) {
	// Chargement du fichier de configuration
	ToolsServiceManager tools = new ToolsServiceManager("tools-service-bean-config.xml");
	
	HelloService helloService = (HelloService)tools.getBean("helloService");
	helloService.setName("Test");
	helloService.printService();
	LOG.info("log4j est initialise avec succes");
	//Runtime.getRuntime().exec(cmdarray, envp, dir)

    }

    public ToolsServiceManager() {
	super();
    }

    public Object getBean(String beanId) {
	return mSpringContext.getBean(beanId);
    }

    public void setSpringContext(ApplicationContext mSpringContext) {
	this.mSpringContext = mSpringContext;
    }
}
