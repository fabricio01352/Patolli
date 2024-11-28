/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package loggs;

import java.io.Serializable;
import javax.swing.JOptionPane;

/**
 *
 * @author SDavidLedesma
 */
public class PatolliProxy implements IPatolliInterface, Serializable {

    private static IPatolliInterface instance;
    private IPatolliInterface logger;
    private Class classs;

    private PatolliProxy(Class classs) {
        this.classs = classs;
        this.logger = PatolliImp.getInstance(classs);
    }

    public static IPatolliInterface getInstance(Class classs) {
        return instance != null ? instance : (instance = new PatolliProxy(classs));
    }

    @Override
    public void log(String message) {
        JOptionPane.showMessageDialog(null, message, "success", JOptionPane.DEFAULT_OPTION);
        logger.log(message);
    }

    @Override
    public void error(String message) {
        JOptionPane.showMessageDialog(null, message, "error", JOptionPane.ERROR_MESSAGE);
        logger.error(message);
    }

    @Override
    public void info(String message) {
        JOptionPane.showMessageDialog(null, message, "info", JOptionPane.INFORMATION_MESSAGE);
        logger.info(message);
    }

    @Override
    public void warning(String message) {
        JOptionPane.showMessageDialog(null, message, "warning", JOptionPane.WARNING_MESSAGE);
        logger.warning(message);
    }

}
