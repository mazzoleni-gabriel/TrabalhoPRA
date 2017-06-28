/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tfpra;

import java.util.ArrayList;

/**
 *
 * @author mpgab
 */
public class Memoria {

    /**
     *
     */
    public static ArrayList<Autor> autores = new  ArrayList();
    public static ArrayList<Leitor> leitores = new ArrayList();
    public static ArrayList<Livro> livros = new ArrayList();
    public static ArrayList<AutorDoLivro> autoresdoslivros = new ArrayList();

    //Métodos de autores
    public ArrayList<Autor> getAutores() {
        return autores;
    }

    public void setAutores(ArrayList<Autor> autores) {
        this.autores = autores;
    }
    
    public boolean addAutor(String nome, String nac){
        int i;
        for(i=0 ; i<autores.size() ; i++){
            if(nome.equals(autores.get(i).getNome())){
                return false;
            }
        }
        Autor autor = new Autor(nome,nac);
        autores.add(autor);
        return true;
    }
    
    public boolean exlAutor(String nome){
        int i;
        for(i=0 ; i<autores.size() ; i++){
            if(nome.equals(autores.get(i).getNome())){
                autores.remove(i);
                return true;
            }
        }
        return false;
    }
    
    public int editaAutorNome(String nome, String nome2){
        int i,j, indice = -1;
        for(i=0 ; i<autores.size() ; i++){
            if(nome.equals(autores.get(i).getNome())){
                indice = i;
            }
        }
        if(indice != -1){
            for(j=0 ; j<autores.size() ; j++){
                if(nome2.equals(autores.get(j).getNome())){
                    return 1; //erro: nome2 já existente
                }          
            }
        }
            
            
        if(indice != -1){
            autores.get(indice).setNome(nome2);
            return 0; //OK
        }
        
        
        
        return 2; // erro: nome1 não encontrado
    }
    
    public boolean editaAutorNac(String nome, String nac){
        int i;
        for(i=0 ; i<autores.size() ; i++){
            if(nome.equals(autores.get(i).getNome())){
                autores.get(i).setNacionalidade(nac);
                return true;
            }
        }
        return false;
    }
    
    public void printaAutores(){
        int i;
        System.out.println("Autores: \n");
        for(i=0 ; i<autores.size() ; i++){
            System.out.println(autores.get(i).getId() + " " + autores.get(i).getNome() + " " + autores.get(i).getNacionalidade() + "\n");
        }
    }
    
    //Métodos de Leitores

    public ArrayList<Leitor> getLeitores() {
        return leitores;
    }

    public static void setLeitores(ArrayList<Leitor> leitores) {
        Memoria.leitores = leitores;
    }
    
    public boolean addLeitor(String nome, int cpf, String email){
        int i;
        for(i=0 ; i<leitores.size() ; i++){
            if(leitores.get(i).getCpf() == cpf){
                return false;
            }
        }
        Leitor leitor = new Leitor(nome,cpf,email);
        leitores.add(leitor);
        return true;
    }
    
    public boolean exlLeitor(int cpf){
        int i;
        for(i=0 ; i<leitores.size() ; i++){
            if(leitores.get(i).getCpf() == cpf){
                leitores.remove(i);
                return true;
            }
        }
        return false;
    }
    
    public boolean editaLeitorNome(int cpf, String nome){
        int i;
        for(i=0 ; i<leitores.size() ; i++){
            if(leitores.get(i).getCpf() == cpf){
                leitores.get(i).setNome(nome);
                return true;
            }
        }
        return false;
    }
    
    public int editaLeitorCpf(int cpf, int cpf2){
        int i;
        int indice = -1;
        for(i=0 ; i<leitores.size() ; i++){
            if(leitores.get(i).getCpf() == cpf){
                indice = i;
            }
        }
        if(indice != -1){
            for(i=0;i<leitores.size();i++){
                if(leitores.get(i).getCpf() == cpf2){
                    return 1; // cpf 2 já cadastrado
                }
            }
            leitores.get(indice).setCpf(cpf2);
            return 0; //ok
        }else{
            return 2;// cpf 1 não cadastrado
        }
    }
    
    public boolean editaLeitorEmail(int cpf, String email){
        int i;
        for(i=0 ; i<leitores.size() ; i++){
            if(leitores.get(i).getCpf() == cpf){
                leitores.get(i).setEmail(email);
                return true;
            }
        }
        return false;
    }
    
    public void printaLeitores(){
        int i;
        System.out.println("Leitores: \n");
        for(i=0 ; i<leitores.size() ; i++){
            System.out.println(leitores.get(i).getId() + " " + leitores.get(i).getNome() + " " + leitores.get(i).getCpf() + " " + leitores.get(i).getEmail() + "\n");
        }
    }
    
    //Livros

    public ArrayList<Livro> getLivros() {
        return livros;
    }

    public static void setLivros(ArrayList<Livro> livros) {
        Memoria.livros = livros;
    }
    
    public void printaLivros(){
        int i;
        System.out.println("Livros: \n");
        for(i=0; i < livros.size(); i++){
            System.out.println(livros.get(i).getId() + " " + livros.get(i).getNome() + " " + livros.get(i).getEditora()
            + " " + livros.get(i).getEdicao() + " " + livros.get(i).getAno() + "\n");
        }
    }
    
    public int addLivro(String nome, String editora, int edicao, int ano, int idautor){
        int i, autor = 0;
        for(i=0 ; i<livros.size() ; i++){
            if( nome.equals(livros.get(i).getNome()) && (edicao == livros.get(i).getEdicao()) ){
                return 2; //Livro já cadastrado
            }
        }
               
        Livro livro = new Livro(nome,editora,edicao,ano,idautor);
        livros.add(livro);
        return 0; //ok
    }
    
    public boolean exlLivro(String nome, int edicao){
        int i;
        for(i=0 ; i<livros.size() ; i++){
            if(nome.equals(livros.get(i).getNome()) && (edicao == livros.get(i).getEdicao())){
                livros.remove(i);
                return true;
            }
        }
        return false;
    }
    
    public boolean editaLivroEditora(String nome, int edicao, String editora){
        int i;
        for(i=0 ; i<livros.size() ; i++){
            if(nome.equals(livros.get(i).getNome()) && (edicao == livros.get(i).getEdicao())){
                livros.get(i).setEditora(editora);
                return true;
            }
        }
        return false;
    }
    
    public int editaLivroEdicao(String nome, int edicao, int edicao2    ){
        int i, indice = -1;
        for(i=0 ; i<livros.size() ; i++){
            if(nome.equals(livros.get(i).getNome()) && (edicao == livros.get(i).getEdicao())){
                indice = i;
            }
        }
        if(indice != -1){
            for(i=0 ; i<livros.size() ; i++){
                if(nome.equals(livros.get(i).getNome()) && (edicao2 == livros.get(i).getEdicao())){
                    return 1; //Já existe um com a nova edição
                }
            }
            livros.get(indice).setEdicao(edicao2);
            return 0; // ok
        }else{
            return 2; // n achou o livro
        }
    }
    
    public boolean editaLivroAno(String nome, int edicao, int ano){
        int i;
        for(i=0 ; i<livros.size() ; i++){
            if(nome.equals(livros.get(i).getNome()) && (edicao == livros.get(i).getEdicao())){
                livros.get(i).setAno(ano);
                return true;
            }
        }
        return false;
    }
    
    public int editaLivroNome(String nome, int edicao, String nome2){
        int i, indice = -1;
        for(i=0 ; i<livros.size() ; i++){
            if(nome.equals(livros.get(i).getNome()) && (edicao == livros.get(i).getEdicao())){
                indice = i;
            }
        }
        if(indice != -1){
            for(i=0 ; i<livros.size() ; i++){
                if(nome2.equals(livros.get(i).getNome()) && (edicao == livros.get(i).getEdicao())){
                    return 1; //Já existe um com a nova edição
                }
            }
            livros.get(indice).setNome(nome2);
            return 0; // ok
        }else{
            return 2; // n achou o livro
        }
    }
    
    
    public int addAutorDoLivro(String nomeLivro, int idAutor){
        int i, autor = 0, add=0;
        for(i=0;i<autores.size();i++){
            if(idAutor == autores.get(i).getId()){
                autor = 1;
            }
        }
        
        if(autor == 0){
            return 1; //Autor n encontrado
        }
        
        AutorDoLivro autordolivro = new AutorDoLivro(-1,-1);
        for(i=0;i<livros.size();i++){
            if(nomeLivro.equals(livros.get(i).getNome())){
                autordolivro.setIdautor(idAutor);
                autordolivro.setIdlivro(livros.get(i).getId());
                autoresdoslivros.add(autordolivro);
                add = 1;
            }
        }
        
        if(add != 0)
            return 0; // OK
        return 2; // não encontrou o livro
    }
    
    public int editaAutorDoLivro(String nomeLivro, int idAutor){
        int i, autor = 0, edit=0;
        for(i=0;i<autores.size();i++){
            if(idAutor == autores.get(i).getId()){
                autor = 1;
            }
        }
        
        if(autor == 0){
            return 1; //Autor n encontrado
        }
        
        AutorDoLivro autordolivro = new AutorDoLivro(-1,-1);
        for(i=0;i<livros.size();i++){
            if(nomeLivro.equals(livros.get(i).getNome())){
                autoresdoslivros.get(i).setIdautor(idAutor);
                edit = 1;
            }
        }
        
        if(edit != 0)
            return 0; // OK
        return 2; // não encontrou o livro
    }
    
    public int excluiAutorDoLivro(String nomeLivro, int idAutor){
        int i, autor = 0, edit=0;
        for(i=0;i<autores.size();i++){
            if(idAutor == autores.get(i).getId()){
                autor = 1;
            }
        }
        
        if(autor == 0){
            return 1; //Autor n encontrado
        }
        
        AutorDoLivro autordolivro = new AutorDoLivro(-1,-1);
        for(i=0;i<livros.size();i++){
            if(nomeLivro.equals(livros.get(i).getNome())){
                autoresdoslivros.remove(i);
                edit = 1;
            }
        }
        
        if(edit != 0)
            return 0; // OK
        return 2; //Não encontrou o livro
    }
    
    public void printaAutoresDosLivros(){
        int i;
        System.out.println("Autores dos livros:"+  "\n");
        for(i=0; i < autoresdoslivros.size(); i++){
            System.out.println(autoresdoslivros.get(i).getIdlivro() + " " + autoresdoslivros.get(i).getIdautor() + "\n");
        }
    }

    public ArrayList<AutorDoLivro> getAutoresdoslivros() {
        return autoresdoslivros;
    }

    public void setAutoreslivros(ArrayList<AutorDoLivro> autoresdoslivros) {
        Memoria.autoresdoslivros = autoresdoslivros;
    }
 
    
    
}
