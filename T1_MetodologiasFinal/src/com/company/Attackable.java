package com.company;

public interface Attackable {
    void attackedByInfantry(Infantry infantry);
    void attackedByCavalry(Cavalry cavalry);
    void attackedByArcher(Archer archer);
    void attackedBySiege(Siege siege);
    void attackedByVillager(Villager villager);
    void attackedByCastle(Castle castle);
    void healedByMonk(Monk monk);
}
