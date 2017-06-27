/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tfpra;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 *
 * @author mpgab
 */
public class ManipuladorArquivo {
    
    
    
    public static void escritor(Memoria mem) throws IOException {
        int i;

        //Autores:
        BufferedWriter writeAutores = new BufferedWriter(new FileWriter("Autores.txt"));
        for(i=0;i<mem.getAutores().size();i++){
            writeAutores.write(mem.getAutores().get(i).getId() + " " + mem.getAutores().get(i).getNome() + " " + mem.getAutores().get(i).getNacionalidade());
            writeAutores.newLine();
        }
        writeAutores.close();
        
        //Leitores
        BufferedWriter writeLeitores = new BufferedWriter(new FileWriter("Leitores.txt"));
        for(i=0;i<mem.getAutores().size();i++){
            writeLeitores.write(mem.getLeitores().get(i).getId() + " " + mem.getLeitores().get(i).getNome() + " " +
                    mem.getLeitores().get(i).getCpf() + " " + mem.getLeitores().get(i).getEmail());
            writeLeitores.newLine();
        }
        writeLeitores.close();
        
        //Livros
        BufferedWriter writeLivros = new BufferedWriter(new FileWriter("Livros.txt"));
        for(i=0;i<mem.getAutores().size();i++){
            writeLivros.write(mem.getLivros().get(i).getId() + " " + mem.getLivros().get(i).getNome() + " " +
                    mem.getLivros().get(i).getEditora() + " " + mem.getLivros().get(i).getEdicao() + " " + mem.getLivros().get(i).getAno() + 
                    " " + mem.getLivros().get(i).getIdautor());
            writeLivros.newLine();
        }
        writeLivros.close();
        
    }
    
    
}
