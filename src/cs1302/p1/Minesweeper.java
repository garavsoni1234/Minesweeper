package cs1302.p1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

/**
 * This class represents a Minesweeper game.
 *
 * @author Garav Soni <gs93569@uga.edu>
 */
public class Minesweeper {
    /**
     * Constructs an object instance of the {@link Minesweeper} class using the
     * information provided in <code>seedFile</code>. Documentation about the 
     * format of seed files can be found in the project's <code>README.md</code>
     * file.
     *
     * @param seedFile the seed file used to construct the game
     * @see            <a href="https://github.com/mepcotterell-cs1302/cs1302-minesweeper-alpha/blob/master/README.md#seed-files">README.md#seed-files</a>
     */
private int rows;
	private int x;
	private int y;
	private int cols;
	private int i;
	private int j;
	private int d;
	int rw =0;
	String Finalversion = " ";
	private int f;
	int GenerateMine;
	private int value1;
	private int value2;
	static Random r = new Random();
	private char a;
	private String [][] Store;
	private String [][] grid;
	private boolean [][] Last;
	private int[][] SavedValues;
	Scanner scan = new Scanner(System.in);
	Scanner scan1 = new Scanner(System.in);
	Scanner scanaNotepad = null;
    public Minesweeper(File seedFile) {
    	
    	try {
    		System.out.println("HERERE");
    	   File df = new File("seedFile.txt");
			  Scanner s = new Scanner(df);
			  	this.rows = s.nextInt();
				this.cols = s.nextInt();
				Last = new boolean[rows][cols];
				int ch = s.nextInt();
 	   for( int i = 0; i<ch; i++){
 		   	Last[s.nextInt()][s.nextInt()] =true; 
 		  

				
 	   }
			}catch (Exception e) {
			   e.getMessage();
			   System.out.println("Cannot create game with FILENAME, because it is not formatted correctly.");
			   System.out.println("                                                                        ");
			}
    
    
    }
    // Minesweeper
    /**
     * Constructs an object instance of the {@link Minesweeper} class using the
     * <code>rows</code> and <code>cols</code> values as the game grid's number
     * of rows and columns respectively. Additionally, One quarter (rounded up) 
     * of the squares in the grid will will be assigned mines, randomly.
     *
     * @param rows the number of rows in the game grid
     * @param cols the number of cols in the game grid
     */
    public Minesweeper(int rows, int cols) {

   	 if((rows>0 && cols >0)&&(rows<=10&&cols<=10)){
			   this.rows=rows;
			   this.cols=cols;
			   GenerateMine = (int) Math.ceil(rows * cols * 0.25);
			   Random12(GenerateMine);
		 }else if((rows==0 && cols==0)&& (rows>10&&cols>10)){
			 System.out.println("Cannot create a mine field with that many rows and/or columns!");
			 
		 }
	}
    // Minesweeper
    /**
     * Starts the game and execute the game loop.
     */
     public void Introduction() {
		System.out.println("        _      ");
		System.out.println("  /\\/\\ (_)_ __   ___  _____      _____  ___ _ __   ___ _ __");
		System.out.println(" /    \\| | '_ \\ / _ \\/ __\\ \\ /\\ / / _ \\/ _ \\ '_ \\ / _ \\ '__|");
		System.out.println("/ /\\/\\ \\ | | | |  __/\\__ \\ V  V /  __/  __/ |_) |  __/ |");
		System.out.println("\\/    \\/_|_| |_|\\___||___/ \\_/\\_/ \\___|\\___| .__/ \\___|_|         ");
		System.out.println("                              ALPHA EDITION |_| v2017.f       ");
		System.out.println(" ");
	}
	//Introduction to the game
	public void Help(){
		System.out.println("Commands Available...");
		System.out.println(" - Reveal: r/reveal row col");
		System.out.println(" -   Mark: m/mark   row col");
		System.out.println(" -  Guess: g/guess  row col");
		System.out.println(" -   Help: h/help");
		System.out.println(" -   Quit: q/quit");
	}
	//Help menu Method
	public void PlayerLoses(){
		System.out.println("                                     ");
		System.out.println(" Oh no... You revealed a mine!");
		System.out.println("  __ _  __ _ _ __ ___   ___    _____   _____ _ __ ");
		System.out.println(" / _` |/ _` | '_ ` _ \\ / _ \\  / _ \\ \\ / / _ \\ '__|");
		System.out.println("| (_| | (_| | | | | | |  __/ | (_) \\ V /  __/ |  ");
		System.out.println("\\__, |\\__,_|_| |_| |_|\\___|  \\___/ \\_/ \\___|_|");
		System.out.println(" |___/                                           ");
		System.out.println("                                            ");
	}
		//Player loses Method when he or she reveals a mine 
	private boolean isInBounds(int row, int col) {
		return false; 		
		}
	// returns true if the seed file is in bounds,returns false otherwise
	public void Wordloop(){
		int e =rows;
		int v = cols;
		String RowsAndCols;
		int q =0;
		Store = new String[rows][cols+1];
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				Store[i][j] = " ";
			}
		}
		grid=new String[rows][cols];
		i =0;
		j =0;
		grid();
				boolean game = false;
				while( game == false){
			try {
				RowsAndCols = scan.next().trim();
				
				if(RowsAndCols.equals("quit")||RowsAndCols.equals("q")) {
					System.out.println("QUIT");
					System.exit(0);
				}else if(RowsAndCols.equals("h")|| RowsAndCols.equals("help")) {
					Help();
					System.out.println("                     ");
					System.out.println("Rounds Completed: "+  ++q);
					System.out.println("                        ");	
					
				
				}
				if(RowsAndCols.equals("r")||RowsAndCols.equals("reveal")) {
					int x = Integer.parseInt(scan.next());
					int y = Integer.parseInt(scan.next());
					Store[x][y] = "r";
					if(x>=rows){
						System.out.println("Cannot create a mine field with that many rows and/or columns!");
						System.exit(0);
					}else if (y>=cols){
						System.out.println("Cannot create a mine field with that many rows and/or columns!");
						System.exit(0);
					}
				}else if(RowsAndCols.equals("g")||RowsAndCols.equals("guess")) {
					int x = Integer.parseInt(scan.next());
					int y = Integer.parseInt(scan.next());
					Store[x][y]="g";
					if(x>=rows){
						System.out.println("Cannot create a mine field with that many rows and/or columns!");
						System.exit(0);
					}else if (y>=cols){
						System.out.println("Cannot create a mine field with that many rows and/or columns!");
						System.exit(0);
					}
				}else if(RowsAndCols.equals("m")||RowsAndCols.equals("mask")) {
					int x = Integer.parseInt(scan.next());
					int y = Integer.parseInt(scan.next());
					Store[x][y]="m";
					if(x>=rows){
						System.out.println("Cannot create a mine field with that many rows and/or columns!");
						System.exit(0);
					}else if (y>=cols){
						System.out.println("Cannot create a mine field with that many rows and/or columns!");
						System.exit(0);
					}
				}else {
					System.out.println("Try Again");
					System.out.println("                     ");
					System.out.println("Rounds Completed: "+  ++q);
					System.out.println("                        ");	
					
				}
				}catch(Exception E) {
					System.out.println("Try Again");
					System.out.println("                     ");
					System.out.println("Rounds Completed: "+  ++q);
					System.out.println("                        ");	
					
				}
			for(i=0;i<grid.length;i++)
			{
					System.out.print(" "+i);
				for(j=0;j<grid[0].length+1;j++)
				{
					
					if ((Store[i][j] != null) && (Store[i][j].equals("r") || Store[i][j].equals("m") || (Store[i][j].equals("g")))) {
						if(Store[i][j].equals("r")){
							try {
								if(Last[i][j] != true){
									System.out.print(" | "+getNumAdjMines(e,v)+" " );
								}
								else if (Last[i][j] == true){
									System.out.print(" |   ");
									game = true;	
								}
							}catch(Exception ew) {
								
								
							}
						}else if(Store[i][j].equals("m")){
							System.out.print(" | F ");
							int h=0;
							if(Last[i][j]==true) {
								grid[i][j]="f";
								rw++;
								if(grid[i][j]=="f" && rw ==GenerateMine){
									WinAndScore(GenerateMine,rows,cols,q);
									System.out.print("won");
									WinAndScore(h, h, h, h);
								}	
							}		
						}else if(Store[i][j].equals("g")){
							
							System.out.print(" | ? ");
								}	
					
					}else{
						System.out.print(" |   ");
					}	
				}
				System.out.println();
				} 
			
			System.out.print("   ");
				for(int k=0;k<grid[0].length;k++)
				{
					System.out.print("  " +k+ "  ");
						
				}
				System.out.println("   ");
			
		}	
				PlayerLoses();
				System.exit(0);
	}
//Main loop for the game, gives scanner input to the user, reads the user input, and creates a grid and stores information
	public void WinAndScore(int generateMine, int rows, int cols, int q){
		int score = (rows*cols)-generateMine-q;
		System.out.println(score);	
	}
		// Win score method, for when user wins the game
	 public void Random12(int GenerateMine){
		 Last= new boolean[rows][cols];
			for(int g=0;g<GenerateMine;g++){
				d = r.nextInt(rows);
				f = r.nextInt(cols);
				if(Last[d][f] == false){
					Last[d][f] = true;
				}
			}
	 }
	//Generates Ramdon of mines based on the rows and cols
	public void grid()
	{
		System.out.println("                        ");
		System.out.println("Rounds Completed: " + "0");
		System.out.println("                        ");
		grid=new String [rows][cols];
		int value1=x;
		int value2=y;
		for(int i=0;i<grid.length;i++)
		{
					System.out.print(" "+i);
			for(int j=0;j<grid[0].length+1;j++)
			{
						System.out.print(" |   ");	
						
			}
			System.out.println();
			
			} 
			System.out.print("   ");
			for(int k=0;k<grid[0].length;k++)
			{
				System.out.print("  " +k+ "  ");
				
			}
			
			System.out.println("   ");
			 
			
			}
	public void TestLast() {
	}
	//Makes the first intial grid
	public int getNumAdjMines(int e, int d) {
		int l=0;
		
		if(i==0 && j ==0){
		 if(Last[i+1][j]==true){
			 l++;
		 }
		 if(Last[i+1][j+1]==true){
			 l++; 
		 }
		 if((Last[i][j+1]==true)){
			 l++;
			}
			}
		else if(i == e-1 && j ==0){
	
			 if(Last[i][j+1]==true){
				 l++;
			 }
			 if(Last[i-1][j+1]==true){
				 l++; 
			 }
			 if((Last[i-1][j]==true)){
				 l++;
			 }
		}else if(i==0 && j ==d-1){
			if(Last[i+1][j-1]==true){
				 l++;
			 }
			 if(Last[i+1][j]==true){
				 l++; 
			 }
			 if((Last[i][j-1]==true)){
				 l++;
			 }
		}else if(i==e-1 && j ==d-1){
				if(Last[i-1][j]==true){
					 l++;
					}
				if(Last[i-1][j-1]==true){
						 l++; 
					 }
				 if((Last[i][j-1]==true)){
						 l++;
		}
		}
		else if(i==0){
			if(Last[i][j-1]==true){
				 l++;
				}
			if(Last[i+1][j]==true){
				 l++;
				}
			if(Last[i+1][j-1]==true){
				 l++;
				}
			if(Last[i+1][j+1]==true){
				 l++;
				}
			if(Last[i][j+1]==true){
				 l++;
				}
			
		}else if (j==0){
			if(Last[i-1][j]==true){
				 l++;
				}
			if(Last[i-1][j+1]==true){
				 l++;
				}
			if(Last[i][j+l]==true){
				 l++;
				}
			if(Last[i+1][j+1]==true){
				 l++;
				}
			if(Last[i+1][j]==true){
				 l++;
			}
		}else if (i==e-1){
			if(Last[i][j-1]==true){
				 l++;
				}
			if(Last[i-1][j+1]==true){
				 l++;
				}
			if(Last[i-1][j]==true){
				 l++;
				}
			if(Last[i-1][j+1]==true){
				 l++;
				}
			if(Last[i][j+1]==true){
				 l++;
				}
		}else if (j==d-1){
			if(Last[i-1][j]==true){
				 l++;
				}
			if(Last[i-1][j-1]==true){
				 l++;
				}
			if(Last[i][j-1]==true){
				 l++;
				}
			if(Last[i+1][j-1]==true){
				 l++;
				}
			if(Last[i+1][j]==true){
				 l++;
				}
		}else if (j!=0 && i!=0 & j !=d-1 & i !=e-1){
			if(Last[i-1][j-1]==true){
				 l++;
				}
			if(Last[i-1][j]==true){
				 l++;
				}
			if(Last[i-1][j+1]==true){
				 l++;
				}
			if(Last[i][j+1]==true){
				 l++;
				}
			if(Last[i+1][j+1]==true){
				 l++;
				}
			if(Last[i+1][j]==true){
				 l++;
				}
			if(Last[i+1][j-1]==true){
				 l++;
				}
			if(Last[i][j-1]==true){
				 l++;
				}
		}
		return l;
		}
	//Gives the number of mines Adj to the row and column
	
    public void run() {
    	Introduction();
    	TestLast();
		Wordloop();
	

    } // run
    /**
     * The entry point into the program. This main method does implement some
     * logic for handling command line arguments. If two integers are provided
     * as arguments, then a Minesweeper game is created and started with a 
     * grid size corresponding to the integers provided and with 10% (rounded
     * up) of the squares containing mines, placed randomly. If a single word 
     * string is provided as an argument then it is treated as a seed file and 
     * a Minesweeper game is created and started using the information contained
     * in the seed file. If none of the above applies, then a usage statement
     * is displayed and the program exits gracefully. 
     *
     * @param args the shell arguments provided to the program
     */
    public static void main(String[] args) {
	/*
	  The following switch statement has been designed in such a way that if
	  errors occur within the first two cases, the default case still gets
	  executed. This was accomplished by special placement of the break
	  statements.
	*/
	Minesweeper game = null;
	switch (args.length) {
        // random game
	case 2: 
	    int rows, cols;
	    // try to parse the arguments and create a game
	    try {
		rows = Integer.parseInt(args[0]);
		cols = Integer.parseInt(args[1]);
		game = new Minesweeper(rows, cols);
		break;
	    } catch (NumberFormatException nfe) { 
		// line intentionally left blank
	    } // try
	// seed file game
	case 1: 
	    String filename = args[0];
	    File file = new File(filename);
	    if (file.isFile()) {
		game = new Minesweeper(file);
		break;
	    } // if
        // display usage statement
	default:
	    System.out.println("Usage: java Minesweeper [FILE]");
	    System.out.println("Usage: java Minesweeper [ROWS] [COLS]");
	    System.exit(0);
	} // switch
	// if all is good, then run the game
	game.run();
    } // main
} // Minesweeper