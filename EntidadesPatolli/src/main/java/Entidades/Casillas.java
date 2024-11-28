/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.util.List;

/**
 *
 * @author SDavidLedesma
 */
public abstract class Casillas {

    private int numero;
    private List<Fichas> fichasEnCasilla;
    private String tipoCasilla;

    public void fichaCae() {
    }

    public abstract void Mov(Fichas ficha);
}
