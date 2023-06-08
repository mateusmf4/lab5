package documin.elementos;

/**
 * Todas as ordenações que podem ser utilizadas em Termos
 */
public enum OrdemTermos {
    NENHUM,
    ALFABETICA,
    TAMANHO;

    /**
     * Converte uma string para um valor do enumerador.
     * @param ordem O nome da ordem
     * @return O enumerador da ordem
     */
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
