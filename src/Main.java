import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] footballTeams = {
                "Arsenal", "Aston Villa", "Bournemouth", "Brentford", "Brighton", "Burnley", "Chelsea", "Crystal Palace",
                "Everton", "Fulham", "Liverpool", "Luton Town", "Manchester City", "Manchester United", "Newcastle United",
                "Nottingham Forest", "Sheffield United", "Tottenham Hotspur", "West Ham United", "Wolverhampton Wanderers",
                "Alavés", "Almería", "Athletic Bilbao", "Atletico Madrid", "Barcelona", "Cádiz", "Celta Vigo", "Getafe",
                "Girona", "Granada", "Las Palmas", "Mallorca", "Osasuna", "Rayo Vallecano", "Real Betis", "Real Madrid",
                "Real Sociedad", "Sevilla", "Valencia", "Villarreal", "AS Roma", "Atalanta", "Bologna", "Cagliari", "Empoli",
                "Fiorentina", "Frosinone", "Genoa", "Inter Milan", "Juventus", "Lazio", "Lecce", "Monza", "Napoli",
                "Salernitana", "Sassuolo", "Torino", "Udinese", "Hellas Verona", "Milan", "Augsburg", "Bayer Leverkusen",
                "Bayern Munich", "Borussia Dortmund", "Borussia Mönchengladbach", "Eintracht Frankfurt", "Freiburg",
                "Heidenheim", "Hoffenheim", "Köln", "Mainz 05", "RB Leipzig", "Union Berlin", "Stuttgart", "Werder Bremen",
                "Wolfsburg", "Darmstadt", "Hertha Berlin", "AS Monaco", "Brest", "Clermont Foot", "FC Lorient", "Le Havre",
                "Lens", "Lille", "Lyon", "Marseille", "Metz", "Montpellier", "Nantes", "Nice", "Paris Saint Germain",
                "Reims", "Rennes", "Strasbourg", "Toulouse", "Atlanta United", "Inter Miami CF", "LA Galaxy", "Adana Demirspor",
                "Alanyaspor", "Antalyaspor", "Beşiktaş", "Çaykur Rizespor", "Fatih Karagümrük", "Fenerbahçe", "Galatasaray",
                "Gaziantep FK", "Hatayspor", "İstanbul Başakşehir", "İstanbulspor", "Kasımpaşa", "Kayserispor", "Konyaspor",
                "Ankaragücü", "Pendikspor", "Samsunspor", "Sivasspor", "Trabzonspor", "Gabala", "Qarabağ", "Neftçi",
                "Zira", "Sabail", "Sumqayıt", "Sabah", "Kapaz", "Turan Tovuz"
        };

        Scanner keyboard = new Scanner(System.in);
        Random random = new Random();
        String word = footballTeams[random.nextInt(footballTeams.length)].toLowerCase();
        List<Character> guesses = new ArrayList<>();

        int wrongCount = 0;

        // Main game loop
        while (true) {
            printHangedMan(wrongCount);

            if (wrongCount >= 6) {
                System.out.println("You lose! The correct team was: " + word);
                break;
            }

            boolean correctGuess = displayBoard(word, guesses);

            if (correctGuess) {
                System.out.println("You win! The correct team was: " + word);
                break;
            }

            System.out.print("Guess a letter: ");
            char guessedLetter = keyboard.nextLine().toLowerCase().charAt(0);

            if (!guesses.contains(guessedLetter)) {
                guesses.add(guessedLetter);

                if (!word.contains(String.valueOf(guessedLetter))) {
                    wrongCount++;
                }
            } else {
                System.out.println("You already guessed that letter. Try again.");
            }
        }

        keyboard.close();
    }

    private static void printHangedMan(int wrongCount) {
        switch (wrongCount) {
            case 0:
                System.out.println(" -------");
                System.out.println(" |     |");
                System.out.println(" |");
                System.out.println(" |");
                System.out.println(" |");
                System.out.println(" |");
                System.out.println(" |");
                break;
            case 1:
                System.out.println(" -------");
                System.out.println(" |     |");
                System.out.println(" |     O");
                System.out.println(" |");
                System.out.println(" |");
                System.out.println(" |");
                System.out.println(" |");
                break;
            case 2:
                System.out.println(" -------");
                System.out.println(" |     |");
                System.out.println(" |     O");
                System.out.println(" |     |");
                System.out.println(" |");
                System.out.println(" |");
                System.out.println(" |");
                break;
            case 3:
                System.out.println(" -------");
                System.out.println(" |     |");
                System.out.println(" |     O");
                System.out.println(" |    /|");
                System.out.println(" |");
                System.out.println(" |");
                System.out.println(" |");
                break;
            case 4:
                System.out.println(" -------");
                System.out.println(" |     |");
                System.out.println(" |     O");
                System.out.println(" |    /|\\");
                System.out.println(" |");
                System.out.println(" |");
                System.out.println(" |");
                break;
            case 5:
                System.out.println(" -------");
                System.out.println(" |     |");
                System.out.println(" |     O");
                System.out.println(" |    /|\\");
                System.out.println(" |    /");
                System.out.println(" |");
                System.out.println(" |");
                break;
            case 6:
                System.out.println(" -------");
                System.out.println(" |     |");
                System.out.println(" |     O");
                System.out.println(" |    /|\\");
                System.out.println(" |    / \\");
                System.out.println(" |");
                System.out.println(" |");
                break;
        }
        System.out.println();
    }

    private static boolean displayBoard(String word, List<Character> guesses) {
        int correctCount = 0;
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            if (guesses.contains(letter)) {
                System.out.print(letter);
                correctCount++;
            } else if (letter == ' ') {
                System.out.print(" ");
                correctCount++;
            } else {
                System.out.print("-");
            }
        }
        System.out.println();

        return correctCount == word.length();
    }
}