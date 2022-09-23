/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.encoreb.dao;
import Conector.ModuloConexao;
import java.util.List;
import br.com.encoreb.models.Quarto;
import java.util.ArrayList;
import java.sql.*;
import java.sql.ResultSet;
import java.sql.PreparedStatement;


/**
 *
 * @author Aluno
 */
public class QuartoDAO {

    private String numQuarto;
    private String tipoQuarto;
    
    public Quarto getquarto() throws SQLException, ClassNotFoundException {
    
        Connection conexao = ModuloConexao.getConnection;
        ResultSet rs = null;
        Quarto quarto = new Quarto();
        
        try {
        PreparedStatement stmt = null;
        stmt = conexao.prepareStatement("select * from quartos WHERE numQuarto = ? and tipoQuarto = ? ");
        
        stmt.setString(1, numQuarto);
        stmt.setString(2, tipoQuarto);
        rs = stmt.executeQuery();
        
        
        while (rs.next()) {
          quarto.getQuarto(rs.getString("quarto"));
          quarto.getOcupado(rs.getString("ocupado"));
          quarto.getTipoQuarto(rs.getString("tipoQuarto"));
          quarto.getNumQuarto(rs.getString("numQuarto"));   
          
          
        }
        
        
        } catch (Exception e) {
        
            System.out.println("Erro: " + e);
        }
        return quarto;
    }
    
    
    
}
