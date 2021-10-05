//Crie um programa que leia e imprima no console todas as linhas de um arquivo de texto.

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class LerImprimirTXT {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("---- IMPRESSÃO E LEITURA DE UM TXT ---- ");

        try{
            BufferedReader leitura = new BufferedReader(new FileReader("./Java3.txt"));
            String value = "";
            while (true){
                if(value != null)
                    System.out.println(value);
                else
                    break;
                
                value = leitura.readLine();

            }
            leitura.close();
        } catch (IOException exception){
            System.out.println("Erro de exceção I/O: " + exception.getMessage());
        } scanner.close();
    } 
}