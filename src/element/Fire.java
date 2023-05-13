package element;

public class Fire extends Element {
    private static final String NAME = "Fire";
    private static final String PORTUGUESE_NAME = "Fogo";

    public Fire() {
        super(NAME, PORTUGUESE_NAME);
    }

    @Override
    public double getResistanceFactor(Element element) {
        return switch (element.getName()) {
            case "Water" -> 2.0;
            case "Earth", "Air" -> 1.0;
            case "Fire" -> 0.5;
            default -> 0;
        };
    }
}
