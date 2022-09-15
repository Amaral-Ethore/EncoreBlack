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
public class LoginDAO 
{
    public List<Funcionario> getLogin() throws SQLException, ClassNotFoundException
    {
        List<Funcionario> funcionario = new ArrayList();
        Connection conexao = ModuloConexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try
        {
            stmt = conexao.prepareStatement("select * from funcionarios");
            rs = stmt.executeQuery();
            
            while(rs.next())
            {
                Funcionario func = new Funcionario();
                func.getUsuario();
                func.getSenha();
                
                funcionario.add(func);
            }
            
        }
        catch(Exception e)
        {
            System.out.println("Erro: " + e);
        }
        return funcionario;
    }
}
