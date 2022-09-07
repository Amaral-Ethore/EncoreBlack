/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.encorebe.models;

import java.sql.Date;

/**
 *
 * @author Aluno
 */
public class Funcionario extends Pessoa {
    private int id;
    private double salario;
    private String funcao;
    private String cargahoraria;
    
    public Funcionario(){
        
    }
    public Funcionario( double salario,String funcao,String cargahoraria,String nome, String sexo, String rg,String cpf, String telefone,String email, String endereco, Date nascimento){
       
        super (nome,sexo, rg,cpf,telefone,email, endereco, nascimento);
        
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
