/**
 * 
 */
package com.lmv.tools.service;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author NG
 * 
 */
public class CmdLauncher {

    private ProcessBuilder mProcessBuilder;


    /**
     * @param directory 
     * @throws IOException
     * @throws InterruptedException
     * 
     */
    public int execute(final OutputStream redirect, final File directory) throws IOException, InterruptedException {
	mProcessBuilder.directory(directory);
	Process p = mProcessBuilder.start();
	new Thread(GestionnaireDeFlux.create(GestionnaireDeFlux.TYPE_INPUT, p, redirect) ).start();
	new Thread(GestionnaireDeFlux.create(GestionnaireDeFlux.TYPE_ERROR, p, redirect)).start();
	final int exitCode = p.waitFor();
	return exitCode;
    }

    /**
     * @return the mProcessBuilder
     */
    public ProcessBuilder getProcessBuilder() {
	return mProcessBuilder;
    }

    /**
     * @param mProcessBuilder
     *            the mProcessBuilder to set
     */
    @Autowired
    public void setProcessBuilder(ProcessBuilder mProcessBuilder) {
	this.mProcessBuilder = mProcessBuilder;
    }
}
