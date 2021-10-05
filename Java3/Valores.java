import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Valores {

    public static void main(String[] args) {

        try {
            int valor1 = Integer.parseInt(args[0]);
            int valor2 = Integer.parseInt(args[1]);

            System.out.println("A área dos valores é: " + (valor1 * valor2));

        } catch (Exception e) {
            System.out.println("Erro de execução: " + e.getMessage());
        }
    }
}