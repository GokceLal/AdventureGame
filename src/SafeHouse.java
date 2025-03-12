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
        if (this.getPlayer().getWonAwards().contains("Water") &&
                this.getPlayer().getWonAwards().contains("Food") &&
                this.getPlayer().getWonAwards().contains("Firewood")
                //&&
                //this.getPlayer().getWonAwards().contains("Diamond")
        ) {

            System.out.println("Congratulations! You have collected all the rewards and returned safely. YOU WIN!");
            return false; // Oyunu bitiriyoruz.
        }
        return true;


    }

}
