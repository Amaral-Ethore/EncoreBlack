/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.encoreb.dao;

import Conector.ModuloConexao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import br.com.encorebe.models.Cliente;

/**
 *
 * @author Professor
 */
public class ClienteDAO {

    public List<Cliente> Select() throws SQLException, ClassNotFoundException {

        Connection con = ModuloConexao.getConnection(); // Busca uma conexão com o banco de dados
        PreparedStatement stmt = null;
        ResultSet rs = null; // Objeto que armazena o resultado de uma busca em uma estrutura de dados que pode ser percorrida
// Instanciando uma nova lista para receber os valores do banco
        List<Cliente> clientes = new ArrayList<>();

        try {
            // Inserindo o comando SQL a ser usado
            stmt = con.prepareStatement("SELECT * FROM clientes");
            rs = stmt.executeQuery(); // Executa o comando SQL
            /* Loop responsável pela busca dos dados no banco que o repetirá até que não
 haja valores */
            while (rs.next()) {

                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setSexo(rs.getString("sexo"));
                cliente.setNascimento(rs.getDate("nascimento"));
                cliente.setRg(rs.getString("RG"));
                cliente.setCpf(rs.getString("CPF"));
                cliente.setTelefone(rs.getString("telefone"));
                cliente.setEmail(rs.getString("email"));
                cliente.setEndereco(rs.getString("endereco"));
                cliente.setAcompanhante(rs.getString("acompanhante"));
                
                clientes.add(cliente); // Adiciona o objeto na lista
            }
        } catch (SQLException ex) { // Tratamento das exceções
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return clientes;   // Retorna a lista
    }

    public Cliente SelectOne(int id) throws SQLException, ClassNotFoundException {
        Connection con = ModuloConexao.getConnection();

        PreparedStatement stmt = null;

        ResultSet rs = null;
        Cliente cliente = new Cliente();
        try {
            stmt = con.prepareStatement("SELECT * FROM clientes AS c WHERE c.id = ?");
            stmt.setInt(1, id);

            rs = stmt.executeQuery();

            while (rs.next()) {
                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setSexo(rs.getString("sexo"));
                cliente.setNascimento(rs.getDate("nascimento"));
                cliente.setRg(rs.getString("RG"));
                cliente.setCpf(rs.getString("CPF"));
                cliente.setTelefone(rs.getString("telefone"));
                cliente.setEmail(rs.getString("email"));
                cliente.setEndereco(rs.getString("endereco"));
                cliente.setAcompanhante(rs.getString("acompanhante"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return cliente;
    }

    public void Insert(Cliente c) throws SQLException, ClassNotFoundException {

        Connection con = ModuloConexao.getConnection(); // Busca uma conexão com o banco de dados

        con.setAutoCommit(false);

        PreparedStatement stmt = null;

        try {

            // Inserindo o comando SQL a ser usado
            stmt = con.prepareStatement("INSERT INTO clientes VALUES (DEFAULT, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

            // O método setString, define que o valor passado será do tipo inteiro
            stmt.setInt(1, c.getId());
            stmt.setString(2, c.getNome());
            stmt.setString(3, c.getSexo());
            stmt.setDate(4, new Date(c.getNascimento().getTime()));
            stmt.setString(5, c.getRg());
            stmt.setString(6, c.getCpf());
            stmt.setString(7, c.getTelefone());
            stmt.setString(8, c.getEmail());
            stmt.setString(9, c.getEndereco());
            stmt.setString(10, c.getAcompanhante());
            
            

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

    public void Update(Cliente cliente) throws SQLException, ClassNotFoundException {
        Connection con = ModuloConexao.getConnection();
        con.setAutoCommit(false);
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("UPDATE clientes SET nome = ?, sexo = ?, nascimento = ?, RG = ?, CPF = ?, telefone = ?, email = ?, endereco = ?, acompanhante = ? WHERE id = ?");
            
            stmt.setInt(1, cliente.getId());
            stmt.setString(2, cliente.getNome());
            stmt.setString(3, cliente.getSexo());
            stmt.setDate(4, new Date(cliente.getNascimento().getTime()));
            stmt.setString(5, cliente.getRg());
            stmt.setString(6, cliente.getCpf());
            stmt.setString(7, cliente.getTelefone());
            stmt.setString(8, cliente.getEmail());
            stmt.setString(9, cliente.getEndereco());
            stmt.setString(10, cliente.getAcompanhante());
            
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
