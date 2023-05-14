package element;

public class Air extends Element {
    private static final String NAME = "Air";
    private static final String PORTUGUESE_NAME = "Ar";
    public Air() {
        super(NAME, PORTUGUESE_NAME);
    }

    @Override
    public double getResistanceFactor(Element enemyElement) {
        return switch (enemyElement.getName()) {
            case "Fire" -> 2.0;
            case "Water", "Earth" -> 1.0;
            case "Air" -> 0.5;
            default -> 0;
        };
    }
}
