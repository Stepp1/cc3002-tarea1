package com.company;

/**
 *
 * Attackable.java
 *
 * The Attackable interface reunites all common methods
 * of the units and buildings that can be attacked.
 *
 * There are two types of methods: attackedBy and healedByMonk
 * These are called by the attack(...) method.
 *
 * All classes that implement the interface must implement its methods.
 */
public interface Attackable {
    /**
     * The method is called when an unit is attacked by an infantry unit.
     * It's used for double dispatch
     * @param infantry the attacked unit
     */
    void attackedByInfantry(Infantry infantry);
    /**
     * The method is called when an unit is attacked by an cavalry unit.
     * It's used for double dispatch
     * @param cavalry the attacked unit
     */
    void attackedByCavalry(Cavalry cavalry);
    /**
     * The method is called when an unit is attacked by an archer unit.
     * It's used for double dispatch
     * @param archer the attacked unit
     */
    void attackedByArcher(Archer archer);
    /**
     * The method is called when an unit is attacked by an siege unit.
     * It's used for double dispatch
     * @param siege the attacked unit
     */
    void attackedBySiege(Siege siege);
    /**
     * The method is called when an unit is attacked by an villager unit.
     * It's used for double dispatch
     * @param villager the attacked unit
     */
    void attackedByVillager(Villager villager);
    /**
     * The method is called when an unit is attacked by an castle building.
     * It's used for double dispatch
     * @param castle the attacked unit
     */
    void attackedByCastle(Castle castle);
    /**
     * The method is called when an monk unit heals another unit.
     * It's used for double dispatch
     * @param monk the attacked unit
     */
    void healedByMonk(Monk monk);
}
