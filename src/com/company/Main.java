package com.company;

import java.util.Scanner;

public class Main {

    public static int idact;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        selectSQLite selectsql = new selectSQLite();

        int aux = -1;
        selectsql.extreuActors();
        while (aux != 0) {
            System.out.println("MENU PER VEURE LA BASE DE DADES");
            System.out.println("     ");
            System.out.println("PREMI 1 PER EXTREURE ELS ACTORS");
            System.out.println("PREMI 2 PER EXTREURE LES PELICULES");
            System.out.println("PREMI 3 PER EXTREURE ELS PERSONATGES");
            System.out.println("PREMI 4 PER EXTREURE LES PELICULES QUE HA FET UN ACTOR SEGONS EL SEU ID");
            System.out.println("PREMI 0 PER SORTIR");
            aux = sc.nextInt();
            if (aux == 1) {
                selectsql.extreuActors();
            } else if (aux == 2) {
                selectsql.extreuMovies();
            } else if (aux == 3) {
                selectsql.extreuPersonatjes();
            }
            else if (aux == 4){
                System.out.println("INTRODUIEX EL ID DEL ACTOR");
                 idact = sc.nextInt();
                selectsql.extreuPersonajeSegonsId();
            }
        }

    }
}
