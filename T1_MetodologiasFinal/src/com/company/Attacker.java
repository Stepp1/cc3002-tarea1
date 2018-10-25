package com.company;

/**
 * Attacker.java
 *
 * The Attacker interface reunites all common methods of all entities that can attack.
 *
 * For the now, the only common method is attack(...).
 *
 * All classes that implement the interface must implement its methods.
 */
public interface Attacker{

    /**
     * The attack method is called when an entity attacks another.
     * The actual method in the subclasses call the corresponding attackedBy method.
     * It is used for double dispatch.
     * @param entity the attacked entity
     */
    void attack(Attackable entity);
}
