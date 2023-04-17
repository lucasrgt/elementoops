package element;

import console.ConsoleColors;

public class Earth extends Element {
    private static final String NAME = "Earth";
    private static final String PORTUGUESE_NAME = "Terra";
    public static final String CONSOLE_COLOR_CODE = ConsoleColors.GREEN;

    public Earth() {
        super(NAME, PORTUGUESE_NAME, CONSOLE_COLOR_CODE);
    }

    @Override
    public double getResistanceFactor(Element element) {
        return switch (element.getName()) {
            case "Air" -> 2.0;
            case "Water", "Fire" -> 1.0;
            case "Earth" -> 0.5;
            default -> 0;
        };
    }
}
