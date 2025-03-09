import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Game {
        private Scanner input = new Scanner(System.in);
    private Set<String> completedAreas = new HashSet<>();


    public void start(){
            System.out.println("Welcome to Adventure Game !");
            System.out.println("Enter your name :");
            String playerName = input.nextLine();

            Player player = new Player(playerName);
            System.out.printf("MR/MS " + player.getName() + " welcome !");

           player.selectChar();


            Location location = null;

            boolean isAreaWin = false;

           while(true){
               player.printInfo();
               System.out.println();
               System.out.println("Area ");
               System.out.println();

               System.out.println("1 - SafeHouse");
               System.out.println("2 - ToolStore");
               System.out.println("3 - Cave ");
               System.out.println("4 - Forest");
               System.out.println("5 - River");
               System.out.println("6 - Coal Mine");
               System.out.println("0 - Exit");
                   System.out.println("Enter your choice");
                   int choice = input.nextInt();

                   switch (choice){
                       case 0:
                           location = null;
                           break;
                       case 1 :
                           location = new SafeHouse(player);
                           break;
                       case 2 :
                           location = new ToolStore(player);
                           break;
                       case 3 :
                           if (completedAreas.contains("Cave")) {
                               System.out.println("You have already won this area! Choose another one.");
                               location = null;
                           } else {
                               location = new Cave(player);
                           }
                           break;
                       case 4:
                           if (completedAreas.contains("Forest")) {
                               System.out.println("You have already won this area! Choose another one.");
                               location = null;

                           }
                           else {
                               location = new Forest(player);
                           }
                          break;
                       case 5:
                           location = new River(player);
                           break;
                       case 6:
                           location = new Coal(player);
                           break;

                       default:
                           System.out.println("Enter a location");
                        //   location = new SafeHouse(player);

                   }

               if (location != null) {
                   boolean result = location.onLocation();

                   if (result && location instanceof BattleLoc && ((BattleLoc) location).isWin()) {
                       completedAreas.add(location.getName());
                   }

                   if (!result) {
                       System.out.println("Game Over");
                       break;
                   }
               }


           }


        }
}
