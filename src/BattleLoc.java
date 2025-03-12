import java.util.Random;

public class BattleLoc extends Location{
    private Obstacle obstacle;
    private String  award;
    private int maxObstacle;
    private int randomEverone;

    private boolean isWin = false;



    public BattleLoc(Player player, String name, Obstacle obstacle, String award, int maxObstacle, boolean isWin) {
        super(player, name);
        this.obstacle = obstacle;
        this.award = award;
        this.maxObstacle = maxObstacle;
        this.isWin = isWin;

    }


    public void isAreaWin(int obsNum) {
        if (obsNum == 0){
            System.out.println("This area have " +obsNum+ " you  killed them" );

        }

    }

    @Override
    public boolean onLocation() {
        int obsNumber = this.randomObstacleNumber();
        System.out.println("Now you are here" + this.getName());
        System.out.println("Be Careful! " + this.getObstacle().getName() + " may be " + obsNumber +" number");
        System.out.println("If you want to battle <B> or leave <L>");
        System.out.println(this.getObstacle().getAward());
        String selectCase = input.next();
        selectCase = selectCase.toUpperCase();
        if(selectCase.equals("B") && combat(obsNumber)){

                System.out.println(this.getName() + " you win ");
            this.isWin = true;

            if(selectCase.equals("L")||!combat(obsNumber)){
                System.out.println("You left the battle.");
                return false;
            }
            return true;

        }


        if (this.getPlayer().getHealthy() <= 0 ){
            System.out.println("You are die");
            return  false;
        }

        return true;
    }



    public boolean combat(int obsNumber){


        for (int i = 1;  i <= obsNumber; i++) {
            this.getObstacle().setHealth(this.getObstacle().getOrjinalHealth());
            playerStarts();
            obstacleStarts(i);
            System.out.println("Your chance of hitting first is 50 percent. The chance of the other side hitting first is 50 percent.");
            Random random = new Random();
            boolean yourChange = random.nextBoolean();
            System.out.println(yourChange ? "You attack first" : "The enemy attacks first!");
            while(this.getPlayer().getHealthy() > 0 && this.getObstacle().getHealth() > 0){
                System.out.print("<B> Battle or <L> Leave : ");
                String selectCombat = input.next().toUpperCase();
                if(selectCombat.equals("B")){
                    if(yourChange){
                        youHit();
                        if (this.getObstacle().getHealth() > 0) {
                            enemyHit();
                        }
                    }
                    if(!yourChange){
                        enemyHit();
                        if (this.getPlayer().getHealthy() > 0) {
                            youHit();
                        }
                    }

                }

            }
            if(this.getObstacle().getHealth() < this.getPlayer().getHealthy()){
                System.out.println("Enemy failed");
                System.out.println("You win "+ this.getObstacle().getAward() + " award");
                this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getObstacle().getAward());
                System.out.println("Your total money "+ this.getPlayer().getMoney());
                System.out.println("You win this area " );
                isWin = true;
            }
            else if(this.getObstacle().getHealth() > this.getPlayer().getHealthy()){
                System.out.println("You failed");
                System.out.println("You lose "+ this.getObstacle().getAward() + " award");
                this.getPlayer().setMoney(this.getPlayer().getMoney() - this.getObstacle().getAward());
                System.out.println("Your total money "+ this.getPlayer().getMoney());
                System.out.println("You lose this area " );
                return false;



            }
            else {
                return false;
            }
        }
        return true;
    }

    public void youHit(){
        System.out.println("You kicked");
        this.obstacle.setHealth(this.obstacle.getHealth() - this.getPlayer().getTotalDamage());
        if(this.getPlayer().getHealthy() < 0){
            this.getPlayer().setHealthy(0);
        }
        afterHit();
    }

    public void enemyHit(){
        System.out.println("Enemy hit you ");
        int obstacleDamage = this.getObstacle().getDamage() - this.getPlayer().getInventory().getArmor().getBlock();
        if(obstacleDamage < 0){
            obstacleDamage = 0;
        }
        this.getPlayer().setHealthy(this.getPlayer().getHealthy() - obstacleDamage);
        afterHit();
    }

    public void afterHit(){
        System.out.println("Your Health: "+ getPlayer().getHealthy());
        System.out.println(this.getObstacle().getName()+ " health is " + this.getObstacle().getHealth());
        System.out.println("----------------");
    }

    public void  playerStarts(){
        System.out.println("Oyuncu değerleri");
        System.out.println("------------------");
        System.out.println("Health: "+ this.getPlayer().getHealthy());
        System.out.println("Damage: "+ this.getPlayer().getTotalDamage());
        System.out.println("Money: " + this.getPlayer().getMoney());

        if(this.getPlayer().getInventory().getWeapon().getDamage() > 0){
            System.out.println("Gun: "+ this.getPlayer().getInventory().getWeapon().getName() +
                    " - Damage: " + this.getPlayer().getInventory().getWeapon().getDamage());
        }
        System.out.println("Armor: "+ this.getPlayer().getInventory().getArmor().getName());
        System.out.println("Blok" + this.getPlayer().getInventory().getArmor().getBlock());
    }

    public void obstacleStarts(int i){
        System.out.println(i + "." + this.getObstacle().getName() + " Value");
        System.out.println("------------------");
        System.out.println("Healty: " + this.getObstacle().getHealth());
        System.out.println("Damage: "+ this.getObstacle().getDamage());
        System.out.println("Award: " + this.getObstacle().getAward());
    }

    public int randomObstacleNumber(){
        Random r = new Random();
        return r.nextInt(this.getMaxObstacle()) + 1;
    }


    public int getMaxObstacle() {
        return maxObstacle;
    }

    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }

    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public int getRandomEverone() {
        return randomEverone;
    }

    public void setRandomEverone(int randomEverone) {
        this.randomEverone = randomEverone;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public boolean isWin() {
        return isWin;
    }

    public void setWin(boolean win) {
        isWin = win;
    }


}
