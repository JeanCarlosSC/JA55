package model;

/**
 *
 * @author Jean Carlos Santoya Cabrera
 */
public class Calculator {
    public static double indiceDeMasaCorporal(double pesoEnKg, double alturaEnCm) {
        double alturaEnM = alturaEnCm / 100.0;
        return pesoEnKg / (alturaEnM * alturaEnM);
    }
    
    public static String getClasification(double imc) {
        if(imc <= 0) {
            return "";
        }
        if(imc < 18.5) {
            return "peso insuficiente";
        }
        if(imc < 24.9) {
            return "peso normal o saludable";
        }
        if(imc < 29.9) {
            return "sobrepeso";
        }
        return "obeso.";
    }
}
