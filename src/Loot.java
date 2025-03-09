import java.util.Random;

public class Loot {  //Ganimetler için
    private String name;
    private int money;
    private String gun;
    private String armor;

    private static final Random random = new Random();


        double randomValue = random.nextDouble();






    public Loot(String name, int money, String gun, String armor) {
        this.name = name;
        this.money = money;
        this.gun = gun;
        this.armor = armor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getGun() {
        return gun;
    }

    public void setGun(String gun) {
        this.gun = gun;
    }

    public String getArmor() {
        return armor;
    }

    public void setArmor(String armor) {
        this.armor = armor;
    }
}
