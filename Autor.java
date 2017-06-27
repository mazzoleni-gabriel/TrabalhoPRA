/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tfpra;

import javax.swing.JOptionPane;


/**
 *
 * @author mpgab
 */
public class Autor {
    String nome;
    String nacionalidade;
    int id;
    static int cont=1;

    Autor(String nome, String nac){
        this.nome = nome;
        this.nacionalidade = nac;
        this.id = cont;
        cont++;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public int getId() {
        return id;
    }

    public void setId(int Id) {
        this.id = id;
    }

    public static int getCont() {
        return cont;
    }

    public static void setCont(int cont) {
        Autor.cont = cont;
    }
    
    
    
    
}
