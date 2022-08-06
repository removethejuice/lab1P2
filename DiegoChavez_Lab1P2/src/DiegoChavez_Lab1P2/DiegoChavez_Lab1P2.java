package DiegoChavez_Lab1P2;

import java.util.Scanner;

public class DiegoChavez_Lab1P2 {

    static Scanner lea = new Scanner(System.in);

    public static void main(String[] args) {
        int numx = 0;
        int numy = 0;
        int filas = 16;
        int columnas = 8;

        /*
        El lab pide que el tamanio sea de 16x16 pero me parecio crear la oportunidad para que el usuario determinara el tamanio de la matriz como un extra
         System.out.println("Seleccione el numero de filas para la matriz");
        while(filas<=0 || columnas <=0 || filas%2!=0){
        System.out.println("Seleccione el numero de filas para la matriz");
        filas = lea.nextInt();
        System.out.println("Seleccione el numero de columnas para la matriz");
        columnas = lea.nextInt();
        }
         */
        char[][] matriz = new char[filas][columnas];

        char[][] matriz2 = new char[filas][columnas];

        char[][] matriz3 = new char[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int w = 0; w < columnas; w++) {
                matriz2[i][w] = '≈';
                matriz3[i][w] = '≈';
            }// fin del primer if
        }// fin del segundo if

        int barcos = 3;

        /*while (barcos <= 0) {
            System.out.println("Seleccione el numero de barcos para cada jugador");
            barcos = lea.nextInt();
        }// fin del while
         */
        // el conteo del jugador 1
        System.out.println("El jugador 1 tiene el tablero del 0-7 , el jugador 2 tiene el tablero del 8-15");
        for (int i = 0; i < barcos; i++) {

            System.out.println("Jugador 1 seleccione la coordenada x  de su barco #" + (i + 1));

            numx = lea.nextInt();

            System.out.println("Jugador 1 seleccione la coordenada y  de su barco #" + (i + 1));

            numy = lea.nextInt();

            if (numx >= filas / 2 || numy >= columnas || numy < 0 || numx < 0) {
                i--;
                System.out.println(" cuadrante equivocado!");
            } else {
                if (matriz2[numx][numy] == '1') {
                    i--;
                    System.out.println("Lugar ya ocupado por nave anterior");
                } else {

                    matriz2[numx][numy] = '1';
                }

            }

        }// fin del for

        // el conteo del jugador 2
        for (int i = 0;
                i < barcos;
                i++) {

            System.out.println("Jugador 2 seleccione la coordenada x  de su barco #" + (i + 1));

            numx = lea.nextInt();

            System.out.println("Jugador 2 seleccione la coordenada y  de su barco #" + (i + 1));

            numy = lea.nextInt();

            if (numx < filas / 2 || numy >= columnas || numy < 0 || numx > filas - 1) {
                i--;
                System.out.println(" cuadrante equivocado!");
            } else {
                if (matriz3[numx][numy] == '2') {
                    i--;
                    System.out.println("Lugar ya ocupado por nave anterior");
                } else {

                    matriz3[numx][numy] = '2';
                }
            }

        }// fin del for

        for (int i = 0; i < filas; i++) {
            for (int w = 0; w < columnas; w++) {
                if (i < (filas / 2) ) {

                    matriz[i][w] = matriz2[i][w];
                } else {
                    matriz[i][w] = matriz3[i][w];
                }
            }// fin del primer for

        }// fin del segundo for

        int coordx = -1;
        int coordy = -1;
        int contador = 0;
        int contador2 = 0;
        boolean bandera = true;
        boolean bandera2 = true;

        while (contador != barcos || contador2 != barcos) {
            while (bandera == true) {
                System.out.println("\n\nJUGADOR 1 QUE ATACA A 2");
                bandera = false;

                recorrerMatrizRecursivo1(matriz, 0, 0);

                while (coordx < 0 || coordx < filas / 2 - 1 || coordx < 0) {
                    System.out.println("\nProporcione las coordenadas y de su ataque");
                    coordx = lea.nextInt();
                }

                while (coordy < 0 || coordy > columnas - 1 || coordy < 0) {
                    System.out.println("Proporcione las coordenadas x de su ataque");
                    coordy = lea.nextInt();
                }
                if (matriz[coordx][coordy] == '2') {
                    bandera = true;
                    System.out.println("\nHa golpeado al enemigo!");
                    contador++;
                    matriz[coordx][coordy] = 'X';

                } else {
                    if (matriz[coordx][coordy] == '≈' || matriz[coordx][coordy] == '*' || matriz[coordx][coordy] == 'X') {
                        System.out.println("\nHa fallado!");

                        matriz[coordx][coordy] = '*';
                        if (matriz[coordx][coordy] == 'X') {
                            matriz[coordx][coordy] = 'X';
                        }

                    }
                }
                coordx = -1;
                coordy = -1;
                if (contador == barcos) {
                    bandera = false;
                    System.out.println("Victoria para el jugador 1");
                    contador2 = barcos;
                }

                recorrerMatrizRecursivo1(matriz, 0, 0);

            }// fin del primer while

            if (contador != barcos) {

                while (bandera2 == true) {
                    System.out.println("\n\nJUGADOR 2 ");
                    bandera2 = false;
                    recorrerMatrizRecursivo2(matriz, 0, 0);
                    while (coordx < 0 || coordx > filas / 2 - 1) {
                        System.out.println("\nProporcione las coordenadas y de su ataque");
                        coordx = lea.nextInt();
                    }

                    while (coordy < 0 || coordy > columnas - 1) {
                        System.out.println("Proporcione las coordenadas x de su ataque");
                        coordy = lea.nextInt();
                    }
                    if (matriz[coordx][coordy] == '1') {
                        bandera2 = true;
                        System.out.println("Ha golpeado al enemigo!");
                        contador2++;
                        matriz[coordx][coordy] = 'X';
                    } else {
                        if (matriz[coordx][coordy] == '≈' || matriz[coordx][coordy] == '*' || matriz[coordx][coordy] == 'X') {
                            System.out.println("Ha fallado");
                            matriz[coordx][coordy] = '*';
                            if (matriz[coordx][coordy] == 'X') {
                                matriz[coordx][coordy] = 'X';
                            }
                        }
                    }

                    coordx = -1;
                    coordy = -1;

                    if (contador2 == barcos) {
                        bandera2 = false;
                        System.out.println("Victoria para el jugador 2");
                        contador = barcos;
                    }

                    recorrerMatrizRecursivo2(matriz, 0, 0);

                }// fin del primer while del segundo ciclo
            }// fin del if
        } // fin del primerisimo if
    }// fin del main

    public static void recorrerMatrizRecursivo(char[][] m, int i, int j) {

        System.out.print(m[i][j] + " ");

        if (i != m.length - 1 || j != m[i].length - 1) {

            if (j == m[i].length - 1) {
                i++;
                j = 0;
                System.out.println("");
            } else {
                j++;
            }

            recorrerMatrizRecursivo(m, i, j);

        }
    }

    public static void recorrerMatrizRecursivo1(char[][] matriz, int i, int j) {
        if (matriz[i][j] != '2') {
            System.out.print(matriz[i][j] + " ");
        } else {
            System.out.print('≈' + " ");
        }
        if (i != matriz.length - 1 || j != matriz[i].length - 1) {

            if (j == matriz[i].length - 1) {
                i++;
                j = 0;
                System.out.println("");
            } else {
                j++;
            }

            recorrerMatrizRecursivo1(matriz, i, j);

        }
    }

    public static void recorrerMatrizRecursivo2(char[][] matriz, int i, int j) {
        if (matriz[i][j] != '1') {
            System.out.print(matriz[i][j] + " ");
        } else {
            System.out.print('≈' + " ");
        }
        if (i != matriz.length - 1 || j != matriz[i].length - 1) {

            if (j == matriz[i].length - 1) {
                i++;
                j = 0;
                System.out.println("");
            } else {
                j++;
            }

            recorrerMatrizRecursivo2(matriz, i, j);

        }
    }

}// fin del class
