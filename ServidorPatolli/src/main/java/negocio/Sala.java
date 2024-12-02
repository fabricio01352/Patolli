/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import Entidades.Rules;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import mensajes.Mensaje;
import modelo.ClienteConexion;

/**
 * 
 * @author SDavidLedesma
 */
public class Sala {

    private String codigo;
    private List<ClienteConexion> clientesEnLobby;
    private Rules condiciones;
    private int usuariosListos;
    private int usuarioEnTurno;

    public Sala(String codigo) {
        this.codigo = codigo;
        this.clientesEnLobby = new ArrayList<>();
        usuarioEnTurno = 0;
    }

    public void anadirJugadorASala(ClienteConexion cliente) {
        clientesEnLobby.add(cliente);
    }

    public void cambiarTurno() {
        usuarioEnTurno++;
        if (usuarioEnTurno == clientesEnLobby.size()) {
            usuarioEnTurno = 0;
        }
    }

    public boolean comprobarJugadorConMismoNombre(String nombre) {
        ClienteConexion cli = clientesEnLobby.stream().filter(c -> c.getNombre().equalsIgnoreCase(nombre)).findFirst().orElse(null);
        return cli != null;
    }

    public List<String> obtenerNombresDeUsuarios() {
        return clientesEnLobby.stream()
                .map(ClienteConexion::getNombre)
                .collect(Collectors.toList());
    }

    public void informarDeNuevoUsuario(String nombre) throws IOException {
        for (ClienteConexion c : clientesEnLobby) {
            c.getOut().writeObject(new Mensaje("UsuarioNuevo", nombre));
            c.getOut().flush();
        }
    }

    public boolean salaLlena() {
        if (clientesEnLobby.size() == condiciones.getJugadores()) {
            return false;
        } else {
            return true;
        }
    }

    public boolean usuarioListo() {
        usuariosListos++;
        if (usuariosListos == clientesEnLobby.size()) {
            return true;
        } else {
            return false;
        }
    }

    public void informarATodosLosJugadoresEnSala(Mensaje mensaje) throws IOException {
        for (ClienteConexion c : clientesEnLobby) {
            c.getOut().writeObject(mensaje);
        }
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public List<ClienteConexion> getClientesEnSala() {
        return clientesEnLobby;
    }

    public void setClientesEnSala(List<ClienteConexion> clientesEnLobby) {
        this.clientesEnLobby = clientesEnLobby;
    }

    public Rules getCondiciones() {
        return condiciones;
    }

    public void setCondiciones(Rules condiciones) {
        this.condiciones = condiciones;
    }

    public int getUsuarioEnTurno() {
        return usuarioEnTurno;
    }

    @Override
    public String toString() {
        return "Lobby{" + "codigo=" + codigo + ", clientesEnLobby=" + clientesEnLobby + ", condiciones=" + condiciones + '}';
    }

}
