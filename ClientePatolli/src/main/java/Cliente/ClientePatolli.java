/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package Cliente;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Observable;
import mensajes.Mensaje;

/**
 *
 * @author SDavidLedesma
 */
public class ClientePatolli extends Observable implements Runnable {

    private String nombre;
    private boolean usuario = true;
    final String host = "localhost";
    private int puerto = 8080;
    ObjectOutputStream out;
    ObjectInputStream in;
    private Socket socket;

    public void conectar() {
        try {
            out = new ObjectOutputStream(socket.getOutputStream());
            in = new ObjectInputStream(socket.getInputStream());
            socket = new Socket(host, puerto);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            while (true) {
                notificarALaInterfaz((Mensaje) in.readObject());

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void notificarALaInterfaz(Mensaje mensaje) throws Exception {
        this.setChanged();
        this.notifyObservers(mensaje);
        this.clearChanged();
    }

}
