package com.company.model;

import java.sql.*;

public class DatabaseConnection {

    private static  String DB_USER_NAME ="root";
    private static  String DB_PASSWORD = "1994ugur";
    private static   int DB_PORT = 3306;
    private static  String DB_NAME ="music_project";


    //ALBUM
    public static final String TABLE_ALBUM = "album";
    public static final String COLUMN_ALBUM_NAME = "albumName";
    public static final String COLUMN_ALBUM_SINGERID= "singerID";

    //SINGER
    public static final String TABLE_SINGER= "singer";
    public static final String COLUMN_SINGERID= "singerID";
    public static final String COLUMN_SINGERNAME = "singerName";

    //SONG
    public static final String TABLE_SONG= "song";
    public static final String COLUMN_SONGID= "songID";
    public static final String COLUMN_SONGNAME = "songName";
    public static final String COLUM_SONG_ALBUMID = "albumID";


    private Connection con = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;

    //CONNECT & CONSTRUCTOR
    public DatabaseConnection(){
        String url = "jdbc:mysql://localhost:"+DB_PORT+"/"+DB_NAME+"?useUniCode=true&characterEncoding=utf8";

        try {
            con = DriverManager.getConnection(url,DB_USER_NAME,DB_PASSWORD);
            System.out.println("DB BAĞLANTISI BAŞARILI...");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

}
