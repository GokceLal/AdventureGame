public abstract class GameChar {
    private int id;
    private String name;
    private int damage;
    private int healthy;
    private int money;
// private GameChar samurai = new Samurai(5,21,15);enumerator

public GameChar(int id, String name,int damage, int healthy, int money) {
    this.id = id;
    this.name = name;
    this.damage = damage;
    this.healthy = healthy;
    this.money = money;
}

    public GameChar(int damage) {
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDamage() {
        return damage;
    }
}


