/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tfpra;

/**
 *
 * @author mpgab
 */
public class Livro {
    int id;
    static int cont = 1;
    String nome;
    String editora;
    int edicao;
    int ano;
    int idautor;
    
    
    Livro(String nome, String editora, int edicao, int ano, int idautor){
        this.nome = nome;
        this.editora = editora;
        this.edicao = edicao;
        this.ano = ano;
        this.idautor = idautor;
        this.id = cont;
        cont++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static int getCont() {
        return cont;
    }

    public static void setCont(int cont) {
        Livro.cont = cont;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public int getEdicao() {
        return edicao;
    }

    public void setEdicao(int edicao) {
        this.edicao = edicao;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getIdautor() {
        return idautor;
    }

    public void setIdautor(int idautor) {
        this.idautor = idautor;
    }
    
    
    
}
