import javax.swing.*;

public class Main {
    private static final int MAX_GERACOES = 1000;

    public static void main(String[] args) {
        resolverProblema();
    }

    public static void resolverProblema(){
        int geracao = 0;
        Geracao geracaoAtual = new Geracao();
        while (geracao <= MAX_GERACOES){
            geracao++;
            Individuo[] melhores = geracaoAtual.getMelhores();
            Individuo primeiro = melhores[0];
            if(primeiro.getAptidao() == 0) {
                int finalGeracao = geracao;
                SwingUtilities.invokeLater(() -> Tabuleiro.criarJanela(primeiro.getGenes(), finalGeracao));
                return;
            }
            Individuo segundo = melhores[1];
            geracaoAtual = new Geracao(primeiro,segundo);
        }
        System.out.println("Solução não encontrada");
    }
}
