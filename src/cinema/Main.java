/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinema;
import exception1.Exc1;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class Main {
    public static void main(String[] args){
        Cinema cine = new Cinema();
        cine.listaFilmes = new ArrayList<>();
        int opcaoMenu = -1;
        
        do{
            try{
            opcaoMenu = Integer.parseInt(JOptionPane.showInputDialog("Digite sua opcao\n"
            + "(1) Cadastrar\n"
            + "(2) Exibir \n"
            + "(3) Remover \n"
            + "(4) Assistir Filme\n"
            + "(5) Editar Duracao do Filme\n"
            + "(6) Sair"));
            }
            catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "O programa fechou/ erro");
                break;
            }
            switch(opcaoMenu){
                case 1: 
                    try{
                        cine.cadastrarFilme();
                    }
                    catch (NumberFormatException e){
                        JOptionPane.showMessageDialog(null, "Vc errou ao cadastrar");
                        
                    }
                    catch(NullPointerException e){
                        JOptionPane.showMessageDialog(null, "Cadastro Incompleto");
                    }
                    break;
                    
                case 2:
                    cine.mostrarFilmes();
                    break;
                case 3:
                    cine.remover();
                    break;
                case 4: 
                    try{
                        cine.assistirFilme();
                    }
                    catch(Exc1 e){
                       e.getMessage();
                    }
                    catch(IndexOutOfBoundsException ex){
                        JOptionPane.showMessageDialog(null, "erro");
                    }
                    catch(NullPointerException ex){
                        JOptionPane.showMessageDialog(null, "erro");
                    }
                    break;
                case 5:
                    cine.Transformar();
                break;
                
                case 6: 
                break;
                
                default: 
                    JOptionPane.showMessageDialog(null, "Não existe a opção que você digitou");
            }
            
            
        } while(opcaoMenu != 6);
    }
    
}
