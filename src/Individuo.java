import java.util.Random;

public class Individuo {
    private int[] genes;
    private static final int TAMANHO_TABULEIRO = 8;
    private static final double TAXA_MUTACAO = 0.05;
    private final Random random = new Random();

    public Individuo(){
        genes = new int[TAMANHO_TABULEIRO];
        for(int i = 0; i < TAMANHO_TABULEIRO;i++){
            genes[i] = new Random().nextInt(TAMANHO_TABULEIRO);
        }
    }

    public Individuo(int[] genes){
        this.genes = genes;
    }

    public int getAptidao() {
        int conflitos = 0;
        for (int i = 0; i < genes.length; i++) {
            for (int j = i + 1; j < genes.length; j++) {
                if (genes[i] == genes[j] || Math.abs(genes[i] - genes[j]) == Math.abs(i - j)) {
                    conflitos++;
                }
            }
        }
        return conflitos;
    }

    public Individuo atosLibidinosos(Individuo parceiro){
        int pontoCorte = random.nextInt(TAMANHO_TABULEIRO);
        int[] novoGenes = new int[TAMANHO_TABULEIRO];

        for (int i = 0; i < pontoCorte; i++) {
            novoGenes[i] = this.genes[i];
        }
        for (int i = pontoCorte; i < TAMANHO_TABULEIRO; i++) {
            novoGenes[i] = parceiro.genes[i];
        }

        return new Individuo(novoGenes);
    }

    public void mutacao(){
        if(random.nextDouble() <= TAXA_MUTACAO){
            genes[random.nextInt(TAMANHO_TABULEIRO)] = random.nextInt(TAMANHO_TABULEIRO);
        }
    }

    public int[] getGenes(){
        return this.genes;
    }
}
