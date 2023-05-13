package element;

public abstract class Element {
    private final String name;
    private final String portugueseName;

    public Element(String name, String portugueseName) {
        this.name = name;
        this.portugueseName = portugueseName;
    }

    /**
     * Força a implementação do fator de resistência nas criaturas dependendo do elemento dos inimigos.
     */
    public abstract double getResistanceFactor(Element element);

    public String getName() {
        return name;
    }
    public String getPortugueseName() {
        return portugueseName;
    }
}
