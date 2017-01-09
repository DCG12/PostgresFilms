package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        selectSQLite selectsql = new selectSQLite();

        int aux = 0;
        selectsql.extreuActors();
        while (aux != 4) {
            System.out.println("MENU PER VEURE LA BASE DE DADES");
            System.out.println("     ");
            System.out.println("PREMI 1 PER EXTREURE ELS ACTORS");
            System.out.println("PREMI 2 PER EXTREURE LES PELICULES");
            System.out.println("PREMI 3 PER EXTREURE ELS PERSONATGES");
            System.out.println("PREMI 4 PER SORTIR");
            aux = sc.nextInt();
            if (aux == 1) {
                selectsql.extreuActors();
            } else if (aux == 2) {
                selectsql.extreuMovies();
            } else if (aux == 3) {
                selectsql.extreuPersonatjes();
            }

        }

    }
}
