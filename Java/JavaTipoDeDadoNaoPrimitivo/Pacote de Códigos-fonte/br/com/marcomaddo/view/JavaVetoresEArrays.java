package br.com.marcomaddo.view;

public class JavaVetoresEArrays {
    public static void main(String[] args) {
        Integer numeros[] = { 0, 2, 3, 4, 5, 6 ,7, 8, 9 };
        int numeros2[] = { 0, 2, 3, 4, 5, 6 ,7, 8, 9 };
        Double doubles[] = { 0.0, 2.0};
        double doubles2[] = { 0.0, 2.2};

        System.out.println(""+numeros+numeros2+doubles+doubles2);
        
        // For Each in Java
        for(Double d : doubles) {
            System.out.println(""+d);
        }
    }
}