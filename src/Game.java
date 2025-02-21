import java.util.Scanner;

public class Game {
        private Scanner input = new Scanner(System.in);

        public void start(){
            System.out.println("Macera Oyununa Hoşgeldiniz");
            System.out.println("Lütfen isminizi giriniz:");
            String playerName = input.nextLine();

            Player player = new Player(playerName);
            System.out.printf("Sayın " + player.getName() + " Hoşgeldiniz!");
            System.out.println("Karakter seç");
           player.selectChar();

        }
}
