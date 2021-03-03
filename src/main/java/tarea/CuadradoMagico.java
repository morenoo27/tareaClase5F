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

            for (int i = 0; i < matriz[fila].length; i++) {

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

            for (int i = 0; i < matriz.length; i++) {

                resultado += matriz[i][columna];
            }

            return resultado;
        }
    }

    public void sumarDiagonalPrincipal() {

    }

    public void sumarDiagonalSecundaria() {

    }

    public boolean isMagic() {

        //creamos array para almacenar los datos de las sumas tanto de filas
        //como de columnas
        int[] sumaFilas = new int[this.matriz.length];
        int[] sumaColumnas = new int[this.matriz.length];

        boolean filas = analizarFilas(sumaFilas);
        boolean columnas = analizarColumnas(sumaColumnas);
        boolean dP = false, dS = false;

        if (filas && columnas && dP && dS) {
            return true;
        } else {
            return false;
        }
    }

    private boolean analizarFilas(int[] sumaFilas) {

        boolean filas = false;

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

    private boolean analizarColumnas(int[] sumaColumnas) {
        return false;

    }
}
