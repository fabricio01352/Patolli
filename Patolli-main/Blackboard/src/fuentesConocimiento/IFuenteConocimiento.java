/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuentesConocimiento;

import elementos.blackboard;
import entidades.Juego;

/**
 * 
 * @author SDavidLedesma
 */
public interface IFuenteConocimiento {
    
    public blackboard blackboard = new blackboard();
    
    public void updateBlackboard(String command, Object obj);
    
}
