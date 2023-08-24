import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Gerenciador {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        Jogo[] jogo = new Jogo[5];
        int escolha = 0;

        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("O que desejas?");
            System.out.println("1 - Iniciar Jogo");
            System.out.println("2 - Salvar Jogo em um arquivo");
            System.out.println("3 - Carregar Jogo de um arquivo");
            System.out.println("4 - Sair");
            escolha = sc.nextInt();

            if(escolha == 1){
                jogo[0] = new Jogo();
                jogo[0].iniciarJogo();
                System.out.println("O jogo acabou, parabens ao vencedor? Deseja encerrar o programa?\n Digite 4 para encerrar e qualquer outra para continuar");
                int escolha2 = 0;
                escolha2 = sc.nextInt();
                if(escolha2 == 4){
                    break;
                }
            }
            if(escolha == 2){
                //salvarJogo();
                int a = 0;
            }
            if(escolha == 2){
                //CarregarJogo();
                int a = 0;
            }
            if(escolha == 4){
                break;
            }
        }


    }
}