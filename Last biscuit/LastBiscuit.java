/* Attempt at level 3
* Written by Oliver Harris
* Enjoy the read */

import java.util.Scanner;

class LastBiscuit {
  public static void main(String[] args) {
    //Final variables could be used if the game had the ability to restart
    final int START_BARREL_ONE = 6;
    final int START_BARREL_TWO = 8;

    final int LOWEST_VALUE = 0; //when the barrel is empty.

    //But this version doesn't restart so the barrels are set here
    int barrelOne = START_BARREL_ONE;
    int barrelTwo = START_BARREL_TWO;

    boolean playerOne = true;
    Scanner in = new Scanner(System.in);


    //Start the game
    System.out.println("Biscuits Left - Barrel 1: "+barrelOne);
    System.out.println("Biscuits Left - Barrel 2: "+barrelTwo);
    do{//main game loop, new loop for each time it changes player
      boolean invalid = false;//if the input goes wrong, the players go is invalid
      //and must go again

      do{//if the user enters something invalid they have to start this loop again

        if(invalid){
          invalid = false;
          System.out.println("Please enter a number between 1 and "+barrelOne+
          " for barrel1 or 1 and "+barrelTwo+" for barrel2");
        }


        //get the number of biscuits to take
        int grab = 0;//temporary value

        if(playerOne){
          System.out.print("Biscuits taken by player 1: ");
        }
        else{
          System.out.print("Biscuits taken by player 2: ");
        }
        while(!in.hasNextInt()){
          System.out.print("Enter a number!: ");
          in.nextLine();
        }
        grab = in.nextInt();



        //get which barrels
        System.out.print("From barrel1 (one), barrel2 (two), or both (both)? ");
        in.nextLine(); //clear the input
        String barrel = in.nextLine();
        barrel = barrel.toLowerCase();//To lowercase. Important for the switch statment
        while(!barrel.equals("one") && !barrel.equals("two") && !barrel.equals("both")){
          System.out.println("Please enter one, two or both.");
          barrel = in.nextLine();

        }

        switch(barrel){//which barrel is being affected
          case "one":
            if(barrelOne < grab || grab <=LOWEST_VALUE){
              invalid = true;
            }
            else{
              barrelOne -= grab;
              playerOne = !playerOne;//swap player
            }
            break;

          case "two":
            if(barrelTwo < grab ||  grab <=LOWEST_VALUE){
              invalid = true;
            }
            else{
              barrelTwo -= grab;
              playerOne = !playerOne;//swap player
            }
            break;

          case "both":
            if(barrelOne < grab || barrelTwo < grab ||  grab <= LOWEST_VALUE ){
              invalid = true;
            }
            else{
              barrelOne -= grab;
              barrelTwo -= grab;
              playerOne = !playerOne;//swap player
            }
            break;
        }

      }
      while(invalid);
      //setting up for the next player, output what's left.
      System.out.println("Biscuits Left - Barrel 1: "+barrelOne);
      System.out.println("Biscuits Left - Barrel 2: "+barrelTwo);

    }
    while(barrelOne != LOWEST_VALUE || barrelTwo != LOWEST_VALUE);//end game conditions

    //who won?
    if(playerOne){
      System.out.println("Winner is player 2");
    }
    else{
      System.out.println("Winner is player 1");
    }

  }


}
