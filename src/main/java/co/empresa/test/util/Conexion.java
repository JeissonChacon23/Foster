package co.empresa.test.util;

import lombok.Getter;
import java.sql.*;
public class Conexion {
    @Getter
    private Connection con = null;
    private PreparedStatement preparedStatement;
    private static Conexion db;
    private static final String url = "jdbc:mysql://localhost:3306/";
    private static final String dbname = "sistema";
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String userName = "root";
    private static final String password = "";

    public Conexion(String driver, String url, String dbName, String userName, String password){
        try{
            Class.forName(driver).newInstance();
            con = (Connection) DriverManager.getConnection(url + dbName, userName, password);
        }catch(InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }catch(Exception e){
            //Todo auto-generated catch block
            e.printStackTrace();
        }
    }
    public void cerrarConexion(){
        try{
            con.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public ResultSet query() throws SQLException{
        ResultSet res = preparedStatement.executeQuery();
        return res;
    }
    public int execute() throws SQLException{
        int result = preparedStatement.executeUpdate();
        return result;
    }
    public PreparedStatement setPreparedStatement(String sql) throws SQLException{
        this.preparedStatement = con.prepareStatement(sql);
        return this.preparedStatement;
    }
}