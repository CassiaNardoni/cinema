/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filme.produtora.romance;

import filme.produtora.Produtora;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class Romance extends Produtora{
    @Override
    public void assistirRomance(){
        JOptionPane.showMessageDialog(null, "Love");
    }
}
