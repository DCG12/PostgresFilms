package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

/**
 * Created by 46406163y on 09/01/17.
 */
public class insertSQLite {

    public static void listaMovies(String ORIGINAL_TITLE, int movie_id, String release_date) {

        Connection c = null;
        Statement stmt = null;
        try {

            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://172.31.73.192:5432/jerry","davidc", "davidc");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();

            String sql = "INSERT INTO MOVIES3 (idMovie, titulo, fecha) " +
                    "VALUES" + "(?, ?, ?);";

            PreparedStatement preparedstament = c.prepareStatement(sql);
            preparedstament.setInt(1, movie_id);
            preparedstament.setString(2, ORIGINAL_TITLE);
            preparedstament.setString(3, release_date);

            preparedstament.executeUpdate();

            stmt.close();
            c.commit();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Records created successfully");
    }
    public static void listaActores(int id, String name) {

        Connection c = null;
        Statement stmt = null;
        try {

            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://172.31.73.192:5432/jerry","davidc", "davidc");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();

            String sql = "INSERT INTO ACTORES3 (idAct, Nombre) " +
                    "VALUES" + "(?, ?);";

            PreparedStatement preparedstament = c.prepareStatement(sql);
            preparedstament.setInt(1, id);
            preparedstament.setString(2, name);

            preparedstament.executeUpdate();

            stmt.close();
            c.commit();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Records created successfully");
    }


    public static void listaPersonajes( int movie_id, int actor_id, int cast_id, String character) {

        Connection c = null;
        Statement stmt = null;
        try {

            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://172.31.73.192:5432/jerry","davidc", "davidc");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();

            String sql = "INSERT INTO AXM3 (movieId, idActor, cast_id, Personaje) " +
                    "VALUES" + "( ?, ?, ?, ?);";

            PreparedStatement preparedstament = c.prepareStatement(sql);

            preparedstament.setInt(1, movie_id);
            preparedstament.setInt(2, actor_id);
            preparedstament.setInt(3, cast_id);
            preparedstament.setString(4, character);

            preparedstament.executeUpdate();

            stmt.close();
            c.commit();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Records created successfully");
    }


}
