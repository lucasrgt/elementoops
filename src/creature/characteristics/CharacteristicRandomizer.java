package creature.characteristics;

import java.util.Random;

/**
 * Criador de um número aleatório para uma característica da criatura.
 */
public class CharacteristicRandomizer {
    /**
     * @param min Número mínimo de uma característica.
     * @param max Número máximo de uma característica.
     * @return Número aleatório de uma característica.
     */
    public static int getRandomCharacteristicNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }
}
