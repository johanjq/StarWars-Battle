import java.util.Random;

public class main {
    public static void main(String[] args) {


        boolean jedi = true, sith = true;
        Random rand = new Random(System.nanoTime());
        int random, healthDamage;

        character luke = new character();
        character yoda = new character();
        character darth_vader = new character();

        //name, health, physic, strength, ph, level
        luke.setName("Luke");
        luke.setHealth(600);
        luke.setPhysic(15);
        luke.setStrength(10);
        luke.setPh(3);
        luke.setLevel(2);

        darth_vader.setName("Darth Vader");
        darth_vader.setHealth(1000);
        darth_vader.setPhysic(10);
        darth_vader.setStrength(30);
        darth_vader.setPh(4);
        darth_vader.setLevel(5);

        yoda.setName("Yoda");
        yoda.setHealth(400);
        yoda.setPhysic(5);
        yoda.setStrength(40);
        yoda.setPh(6);
        yoda.setLevel(10);

        System.out.println(luke.getName()+" has "+luke.getHealth()+" life points");
        System.out.println(yoda.getName()+" has "+yoda.getHealth()+" life points");
        System.out.println(darth_vader.getName()+" has "+darth_vader.getHealth()+" life points");
        System.out.println();
        do{
            //Luke attacking
            random = rand.nextInt(2);
            if(random == 0){
                healthDamage = luke.physical_attack();
            }
            else{
                healthDamage = luke.strength_attack();
            }
            System.out.println(luke.getName()+" has performed an attack of: "+healthDamage);
            //darth vader original health - health after getting an attack from luke
            darth_vader.damage(healthDamage);

            //Yoda attacking
            random = rand.nextInt(2);
            if(random == 0){
                healthDamage = yoda.physical_attack();
            }
            else{
                healthDamage = yoda.strength_attack();
            }
            System.out.println(yoda.getName()+" has performed an attack of: "+healthDamage);
            //darth vader original health - health after getting an attack from luke
            darth_vader.damage(healthDamage);

            //Dart Vader attacking but if he is still alive:
            if(darth_vader.getHealth() > 0){
                random = rand.nextInt(2);
                if(random == 0){
                    healthDamage = darth_vader.physical_attack();
                }
                else{
                    healthDamage = darth_vader.strength_attack();
                }
                System.out.println(darth_vader.getName()+" has performed an attack of: "+healthDamage);
                //luke or yoda original health - health after getting an attack from luke
                //Who is going to attack to?
                random = rand.nextInt(2);
                if(random == 0){
                    luke.damage(healthDamage);
                }
                else{
                    yoda.damage(healthDamage);
                }
                if(luke.getHealth() <= 0 || yoda.getHealth() <= 0){
                    jedi = false;
                }
            }
            else{
                sith = false;
            }

            System.out.println(luke.getName()+" has "+luke.getHealth()+" life points");
            System.out.println(yoda.getName()+" has "+yoda.getHealth()+" life points");
            System.out.println(darth_vader.getName()+" has "+darth_vader.getHealth()+" life points");
            System.out.println();

            try {
                System.in.read();
            }catch(Exception e){}
            
        }while(jedi && sith);
    }
}
