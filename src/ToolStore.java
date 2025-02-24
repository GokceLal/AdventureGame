public class ToolStore extends NormalLocation {
    public ToolStore(Player player) {
        super(player, "Store");


    }

    @Override
    public boolean onLocation() {
        System.out.println("Welcome to our store");
        boolean showMenu = true;
        while (showMenu) {


            System.out.println("1 - Weapon");
            System.out.println("2 - Armor");
            System.out.println("3 - Exit");
            System.out.println("Enter your choice");
            int choice = Location.input.nextInt();
            while (choice < 1 || choice > 3) {
                System.out.println("Wrong choice");
                choice = Location.input.nextInt();
            }
            switch (choice) {
                case 1:
                    printWeapons();
                    buyWeapon();
                    break;
                case 2:
                    printArmors();
                    buyArmor();
                    break;
                case 3:
                    System.out.println("Goodbye");
                    showMenu = false;
                    break;

            }

        }
        return true;
    }


    public void printWeapons() {
        System.out.println("WEAPON LIST");
        System.out.println("-------------");
        for (Weapon w : Weapon.weapons()) {
            System.out.println("ID: " + w.getId() + "\t Weapon:" + w.getName() + "\t Damage:" + w.getDamage() + " \t Price: " + w.getPrice());
        }

        System.out.println("0 - Exit");


    }

    public void buyWeapon() {
        System.out.println("Select a weapon");
        int selectWeaponID = Location.input.nextInt();
        while (selectWeaponID < 0 || selectWeaponID > Weapon.weapons().length) {
            System.out.println("Wrong choice");
            selectWeaponID = input.nextInt();
        }

        if(selectWeaponID != 0){

            Weapon selectedWeapon = Weapon.getWeaponObjById(selectWeaponID);
            if (selectedWeapon != null) {
                if (selectedWeapon.getPrice() > this.getPlayer().getMoney()) {
                    System.out.println("You don't have enough money");
                } else {
                    System.out.println("You bought " + selectedWeapon.getName());
                    this.getPlayer().setMoney(this.getPlayer().getMoney() - selectedWeapon.getPrice());
                    System.out.println("Your money : " + this.getPlayer().getMoney());
                    System.out.println("Last weapon : " + this.getPlayer().getInventory().getWeapon().getName());
                    this.getPlayer().getInventory().setWeapon(selectedWeapon);
                    System.out.println("Your weapon:" + this.getPlayer().getInventory().getWeapon().getName());

                }
            }

        }

    }


    public void printArmors() {
        System.out.println("ARMOR LIST");
        for (Armor a : Armor.armors()) {
            System.out.println(a.getId() + " - " + a.getName() + " - Block: " + a.getBlock() + " - Price: " + a.getPrice());
        }
        System.out.println("0 - Exit");
    }


        public void buyArmor() {
            System.out.println("Select an armor");
            int selectArmorID = Location.input.nextInt();
            while (selectArmorID < 1 || selectArmorID > Armor.armors().length) {
                System.out.println("Wrong choice");
                selectArmorID = input.nextInt();
            }

         if (selectArmorID != 0){
             Armor selectedArmor = Armor.getArmorObjById(selectArmorID);
             if(selectedArmor != null){
                 if (selectedArmor.getPrice()>this.getPlayer().getMoney()){
                     System.out.println("You don't have enough money");
                 }
                 else {
                     System.out.println(selectedArmor.getName() + " bought" );
                     int balance = this.getPlayer().getMoney() - selectedArmor.getPrice();
                     System.out.println("Your money : " + balance);
                     this.getPlayer().setMoney(balance);
                     this.getPlayer().getInventory().setArmor(selectedArmor);
                     System.out.println("Your armor: " + this.getPlayer().getInventory().getArmor().getName());
                 }
             }
         }
        }
    }



