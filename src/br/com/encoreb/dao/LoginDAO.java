/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.encoreb.dao;
import Conector.ModuloConexao;
import java.sql.*;
import java.sql.SQLException;
import java.sql.Connection;
import br.com.encorebe.models.Funcionario;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;


public class LoginDAO 
{
    public List<Funcionario> LoginFunc() throws SQLException, ClassNotFoundException
    {
        Connection conexao = ModuloConexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Funcionario> funcionario = new ArrayList();
        
        
    }
    
    
    
}
