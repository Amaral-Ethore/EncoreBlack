/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.encoreb.models;

/**
 *
 * @author Aluno
 */
public class Quarto {
    private String numquarto;
    private String tipoQuarto;
    private Boolean ocupado;

    public Quarto(int andar, int quarto, String tipoQuarto, Boolean ocupado){
        this.ocupado = false;
    }            
    public Quarto(){
        
    }

    public String getNumquarto() {
        return numquarto;
    }

    public void setNumquarto(String numquarto) {
        this.numquarto = numquarto;
    }

    public String getTipoQuarto() {
        return tipoQuarto;
    }

    public void setTipoQuarto(String tipoQuarto) {
        this.tipoQuarto = tipoQuarto;
    }

    public Boolean getOcupado() {
        return ocupado;
    }

    public void setOcupado(Boolean ocupado) {
        this.ocupado = ocupado;
    }
    
    
    
    
}
