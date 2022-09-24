/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.encoreb.dao;

import Conector.ModuloConexao;
import br.com.encoreb.models.Cliente;
import br.com.encoreb.models.Funcionario;
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
public class FuncionarioDAO {

    public List<Funcionario> Select() throws SQLException, ClassNotFoundException {

        Connection con = ModuloConexao.getConnection(); // Busca uma conexão com o banco de dados
        PreparedStatement stmt = null;
        ResultSet rs = null; // Objeto que armazena o resultado de uma busca em uma estrutura de dados que pode ser percorrida
// Instanciando uma nova lista para receber os valores do banco
        List<Funcionario> funcionarios = new ArrayList<>();

        try {
            // Inserindo o comando SQL a ser usado
            stmt = con.prepareStatement("SELECT * FROM funcionarios");
            rs = stmt.executeQuery(); // Executa o comando SQL
            /* Loop responsável pela busca dos dados no banco que o repetirá até que não
 haja valores */
            while (rs.next()) {

                Funcionario funcionario = new Funcionario();
                funcionario.setId(rs.getInt("id"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setSexo(rs.getString("sexo"));
                funcionario.setNascimento(rs.getDate("nascimento"));
                funcionario.setRg(rs.getString("RG"));
                funcionario.setCpf(rs.getString("CPF"));
                funcionario.setTelefone(rs.getString("telefone"));
                funcionario.setEmail(rs.getString("email"));
                funcionario.setEndereco(rs.getString("endereco"));
                funcionario.setFuncao(rs.getString("funcao"));
                funcionario.setCargahoraria(rs.getString("cargahoraria"));
                funcionario.setSalario(rs.getDouble("salario"));
                funcionario.setSetor(rs.getString("setor"));

                funcionarios.add(funcionario); // Adiciona o objeto na lista
            }
        } catch (SQLException ex) { // Tratamento das exceções
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return funcionarios;   // Retorna a lista
    }

    public Funcionario SelectOne(int id) throws SQLException, ClassNotFoundException {
        Connection con = ModuloConexao.getConnection();

        PreparedStatement stmt = null;

        ResultSet rs = null;
        Funcionario funcionario = new Funcionario();
        try {
            stmt = con.prepareStatement("SELECT * FROM funcionarios AS c WHERE c.id = ?");
            stmt.setInt(1, id);

            rs = stmt.executeQuery();
 
            while (rs.next()) {
                funcionario.setId(rs.getInt("id"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setSexo(rs.getString("sexo"));
                funcionario.setNascimento(rs.getDate("nascimento"));
                funcionario.setRg(rs.getString("RG"));
                funcionario.setCpf(rs.getString("CPF"));
                funcionario.setTelefone(rs.getString("telefone"));
                funcionario.setEmail(rs.getString("email"));
                funcionario.setEndereco(rs.getString("endereco"));
                funcionario.setFuncao(rs.getString("funcao"));
                funcionario.setCargahoraria(rs.getString("cargahoraria"));
                funcionario.setSalario(rs.getDouble("salario"));
                funcionario.setSetor(rs.getString("setor"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return funcionario;
    }

    public void Insert(Funcionario f) throws SQLException, ClassNotFoundException {

        Connection con = ModuloConexao.getConnection(); // Busca uma conexão com o banco de dados

        con.setAutoCommit(false);

        PreparedStatement stmt = null;

        try {

            // Inserindo o comando SQL a ser usado
            stmt = con.prepareStatement("INSERT INTO funcionarios VALUES (DEFAULT,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?,?)");

            // O método setString, define que o valor passado será do tipo inteiro
            stmt.setString(1, f.getNome());
            stmt.setString(2, f.getSexo());
            stmt.setDate(3, new Date(f.getNascimento().getTime()));
            stmt.setString(4, f.getRg());
            stmt.setString(5, f.getCpf());
            stmt.setString(6, f.getTelefone());
            stmt.setString(7, f.getEmail());
            stmt.setString(8, f.getEndereco());
            stmt.setDouble(9, f.getSalario());
            stmt.setString(10, f.getFuncao());
            stmt.setString(11, f.getSetor());
            stmt.setString(12, f.getCargahoraria());
            stmt.setString(13, f.getLogin());
            stmt.setString(14, f.getSenha());

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

    public void Update(Funcionario funcionario) throws SQLException, ClassNotFoundException {
        Connection con = ModuloConexao.getConnection();
        con.setAutoCommit(false);
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("UPDATE funcionarios SET nome = ?, sexo = ?, nascimento = ?, RG = ?, CPF = ?, telefone = ?, email = ?, endereco = ?, salario = ?, funcao = ?,setor = ?, cargaHoraria = ? WHERE id = ?");
            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getSexo());
            stmt.setDate(3, new Date(funcionario.getNascimento().getTime()));
            stmt.setString(4, funcionario.getRg());
            stmt.setString(5, funcionario.getCpf());
            stmt.setString(6, funcionario.getTelefone());
            stmt.setString(7, funcionario.getEmail());
            stmt.setString(8, funcionario.getEndereco());
            stmt.setDouble(9, funcionario.getSalario());
            stmt.setString(10, funcionario.getFuncao());
            stmt.setString(11, funcionario.getSetor());
            stmt.setString(12, funcionario.getCargahoraria());
            stmt.setInt(13, funcionario.getId());
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

    public List<Funcionario> pesquisar(String termo) throws SQLException, ClassNotFoundException {
        Connection con = ModuloConexao.getConnection();

        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Funcionario> funcionarios = new ArrayList<>();
        try {
            stmt = con.prepareStatement("select * from  funcionarios where nome like ?");
            stmt.setString(1, "%"+ termo + "%");

            rs = stmt.executeQuery();

            while (rs.next()) {
                Funcionario funcionario = new Funcionario();
                funcionario.setId(rs.getInt("id"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setSexo(rs.getString("sexo"));
                funcionario.setNascimento(rs.getDate("nascimento"));
                funcionario.setRg(rs.getString("RG"));
                funcionario.setCpf(rs.getString("CPF"));
                funcionario.setTelefone(rs.getString("telefone"));
                funcionario.setEmail(rs.getString("email"));
                funcionario.setEndereco(rs.getString("endereco"));
                funcionario.setFuncao(rs.getString("funcao"));
                funcionario.setCargahoraria(rs.getString("cargahoraria"));
                funcionario.setSalario(rs.getDouble("salario"));
                funcionario.setSetor(rs.getString("setor"));

                funcionarios.add(funcionario);
            }

        } catch (SQLException ex) {
            System.out.println(ex);

            throw ex;

        } finally {

            if (stmt != null) {
                stmt.close();
            }
            con.setAutoCommit(true);
        }

        return funcionarios;

    }
}
