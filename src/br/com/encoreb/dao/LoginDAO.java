/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.encoreb.dao;
import Conector.ModuloConexao;

import java.util.ArrayList;
import java.util.List;
import br.com.encoreb.models.Funcionario;
import java.sql.*;
import java.sql.SQLException;
/**
 *
 * @author Assistência02
 */
public class LoginDAO 
{
    public List<Funcionario> Login() throws SQLException, ClassNotFoundException
    {
        Connection conexao = ModuloConexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Funcionario> funcionario = new ArrayList();

        
        try
        {
            while(rs.next())
            {
            rs = stmt.executeQuery();
            stmt = conexao.prepareStatement("select * from funcionario;");
            Funcionario func = new Funcionario();
            
            func.setLogin(rs.getString("usuario"));
            func.setSenha(rs.getString("senha"));
            funcionario.add(func);
            }
        }
        catch(Exception e)
        {
            System.out.println("Error");
        }
        return funcionario;
    }
}
