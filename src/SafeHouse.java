public class SafeHouse extends Location {
    public SafeHouse(Player player)
    {
        super (player, "Güvenli ev");
    }

    @Override
     public boolean onLocation() {
        System.out.println("This house is safe");
        System.out.println("Your health has been restored");
        this.getPlayer().setHealthy(this.getPlayer().getOrjinalHealth());
        return true;


    }
}
