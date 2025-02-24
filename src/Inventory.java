public class Inventory {
   // private int weaponDamage;
    // private String weaponName;


   // public Inventory(int weaponDamage, String weaponName) {
     //   this.weaponDamage = 0;
       // this.weaponName = "Punch"; //Yumruk

    //}

    private Weapon weapon;
    private Armor armor;

    public Inventory(){
        this.weapon = new Weapon("Punch",-1,0,0);
        this.armor = new Armor(-1,"No-Armor",0,0);
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }
}
