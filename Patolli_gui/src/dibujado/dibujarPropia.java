package dibujado;

import entidades.Casilla;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 * 
 * @author SDavidLedesma
 */
public class dibujarPropia implements IDibujar {

    @Override
    public void dibujar(Graphics2D g2d, Casilla casilla, int numCasillasAspa, int TAMANIOCASILLA) {
        if (casilla.getTipoCasilla().equalsIgnoreCase("propia")) {
            Rectangle rect = new Rectangle();
            g2d.setColor(Color.GREEN);
            rect.setBounds(casilla.getCoordenadaX(), casilla.getCoordenadaY(), TAMANIOCASILLA, TAMANIOCASILLA);
            g2d.fill(rect);
            g2d.draw(rect);
            g2d.setColor(Color.BLACK);
            rect.setBounds(casilla.getCoordenadaX(), casilla.getCoordenadaY(), TAMANIOCASILLA, TAMANIOCASILLA);
            g2d.draw(rect);
        }
    }

}
