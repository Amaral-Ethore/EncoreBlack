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

    public String getNumQuarto() {
        return numQuarto;
    }

    public void setNumQuarto(String numQuarto) {
        this.numQuarto = numQuarto;
    }

    public String getTipoQuarto() {
        return tipoQuarto;
    }

    public void setTipoQuarto(String tipoQuarto) {
        this.tipoQuarto = tipoQuarto;
    }
    
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
          
          quarto.setOcupado(rs.getBoolean("ocupado"));
          quarto.setTipoQuarto(rs.getString("tipoQuarto"));
          quarto.setNumquarto(rs.getString("numQuarto"));   
          
          
        }
        
        
        } catch (Exception e) {
        
            System.out.println("Erro: " + e);
        }
        return quarto;
    }
    
    public Quarto SelectOne(String numquarto) throws SQLException, ClassNotFoundException {
        Connection conexao = ModuloConexao.getConnection();
        
        PreparedStatement stmt = null;
        
        ResultSet rs = null;
        
        Quarto quarto = new Quarto();
        try {
        stmt = conexao.prepareStatement("SELECT * FROM quartos AS c Where c.numQuarto = ?");
        stmt.setString(1, numquarto);
        
        
        rs = stmt.executeQuery();
        
        while(rs.next()) {
        quarto.setNumquarto(rs.getString("numQuarto"));
        quarto.setTipoQuarto(rs.getString("tipoQuarto"));
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
           
            stmt = conexao.prepareStatement("INSERT INTO quartos VALUES ( ?,?,? )");
            
            stmt.setString(1, quarto.getNumquarto());
            stmt.setString(2, quarto.getTipoQuarto());
            stmt.setBoolean(3, quarto.getOcupado());
            
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
     public List<Quarto> Pesquisar(String quarto) throws SQLException, ClassNotFoundException {
          Connection conexao = ModuloConexao.getConnection();
          
          ResultSet rs = null;
          PreparedStatement stmt = null;
          List<Quarto> quartos = new ArrayList<>();
          
         try {
             stmt = conexao.prepareStatement("select * from quartos where numQuarto like ?");
             stmt.setString(1, "%"+ quarto + "%");
             
             rs = stmt.executeQuery();
             
             while (rs.next()) {
                 Quarto Quarto = new Quarto();
                 Quarto.setNumquarto(rs.getString("numQuarto"));
                 Quarto.setTipoQuarto(rs.getString("tipoQuarto"));
                 Quarto.setOcupado(rs.getBoolean("ocupado"));
                 quartos.add(Quarto);
                 
             }
         } catch (SQLException ex) {
             System.out.println(ex);
             throw ex;
         }
         return quartos;
     
     }
    
    public void Update(Quarto quarto) throws SQLException, ClassNotFoundException {
        Connection conexao = ModuloConexao.getConnection();
        conexao.setAutoCommit(false);
        PreparedStatement stmt = null;
        
        try {
            stmt = conexao.prepareStatement("UPDATE quartos SET tipoQuarto = ?, ocupado = ? WHERE numQuarto = ?");
            stmt.setString(3, quarto.getNumquarto());
            stmt.setString(1, quarto.getTipoQuarto());
            stmt.setBoolean(2, quarto.getOcupado());
            stmt.executeUpdate();
            limparformulario();
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

    private void limparformulario() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}


    
    
    
    
    
