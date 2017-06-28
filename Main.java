/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tfpra;

import java.io.IOException;
import static tfpra.ManipuladorArquivo.leAutores;
import static tfpra.ManipuladorArquivo.leitor;
//import static tfpra.Main.memoria;

/**
 *
 * @author mpgab
 */
public class Main {

    public static Memoria memoria = new Memoria();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        
        //Memoria:
        //leAutores(memoria);
        leitor(memoria);
        
        
        TelaInicial telaInicial;
        telaInicial = new TelaInicial();
        telaInicial.setVisible(true);
        
        
        
    }
    
}
