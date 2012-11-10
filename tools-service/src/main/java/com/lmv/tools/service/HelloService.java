/**
 * 
 */
package com.lmv.tools.service;

import org.springframework.stereotype.Component;

/**
 * @author NG
 *
 */
@Component
public class HelloService {

	private String mName = "default Name";
	
	/**
	 * 
	 */
	public void printService() {
		System.out.println("Hello Service with Name: " + mName );
	}

	public String getName() {
		return mName;
	}

	public void setName(String mName) {
		this.mName = mName;
	}

}
