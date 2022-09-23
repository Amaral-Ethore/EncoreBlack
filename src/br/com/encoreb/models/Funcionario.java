/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.encoreb.models;

import java.util.Date;



/**
 *
 * @author Aluno
 */
public class Funcionario extends Pessoa {
    private int id;
    private double salario;
    private String funcao;
    private String cargahoraria;
    private String setor;
<<<<<<< HEAD:src/br/com/encorebe/models/Funcionario.java
    private String senha;
    private String login;
=======
    private String usuario;
    private String senha;
    

    public Funcionario(){
        
    }
    
    public Funcionario( double salario,String funcao,String cargahoraria,String nome, String sexo, String rg,String cpf, String telefone,String email, String endereco, Date nascimento){
       
        super (nome,sexo, rg,cpf,telefone,email, endereco, nascimento);        
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
>>>>>>> fc93df99b9cb303a26beb9f7f6c4faabaf4d5cf1:src/br/com/encoreb/models/Funcionario.java

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
<<<<<<< HEAD:src/br/com/encorebe/models/Funcionario.java

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
=======
>>>>>>> fc93df99b9cb303a26beb9f7f6c4faabaf4d5cf1:src/br/com/encoreb/models/Funcionario.java

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }
    
    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public String getCargahoraria() {
        return cargahoraria;
    }

    public void setCargahoraria(String cargahoraria) {
        this.cargahoraria = cargahoraria;
    }
    
    
}
