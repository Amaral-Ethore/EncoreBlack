/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.encoreb.models;

import java.sql.Date;

/**
 *
 * @author Aluno
 */
public class Cliente extends Pessoa{
    private int id;
    
    public Cliente(){
        
    }
    public Cliente(int id,String nome, String sexo, String rg,String cpf, String telefone,String email, String endereco, Date nascimento){
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
}
