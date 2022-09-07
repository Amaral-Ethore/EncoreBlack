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
public class Cliente extends Pessoa{
    private int id;
    private String acompanhante;
    
    public Cliente(){
        
    }
    public Cliente(int id, String acompanhante,String nome, String sexo, String rg,String cpf, String telefone,String email, String endereco, Date nascimento){
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

    public String getAcompanhante() {
        return acompanhante;
    }

    public void setAcompanhante(String acompanhante) {
        this.acompanhante = acompanhante;
    }
}
