package com.jurgo;

import java.util.Random;
import java.util.Scanner;

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

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        while (true) {
            imprimirMapa(mapa);
            System.out.print("Ingrese movimiento (w/a/s/d): ");
            char movimiento = scanner.next().charAt(0);
            realizarMovimiento(mapa, movimiento, personaje);
        }

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
    private static void realizarMovimiento(String[][] mapa, char movimiento, int[] personaje) {
        int nuevaX = personaje[0];
        int nuevaY = personaje[1];

        if (movimiento == 'w') {
            nuevaX--;
        } else if (movimiento == 's') {
            nuevaX++;
        } else if (movimiento == 'a') {
            nuevaY--;
        } else if (movimiento == 'd') {
            nuevaY++;
        } else {
            System.out.println("Movimiento inválido");
            return;
        } if (esMovimientoValido(mapa, nuevaX, nuevaY)){
            moverPersonaje(mapa, nuevaX, nuevaY, personaje);
        }
    }
    private static boolean esMovimientoValido(String[][] mapa, int nuevaX, int nuevaY){
        if (nuevaX < 0 || nuevaX >= mapa.length || nuevaY < 0 || nuevaY >= mapa[0].length) {
            System.out.println("Movimiento fuera de los limites");
            return false;
        } else if (mapa[nuevaX][nuevaY].equals("#")){
            System.out.println("No puedes atravesar un obstáculo");
            return false;
        }
        return true;
    }
    private static void moverPersonaje(String[][]mapa, int nuevaX, int nuevaY, int[] personaje) {
        mapa[personaje[0]][personaje[1]]=".";
        personaje[0] = nuevaX;
        personaje[1] = nuevaY;
        colocarEntidad(mapa, personaje, "P");
    }
}


    

