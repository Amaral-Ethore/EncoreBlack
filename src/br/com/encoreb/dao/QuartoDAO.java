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
import java.util.logging.Level;
import java.util.logging.Logger;


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
    
    public Quarto SelectOne(int id) throws SQLException, ClassNotFoundException {
        Connection conexao = ModuloConexao.getConnection();
        
        PreparedStatement stmt = null;
        
        ResultSet rs = null;
        
        Quarto quarto = new Quarto();
        try {
        stmt = conexao.prepareStatement("SELECT * FROM quarto AS c Where c.id = ?");
        stmt.setInt(1, id);
        
        
        rs = stmt.executeQuery();
        
        while(rs.next()) {
        quarto.setQuarto(rs.getInt("quarto"));
        quarto.setTipoQuarto(rs.getString("tipoQuarto"));
        quarto.setAndar(rs.getInt("Andar"));
        quarto.setOcupado(rs.getBoolean("ocupado"));
       
        }
        } catch (SQLException ex) {
                Logger.getLogger(QuartoDAO.class.getName()).log(Level.SEVERE, null, ex);
    
        }
         return quarto;
        }
        
    public void Insert(Quarto quarto) throws SQLException, ClassNotFoundException {
        
        Connection conexao = ModuloConexao.getConnection();
        conexao.setAutoCommit(false);
        
        PreparedStatement stmt = null;
        try {
           
            stmt = conexao.prepareStatement("INSERT INTO quartos VALUES (DEFAULT, ?,?,?,? )");
            
            stmt.setString(1, quarto.getTipoQuarto());
            stmt.setInt(2, quarto.getAndar());
            stmt.setBoolean(3, quarto.getOcupado());
            stmt.setInt(4, quarto.getQuarto());
            
            stmt.executeUpdate();
            conexao.commit();
            
        } catch (SQLException ex) {
            System.out.println(ex);
            conexao.rollback();
            throw ex;
        } finally {
            if (stmt != null) {
                stmt.close();
        }
        conexao.setAutoCommit(true);
        
    }
    }
    
    
    
    
    
    
    public void Update(Quarto quarto) throws SQLException, ClassNotFoundException {
        Connection conexao = ModuloConexao.getConnection();
        conexao.setAutoCommit(false);
        PreparedStatement stmt = null;
        
        try {
            stmt = conexao.prepareStatement("UPDATE funcionario SET tipoQuarto = ?, numQuarto = ?, ocupado = ?");
            stmt.executeUpdate();
            conexao.commit();
        } catch (SQLException ex) {
            System.out.println(ex);
            conexao.rollback();
            throw ex;
        } finally {
            
            if  (stmt != null) {
                stmt.close();
            }
            conexao.setAutoCommit(true);
        }
        
        
        
    }
}


    
    
    
    
    
