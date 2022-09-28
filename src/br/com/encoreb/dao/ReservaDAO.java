/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.encoreb.dao;

import Conector.ModuloConexao;
import br.com.encoreb.models.Cliente;
import br.com.encoreb.models.ClienteQuarto;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import br.com.encoreb.models.Reserva;
/**
 *
 * @author Aluno
 */
public class ReservaDAO {

    public List<Reserva> Select() throws SQLException, ClassNotFoundException {

        Connection con = ModuloConexao.getConnection(); // Busca uma conexão com o banco de dados
        PreparedStatement stmt = null;
        ResultSet rs = null; // Objeto que armazena o resultado de uma busca em uma estrutura de dados que pode ser percorrida
// Instanciando uma nova lista para receber os valores do banco
        List<Reserva> reslist = new ArrayList<>();
        Reserva res = new Reserva();
        try {
            // Inserindo o comando SQL a ser usado
            stmt = con.prepareStatement("SELECT * FROM reservas");
            rs = stmt.executeQuery(); // Executa o comando SQL
            /* Loop responsável pela busca dos dados no banco que o repetirá até que não
 haja valores */
            while (rs.next()) {

                res.setId_res(rs.getInt("id_res"));
                res.setId_cli(rs.getInt("id_cli"));
                res.setId_func(rs.getInt("id_func"));
                res.setData_entrada(rs.getDate("data_entrada"));
                res.setData_saida(rs.getDate("data_saida"));
                res.setAdultos(rs.getInt("adultos"));
                res.setCriancas(rs.getInt("criancas"));
                res.setQuarto(rs.getInt("quarto"));
                res.setValor(rs.getDouble("valor"));
                res.setResponsavel(rs.getString("responsavel"));
                reslist.add(res); // Adiciona o objeto na lista
            }
        } catch (SQLException ex) { // Tratamento das exceções
            Logger.getLogger(ReservaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return reslist;   // Retorna a lista
    }

    public Reserva SelectOne(int id) throws SQLException, ClassNotFoundException {
        Connection con = ModuloConexao.getConnection();

        PreparedStatement stmt = null;

        ResultSet rs = null;
        Reserva res = new Reserva();
        try {
            stmt = con.prepareStatement("SELECT * FROM reserva AS c WHERE c.id_res = ?");
            stmt.setInt(1, id);

            rs = stmt.executeQuery();

            while (rs.next()) {
                res.setId_res(rs.getInt("id_res"));
                res.setId_cli(rs.getInt("id_cli"));
                res.setId_func(rs.getInt("id_func"));
                res.setData_entrada(rs.getDate("data_entrada"));
                res.setData_saida(rs.getDate("data_saida"));
                res.setAdultos(rs.getInt("adultos"));
                res.setCriancas(rs.getInt("criancas"));
                res.setQuarto(rs.getInt("quarto"));
                res.setValor(rs.getDouble("valor"));
                res.setResponsavel(rs.getString("responsavel"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReservaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return res;
    }

    public void Insert(Reserva res) throws SQLException, ClassNotFoundException {

        Connection con = ModuloConexao.getConnection(); // Busca uma conexão com o banco de dados

        con.setAutoCommit(false);

        PreparedStatement stmt = null;
        


        try {

            // Inserindo o comando SQL a ser usado
            stmt = con.prepareStatement("INSERT INTO reservas VALUES (DEFAULT, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

            // O método setString, define que o valor passado será do tipo inteiro
            stmt.setInt(1, res.getId_cli());
            stmt.setInt(2, res.getId_func());
            stmt.setDate(3, new Date(res.getData_entrada().getTime()));             
            stmt.setDate(4, new Date(res.getData_saida().getTime()));
            stmt.setInt(5, res.getAdultos());
            stmt.setInt(6, res.getCriancas());
            stmt.setInt(7, res.getQuarto());
            stmt.setDouble(8, res.getValor());
            stmt.setString(9, res.getResponsavel());
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

    public void Update(Reserva res) throws SQLException, ClassNotFoundException {
        Connection con = ModuloConexao.getConnection();
        con.setAutoCommit(false);
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("UPDATE reservas SET id_cli= ?, id_fubc = ?, data_entrada = ?, data_saida = ?, adultos = ?, criancas = ?, quarto = ?, valor = ?, responsavel = ?  WHERE id_res = ?");
            stmt.setInt(1, res.getId_cli());
            stmt.setInt(2, res.getId_func());
            stmt.setDate(3, new Date(res.getData_entrada().getTime()));  
            stmt.setDate(4, new Date(res.getData_entrada().getTime()));
            stmt.setInt(5, res.getAdultos());
            stmt.setInt(6, res.getCriancas());
            stmt.setInt(7, res.getQuarto());
            stmt.setDouble(8, res.getValor());
            stmt.setString(9, res.getResponsavel());
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
