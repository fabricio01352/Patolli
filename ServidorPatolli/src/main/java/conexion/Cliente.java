/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexion;

import Entidades.Rules;
import mensajes.Mensaje;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import mensajes.ComunicacionSala;
import mensajes.MensajeSala;
import modelo.ClienteConexion;

/**
 *
 * @author SDavidLedesma
 */
public class Cliente implements Runnable {

    Socket clienteSocket;
    private ObjectInputStream in;
    private ObjectOutputStream out;
    private Servidor protocolo;
    private GestionarClientes clientes;

    public Cliente(Socket clienteSocket, GestionarClientes clientes) {
        this.clientes = clientes;
        this.protocolo = new Servidor(clientes);
        try {
            this.clienteSocket = clienteSocket;
            out = new ObjectOutputStream(clienteSocket.getOutputStream());
            in = new ObjectInputStream(clienteSocket.getInputStream());
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void run() {
        try {
            while (true) {
                Mensaje mensajeRecibido = (Mensaje) in.readObject();
                if (mensajeRecibido.getTipo().equals("CrearLobby")) {

                    Rules condiciones = (Rules) mensajeRecibido.getContenido();
                    String codigo = protocolo.crearSala(condiciones);
                    out.writeObject(new Mensaje("Codigo", codigo));
                    out.flush();

                    String nombre = condiciones.getAdmin().getNombre();
                    ComunicacionSala solicitud = new ComunicacionSala(nombre, codigo);
                    ClienteConexion clienteConectado = new ClienteConexion(out, in, nombre);
                    protocolo.unirClienteASala(solicitud, clienteConectado);

                } else if (mensajeRecibido.getTipo().equalsIgnoreCase("UnirseALobby")) {
                    ComunicacionSala solicitud = (ComunicacionSala) mensajeRecibido.getContenido();
                    ClienteConexion cliente = new ClienteConexion(out, in, solicitud.getNombre());
                    protocolo.unirClienteASala(solicitud, cliente);
                } else if (mensajeRecibido.getTipo().equalsIgnoreCase("MensajeALobby")) {
                    MensajeSala mensaje = (MensajeSala) mensajeRecibido.getContenido();
                    protocolo.manejarMensajesALobby(mensaje);

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Socket getClienteSocket() {
        return clienteSocket;
    }

    public void mandarMensajeAlCliente(Mensaje mensaje) {
        try {
            out.writeObject(mensaje);
            out.flush();
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
