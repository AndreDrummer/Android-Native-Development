package br.com.marcomaddo.view;

import java.io.IOException;

/*
    Criar um game para receber letras digitadas via Teclado
    Tratamento de Error
    Switch Case Statement
*/

public class JavaGame {
    public static void main(String[] args) throws IOException {
        System.out.println("Digite uma  das letras da palavra Aplicativos: ---> ");
        int codeAscII = System.in.read();        

        switch((char) codeAscII) {
            case 'A':
            case 'p':
            case 'l':
            case 'i':
            case 'c':
            case 't':
            case 'o':
            case 'n':
            case 's':
            case 'a':
            case 'P':
            case 'L':
            case 'I':
            case 'C':
            case 'T':
            case 'O':
            case 'N':
            case 'S':
                System.out.println("Letra digitada "+(char) codeAscII);
                break;
            default:
                System.out.println("Letra digitada não pertence a palavra Aplicativos");
                
            
        }
    }
}