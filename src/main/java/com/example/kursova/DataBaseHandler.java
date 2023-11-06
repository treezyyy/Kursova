package com.example.kursova;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;


public class DataBaseHandler extends Configs{
    Connection dbConnection;
    public Connection getDbConnection() throws ClassNotFoundException, SQLException{
        String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName;
        Class.forName("com.mysql.cj.jdbc.Driver");
        dbConnection = DriverManager.getConnection(connectionString,dbUser, dbPass);
        return dbConnection;
    }

    public void signUpUser(User user) throws SQLException, ClassNotFoundException {
        String insert = "INSERT INTO " + Const.USER_TABLE + "(" + Const.USERS_FIRSTNAME + "," + Const.USERS_USERNAME + ","
                + Const.USERS_PASSWORD + "," + Const.USERS_GENDER + "," + Const.USERS_PHONE + "," + Const.USERS_EMAIL + "," + Const.USERS_VIN + ")" + "VALUES(?,?,?,?,?,?,?)";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1, user.getFirstName());
            prSt.setString(2, user.getUserName());
            prSt.setString(3, user.getPassword());
            prSt.setString(4, user.getGendere());
            prSt.setString(5, user.getPhone());
            prSt.setString(6, user.getEmail());
            prSt.setString(7, user.getVin());
            prSt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public ResultSet getUser(User user) {
        ResultSet resSet = null;
        String select = "SELECT * FROM " + Const.USER_TABLE + " WHERE " + Const.USERS_USERNAME + " = ? AND " + Const.USERS_PASSWORD + " = ?";

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            prSt.setString(1, user.getUserName());
            prSt.setString(2, user.getPassword());
            resSet = prSt.executeQuery();
        } catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return resSet;
    }

    public String getNameFromDB(int idusers) throws SQLException, ClassNotFoundException {
        Connection conn = getDbConnection();
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM " + Const.USER_TABLE + " WHERE " + Const.USERS_ID + " = ?");
        stmt.setInt(1, idusers);
        ResultSet rs = stmt.executeQuery();
        String name = null;
        if (rs.next()) {
            name = rs.getString("userName");
        }
        conn.close();
        return name;
    }

    public String getVinFromDB(String login) throws SQLException, ClassNotFoundException {
        Connection conn = getDbConnection();
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM " + Const.USER_TABLE + " WHERE " + Const.USERS_USERNAME + " = ?");
        stmt.setString(1, login);
        ResultSet rs = stmt.executeQuery();
        String name = null;
        if (rs.next()) {
            name = rs.getString("vin");
        }
        conn.close();
        return name;
    }

    public String getMobileFromDB(int idusers) throws SQLException, ClassNotFoundException {
        Connection conn = getDbConnection();
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM " + Const.USER_TABLE + " WHERE " + Const.USERS_ID + " = ?");
        stmt.setInt(1, idusers);
        ResultSet rs = stmt.executeQuery();
        String name = null;
        if (rs.next()) {
            name = rs.getString("phone");
        }
        conn.close();
        return name;
    }

    public String getEmailFromDB(int idusers) throws SQLException, ClassNotFoundException {
        Connection conn = getDbConnection();
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM " + Const.USER_TABLE + " WHERE " + Const.USERS_ID + " = ?");
        stmt.setInt(1, idusers);
        ResultSet rs = stmt.executeQuery();
        String name = null;
        if (rs.next()) {
            name = rs.getString("email");
        }
        conn.close();
        return name;
    }

    public String getFirstInfoFromDB(int idinformations) throws SQLException, ClassNotFoundException {
        Connection conn = getDbConnection();
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM " + Const.INFORMATIONS_TABLESECOND + " WHERE " + Const.INFORMATIONS_ID + " = ?");
        stmt.setInt(1, idinformations);
        ResultSet rs = stmt.executeQuery();
        String name = null;
        if (rs.next()) {
            name = rs.getString("information");
        }
        conn.close();
        return name;
    }


    public int getIdFromDB(String userName) throws SQLException, ClassNotFoundException {
        Connection conn = getDbConnection();
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM " + Const.USER_TABLE + " WHERE " + Const.USERS_USERNAME + " = ?");
        stmt.setString(1, userName);
        ResultSet rs = stmt.executeQuery();
        int id = 0;
        if (rs.next()) {
            id = rs.getInt("idusers");
        }
        conn.close();
        return id;
    }


    public String getMaleFromDB(String userName) throws SQLException, ClassNotFoundException {
        Connection conn = getDbConnection();
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM " + Const.USER_TABLE + " WHERE " + Const.USERS_USERNAME + " = ?");
        stmt.setString(1, userName);
        ResultSet rs = stmt.executeQuery();
        String male = null;
        if (rs.next()) {
            male = rs.getString("gendere");
        }
        conn.close();
        return male;
    }


    public String getShtFromDB(String Nomer) throws SQLException, ClassNotFoundException {
        Connection conn = getDbConnection();
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM " + Const.SHT_TABLE + " WHERE " + Const.SHT_NOMER + " = ?");
        stmt.setString(1, Nomer);
        ResultSet rs = stmt.executeQuery();
        String sht = null;
        if (rs.next()) {
            sht = rs.getString("first");
        }
        conn.close();
        return sht;
    }

    public String getShtSecondFromDB(String Nomer) throws SQLException, ClassNotFoundException {
        Connection conn = getDbConnection();
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM " + Const.SHT_TABLE + " WHERE " + Const.SHT_NOMER + " = ?");
        stmt.setString(1, Nomer);
        ResultSet rs = stmt.executeQuery();
        String sht = null;
        if (rs.next()) {
            sht = rs.getString("second");
        }
        conn.close();
        return sht;
    }

}
