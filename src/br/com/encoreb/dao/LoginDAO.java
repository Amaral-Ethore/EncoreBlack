/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.encoreb.dao;

import Conector.ModuloConexao;
import java.util.List;
import br.com.encoreb.models.Funcionario;
import java.util.ArrayList;
import java.sql.*;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

/**
 *
 * @author Assistência02
 */
public class LoginDAO {

    public Funcionario getLogin(String usuario, String senha) throws SQLException, ClassNotFoundException {
       
        Connection conexao = ModuloConexao.getConnection();
        ResultSet rs = null;
        Funcionario func = new Funcionario();

        try {
            PreparedStatement stmt = null;
            stmt = conexao.prepareStatement("select * from funcionarios WHERE usuario = ? and senha = ?");
            
            stmt.setString(1, usuario);
            stmt.setString(2, senha);
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                func.setId(rs.getInt("id"));
                func.setNome(rs.getString("nome"));
                func.setSexo(rs.getString("sexo"));
                func.setNascimento(rs.getDate("nascimento"));
                func.setRg(rs.getString("RG"));
                func.setCpf(rs.getString("CPF"));
                func.setTelefone(rs.getString("telefone"));
                func.setEmail(rs.getString("email"));
                func.setEndereco(rs.getString("endereco"));
                func.setSalario(rs.getDouble("salario"));
                func.setFuncao(rs.getString("funcao"));
                func.setSetor(rs.getString("setor"));
                func.setCargahoraria(rs.getString("cargaHoraria"));
                func.setUsuario(rs.getString("usuario"));
                func.setSenha(rs.getString("senha"));
            }
        } catch (Exception e) {
            System.out.println("Erro: " + e);
        }
        return func;
    }

//    public List<Funcionario> getSetor() throws SQLException, ClassNotFoundException
//    {
//        List<Funcionario> funcionario = new ArrayList();
//        Connection conexao = ModuloConexao.getConnection();
//        ResultSet rs = null;
//        
//        
//        try
//        {
//            PreparedStatement stmt = null;
//            
//            stmt = conexao.prepareStatement("select * from funcionarios");        
//            
//            while(rs.next())
//            {
//                
//                Funcionario func = new Funcionario();
//                func.getSetor();
//                funcionario.add(func);
//            }     
//        }
//        catch(Exception e)
//        {
//            System.out.println("Erro: " + e);
//        }
//        return funcionario;
//    }
}
