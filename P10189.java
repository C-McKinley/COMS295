import java.util.Scanner;
import java.io.BufferedInputStream;
/**
* @author Colby McKinley
* @UVa_ID colby_mckinley
* @JUDGE_ID: 922619
* @Problem_ID: 10189 - Minesweeper
*
*/

class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(new BufferedInputStream(System.in));
		int rows;
		int cols;
		char[][] grid;
		String inputLine;
		int counter = 1;
		while(true) {
			rows = scan.nextInt();
			cols = scan.nextInt();
			if(rows == 0 && cols == 0)
				break;
			if(counter!=1)
				System.out.print("\n");
			grid = new char[rows][cols];
			for(int i = 0; i < rows; i++) {
				inputLine = scan.next();
				for(int j = 0; j < cols; j++)
					grid[i][j] = inputLine.charAt(j);
			}
			System.out.println("Field #" + counter + ":");
			printGrid(locatedDangersMap(rows,cols, grid));
			counter++;
		}
	}
	
	static char[][] locatedDangersMap(int rows, int cols, char[][] grid) {
		char[][] resultMap = new char[rows][cols];
		int value = 0;
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				if(grid[i][j] == '*')
					resultMap[i][j] = '*';
				else  {
					resultMap[i][j] = '0';
					//Left
					if(j > 0) {
						if(grid[i][j-1] == '*') {
							value = Character.getNumericValue(resultMap[i][j]);
							value++;
							resultMap[i][j] = (char)(value + '0');
						}
					}
					//Right
					if(j +1 < cols) {
						if(grid[i][j+1] == '*') {
							value = Character.getNumericValue(resultMap[i][j]);
							value++;
							resultMap[i][j] = (char)(value + '0');
						}
					}
					//Down
					if(i > 0) {
						if(grid[i-1][j] == '*') {
							value = Character.getNumericValue(resultMap[i][j]);
							value++;
							resultMap[i][j] = (char)(value + '0');
						}
					}
					//Up
					if(i + 1 < rows) {
						if(grid[i+1][j] == '*') {
							value = Character.getNumericValue(resultMap[i][j]);
							value++;
							resultMap[i][j] = (char)(value + '0');
						}
					}
					//Up and Left
					if((i + 1 < rows)&&(j > 0)) {
						if(grid[i+1][j-1] == '*') {
							value = Character.getNumericValue(resultMap[i][j]);
							value++;
							resultMap[i][j] = (char)(value + '0');
						}
					}
					//Up and Right
					if((i + 1 < rows)&&(j+1 < cols)) {
						if(grid[i+1][j+1] == '*') {
							value = Character.getNumericValue(resultMap[i][j]);
							value++;
							resultMap[i][j] = (char)(value + '0');
						}
					}
					//Bottom and Left
					if((i > 0)&&(j > 0)) {
						if(grid[i-1][j-1] == '*') {
							value = Character.getNumericValue(resultMap[i][j]);
							value++;
							resultMap[i][j] = (char)(value + '0');
						}
					}
					//Bottom and Right
					if((i > 0)&&(j+1 < cols)) {
						if(grid[i-1][j+1] == '*') {
							value = Character.getNumericValue(resultMap[i][j]);
							value++;
							resultMap[i][j] = (char)(value + '0');
						}
					}
				}
			}
		}
		return resultMap;
	}
	
	static void printGrid(char[][] grid) {
		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid[i].length; j++)
				System.out.print(grid[i][j]);
			System.out.print("\n");
		}
	}
}
