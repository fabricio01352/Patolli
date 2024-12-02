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
public class MensajeSala implements Serializable {

    private String codigo;
    private String mensaje;
    private Object contenido;

    public MensajeSala() {
    }

    public MensajeSala(String codigo, String mensaje, Object contenido) {
        this.codigo = codigo;
        this.mensaje = mensaje;
        this.contenido = contenido;
    }

    public MensajeSala(String mensaje, String codigo) {
        this.mensaje = mensaje;
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Object getContenido() {
        return contenido;
    }

    public void setContenido(Object contenido) {
        this.contenido = contenido;
    }

}
