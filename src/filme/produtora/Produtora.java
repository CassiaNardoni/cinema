package filme.produtora;

import filme.produtora.comedia.Comedia;
import filme.produtora.drama.Drama;
import filme.produtora.romance.Romance;
import filme.produtora.terror.Terror;

/**
 *
 * @author Usuario
 */
public abstract class Produtora {
    String nomeProdutora;
    String nomeAutor;
    String genero;
    Romance romance;
    Comedia comedia;
    Terror terror;
    Drama drama;
    
    public Produtora(){
    }
    
    public void setNomeProdutora(String a){
        this.nomeProdutora = a;
    }
    public String getNomeProdutora(){
        return this.nomeProdutora;
    }
    public void setNomeAutor(String b){
        this.nomeAutor = b;
    }
    public String getNomeAutor(){
        return this.nomeAutor;
    }
    
    public void setComedia(Comedia comedia){
        this.comedia = comedia;
    }
    public void assistirComedia(){  // Overload
        this.comedia.assistirComedia("rsrs");
    }
    public void setDrama(Drama drama){
        this.drama = drama;
    }
    public void assistirDrama(){
        this.drama.assistirDrama();
    }
    public void setRomance(Romance romance){
        this.romance = romance;
    }
    public void assistirRomance(){
        this.romance.assistirRomance();
    }
     public void setTerror(Terror terror){
        this.terror = terror ;
    }
    public void assistirTerror(){ // sobreescrito
        this.terror.assistirTerror();
    }
    
    public Comedia getComedia(){
        return this.comedia;
    }
    public Drama getDrama(){
        return this.drama;
    }
    public Romance getRomance(){
        return this.romance;
    }
    public Terror getTerror(){
        return this.terror;
    }
   
}
