/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Aluno
 */
public class ModuloConexao {

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

    private static final String URL = "jdbc:mysql://localhost:3306/encoreblack?useTimezone=true&serverTimezone=UTC";

    private static final String USER = "root";

    private static final String PASSWORD = "root";
    public static Connection getConnection;

    public static Connection getConnection() throws SQLException, ClassNotFoundException {

        try {

            // O método forName carrega e inicia o driver passado por parâmetro
            Class.forName(DRIVER);

            // Estabelecendo a conexão
            return DriverManager.getConnection(URL, USER, PASSWORD);

        } catch (ClassNotFoundException | SQLException ex) {

            System.out.println(ex);
            
            return null;

        }
    }
}
