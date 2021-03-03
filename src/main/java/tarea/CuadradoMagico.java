/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea;

import java.util.Random;

/**
 *
 * @author alejandro
 */
public class CuadradoMagico {

    private int[][] matriz;

    private static Random random = new Random();

    public CuadradoMagico() {
        this.matriz = new int[3][3];

        llenarMatriz();
    }

    public int[][] getMatriz() {
        return matriz;
    }

    public void setMatriz(int orden) {

        this.matriz = new int[orden][orden];
    }

    private void llenarMatriz() {

        for (int i = 0; i < matriz.length; i++) {

            for (int j = 0; j < matriz[i].length; j++) {

                matriz[i][j] = random.nextInt(9) + 1;
            }
        }
    }

    public void mostrarMatriz() {

        for (int i = 0; i < matriz.length; i++) {

            for (int j = 0; j < matriz[i].length; j++) {

                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    private int sumarFila(int fila) {

//        /**
//         * Como nosotros mandamos que fila queremos realment (fila 4)
//         * corresponde realmente a la fila 3 entonces lo que haremos antes de
//         * nada sera recibir la fila que queremos segun la enumeracion de los
//         * array
//         */
//        fila -= 1;
        /**
         * Tambien vamos a filtrar si la fila que queremos sumar esta dentro de
         * la matriz, si no esta dentro de la matriz la suma devolvera -1 y si
         * existe, la suma correspondiente
         */
        if (fila > matriz.length) {

            System.out.println("Esa fila no existe");
            return -1;
        } else {
            int resultado = 0;
            int i;
            for (i = 0; i < matriz[fila].length; i++) {

                resultado += matriz[fila][i];
            }

            return resultado;
        }
    }

    private int sumarColumna(int columna) {

//        /**
//         * Como nosotros mandamos que fila queremos realment (fila 4)
//         * corresponde realmente a la fila 3 entonces lo que haremos antes de
//         * nada sera recibir la fila que queremos segun la enumeracion de los
//         * array
//         */
//        columna -= 1;
        /**
         * Tambien vamos a filtrar si la columna que queremos sumar esta dentro
         * de la matriz, si no esta dentro de la matriz la suma devolvera -1 y
         * si existe, la suma correspondiente
         *
         * Como la matriz deducimos que sera cuadrada, con comprobarlo con la
         * columna 0 nos valdria
         */
        if (columna > matriz.length) {

            System.out.println("Esa columna no existe");

            return -1;
        } else {
            int resultado = 0;

            int i;
            for (i = 0; i < matriz.length; i++) {

                resultado += matriz[i][columna];
            }

            return resultado;
        }
    }

    public int sumarDiagonalPrincipal() {

        int resultado = 0;

        for (int i = 0; i < matriz.length; i++) {

            for (int j = 0; j < matriz[i].length; j++) {

                if (i + j == matriz.length - 1) {//para filtrar que esta en la diagonal
                    resultado += matriz[i][j];
                }
            }
        }

        return resultado;
    }

    public int sumarDiagonalSecundaria() {

        int resultado = 0;

        for (int i = 0; i < matriz.length; i++) {

            resultado += matriz[i][i];
        }

        return resultado;
    }

    public boolean isMagic() {

        //creamos array para almacenar los datos de las sumas tanto de filas
        //como de columnas
        boolean filas = analizarFilas();
        boolean columnas = analizarColumnas();
        boolean dP = sumarDiagonalPrincipal() == 10;
        boolean dS = sumarDiagonalSecundaria() == 10;

        if (filas && columnas && dP && dS) {

            return true;
        } else {

            return false;
        }
    }

    private boolean analizarFilas() {

        boolean filas = false;

        int[] sumaFilas = new int[this.matriz.length];

        //recorremos cada una de las filas y almacenamos su resultado
        for (int i = 0; i < matriz.length; i++) {

            sumaFilas[i] = this.sumarFila(i);

            /**
             * Una vez hemos sumado todas las filas, comprobamos que odas y cada
             * una de ellas su suma sea igual a 10, para asi poner que la matriz
             * cumple este requisito para ser cuadrado magico
             */
            if (sumaFilas[i] == 10) {
                filas = true;
            } else {
                filas = false;
            }
        }

        if (filas) {
            return true;
        } else {
            return false;
        }
    }

    private boolean analizarColumnas() {

        boolean columnas = false;

        int[] sumaColumnas = new int[this.matriz.length];

        //recorremos cada una de las columnas y almacenamos su resultado
        for (int i = 0; i < matriz.length; i++) {

            sumaColumnas[i] = this.sumarColumna(i);

            /**
             * Una vez hemos sumado todas las filas, comprobamos que odas y cada
             * una de ellas su suma sea igual a 10, para asi poner que la matriz
             * cumple este requisito para ser cuadrado magico
             */
            if (sumaColumnas[i] == 10) {
                columnas = true;
            } else {
                columnas = false;
            }
        }

        if (columnas) {
            return true;
        } else {
            return false;
        }
    }
}
