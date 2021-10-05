import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.ArrayList;

public class Atividade {
    public static void main(String args[]) {
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("---- 1° ATIVIDADE AVALIATIVA ---- ");
        
        try{
            //buffer inicial e conta a quantidade de linhas do arquivo
            BufferedReader leitura = new BufferedReader(new FileReader("./NaoOrdenado.txt"));
            String value = "";
            int cont = 0;
            
            while ((value = leitura.readLine()) != null){
                cont ++;
            }
            leitura.close();

            //array com o tamanho das linhas
            int[] array = new int [cont];
            cont = 0;
            
            //Leio novamente o arquivo de buffer
            leitura = new BufferedReader(new FileReader("./NaoOrdenado.txt"));
            value = "";

            while((value = leitura.readLine()) != null) {
                //Aloco os valores nas posições
                int num = Integer.parseInt(value);
                array[cont] = num;
                cont++;
            }
            leitura.close();
            
            System.out.println("---- Ordenação InsertionSort ---- ");
            for (int i = 0; i < array.length; i++) {
                int atual = array[i];
                int j = i - 1;
                while (j >= 0 && array[j] >= atual) {
                    array[j + 1] = array[j];
                    j--;
                }
                array[j + 1] = atual;
            System.out.println(Arrays.toString(array)); //imprimindo a ordenação InsertionSort
            }

            ArrayList<Integer> lista = new ArrayList<>();
            for (int i = 0; i < array.length; i++) {
                lista.add(array[i]);
            }
            BufferedWriter impressao = new BufferedWriter(new FileWriter("Ordenados.txt"));//criando um arquivo para alocar os números ordenados.

            System.out.println("\nArray: ");    //imprimindo o array
            for (int i = 0; i < array.length; i++) {
                System.out.println(array[i]);
                impressao.append("\n" + array[i]);
            }

            System.out.println("\nCollection: ");   //imprimindo a collection ordenada
            for (int collection:lista){
                System.out.println(collection);
            }             
            impressao.close();
            
        } catch (IOException exception){
            System.out.println("Erro de exceção I/O: " + exception.getMessage());
        } scanner.close();
    } 
}
