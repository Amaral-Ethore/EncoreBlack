/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.encoreb.dao;

import Conector.ModuloConexao;
import br.com.encorebe.models.Cliente;
import br.com.encorebe.models.ClienteQuarto;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Aluno
 */
public class ClienteQuartoDAO {

    public List<ClienteQuarto> Select() throws SQLException, ClassNotFoundException {

        Connection con = ModuloConexao.getConnection(); // Busca uma conexão com o banco de dados
        PreparedStatement stmt = null;
        ResultSet rs = null; // Objeto que armazena o resultado de uma busca em uma estrutura de dados que pode ser percorrida
// Instanciando uma nova lista para receber os valores do banco
        List<ClienteQuarto> cliquart = new ArrayList<>();

        try {
            // Inserindo o comando SQL a ser usado
            stmt = con.prepareStatement("SELECT * FROM clientequarto");
            rs = stmt.executeQuery(); // Executa o comando SQL
            /* Loop responsável pela busca dos dados no banco que o repetirá até que não
 haja valores */
            while (rs.next()) {

                ClienteQuarto cliquar = new ClienteQuarto();
                cliquar.setId(rs.getInt("id"));
                cliquar.setIdcliente(rs.getInt("idcliente"));
                cliquar.setIdquarto(rs.getInt("idquarto"));

                cliquart.add(cliquar); // Adiciona o objeto na lista
            }
        } catch (SQLException ex) { // Tratamento das exceções
            Logger.getLogger(ClienteQuartoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cliquart;   // Retorna a lista
    }

    public ClienteQuarto SelectOne(int id) throws SQLException, ClassNotFoundException {
        Connection con = ModuloConexao.getConnection();

        PreparedStatement stmt = null;

        ResultSet rs = null;
        ClienteQuarto cliquar = new ClienteQuarto();
        try {
            stmt = con.prepareStatement("SELECT * FROM clientequarto AS c WHERE c.idclienteQuarto = ?");
            stmt.setInt(1, id);

            rs = stmt.executeQuery();

            while (rs.next()) {
                cliquar.setId(rs.getInt("idclienteQuarto"));
                cliquar.setIdcliente(rs.getInt("idcliente"));
                cliquar.setIdquarto(rs.getInt("idquarto"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteQuartoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return cliquar;
    }

    public void Insert(ClienteQuarto cq) throws SQLException, ClassNotFoundException {

        Connection con = ModuloConexao.getConnection(); // Busca uma conexão com o banco de dados

        con.setAutoCommit(false);

        PreparedStatement stmt = null;

        try {

            // Inserindo o comando SQL a ser usado
            stmt = con.prepareStatement("INSERT INTO clientequarto VALUES (DEFAULT, ?, ?)");

            // O método setString, define que o valor passado será do tipo inteiro
            stmt.setInt(1, cq.getIdcliente());
            stmt.setInt(2, cq.getIdquarto());

            // Método responsável por fazer a alteração no banco de dados
            stmt.executeUpdate();
            con.commit();

        } catch (SQLException ex) {  // Tratamento das exceções

            System.out.println(ex);
            con.rollback();
            throw ex;

        } finally { // Encerramento da conexão

            if (stmt != null) {
                stmt.close();
            }
            con.setAutoCommit(true);
        }
    }

    public void Update(ClienteQuarto cliquar) throws SQLException, ClassNotFoundException {
        Connection con = ModuloConexao.getConnection();
        con.setAutoCommit(false);
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("UPDATE clientequarto SET idcliente = ?, idquarto= ? WHERE idclienteQuarto = ?");
            stmt.setInt(1, cliquar.getId());
            stmt.setInt(2, cliquar.getIdcliente());
            stmt.setInt(3, cliquar.getIdquarto());
            stmt.executeUpdate();
            con.commit();
        } catch (SQLException ex) {
            System.out.println(ex);
            con.rollback();
            throw ex;

        } finally {

            if (stmt != null) {
                stmt.close();
            }
            con.setAutoCommit(true);
        }
    }
}
