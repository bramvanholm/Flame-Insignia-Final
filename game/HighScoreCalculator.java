package game;

import java.io.*;
import java.util.*;


public class HighScoreCalculator {

	//instance variables
	public int highScore;
	
	//class constructor
	public HighScoreCalculator (int allies, int turns, String difficulty) {
		
		//local variables
		int tempHighScore = allies*150 + turns*50;
		
		switch(difficulty){
		case "Easy":
			highScore=tempHighScore;
			break;
		case "Standard":
			highScore = (tempHighScore+150)*2;
			break;
		case "Hard":
			highScore = (tempHighScore+300)*4;
			break;
		}
	}
	
	//give Score
	public int getHighScore() {
		return this.highScore;
	}
	
	//Getting the High Scores from the file
	public ArrayList<Integer> getHighScoreList() {
		
		//local variables
		ArrayList<Integer> allScores = new ArrayList<Integer>();
		ArrayList<Integer> bestScores = new ArrayList<Integer>();
		
		//read data from file
		try(Scanner scan = new Scanner(new FileReader("src/resources/High Scores.txt"));) {
			while (scan.hasNext()) {
				int highScore = scan.nextInt();
				allScores.add(highScore);
			}
			Collections.sort(allScores);
			Collections.reverse(allScores);

			if (allScores.size()<10) {
				for(int i=0; i<allScores.size(); i++) {
					bestScores.add(allScores.get(i));
				}
			} else {
				for(int i =0;i<10;i++) {
					bestScores.add(allScores.get(i));
				}
			}
		}catch(FileNotFoundException e) {
			System.out.println("File Not Found" +e);
			System.exit(0);

		}catch (Exception e) {
			System.out.println("Error" +e);
			System.exit(0);
		}
		return bestScores;
	}
	
	//Adding the High Score to the file with the High Scores
	public void addHighScore(int highScore) {

		//write data to file
		try (Scanner scan = new Scanner(new FileReader("src/resources/High Scores.txt"));
				FileWriter out = new FileWriter("src/resources/High Scores.txt",true)){
			FileOutputStream fileOut = new FileOutputStream("src/Resources/High Scores.txt", true);
			PrintWriter outHighScore = new PrintWriter(fileOut, true);
			outHighScore.format("%d %n", highScore);
			outHighScore.close();
			fileOut.close();
		} catch (IOException e){
			System.out.println("Error" +e);
		}
	}
}