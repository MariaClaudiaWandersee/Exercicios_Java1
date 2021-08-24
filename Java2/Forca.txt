import java.util.Scanner;

public class forca {
  public static void main(String args[]) {

    Scanner scanner = new Scanner(System.in);
    String palavraOculta = "";
    String palavraInformada = "";

    System.out.println("Informe a palavra oculta: ");
    palavraOculta = scanner.next();

    System.out.println("\nQuantidade de tentativas: 6");

    for (int tentativas = 5; tentativas >= 0; --tentativas) {

      System.out.println("\nDigite a sua tentativa: ");
      palavraInformada = scanner.next();

      if (palavraInformada.equals(palavraOculta)) {
        System.out.println("\n***Parabéns, você acertou e não foi enforcado!***");
        break;
      } else if (tentativas == 5) {
        System.out.println("\n\tVocê perdeu a cabeça");
      } else if (tentativas == 4) {
        System.out.println("\n\tVocê perdeu o tronco");
      } else if (tentativas == 3) {
        System.out.println("\n\tVocê perdeu um braço");
      } else if (tentativas == 2) {
        System.out.println("\n\tVocê perdeu o outro braço");
      } else if (tentativas == 1) {
        System.out.println("\n\tVocê perdeu uma perna");
      } else {
        System.out.println("\n\tVocê perdeu a outra perna e foi enforcado. | Game Over");
      }
    }

  }
}