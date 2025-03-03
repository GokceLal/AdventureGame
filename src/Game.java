import java.util.Scanner;

public class Game {
        private Scanner input = new Scanner(System.in);

        public void start(){
            System.out.println("Macera Oyununa Hoşgeldiniz");
            System.out.println("Lütfen isminizi giriniz:");
            String playerName = input.nextLine();

            Player player = new Player(playerName);
            System.out.printf("Sayın " + player.getName() + " Hoşgeldiniz!");

           player.selectChar();


            Location location = null;
           while(true){
               player.printInfo();
               System.out.println();
                   System.out.println("Area ");
               System.out.println();
               System.out.println("1 - SafeHouse");

               System.out.println("2- ToolStore");
               System.out.println("3- Cave ");
               System.out.println("4 - Forest");
               System.out.println("5 - River");
               System.out.println("0- Exit");
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
                           location = new Cave(player);
                           break;
                       case 4:
                           location = new Forest(player);
                           break;
                       case 5:
                           location = new River(player);
                           break;

                       default:
                           System.out.println("Enter a location");
                        //   location = new SafeHouse(player);

                   }

                   if(!location.onLocation() || location == null)
                   {
                       System.out.println("Game Over");
                       break;
                   }
               }


        }
}
