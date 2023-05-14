package element;

public class Water extends Element {
    private static final String NAME = "Water";
    private static final String PORTUGUESE_NAME = "Água";

    public Water() {
        super(NAME, PORTUGUESE_NAME);
    }

    @Override
    public double getResistanceFactor(Element enemyElement) {
        return switch (enemyElement.getName()) {
            case "Earth" -> 2.0;
            case "Air", "Fire" -> 1.0;
            case "Water" -> 0.5;
            default -> 0;
        };
    }
}
