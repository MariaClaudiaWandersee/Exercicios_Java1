//Crie um programa que receba um valor e calcule a tabuada deste valor, salvando seu resultado em um arquivo de texto.

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ValueTabuada {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("---- PROGRAMA DE TABUADA ---- ");

        System.out.println("Informe um número: ");
        int script = scanner.nextInt();
        try {
            BufferedWriter escrita = new BufferedWriter(new FileWriter("./Java3.txt"));
            
            int multiplicador = 0;

            while (multiplicador <= 10) {
                int result = script * multiplicador;
                System.out.println(result);
                escrita.append(result + "\n");
                multiplicador++;
            }
            escrita.close();
        } catch (IOException exception) {
            System.out.println("Erro de exceção I/O: " + exception.getMessage());
        }
        scanner.close();
    }
}