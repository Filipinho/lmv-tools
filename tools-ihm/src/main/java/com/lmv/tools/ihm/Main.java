package com.lmv.tools.ihm;

import org.springframework.core.io.FileSystemResource;

import com.lmv.tools.service.ToolsServiceManager;

/**
 * Hello world!
 *
 */
public class Main{
    
    public static void main( String[] args ){
	FileSystemResource res = new FileSystemResource("lib/v1.1/");

	    ToolsServiceManager.execute(res.getFile());

    }
}
