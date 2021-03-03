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
}
