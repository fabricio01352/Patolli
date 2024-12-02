/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexion;

import java.util.ArrayList;
import java.util.List;
import mensajes.MensajeSala;
import modelo.ClienteConexion;
import negocio.Sala;

/**
 * 
 * @author SDavidLedesma
 */
public class GestionarClientes {

    private List<Cliente> clientes;
    private List<Sala> lobbys;

    public GestionarClientes() {
        this.clientes = new ArrayList<>();
        this.lobbys = new ArrayList<>();
    }

    public void agregarCliente(Cliente hiloCliente) {
        clientes.add(hiloCliente);
    }

    public void eliminarCliente(Cliente hiloCliente) {
        clientes.remove(hiloCliente);
    }

    public List<Cliente> obtenerClientes() {
        return clientes;
    }

    public void anadirSala(Sala lobby) {
        lobbys.add(lobby);
        System.out.println("Lobby agregado exitosamente");
        System.out.println(lobby);
    }

    public Sala comprobarSiLobbyExiste(String codigo) {
        for (Sala l : lobbys) {
            if (l.getCodigo().equalsIgnoreCase(codigo)) {
                return l;
            }
        }
        return null;
    }

    public boolean comprobarUsuarioEnLobby(Sala lobby, String nombre) {
        for (ClienteConexion c : lobby.getClientesEnSala()) {
            if (c.getNombre().equalsIgnoreCase(nombre)) {
                return false;
            }
        }
        return true;
    }

    public void recibirMensajeDeSala(MensajeSala mensaje) {

    }
}
