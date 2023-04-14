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
        switch (element.getName()) {
            case "Air":
                return 2.0;
            case "Water":
            case "Fire":
                return 1.0;
            case "Earth":
                return 0.5;
            default:
                return 0;
        }
    }
}
