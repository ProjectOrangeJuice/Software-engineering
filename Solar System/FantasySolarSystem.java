import java.util.Scanner;
import java.util.Random;

class FantasySolarSystem{
  public static void main(String[] args){
    String input;
    final int RANDOM_MAX = 10;
    SolarSystem solarSystem = null;//Set as null to allow it to compile
    Scanner in = new Scanner(System.in);
    Random rnd = new Random();


    System.out.println("Enter solar system name: ");
    do { //There will be atleast one input
      input = in.nextLine();
      if(!input.equals("done")){
        if(solarSystem == null){//This will be the first input
          solarSystem = new SolarSystem(input);//Replace null with the object
          System.out.println("Now enter planet names - type 'done' to finish");
          System.out.println("Enter name: ");
        } else{
          double mass = rnd.nextDouble()*RANDOM_MAX;
          double distance;
          do {//Must run atleast once
            distance = rnd.nextDouble()*RANDOM_MAX;
          }while(distance<1);
          solarSystem.addPlanet(input,mass,distance);
          System.out.println("Enter name: ");
        }

      }
    }while(!input.equals("done"));
    //Display the results in two formats.
    System.out.println(solarSystem.toString());
    System.out.println(solarSystem.toTable());

  }

}
