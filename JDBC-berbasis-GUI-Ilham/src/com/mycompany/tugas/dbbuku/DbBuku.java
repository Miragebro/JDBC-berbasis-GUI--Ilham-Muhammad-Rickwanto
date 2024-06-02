package com.mycompany.tugas.dbbuku;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbBuku {
    static Connection con;
    static String driver = "com.mysql.cj.jdbc.Driver";
    static String url = "jdbc:mysql://localhost:3306/jdbcperpustakaan";
    static String username = "root";
    static String password = "";
    
    public static Connection getConnection() throws Exception{
        if(con == null) {
            Class.forName(driver);
            con = DriverManager.getConnection(url, username, password);
        }
        return con;
    }
}
