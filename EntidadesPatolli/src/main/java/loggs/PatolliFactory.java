/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package loggs;

/**
 *
 * @author SDavidLedesma
 */
public class PatolliFactory {

    public static IPatolliInterface getLogger(Class c) {
        return PatolliProxy.getInstance(c);
    }
}
