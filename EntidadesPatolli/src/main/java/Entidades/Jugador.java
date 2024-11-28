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
public class Jugador {

    private String nombre;
    private Integer fondos;
    private List<Fichas> fichas;
    private Integer apuesta;

    public int tirarDados() {

        return 0;
    }

    public void apostar(Integer monto) {

    }

    public Jugador() {
    }

    public Jugador(String nombre, Integer fondos, List<Fichas> fichas, Integer apuesta) {
        this.nombre = nombre;
        this.fondos = fondos;
        this.fichas = fichas;
        this.apuesta = apuesta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getFondos() {
        return fondos;
    }

    public void setFondos(Integer fondos) {
        this.fondos = fondos;
    }

    public List<Fichas> getFichas() {
        return fichas;
    }

    public void setFichas(List<Fichas> fichas) {
        this.fichas = fichas;
    }

    public Integer getApuesta() {
        return apuesta;
    }

    public void setApuesta(Integer apuesta) {
        this.apuesta = apuesta;
    }

}
