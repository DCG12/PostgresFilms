package com.company;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by 46406163y on 09/01/17.
 */
public class themovieDBproject {

    public static String getHTML(String urlToRead) throws Exception {
        StringBuilder result = new StringBuilder();
        URL url = new URL(urlToRead);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }
        rd.close();
        return result.toString();
    }

    public static void main(String[] args){
        pelis();
        actores();
        personajes();
    }

    public static void pelis() {
        String s = "";
        String api_key = "22dc8ee0cdffaed336cb797e630ad06f";

        for (int i = 0; i < 100; i++) {
            int peli = 600 + i;
            String film = String.valueOf(peli);
            String peticio = "https://api.themoviedb.org/3/movie/" + film + "?api_key=" + api_key;
            try {
                s = getHTML(peticio);
                SJS(s);
            } catch (Exception e) {
                System.out.println("La peli " + film + " no existeix");
            }
        }
    }

    public static void actores() {
        String c = "";
        String api_key = "22dc8ee0cdffaed336cb797e630ad06f";

        for (int i = 0; i < 100; i++) {
            int peli = 1 + i;
            String film = String.valueOf(peli);
            String peticio2 = "https://api.themoviedb.org/3/person/" + film + "?api_key=" + api_key;
            try {
                c = getHTML(peticio2);
                SJC(c);
            } catch (Exception e) {
                System.out.println("El actor " + film + " no existeix");
            }
        }
    }

    public static void personajes() {
        String m = "";
        String api_key = "22dc8ee0cdffaed336cb797e630ad06f";

        for (int i = 0; i < 100; i++) {
            int peli = 600 + i;
            String film = String.valueOf(peli);
            String peticio3 = "https://api.themoviedb.org/3/movie/" + film + "/credits?api_key=22dc8ee0cdffaed336cb797e630ad06f";
            try {
                m = getHTML(peticio3);
                SJP(m);
            } catch (Exception e) {
                System.out.println("La pelicula " + film + " no existeix");
            }
        }
    }

    public static void SJS(String cadena) {

        Object obj02 = JSONValue.parse(cadena);
        JSONObject arra02 = (JSONObject) obj02;
        System.out.println(arra02.get("original_title"));
        System.out.println(arra02.get("release_date"));

        insertSQLite.listaMovies(arra02.get("original_title").toString(), Integer.parseInt(arra02.get("id").toString()), arra02.get("release_date").toString());

    }

    public static void SJC(String cadena) {

        Object obj02 = JSONValue.parse(cadena);
        JSONObject arra02 = (JSONObject) obj02;

        int id = Integer.parseInt(arra02.get("id").toString());
        String nomActor = arra02.get("name").toString();
        insertSQLite.listaActores(id,nomActor);

    }

    public static void SJP(String cadena) {
        Object obj02 = JSONValue.parse(cadena);
        JSONObject arra02 = (JSONObject) obj02;
        JSONArray arra03 = (JSONArray) arra02.get("cast");


        for (int i = 0; i < arra03.size(); i++) {

            JSONObject jb = (JSONObject) arra03.get(i);

            insertSQLite.listaPersonajes(Integer.parseInt(arra02.get("id").toString()), Integer.parseInt(jb.get("id").toString()), Integer.parseInt(jb.get("cast_id").toString()), jb.get("character").toString());
        }
    }
}
