/**
 * 
 */
package com.lmv.tools.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;

/**
 * 
 * @author NG4E
 *
 */
public class GestionnaireDeFlux implements Runnable {
    /**     */
    public static final String TYPE_INPUT = "input";
    public static final String TYPE_ERROR = "error";

    /**   */
    private final OutputStream os;
    /**   */
    private final InputStream inputStream;

    /**
     * 
     * @param type
     * @param p
     * @param redirect
     * @return
     */
    public static GestionnaireDeFlux create(final String type, final Process p, final OutputStream redirect) {
	if (TYPE_INPUT.equals(type)) {
	    return new GestionnaireDeFlux(p.getInputStream(), redirect);
	} else if (TYPE_ERROR.equals(type)) {
	    return new GestionnaireDeFlux(p.getErrorStream());
	} else {
	    throw new IllegalArgumentException(
		    String.format("the type must be one of %s or %s ",
			    TYPE_ERROR, TYPE_INPUT));
	}

    }

    /**
     * 
     */
    public GestionnaireDeFlux() {
	this(null, null);
    }

    /**
     * Construit le stream d'entree qui permet de recuperer ce que le script
     * appelle affiche a l'ecran par exemple
     * 
     * @param InputStream is
     */
    private GestionnaireDeFlux(final InputStream inputStream) {
	this(inputStream, null);
    }

    /**
     * Stream d'entree et flux de sortie permet de rediriger vers un fichier ou
     * l'ecran par exemple les retour du script appelle
     * 
     * @param InputStream
     *            is
     * @param OutputStream
     *            redirect
     */
    private GestionnaireDeFlux(final InputStream inputStream,
	    final OutputStream redirect) {
	this.os = redirect;
	this.inputStream = inputStream;
    }

    /**
     * thread
     */
    public void run() {
	try {
	    PrintWriter pw = null;
	    InputStreamReader isr = new InputStreamReader(inputStream);
	    BufferedReader br = new BufferedReader(isr);
	    String line = null;

	    // TODO handle else
	    if (os != null) {
		pw = new PrintWriter(os);
	    }

	    while ((line = br.readLine()) != null) {

		if (pw != null) {
		    pw.println(line);
		}
		// System.out.println(line);
	    }

	    // TODO handle else
	    if (pw != null) {
		pw.flush();
	    }
	} catch (IOException ioe) {
	    // TODO handle exception
	    ioe.printStackTrace();
	}
    }
}
