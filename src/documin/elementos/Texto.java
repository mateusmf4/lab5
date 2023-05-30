package documin.elementos;

public class Texto extends Elemento {
    public Texto(int prioridade, String valor) {
        super(prioridade, valor);
    }

    @Override
    public String getVersaoCompleta() {
        return valor;
    }

    @Override
    public String getVersaoResumida() {
        return valor;
    }
}
