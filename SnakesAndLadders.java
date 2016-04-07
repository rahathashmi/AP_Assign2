import java.io.*;
import java.util.*;

public class SnakesAndLadders {
	// Declaration of variables for use 
	    public static int rounds;
	    public static int sum;
	    public static int avg, max, min;    
	    public static int[] rounds_arr = new int[100];  
	    public static int[] frulecheck;
	    public static int no_ladders = 7;    
	    public static int no_snakes = 7;     
	    public static int[] snake_arr = new int[no_snakes]; 
	    public static int[] ladder_arr = new int[no_ladders];    
	   
	    
	    public static void main(String[] arg) throws IOException
	    {
	    	System.out.println ("\t\t\tWelcome To Snakes And Ladders");
	    	String input;
	    	int no=0; 
	    	Scanner in = new Scanner(System.in);
	    	System.out.println("Enter the number of players who want to play 2-4\n");
	    	int num = in.nextInt();
	    	if (num < 2 || num > 5){
	    	System.out.println("Error! Cant handle "+  num +" of players");
	    	return;
	    	
	    	}
	    	
	    		gameBoard();

	    		String i1;
	    		i1=play();
	    		if (i1.equals("P") || i1.equals("p"))
	    		{
	    			game(num);
	    		}
	    		else if (i1.equals("E") || i1.equals("e"))
	    		{
	    			return;
	    		}
	    			
	    	
	    	} // End of main

	    private static final long MEGABYTE = 1024L * 1024L;

	    public static long bytesToMegabytes(long bytes) {
	      return bytes / MEGABYTE;
	    }
	
        
    public static int rulecheck(int roll, int snake_arr[], int ladder_arr[], int userno, int pos) {
        int newpos = 0;
        if (pos == snake_arr[0]) {
        	System.out.println("Snake detected ! Go down from " + pos);
            pos = 5;
            frulecheck[userno] = 1;
        } else if (pos == snake_arr[1]) {
        	System.out.println("Snake detected ! Go down from " + pos);
            pos = 1;
            frulecheck[userno] = 1;
        } else if (pos == snake_arr[2]) {
        	System.out.println("Snake detected ! Go down from " + pos);
            pos = 19;
            frulecheck[userno] = 1;
        } else if (pos == snake_arr[3]) {
        	System.out.println("Snake detected ! Go down from " + pos);
            pos = 52;
            frulecheck[userno] = 1;
        } else if (pos == snake_arr[4]) {
        	System.out.println("Snake detected ! Go down from " + pos);
            pos = 57;
            frulecheck[userno] = 1;
        } else if (pos == snake_arr[5]) {
        	System.out.println("Snake detected ! Go down from " + pos);
            pos = 61;
            frulecheck[userno] = 1;
        } else if (pos == snake_arr[6]) {
            System.out.println("Snake detected ! Go down from " + pos);
            pos = 69;
            frulecheck[userno] = 1;
        } else if (pos == ladder_arr[0]) {
        	System.out.println ("Ladder detected !! Go up from "+ pos);
            newpos = getDice2();
            pos = 25 + newpos;
            System.out.println ("You are at "+ pos);
        } else if (pos == ladder_arr[1]) {
        	System.out.println ("Ladder detected !! Go up from "+ pos);
            newpos = getDice2();
            pos = 53 + newpos;
            System.out.println ("You are at "+ pos);
        } else if (pos == ladder_arr[2]) {
        	System.out.println ("Ladder detected !! Go up from "+ pos);
            newpos = getDice2();
            pos = 41 + newpos;
            System.out.println ("You are at "+ pos);
        } else if (pos == ladder_arr[3]) {
        	System.out.println ("Ladder detected !! Go up from "+ pos);
            newpos = getDice2();
            pos = 61 + newpos;
            System.out.println ("You are at "+ pos);
        } else if (pos == ladder_arr[4]) {
        	System.out.println ("Ladder detected !! Go up from "+ pos);
            newpos = getDice2();
            pos = 82 + newpos;
            System.out.println ("You are at "+ pos);
        } else if (pos == ladder_arr[5]) {
        	System.out.println ("Ladder detected !! Go up from "+ pos);
            newpos = getDice2();
            pos = 99 + newpos;
            System.out.println ("You are at "+ pos);
        } 
        else if (pos == ladder_arr[6]) {
        	System.out.println ("Ladder detected !! Go up from "+ pos);
            newpos = getDice2();
            pos = 91 + newpos;
            System.out.println ("You are at "+ pos);
        } 
        if (pos > 100) {
            pos = pos - roll;
        } else if (pos == 100) 
        {
            System.out.println("Game Over !! Player " + (userno + 1) + " Won");
        }
        return pos;
    }
	 public static int getDice ()
	    {
		 int diceRoll=0;
	        diceRoll = (int)(Math.random()*6 )+1 ; 
	       
	        return diceRoll; 
	    }
	 // For again dice roll if required
	 public static int getDice2() {
	        int diceRoll=0;
	        diceRoll = getDice();
	        int temp = 0;
	        while (true) {

	            if (diceRoll == 6) {
	                temp = temp + diceRoll ;
	                diceRoll = getDice();
	            } 
	            else 
	            {
	                diceRoll = diceRoll + temp;
	                break;
	            }
	        }
	        return diceRoll;
	    }
	 // For P keyword check
	 
	public static String play() throws IOException {
		
		BufferedReader myInput2 = new BufferedReader (new InputStreamReader (System.in));
		System.out.println("Press P to play and E to exit");
		String input1;
		input1=myInput2.readLine();
		return input1;
		
	}
	public static String game(int num) throws IOException{
		 BufferedReader myInput = new BufferedReader (new InputStreamReader (System.in));
		 String i2;
		 i2=myInput.readLine();
		  int no_users;
		  no_users=num;
		  
		  int[] totalusers = new int[no_users];
		  for (int i = 0; i < num; i++) {
              totalusers[i] = 0;
          }
          
		  frulecheck = new int[no_users];
		 for (int k = 0; k < 100; k++) {
	            //Assigning initial positions to the players which is 0
		  
	            for (int i = 0; i < num; i++) {
	                totalusers[i] = 0;
	                
	            }
	            // For checking first six
	            
	            for (int i = 0; i < num; i++) {
	                frulecheck[i] = 1;
	                
	            }
	            // Assigning ladders
	            ladder_arr[0] = 8;  // Will go to 25
	            ladder_arr[1] = 22; // Will go to 53
	            ladder_arr[2] = 29; // Will go to 41
	            ladder_arr[3] = 39; // Will go to 61
	            ladder_arr[4] = 71; // Will go to 82
	            ladder_arr[5] = 82; // Will go to 99
	            ladder_arr[6] = 83; // Will go to 91
	            
	            snake_arr[0] = 10; //Tail at 5
	            snake_arr[1] = 31; //Tail at 1
	            snake_arr[2] = 22; //Tail at 19
	            snake_arr[3] = 50; //Tail at 52
	            snake_arr[4] = 87; //Tail at 57
	            snake_arr[5] = 91; //Tail at 61
	            snake_arr[6] = 99; //Tail at 69
	            rounds = 0;
	            int max_roll = 0;
	            while (max_roll != 100) {
	                rounds++;
	                for (int i = 0; i < num; i++) {
	                    System.out.println("Turn of user " + (i + 1));
	                    int dice_roll=0;
	                    dice_roll = getDice();
	               
	                    // rulechecking for first six
	                    if (dice_roll != 6 && frulecheck[i] == 1) {
	                        System.out.println("You rolled " + dice_roll + "Need 6 to move" );
	                        continue;
	                    }
	                    else {
	                    	
	                    frulecheck[i] = 0;
	                    int dice2=getDice2();
	                    System.out.println("User "+ (i+1) +" have rolled "+ dice2);
	                    totalusers[i] += dice2;
	                    System.out.println("User "+ (i+1) + "is at "+ totalusers[i]);
	                    totalusers[i] = rulecheck(dice2, snake_arr, ladder_arr,i,totalusers[i]);
	                    if (totalusers[i] == 100) {

	                        max_roll = 100;
	                        break;
	                    }
	                }
	            }
	            }
	            rounds_arr[k] = rounds;
	}
	      // For Average
	        for (int i = 0; i < rounds_arr.length; i++) {
	            sum = sum + rounds_arr[i];
	        }
	        avg = sum / rounds_arr.length; // Finding avg rounds
	        Arrays.sort(rounds_arr);
	        min = rounds_arr[0]; // Finding minimum rounds
	        max = rounds_arr[rounds_arr.length - 1]; // Finding maximum rounds
	        
	        System.out.println("Minimum rounds "+ min);
	        System.out.println("Average rounds "+ avg);
	        System.out.println("Maximum rounds "+ max);
	     // Get the Java runtime
	        Runtime runtime = Runtime.getRuntime();
	        // Run the garbage collector
	        runtime.gc();
	        // Calculate the used memory
	        long memory = runtime.totalMemory() - runtime.freeMemory();
	        System.out.println("Used memory is bytes: " + memory);
	        System.out.println("Used memory is megabytes: "+ bytesToMegabytes(memory));
	        
	     
	        return i2; // returns prameter "playAg
		 
		
		
		
	}
public static void gameBoard(){

	// Board in array
	 int[] integerArray = new int[100];
	    for (int i=1; i < 100 ; i++){
	    integerArray[i] = i;
	    }
    int counter= 100,iteration=-1; // sets the counter and iteration vaiables to be used in making the board
    System.out.println ("\t\t\tGame Board\t\t\t");
    
  
   
    /*
  Visualization of board to user
    */
    while (counter > 0){// start while
        if (counter%10 == 0 && counter != 100){// rulechecks if the counter is at a 90, or 80...
            if(iteration==-1)
            {
                // subtract 9 from the counter
                // and sets it to start adding by one
                counter-=9;
                iteration=1;
            }
            else
            {
                System.out.print(counter+"\t");
                counter-=10;
                iteration=-1; // set the counter to start subtract by ones
            }
            if(counter!=0)
            System.out.print("\n" + counter + "\t"); // just prints out the counter with a line breck
        }
        else
        System.out.print(counter + "\t"); // just prints out the counter
        counter+=iteration; // sets counter to add by iteration
    }// end while
    System.out.println();
    System.out.println ("-----------------------------------------------------");
    
    
	}

	
}

