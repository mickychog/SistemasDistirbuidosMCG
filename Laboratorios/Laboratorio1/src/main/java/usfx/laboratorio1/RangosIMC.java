/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usfx.laboratorio1;

/**
 *
 * @author micky
 */

class RangosIMC {
    private static String[] CATEGORIAS = {"Bajo peso", "Peso normal", "Sobrepeso", "Obesidad"};
    private static double[] RANGOS_INFERIORES = {0, 18.5, 25, 30};
    private static double[] RANGOS_SUPERIORES = {18.5, 25, 30, Double.POSITIVE_INFINITY};

    public static String clasificar(double imc) {
        for (int i = 0; i < CATEGORIAS.length; i++) {
            if (imc >= RANGOS_INFERIORES[i] && imc < RANGOS_SUPERIORES[i]) {
                return CATEGORIAS[i];
            }
        }
        return "Clasificacion no encontrada";
    }
}
