/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mensajes;

import java.io.Serializable;

/**
 *
 * @author SDavidLedesma
 */
public class RegistrarMovimiento implements Serializable {
    
    private int roll;
    private int pasos;

    public RegistrarMovimiento() {
    }

    public RegistrarMovimiento(int roll, int pasos) {
        this.roll = roll;
        this.pasos = pasos;
    }
    
    

    public int getRoll() {
        return roll;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }

    public int getPasos() {
        return pasos;
    }

    public void setPasos(int pasos) {
        this.pasos = pasos;
    }
    
    
}
