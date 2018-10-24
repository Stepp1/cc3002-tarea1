package com.company;

public interface AttackableUnits{
    void attackedByInfantry(Infantry infantry);
    void attackedByCavalry(Cavalry cavalry);
    void attackedByArcher(Archer archer);
    void attackedBySiege(Siege siege);
    void attackedByVillager(Villager villager);
    //void attackedByCastle(Castle castle);
}
