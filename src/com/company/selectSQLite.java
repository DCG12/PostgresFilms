package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by 46406163y on 09/01/17.
 */
public class selectSQLite {

    public static void main(String[] args)
    {
        extreuActors();
        extreuMovies();
    }

    public static void extreuActors(){
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://172.31.73.192:5432/jerry","davidc", "davidc");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM ACTORES;" );
            while ( rs.next() ) {
                int id = rs.getInt("idAct");
                String  name = rs.getString("Nombre");
                System.out.println( "ID = " + id );
                System.out.println( "NAME = " + name );
            }
            rs.close();
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Operation done successfully");
    }

    public static void extreuMovies(){
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://172.31.73.192:5432/jerry","davidc", "davidc");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM MOVIES;" );
            while ( rs.next() ) {
                int id = rs.getInt("idMovie");
                String  name = rs.getString("titulo");
                String fecha = rs.getString("fecha");
                System.out.println( "ID = " + id + " TITULO= " + name + " FECHA= " + fecha);
            }
            rs.close();
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Operation done successfully");
    }
    public static void extreuPersonatjes(){
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://172.31.73.192:5432/jerry","davidc", "davidc");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM AXM;" );
            while ( rs.next() ) {
                int movie_id = rs.getInt("MovieId");
                int actor_id = rs.getInt("idActor");
                int cast_id = rs.getInt("cast_id");
                String  character = rs.getString("Personaje");
                System.out.println(" PERSONATGE = " + character + "iD PELICULA = " + movie_id + " ID ACTOR = " + actor_id + " ID CAST = " + cast_id );
            }
            rs.close();
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Operation done successfully");
    }
    public static void extreuPersonajeSegonsId(){
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://172.31.73.192:5432/jerry","davidc", "davidc");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            Main m = new Main();
            int aux1 = m.idact;
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT Personaje FROM AXM WHERE (idActor =  "+aux1+"  );" );
            while ( rs.next() ) {/*
                int movie_id = rs.getInt("MovieId");
                int actor_id = rs.getInt("idActor");
                int cast_id = rs.getInt("cast_id");*/
                String  character = rs.getString("Personaje");
                System.out.println(" PERSONATGE = " + character);
            }
            rs.close();
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Operation done successfully");
    }

}
