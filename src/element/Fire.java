package element;

import console.ConsoleColors;

public class Fire extends Element {
    private static final String NAME = "Fire";
    private static final String PORTUGUESE_NAME = "Fogo";
    public static final String CONSOLE_COLOR_CODE = ConsoleColors.RED;

    public Fire() {
        super(NAME, PORTUGUESE_NAME, CONSOLE_COLOR_CODE);
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
