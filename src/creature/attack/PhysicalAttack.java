package creature.attack;

import creature.characteristics.Characteristics;

/**
 * Ataque físico.
 */
public class PhysicalAttack extends Attack {
    private final Characteristics characteristics;

    public PhysicalAttack(Characteristics characteristics) {
        super(characteristics);
        this.characteristics = characteristics;
    }

    @Override
    public int castAttack() {
        return this.characteristics.getPower() * this.characteristics.getDamage();
    }
}
