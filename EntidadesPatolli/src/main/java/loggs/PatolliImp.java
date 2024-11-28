/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package loggs;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SDavidLedesma
 */
public class PatolliImp implements IPatolliInterface, Serializable {

    private static IPatolliInterface instance;
    private Class classs;
    private Logger logger;

    private PatolliImp(Class classs) {
        this.classs = classs;
        this.logger = Logger.getLogger(classs.getName());
    }

    public static IPatolliInterface getInstance(Class classs) {
        return instance != null ? instance : (instance = new PatolliImp(classs));
    }

    @Override
    public void log(String message) {
        System.out.println(String.format("%s : %s", classs.getName(), message));
        logger.log(Level.FINE, message);
    }

    @Override
    public void error(String message) {
        System.err.print(String.format("%s : %s", classs.getName(), message));
        logger.log(Level.SEVERE, message);
    }

    @Override
    public void info(String message) {
        System.out.println(String.format("%s : %s", classs.getName(), message));
        logger.log(Level.INFO, message);
    }

    @Override
    public void warning(String message) {
        System.err.print(String.format("%s : %s", classs.getName(), message));
        logger.log(Level.WARNING, message);
    }

}
