/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filme;

import filme.produtora.Produtora;
import filme.produtora.comedia.Comedia;
import filme.produtora.drama.Drama;
import filme.produtora.romance.Romance;
import filme.produtora.terror.Terror;

/**
 *
 * @author Usuario
 */
public abstract class  Filme {
    String nomeFilme;
    double duracaoFilme;
    Produtora produtora;
    
    public void setnomeFilme(String a){
        this.nomeFilme = a;
    }
    public String getnomeFilme(){
        return this.nomeFilme;
    }
    
    public void setDuracaoFilme(double a){
        this.duracaoFilme = a;
    }
    public double getDuracaoFilme(){
        return this.duracaoFilme;
    }
    
    public void setProdutora(Produtora produt){
        this.produtora = produt;
    }
    public Produtora getProdutora(){
        return this.produtora;
    }
    public String getNomeProdutora(){
        return this.produtora.getNomeProdutora();
    }
    
    public Comedia getComediaclass(){
       return this.produtora.getComedia(); 
    }
    public Drama getDramaclass(){
       return this.produtora.getDrama(); 
    }
    public Romance getRomanceclass(){
       return this.produtora.getRomance(); 
    }
    public Terror getTerrorclass(){
       return this.produtora.getTerror(); 
    }
    public void assistirFilmeComedia(){
        this.produtora.assistirComedia();
    }
    public void assistirFilmeDrama(){
        this.produtora.assistirDrama();
    }
    public void assistirFilmeRomance(){
        this.produtora.assistirRomance();
    }
    public void assistirFilmeTerror(){
        this.produtora.assistirTerror();
    }
    
    
}
