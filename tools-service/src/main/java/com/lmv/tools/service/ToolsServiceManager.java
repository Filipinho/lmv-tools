package com.lmv.tools.service;

import java.io.File;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
 */
public class ToolsServiceManager {

    private static Logger LOG = Logger.getLogger(ToolsServiceManager.class);

    private ApplicationContext mSpringContext;

    public ToolsServiceManager(String springConfigFilePath) {
	super();
	this.setSpringContext(new ClassPathXmlApplicationContext(springConfigFilePath));
    }

   
    /**
     * 
     * @return code execution du script
     */
    public static int execute(final File path) {
	int exitCode = -100;
	// Chargement du fichier de configuration
	ToolsServiceManager tools = new ToolsServiceManager("tools-service-bean-config.xml");
	final CmdLauncher launcher = (CmdLauncher) tools.getBean("cmdLauncher");
	try {
	    LOG.info( "Ressource from context : " + path );
	    exitCode = launcher.execute(System.out, path);
	} catch (IOException e) {
	    LOG.error(e.getMessage(), e);
	} catch (InterruptedException ie) {
	    LOG.error(ie.getMessage(), ie);
	}
	
	LOG.info("Code retour " + exitCode );
	return exitCode;
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

    public ApplicationContext getSpringContext() {
        return mSpringContext;
    }
}
