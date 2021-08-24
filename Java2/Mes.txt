//Crie um programa que receba um número e indique o mês que representa.
import java.util.Scanner;

public class ListaExercicios2 {
    public static void main(String args[]) {
      Scanner scanner = new Scanner(System.in);
      
      System.out.println("------ DIGITE UM NÚMERO PARA SABER O MÊS ------");
      
      System.out.println("Digite um número inteiro:");
      int num = scanner.nextInt();
        
        if(num == 1)
        {
        System.out.println("Janeiro");
        }
        
        if(num == 2)
        {
        System.out.println("Fevereiro");
        }
        
        if(num == 3)
        {
        System.out.println("Março");
        }
        
        if(num == 4)
        {
        System.out.println("Abril");
        }
        
        if(num == 5)
        {
        System.out.println("Maio");
        }
        
        if(num == 6)
        {
        System.out.println("Junho");
        }
        
        if(num == 7)
        {
        System.out.println("Julho");
        }
        
        if(num == 8)
        {
        System.out.println("Agosto");
        }
        
        if(num == 9)
        {
        System.out.println("Setembro");
        }
        
        if(num == 10)
        {
        System.out.println("Outubro");
        }
        
        if(num == 11)
        {
        System.out.println("Novembro");
        }
        
        if(num == 12)
        {
        System.out.println("Desembro");
        }
        scanner.close();
        }
}

