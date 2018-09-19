/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filme.produtora.comedia;

import filme.produtora.Produtora;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class Comedia extends Produtora {
    @Override
    public void assistirComedia(){
        JOptionPane.showMessageDialog(null, "Rsrs");
    }
    
    public void assistirComedia(String messagem){ // Overload sobrecarga de método
        messagem = "rarara";
        JOptionPane.showMessageDialog(null, messagem);
    }
    
}
