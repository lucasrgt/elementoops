package element;

public class Earth extends Element {
    private static final String NAME = "Earth";
    private static final String PORTUGUESE_NAME = "Terra";
    public Earth() {
        super(NAME, PORTUGUESE_NAME);
    }

    @Override
    public double getResistanceFactor(Element enemyElement) {
        return switch (enemyElement.getName()) {
            case "Air" -> 2.0;
            case "Water", "Fire" -> 1.0;
            case "Earth" -> 0.5;
            default -> 0;
        };
    }
}
