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
        switch (element.getName()) {
            case "Earth":
                return 2.0;
            case "Air":
            case "Fire":
                return 1.0;
            case "Water":
                return 0.5;
            default:
                return 0;
        }
    }
}
