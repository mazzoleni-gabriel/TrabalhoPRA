/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tfpra;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
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
        for (i = 0; i < mem.getAutores().size(); i++) {
            writeAutores.write(mem.getAutores().get(i).getId() + ";" + mem.getAutores().get(i).getNome() + ";" + mem.getAutores().get(i).getNacionalidade()+ ";");
            writeAutores.newLine();
        }
        writeAutores.close();

        //Leitores
        BufferedWriter writeLeitores = new BufferedWriter(new FileWriter("Leitores.txt"));
        for (i = 0; i < mem.getLeitores().size(); i++) {
            writeLeitores.write(mem.getLeitores().get(i).getId() + ";" + mem.getLeitores().get(i).getNome() + ";"
                    + mem.getLeitores().get(i).getCpf() + ";" + mem.getLeitores().get(i).getEmail()+ ";");
            writeLeitores.newLine();
        }
        writeLeitores.close();

        //Livros
        BufferedWriter writeLivros = new BufferedWriter(new FileWriter("Livros.txt"));
        for (i = 0; i < mem.getLivros().size(); i++) {
            writeLivros.write(mem.getLivros().get(i).getId() + ";" + mem.getLivros().get(i).getNome() + ";"
                    + mem.getLivros().get(i).getEditora() + ";" + mem.getLivros().get(i).getEdicao() + ";" + mem.getLivros().get(i).getAno()+ ";"
            );
            writeLivros.newLine();
        }
        writeLivros.close();

        //
        BufferedWriter writeAutoresDosLivros = new BufferedWriter(new FileWriter("Autores dos livros.txt"));
        for (i = 0; i < mem.getAutoresdoslivros().size(); i++) {
            writeAutoresDosLivros.write(mem.getAutoresdoslivros().get(i).getIdlivro() + ";" + mem.getAutoresdoslivros().get(i).getIdautor()+ ";");
            writeAutoresDosLivros.newLine();
        }
        writeAutoresDosLivros.close();

    }

    public static void escritorBinario(Memoria mem) {
        escritorBinarioAutores(mem);
        escritorBinarioLivros(mem);
        escritorBinarioLeitores(mem);
        escritorBinarioAutoresDosLivros(mem);

    }

    public static void escritorBinarioAutores(Memoria mem) {
        int i;
        File binaryFile = new File("Autores.dat");
        try {
            FileOutputStream fos = new FileOutputStream(binaryFile);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            // escreve todos os produtos do registro no arquivo
            /*for (i=0;i<mem.getAutores().size();i++){                
                oos.writeObject(mem.getAutores().get(i));
            }*/
            oos.writeObject(mem.getAutores());
            
            // fecha o arquivo
            oos.flush();
            oos.close();
            fos.flush();
            fos.close();            
        }
        catch(IOException e)
        {
            System.err.println(e.getMessage());
        }
   
    }
    
    public static void escritorBinarioLeitores(Memoria mem){
        int i;
        File binaryFile = new File ("Leitores.dat");
        try{            
            FileOutputStream fos = new FileOutputStream(binaryFile);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            // escreve todos os produtos do registro no arquivo
            for (i=0;i<mem.getLeitores().size();i++){                
                oos.writeObject(mem.getLeitores().get(i));
            }
            // fecha o arquivo
            oos.flush();
            oos.close();
            fos.flush();
            fos.close();            
        }
        catch(IOException e)
        {
            System.err.println(e.getMessage());
        }
   
    }
        
    public static void escritorBinarioLivros(Memoria mem){
        int i;
        File binaryFile = new File ("Livros.dat");
        try{            
            FileOutputStream fos = new FileOutputStream(binaryFile);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            // escreve todos os produtos do registro no arquivo
            for (i=0;i<mem.getLivros().size();i++){                
                oos.writeObject(mem.getLivros().get(i));
            }
            // fecha o arquivo
            oos.flush();
            oos.close();
            fos.flush();
            fos.close();            
        }
        catch(IOException e)
        {
            System.err.println(e.getMessage());
        }
   
    }  
    
    public static void escritorBinarioAutoresDosLivros(Memoria mem){
        int i;
        File binaryFile = new File ("Autores dos livros.dat");
        try{            
            FileOutputStream fos = new FileOutputStream("Autores dos livros.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            // escreve todos os produtos do registro no arquivo
            for (i=0;i<mem.getAutoresdoslivros().size();i++){                
                oos.writeObject(mem.getAutoresdoslivros().get(i));
            }
            
            // fecha o arquivo
            oos.flush();
            oos.close();
            fos.flush();
            fos.close();            
        }
        catch(IOException e)
        {
            System.err.println(e.getMessage());
        }
   
    }
    
    static void leAutores(Memoria mem){
        try{ ;
            //File fileDestiny = new File(destino);
            FileInputStream i = new FileInputStream("Autores.dat");
            ObjectInputStream ois = new ObjectInputStream(i);
            
            ArrayList<Autor> autores = new  ArrayList();
            autores = (ArrayList<Autor>) ois.readObject();
            int j;
            for(j=0;j<autores.size();j++){
                mem.getAutores().add(autores.get(j));
            }
            /*if(ois.available() !=0){
                Autor autor = (Autor) ois.readObject();
                System.out.println(autor.id);
                mem.getAutores().add(autor);
            }else{
                System.out.println(ois.available());
            }*/
            
            
            /*while((autor = (Autor)ois.readObject()) != null){
                mem.getAutores().add(autor);
                Autor.setCont(autor.getCont());
            }*/

            ois.close();
            i.close();

        } catch (Exception e) {
            System.out.println("Erro = " + e);
        }
    }
    
    public static void leitor(Memoria mem) throws FileNotFoundException, IOException{
        BufferedReader buffRead = new BufferedReader(new FileReader("Autores.txt"));
        String linha, aux="", nome="", nac="";
        int i, cont, id=0;
        while( (linha = buffRead.readLine()) != null){
            System.out.println(linha);
            
            cont=0;
            for(i=0;i<(linha.length()-1);i++){
                if(linha.charAt(i) != ';'){
                    aux = aux+linha.charAt(i);
                }
                if(linha.charAt(i+1) == ';'){
                    if(cont == 0){
                        id = Integer.parseInt(aux);
                    }
                    if(cont == 1){
                        nome = aux;
                    }
                    if(cont == 2){
                        nac = aux;
                    }
                    cont++;
                    aux="";
                }
                
            }
            mem.getAutores().add(new Autor(id,nome,nac));
        }
        buffRead.close();
        
        
        BufferedReader buffRead2 = new BufferedReader(new FileReader("Leitores.txt"));
        String email="";
        int cpf=0;
        cont=0;
        while( (linha = buffRead2.readLine()) != null){
            System.out.println(linha);
            
            cont=0;
            for(i=0;i<(linha.length()-1);i++){
                if(linha.charAt(i) != ';'){
                    aux = aux+linha.charAt(i);
                }
                if(linha.charAt(i+1) == ';'){
                    if(cont == 0){
                        id = Integer.parseInt(aux);
                    }
                    if(cont == 1){
                        nome = aux;
                    }
                    if(cont == 2){
                        cpf = Integer.parseInt(aux);
                    }
                    if(cont == 3){
                        email = aux;
                    }
                    cont++;
                    aux="";
                }
                
            }
            mem.getLeitores().add(new Leitor(id,nome,cpf,email));
        }
        buffRead2.close();
        
        
        BufferedReader buffRead3 = new BufferedReader(new FileReader("Livros.txt"));
        String editora="";
        int edicao=0, ano=0, idautor=0;
        
        cont=0;
        while( (linha = buffRead3.readLine()) != null){
            System.out.println(linha);
            cont=0;
            for(i=0;i<(linha.length()-1);i++){
                if(linha.charAt(i) != ';'){
                    aux = aux+linha.charAt(i);
                }
                if(linha.charAt(i+1) == ';'){
                    if(cont == 0){
                        id = Integer.parseInt(aux);
                    }
                    if(cont == 1){
                        nome = aux;
                    }
                    if(cont == 2){
                        editora = aux;
                    }
                    if(cont == 3){
                        edicao = Integer.parseInt(aux);
                    }
                    if(cont == 4){
                        ano = Integer.parseInt(aux);
                    }
                    cont++;
                    aux="";
                }
                
            }
            mem.getLivros().add(new Livro(id,nome,editora,edicao,ano,0));
        }
        buffRead3.close();
        
        
        BufferedReader buffRead4 = new BufferedReader(new FileReader("Autores dos livros.txt"));

        int id2=0;
        cont=0;
        while( (linha = buffRead4.readLine()) != null){
            System.out.println(linha);
            cont=0;
            for(i=0;i<(linha.length()-1);i++){
                if(linha.charAt(i) != ';'){
                    aux = aux+linha.charAt(i);
                }
                if(linha.charAt(i+1) == ';'){
                    if(cont == 0){
                        id = Integer.parseInt(aux);
                    }
                    if(cont == 1){
                        id2 = Integer.parseInt(aux);
                    }
                    cont++;
                    aux="";
                }
                
            }
            mem.getAutoresdoslivros().add(new AutorDoLivro(id,id2));
        }
        buffRead4.close();
        
        
    }

}
