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
public class Leitor {
    int id;
    static int cont = 1;
    String nome;
    int cpf;
    String email;
    
    Leitor(String nome, int cpf, String email){
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
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
        Leitor.cont = cont;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    
}
