package com.jurgo;


public class Juego {
    public static void main(String[] args) {
        String[][] mapa = crearMapa();


        int[] personaje = crearPersonaje(4, 5);
        int[] enemigo1 = crearEnemigo(2, 3);
        int[] enemigo2 = crearEnemigo(1, 8);

        colocarEntidad(mapa, personaje, "P");  
        colocarEntidad(mapa, enemigo1, "E");  
        colocarEntidad(mapa, enemigo2, "E");

        imprimirMapa(mapa);

    }


    
    public static String[][] crearMapa() {
        String[][] mapa = {
            {"#", "#", "#", "#", "#", "#", "#", "#", "#", "#"},
            {"#", "X", ".", "#", ".", "#", ".", ".", ".", "#"},
            {"#", ".", ".", ".", ".", ".", ".", "#", ".", "#"},
            {"#", "#", "#", ".", ".", "#", ".", "#", ".", "#"},
            {"#", ".", ".", ".", "#", ".", "#", "#", ".", "#"},
            {"#", ".", ".", "#", "#", ".", "#", "#", ".", "#"},
            {"#", ".", ".", ".", "#", ".", "#", "#", ".", "#"},
            {"#", "#", ".", "#", "#", ".", ".", ".", "C", "#"},
            {"#", ".", ".", ".", "C", ".", ".", ".", ".", "#"},
            {"#", "#", "#", "#", "#", "#", "#", "#", "#", "#"}
        };
        return mapa;
    }
    public static void imprimirMapa(String[][] mapa) {
        for (int fila = 0; fila < 10; fila++) {
            for (int col = 0; col < 10; col++) {
                System.out.print(mapa[fila][col] + " ");
            }
            System.out.println(); 
        }
    }
    public static int[] crearPersonaje(int x, int y) {
        int[] personaje = new int[4];  
        personaje[0] = x;  
        personaje[1] = y;  
        personaje[2] = 100;  
        personaje[3] = 15;  
        return personaje;
    }
    public static int[] crearEnemigo(int x, int y) {
        int[] enemigo = new int[4];  
        enemigo[0] = x;  
        enemigo[1] = y; 
        enemigo[2] = 45;  
        enemigo[3] = 10;  
        return enemigo;
    }
    public static void colocarEntidad(String[][] mapa, int[] entidad, String simbolo) {
        int x = entidad[0];
        int y = entidad[1];
        mapa[x][y] = simbolo;  
    }
}
