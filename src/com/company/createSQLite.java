package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * Created by 46406163y on 09/01/17.
 */
public class createSQLite {
    public static void main(String[] args) {
        {
            Connection c = null;
            Statement stmt = null;
            try {
                Class.forName("org.postgresql.Driver");
                c = DriverManager.getConnection("jdbc:postgresql://172.31.73.192:5432/jerry","davidc", "davidc");
                System.out.println("Opened database successfully");

                stmt = c.createStatement();
                String sql = "CREATE TABLE MOVIES3 " +
                        "(idMovie       INT     PRIMARY KEY     NOT NULL," +
                        " titulo        TEXT                    NOT NULL, " +
                        " fecha         VARCHAR(50)                    NOT NULL)";
                stmt.executeUpdate(sql);
                sql = "CREATE TABLE ACTORES3 " +
                        "(idAct              INT       PRIMARY KEY    NOT NULL," +
                        " Nombre          CHAR(50)                    NOT NULL )";
                stmt.executeUpdate(sql);
                sql = "CREATE TABLE AXM3 " +
                        "(movieId         INT                      NOT NULL," +
                        "idActor          INT                      NOT NULL," +
                        "cast_id          INT           NOT NULL ," +
                        " Personaje       CHAR(50)  )";
                stmt.executeUpdate(sql);
                stmt.close();
                c.close();
            } catch ( Exception e ) {
                System.err.println( e.getClass().getName() + ": " + e.getMessage() );
                System.exit(0);
            }
            System.out.println("Table created successfully");
        }

    }


}
