package element;

import console.ConsoleColors;

public class Air extends Element {
    private static final String NAME = "Air";
    private static final String PORTUGUESE_NAME = "Ar";
    public static final String CONSOLE_COLOR_CODE = ConsoleColors.YELLOW;

    public Air() {
        super(NAME, PORTUGUESE_NAME, CONSOLE_COLOR_CODE);
    }

    @Override
    public double getResistanceFactor(Element element) {
        switch (element.getName()) {
            case "Fire":
                return 2.0;
            case "Water":
            case "Earth":
                return 1.0;
            case "Air":
                return 0.5;
            default:
                return 0;
        }
    }
}
