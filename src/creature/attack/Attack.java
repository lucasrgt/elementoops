package creature.attack;

import creature.characteristics.Characteristics;

/**
 * Classe modelo para um ataque.
 */
public abstract class Attack {
    public Characteristics characteristics;

    public Attack(Characteristics characteristics) {
        this.characteristics = characteristics;
    }

    /**
     * Conjuração de um ataque.
     * @return Dano causado.
     */
    public abstract int castAttack();
}
