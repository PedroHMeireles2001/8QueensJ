import javax.swing.*;
import java.awt.*;

class Tabuleiro extends JPanel {

    private static final int TAMANHO_CELULA = 60;
    private int[] solucao;

    public Tabuleiro(int[] solucao) {
        this.solucao = solucao;
        setPreferredSize(new Dimension(TAMANHO_CELULA * 8, TAMANHO_CELULA * 8));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        desenharTabuleiro(g);
        desenharRainhas(g);
    }

    private void desenharTabuleiro(Graphics g) {
        for (int linha = 0; linha < 8; linha++) {
            for (int coluna = 0; coluna < 8; coluna++) {
                if ((linha + coluna) % 2 == 0) {
                    g.setColor(Color.WHITE);
                } else {
                    g.setColor(Color.GRAY);
                }
                g.fillRect(coluna * TAMANHO_CELULA, linha * TAMANHO_CELULA, TAMANHO_CELULA, TAMANHO_CELULA);
            }
        }
    }

    private void desenharRainhas(Graphics g) {
        g.setColor(Color.RED);
        for (int coluna = 0; coluna < 8; coluna++) {
            int linha = solucao[coluna];
            int x = coluna * TAMANHO_CELULA;
            int y = linha * TAMANHO_CELULA;
            g.fillOval(x + 10, y + 10, TAMANHO_CELULA - 20, TAMANHO_CELULA - 20);
        }
    }

    public static void criarJanela(int[] solucao, int geracao) {
        JFrame frame = new JFrame("Tabuleiro das 8 Rainhas, geração: " + geracao);
        Tabuleiro tabuleiro = new Tabuleiro(solucao);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(tabuleiro);
        frame.pack();
        frame.setLocationRelativeTo(null); // Centraliza a janela
        frame.setVisible(true);
    }
}