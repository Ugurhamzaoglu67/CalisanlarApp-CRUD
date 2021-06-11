package com.company;


import com.company.Calisan;
import com.company.model.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MyCalisanlar {
    private Connection con = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;


    public MyCalisanlar(){
        String url = "jdbc:mysql://localhost:"+ DatabaseConnection.dbPort+"/"+DatabaseConnection.dbName+"?useUnicode=true&characterEncoding=utf8";

        try{
            con = DriverManager.getConnection(url,DatabaseConnection.userName,DatabaseConnection.password);
            System.out.println("Db bağlantı başarılı...");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public boolean girisYap(String kullanici_adi, String parola) {
        String sorgu ="Select * from adminler where username = ? and password = ?";

        try {
            preparedStatement = con.prepareStatement(sorgu);
            preparedStatement.setString(1, kullanici_adi);
            preparedStatement.setString(2,parola);

            ResultSet rs = preparedStatement.executeQuery();

            return rs.next();


        } catch (SQLException ex) {
            Logger.getLogger(MyCalisanlar.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }


    }

    public ArrayList<Calisan> calisanlariGetir() {

        ArrayList<Calisan> cikti = new ArrayList<>();

        try {
            statement = con.createStatement();
            String sorgu = "Select * FROM calisanlar";
            ResultSet rs = statement.executeQuery(sorgu);

            while(rs.next()){
                int id = rs.getInt("id");
                String ad = rs.getString("ad");
                String soyad = rs.getString("soyad");
                String dep = rs.getString("departman");
                String maas = rs.getString("maas");

                cikti.add(new Calisan(id,ad,soyad,dep,maas));

            }


            return cikti;

        } catch (SQLException ex) {
            Logger.getLogger(MyCalisanlar.class.getName()).log(Level.SEVERE, null, ex);

            return null;
        }
    }




}
