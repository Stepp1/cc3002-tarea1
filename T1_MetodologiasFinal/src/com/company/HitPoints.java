package com.company;

/**
 *
 * HitPoints.java
 *
 * The class HitPoints is in charge of
 * managing the hp and the damage received
 * by each unit or building.
 * It contains methods regarding the state of an unit or building.
 * These are getters and setters.
 *
 * @author Stepp
 */
public class HitPoints {
    /** The hp of an unit*/
    private double hp;

    /** The hp cap of an unit*/
    private double hpCap;

    /** The hp cap of an unit*/
    private double hpCapBuilding;

    /**
     * Instantiates a new Hit Points class.
     * @param hp the life of the entity.
     */
    public HitPoints(double hp){
        this.hp = hp;
        this.hpCapBuilding = hp;
        this.hpCap = hp * 2.0;
    }

    /**
     * This method returns the current hp
     * of an unit
     * @return the actual life
     */
    public double getHp(){
        return hp;
    }


    /**
     * This method returns the hp cap
     * of an unit
     * @return the life cap
     */
    public double getHpCapUnit(){
        return hpCap;
    }


    /**
     * This method returns the hp cap
     * of an unit
     * @return the life cap
     */
    public double getHpCapBuilding(){
        return hpCapBuilding;
    }

    /**
     * This method is used to reduce the
     * current hp of an unit
     * @param damage damage dealt to the entity
     */
    public void substractHP(double damage){
        this.hp -= damage;
        if(this.hp <= 0){
            this.setDead();
        }
    }

    /**
     * This method is used to set the unit to
     * a dead state.
     */
    public void setDead(){
        this.hp = 0;
    }

    /**
     * This method checks if the unit is dead.
     * Therefore, it checks if the hp is inferior
     * or equal to zero.
     * @return true if the hp is inferior or equal to zero
     */
    public boolean isDead() {
        return hp <= 0;
    }

    /**
     * This method is used to add more hp, a.k.a heal,
     * the current hp of an unit
     * The unit has a maximum hp: the hpCap.
     * @param heal amount of hp to be added
     */
    public void addtHP(double heal){
        if(!(this.hp <= 0)) {
            this.hp += heal;
        }
        if(this.hp > this.hpCap){
            this.getHpCapUnit();
        }
    }

    /**
     * This method is used to add more hp, a.k.a repair,
     * to the current hp of an unit.
     * The building has a maximum hp: the hpCapBuilding
     * @param heal amount of hp to be added
     */
    public void addBuildingHP(double heal){
        if(!(this.hp <= 0)) {
            this.hp += heal;
        }
        if(this.hp > this.hpCapBuilding){
            this.getHpCapBuilding();
        }
    }





    /* **************************** UNUSED METHODS ******************************/

    /**
     * This method is used to set the unit to
     * a its hp cap.
     */
    public void setMaxHp(double hpCap){
        this.hpCap = hpCap;
    }

    /**
     * This method is used to set the building to
     * a its hp cap.
     */
    public void setMaxHpBuilding(double hpCap){
        this.hpCapBuilding = hpCap;
    }


    /**
     * This method is used to set
     * the hp cap of an unit
     */
    public void setHpCapUnit(){
        this.hpCap = hp * 2.0;
    }


    /**
     * This method is used to set
     * the hp cap of a building
     */
    public void setHpCapBuilding(){
        this.hpCapBuilding = hp * 2.0;
    }


}
