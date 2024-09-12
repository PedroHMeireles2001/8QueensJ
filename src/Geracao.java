import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Geracao {
    List<Individuo> individuos = new ArrayList<>();
    private static final int TAMANHO_POPULACAO = 100;

    public Geracao(){
        for(int i = 0; i < TAMANHO_POPULACAO; i++){
            Individuo individuo = new Individuo();
            individuos.add(individuo);
        }
    }

    public Geracao(Individuo eva, Individuo adao){
        for(int i = 0; i < TAMANHO_POPULACAO / 2; i++){
            Individuo filho1 = eva.atosLibidinosos(adao);
            Individuo filho2 = adao.atosLibidinosos(eva);
            filho1.mutacao();
            filho2.mutacao();
            this.individuos.add(filho1);
            this.individuos.add(filho2);
        }
    }

    public Individuo[] getMelhores(){
        this.individuos.sort(Comparator.comparingInt(Individuo::getAptidao));
        return new Individuo[]{individuos.get(0),individuos.get(1)};
    }

}
