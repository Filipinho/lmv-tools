/**
 * 
 */
package com.lmv.tools.service;

import java.io.IOException;

import org.springframework.core.io.ClassPathResource;


/**
 * @author NG
 *
 */
public class Main {

    /**
     * 
     */
    public Main() {}

    public static void main(String[] args){
	ClassPathResource res = new ClassPathResource("/v1.1");

	
	try {
	    ToolsServiceManager.execute(res.getFile());
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }
    

}
