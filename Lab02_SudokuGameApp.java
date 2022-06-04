//Kritika Ravichander
//KRR92
package lab02_krr92;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JFileChooser;

class Lab02_KRR92 {

    int NUMBER_OF_LEVELS = 3;
    int NUMBER_OF_GAMES_PER_LEVEL = 12;
    int NUMBER_OF_ROWS = 9;
    int NUMBER_OF_COLS = 9;

    public static void main(String[] args) {
        try {
            new Lab02_KRR92();
        } catch (FileNotFoundException ex) {
            System.out.println("Please kill me");
        }
        //constructor
    }

    public Lab02_KRR92() throws FileNotFoundException {
        Scanner sudokuDataBaseScanner;
        try {
            sudokuDataBaseScanner = getSudokuDataBaseScanner();
            int[][][][] sudokuGames = getAllSudokuGames(sudokuDataBaseScanner);
            sudokuDataBaseScanner.close();
            goToMainMenu(sudokuGames);
        } catch (FileNotFoundException ex) {
            System.out.println("Error: That file doesn't exist.");
            System.exit(1);
        }
    }

    private Scanner getSudokuDataBaseScanner() throws FileNotFoundException {
        JFileChooser fc = new JFileChooser();
        fc.showOpenDialog(null);
        File file = fc.getSelectedFile();
        Scanner scanner = new Scanner(file);
        return scanner;
        //Reads file
    }

    private int[][][][] getAllSudokuGames(Scanner sudokuDataBaseScanner) {
        int[][][][] allSudokuGames = new int[NUMBER_OF_LEVELS][NUMBER_OF_GAMES_PER_LEVEL][NUMBER_OF_ROWS][NUMBER_OF_COLS];

        allSudokuGames[0] = getGamesForLevel(0, sudokuDataBaseScanner);
        allSudokuGames[1] = getGamesForLevel(1, sudokuDataBaseScanner);
        allSudokuGames[2] = getGamesForLevel(2, sudokuDataBaseScanner);

        return allSudokuGames;
    }

    private int[][][] getGamesForLevel(int level, Scanner sudokuDataBaseScanner) {
        int[][][] gamesForLevelN = new int[NUMBER_OF_GAMES_PER_LEVEL][NUMBER_OF_ROWS][NUMBER_OF_COLS];
        int gameNumber = 0;
        for (int i = 0; i < NUMBER_OF_GAMES_PER_LEVEL; i++) {
            int[][] currentGame = new int[NUMBER_OF_ROWS][NUMBER_OF_COLS];
            String line = sudokuDataBaseScanner.nextLine();
            for (int j = 0; j < NUMBER_OF_ROWS; j++) {
                line = sudokuDataBaseScanner.nextLine();
                String[] items = line.split("(?!^)");
                for (int k = 0; k < NUMBER_OF_COLS; k++) {
                    currentGame[j][k] = Integer.parseInt(items[k]);
                }
            }
            gamesForLevelN[gameNumber] = currentGame;
            gameNumber++;
        }
        return gamesForLevelN;
    }

    private void goToMainMenu(int[][][][] sudokuGames) {
        //Choose next level (user input)
        Scanner userInput = new Scanner(System.in);
        int fuckNetBeans = 0;
        while (fuckNetBeans != -69) {
            System.out.println("Enter a number for level:\n"
                    + "1) Beginner\n"
                    + "2) Intermediate\n"
                    + "3) Advanced\n"
                    + "4) Exit");
            int level = userInput.nextInt() - 1;
            if (level == 3) {
                System.out.println("Thanks for playing. See you soon ;)");
                System.exit(0);
            }
            //Printing all the games
            for (int game = 0; game < sudokuGames[level].length; game++) {
                System.out.println("Game number:" + game);
                for (int row = 0; row < sudokuGames[level][game].length; row++) {
                    for (int col = 0; col < sudokuGames[level][game][row].length; col++) {
                        System.out.print(sudokuGames[level][game][row][col] + " ");
                    }
                    System.out.println(" ");
                }
            }
            //Choose game to play (user input)
            System.out.println("What game number do you want to play?");
            int game = userInput.nextInt();
            //Access 3D array
            System.out.println("Current game: " + game);
            for (int row = 0; row < sudokuGames[level][game].length; row++) {
                for (int col = 0; col < sudokuGames[level][game][row].length; col++) {
                    System.out.print(sudokuGames[level][game][row][col] + " ");
                }
                System.out.println(" ");
            }
        }
    }
}
