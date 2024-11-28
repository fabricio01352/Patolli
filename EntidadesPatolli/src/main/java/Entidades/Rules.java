/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.io.Serializable;
import mensajes.ComunicacionSala;

/**
 *
 * @author SDavidLedesma
 */
public class Rules implements Serializable {

    public ComunicacionSala admin;
    public int jugadores;
    public int semillas;
    public int apuestas;

    public Rules() {
    }

    public Rules(ComunicacionSala admin, int jugadores, int semillas, int apuestas) {
        this.admin = admin;
        this.jugadores = jugadores;
        this.semillas = semillas;
        this.apuestas = apuestas;
    }

    public ComunicacionSala getAdmin() {
        return admin;
    }

    public void setAdmin(ComunicacionSala admin) {
        this.admin = admin;
    }

    public int getJugadores() {
        return jugadores;
    }

    public void setJugadores(int jugadores) {
        this.jugadores = jugadores;
    }

    public int getSemillas() {
        return semillas;
    }

    public void setSemillas(int semillas) {
        this.semillas = semillas;
    }

    public int getApuestas() {
        return apuestas;
    }

    public void setApuestas(int apuestas) {
        this.apuestas = apuestas;
    }

}
