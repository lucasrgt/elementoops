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
        switch (element.getName()) {
            case "Water":
                return 2.0;
            case "Earth":
            case "Air":
                return 1.0;
            case "Fire":
                return 0.5;
            default:
                return 0;
        }
    }
}
