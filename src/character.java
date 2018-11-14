/*System.nanoTime(): is a number. it generates different random
numbers
ph: its the power you use to make an attack, if you don't have any
you can't perform an attack
*/

import java.util.Random;

public class character {
    private String name;
    private int health, physic, strength, ph, level;


    private Random rand = new Random(System.nanoTime());

    //Getters and Setters
    public int getHealth(){
        return health;
    }
    public void setHealth(int health){
        this.health = health;
    }
    public int getPhysic(){
        return physic;
    }
    public void setPhysic(int physic){
        this.physic = physic;
    }
    public int getStrength(){
        return strength;
    }
    public void setStrength(int strength){
        this.strength = strength;
    }
    public int getPh(){
        return ph;
    }
    public void setPh(int ph){
        this.ph = ph;
    }
    public int getLevel(){
        return level;
    }
    public void setLevel(int level){
        this.level = level;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    //Attacks
    public int physical_attack(){
        int random = rand.nextInt(3);
        return level * physic * random;
    }
    public int strength_attack(){
        if(ph > 0){
            ph--;
            return level * strength;
        }
        else{
            return 0;
        }
    }
    public void damage(int healthDamage){
        this.health = this.health - healthDamage;
    }
}
