package documin.elementos;

public enum OrdemTermos {
    NENHUM,
    ALFABETICA,
    TAMANHO;

    public static OrdemTermos fromString(String ordem) {
        switch (ordem.toUpperCase()) {
            case "NENHUM":
                return NENHUM;
            case "ALFABETICA":
                return ALFABETICA;
            case "TAMANHO":
                return TAMANHO;
            default:
                return NENHUM;
        }
    }
}
