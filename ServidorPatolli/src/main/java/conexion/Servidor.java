/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexion;

import Entidades.Rules;
import java.io.IOException;
import java.util.Random;
import mensajes.ComunicacionSala;
import mensajes.Mensaje;
import mensajes.MensajeSala;
import mensajes.RegistrarMovimiento;
import modelo.ClienteConexion;
import negocio.Sala;

/**
 *
 * @author SDavidLedesma
 */
public class Servidor {

    private GestionarClientes manejadorClientes;

    public Servidor(GestionarClientes manejadorClientes) {
        this.manejadorClientes = manejadorClientes;
    }

    public void unirClienteASala(ComunicacionSala solicitud, ClienteConexion cliente) throws IOException {
        Sala lobby = (Sala) manejadorClientes.comprobarSiLobbyExiste(solicitud.getCodigo());
        if (lobby != null) {
            if (lobby.salaLlena()) {
                if (manejadorClientes.comprobarUsuarioEnLobby(lobby, solicitud.getNombre())) {
                    cliente.getOut().writeObject(new Mensaje("UsuarioValido", null));
                    cliente.getOut().flush();
                    lobby.informarDeNuevoUsuario(solicitud.getNombre());
                    lobby.anadirJugadorASala(cliente);
                    cliente.getOut().writeObject(new Mensaje("Codigo", solicitud.getCodigo()));
                    cliente.getOut().flush();

                    cliente.getOut().writeObject(new Mensaje("UsuariosConectados", lobby.obtenerNombresDeUsuarios()));
                    cliente.getOut().flush();

                } else {
                    cliente.getOut().writeObject(new Mensaje("UsuarioInvalido", "Ese usuario ya existe"));
                    cliente.getOut().flush();
                }
            } else {
                cliente.getOut().writeObject(new Mensaje("LobbyLleno", "Este lobby ya esta lleno"));
                cliente.getOut().flush();
            }
        } else {
            cliente.getOut().writeObject(new Mensaje("LobbyInexistente", "No existe ese lobby"));
            cliente.getOut().flush();
        }
    }

    public String crearSala(Rules condiciones) {
        String codigo = generarCodigo();
        Sala lobby = new Sala(codigo);
        lobby.setCondiciones(condiciones);
        manejadorClientes.anadirSala(lobby);
        System.out.println(codigo);
        return codigo;
    }

    public String generarCodigo() {
        Random random = new Random();
        StringBuilder codigo = new StringBuilder(4);

        for (int i = 0; i < 4; i++) {
            char letra = (char) (random.nextInt(26) + 'A');
            codigo.append(letra);
        }

        return codigo.toString();
    }

    public void manejarMensajesALobby(MensajeSala mensaje) throws IOException {
        String codigo = mensaje.getCodigo();
        Sala lobby = (Sala) manejadorClientes.comprobarSiLobbyExiste(codigo);
        if (mensaje.getMensaje().equalsIgnoreCase("UsuarioListo")) {
            if (lobby.usuarioListo()) {
                lobby.informarATodosLosJugadoresEnSala(new Mensaje("PartidaIniciada", null));
                for (int i = 0; i < lobby.getClientesEnSala().size(); i++) {
                    lobby.getClientesEnSala().get(i).getOut().writeObject(new Mensaje("TuNumeroDeJugador", i));
                    lobby.getClientesEnSala().get(i).getOut().flush();
                }
            }
        } else if (mensaje.getMensaje().equalsIgnoreCase("Tirar")) {
            RegistrarMovimiento movimiento = (RegistrarMovimiento) mensaje.getContenido();
            for (int i = 0; i < lobby.getClientesEnSala().size(); i++) {
                if (i == movimiento.getRoll()) {
                    continue;
                } else {
                    lobby.getClientesEnSala().get(i).getOut().writeObject(new Mensaje("TiroJugador", movimiento));
                    lobby.getClientesEnSala().get(i).getOut().flush();
                }
            }
            lobby.cambiarTurno();
            lobby.getClientesEnSala().get(lobby.getUsuarioEnTurno()).getOut().writeObject(new Mensaje("Tu turno", null));
            lobby.getClientesEnSala().get(lobby.getUsuarioEnTurno()).getOut().flush();

        }
    }
}
