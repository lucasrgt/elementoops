package element;

import console.ConsoleColors;

public class Water extends Element {
    private static final String NAME = "Water";
    private static final String PORTUGUESE_NAME = "Água";
    public static final String CONSOLE_COLOR_CODE = ConsoleColors.CYAN;

    public Water() {
        super(NAME, PORTUGUESE_NAME, CONSOLE_COLOR_CODE);
    }

    @Override
    public double getResistanceFactor(Element element) {
        return switch (element.getName()) {
            case "Earth" -> 2.0;
            case "Air", "Fire" -> 1.0;
            case "Water" -> 0.5;
            default -> 0;
        };
    }
}
