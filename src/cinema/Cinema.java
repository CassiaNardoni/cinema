
package cinema;
import exception1.Exc1;
import filme.Filme;
import javax.swing.JOptionPane;
import filme.FilmeConcreto;
import filme.produtora.ProdutoraConcreta;
import filme.produtora.comedia.Comedia;
import filme.produtora.drama.Drama;
import filme.produtora.romance.Romance;
import filme.produtora.terror.Terror;
import java.util.ArrayList;
/**
 *
 * @author Usuario
 */
public class Cinema implements ITransformar{
    ArrayList<Filme> listaFilmes; //polimorfismo e genérica
                                  // várias classes diferentes e juntando em uma só
    public void cadastrarFilme(){
        FilmeConcreto novoFilme = new FilmeConcreto();
        ProdutoraConcreta novaProdutora = new ProdutoraConcreta();
        
        String nomeFilme = JOptionPane.showInputDialog("Digite o nome do Filme");
        novoFilme.setnomeFilme(nomeFilme);
        double duracaoFilme = Double.parseDouble(JOptionPane.showInputDialog("Digite a duracao do filme"));
        novoFilme.setDuracaoFilme(duracaoFilme);
        
        String nomeProdutora = JOptionPane.showInputDialog("Digite o nome da produtora");
        novaProdutora.setNomeProdutora(nomeProdutora);
        String nomeAutor = JOptionPane.showInputDialog("Digite o nome do autor");
        novaProdutora.setNomeAutor(nomeAutor);
        
        Comedia generoComedia;
        Drama generoDrama;
        Romance generoRomance;
        Terror generoTerror;
        
        int opcao = Integer.parseInt(JOptionPane.showInputDialog("Qual o genero do Filme\n"
                                                + "\t *1* (Comedia) \n"
                                                 + "\t *2* (Terror) \n"
                                                   + "\t *3* (Romance) \n "
                                                     + "\t *4* (Drama) \n"));
        
        if(opcao == 1){
            generoComedia = new Comedia();
            novaProdutora.setComedia(generoComedia);
        }
        if(opcao == 2){
            generoTerror = new Terror();
            novaProdutora.setTerror(generoTerror);
        }
        if(opcao == 3){
           generoRomance = new Romance();
           novaProdutora.setRomance(generoRomance);
        }
        if(opcao == 4){
           generoDrama = new Drama();
           novaProdutora.setDrama(generoDrama);
        }
        
        novoFilme.setProdutora(novaProdutora);
        listaFilmes.add(novoFilme);
    }
    
    public void mostrarFilmes(){
        String mensagem = "Filmes: \n";
        for(Filme f : listaFilmes){
            mensagem+= f.getnomeFilme() + " - " + f.getNomeProdutora() + "\n";    
        }
        
        JOptionPane.showMessageDialog(null, mensagem);
        
    }
    public void remover(){
        String nome = JOptionPane.showInputDialog("Insira o nome do filme que deseja excluir: ");
        boolean removido = false;
        for(int i=0; i<listaFilmes.size(); i++){
            Filme f = listaFilmes.get(i);
            if(f.getnomeFilme().equals(nome)){
                listaFilmes.remove(i);
                removido = true;
            }
        }
        if(removido){
            JOptionPane.showMessageDialog(null, " Filme encontrado e excluído");
            
        }
        
        else{
            JOptionPane.showMessageDialog(null, "Filme não encontrado");
        }
    }
    
    public void assistirFilme() throws Exc1 {
        int opcaoFilme = -1;
        int i = 0;
        
        while(opcaoFilme != 0){
          opcaoFilme = Integer.parseInt(JOptionPane.showInputDialog("O filme atual é: " 
          + "\n" + this.listaFilmes.get(i).getnomeFilme() + " - " + this.listaFilmes.get(i).getNomeProdutora()
          + "\n "
          + "\n #1# - Assistir próximo filme"
          + "\n #2# - Assistir filme anterior"
          + "\n #3# - Assistir"
          + "\n #0# - sair"));
          
          if(opcaoFilme == 1){
              if(i>this.listaFilmes.size()){
                  throw new Exc1("Fim da lista de filmes");
              }
              else{
                i++;
              }
          } 
          if(opcaoFilme == 2){
              if(i<this.listaFilmes.size()){
                  throw new Exc1("Não tem anterior");
              }
              else{
                i--;
              }
          }
            if(opcaoFilme == 3){
                if(this.listaFilmes.get(i).getComediaclass()!=null){
                    this.listaFilmes.get(i).assistirFilmeComedia();
                }
                else {
                    if(this.listaFilmes.get(i).getDramaclass()!=null){
                        this.listaFilmes.get(i).assistirFilmeDrama();
              
                    }
                    else{
                        if(this.listaFilmes.get(i).getRomanceclass()!=null){
                            this.listaFilmes.get(i).assistirFilmeRomance();
                        }
                        else {
                                this.listaFilmes.get(i).assistirFilmeTerror();  
                            
                        }
                    }
                }
            }
        }
    }
    @Override
    public void Transformar(){
        String nome = JOptionPane.showInputDialog("Digite o nome da musica que quer Editar");
        
        for(int i=0; i<this.listaFilmes.size(); i++){
            Filme f = listaFilmes.get(i);
            if(f.getnomeFilme().equals(nome)){
                double duracaoFilme = f.getDuracaoFilme();
                double temporemovido = Double.parseDouble(JOptionPane.showInputDialog(" Filme que sera modificado. \n Digite o tempo que quer remover do filme: "
                                                                                        + "\n\n Musica: " + f.getnomeFilme() + "\n" 
                                                                                        + "\n Minutos: " + f.getDuracaoFilme()));
                if(temporemovido<=duracaoFilme){
                    double edicao = duracaoFilme - temporemovido;
                    f.setDuracaoFilme(edicao);
                    JOptionPane.showMessageDialog(null, "edicao bem sucedida! \n Tempo total pos edicao: " + f.getDuracaoFilme());
                    
                }
            }
        }
    }
}
