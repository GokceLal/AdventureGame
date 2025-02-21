import java.util.Scanner;

public class Player {
    private int damage;
    private int healthy;
    private int money;
    private String name;
    private String charName;
    private Scanner input = new Scanner(System.in);

    public Player(String name){
        this.name = name;
    }

    public void selectChar() {
        Samurai samurai = new Samurai();
        Knight knight = new Knight();
        Archer archer = new Archer();

        GameChar[] charList ={new Samurai(), new Archer(), new Knight()};
        System.out.println("--------------------------------------------");

        for (GameChar gameChar : charList) {
            System.out.println("ID: "+gameChar.getId() +"\t GameChar:" + gameChar.getName() +  "\t Damage:" + gameChar.getDamage() +" \t Health: " +gameChar.getHealthy() +"\t Money: "+ gameChar.getMoney());

        }

        System.out.println("----------------------------------------");
        System.out.println("Please select a character");
        int selectChar = input.nextInt();
        switch (selectChar){
            case 1:
                initPlayer(new Samurai());
                break;
            case 2:
                initPlayer(new Archer());
                break;
            case 3:
                initPlayer(new Knight());
                break;
            default:
                initPlayer(new Samurai());
        }

        System.out.println("Your char is " + this.getCharName()+ ", Damage: " + this.getDamage() + ", Healty: " + this.getHealthy() + ",Money: " + this.getMoney());



        }
        public void initPlayer(GameChar gamechar){

        this.setDamage(gamechar.getDamage());
        this.setHealthy(gamechar.getHealthy());
        this.setMoney(gamechar.getMoney());
        this.setCharName(gamechar.getName());


    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealthy() {
        return healthy;
    }

    public void setHealthy(int healthy) {
        this.healthy = healthy;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }
}
