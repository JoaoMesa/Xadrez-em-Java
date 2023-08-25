import java.util.Scanner;
import java.io.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Gerenciador {
    public static void main(String[] args) {
        int nJogos = 0;
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
                System.out.println("O jogo acabou, parabens ao vencedor!");
                nJogos ++;
                
            }
            if(escolha == 2){
                int qualJogo = 0;
                if(nJogos > 0){
                    System.out.println("Qual jogo deseja carregar?\n");
                for(int i = 0; i < nJogos; i++){
                    System.out.println("Jogo " + i+1);
                }
                qualJogo = sc.nextInt();
                String Moves = jogo[qualJogo-1].criaRegistro(); 
                //System.out.println(Moves);
                String[] moves = Moves.split(" ");
                try {
                    FileWriter writer = new FileWriter("moves.txt"); 
                    writer.write(jogo[qualJogo-1].getNome1() + " - peças brancas\n");
                    writer.write(jogo[qualJogo-1].getNome2() + " - peças pretas\n");
                    for (String move : moves) {
                        writer.write(move + System.lineSeparator()); 
                    }
                    writer.close(); // Fechar o FileWriter
                    System.out.println("Jogadas de xadrez foram escritas no arquivo.");
                    } catch (IOException e) {
                        System.out.println("Ocorreu um erro ao escrever no arquivo.");
                        e.printStackTrace();
                    }
                }
            }
            if(escolha == 3){
                System.out.println("De qual arquivo pegar as jogadas?");
                String nome = sc.next();
                System.out.println(nome);
                try {
                FileReader reader = new FileReader(nome + ".txt");
                BufferedReader bufferedReader = new BufferedReader(reader);
                String line;
                int lineCount = 0;
                while ((line = bufferedReader.readLine()) != null) {
                lineCount++;
                if (lineCount >= 3) {
                    // Processar cada linha a partir da terceira linha do arquivo como uma jogada de xadrez
                    System.out.println("Processando jogada: " + line);
                }
            }

            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao ler o arquivo.");
            e.printStackTrace();
        }
            }
            if(escolha == 4){
                System.out.println("Fechando o jogo! Muito obrigado!");
                break;
            }
        }


    }
}