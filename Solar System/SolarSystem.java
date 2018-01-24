/*
*Learning from feedback
*In the previous coursework I was putting else {} on a new line after if.
*So in this coursework I've made sure it's straight after the last bracket of if
*I've also used final variables instead of leaving "magic" and
*repeating numbers. This gives the magic numbers a description and making it
*easier to change a value throughout the program
*/


import java.util.ArrayList;

public class SolarSystem{
  private final String SOLAR_NAME;
  private ArrayList<Planet> planets = new ArrayList<Planet>();

  //Name itself
  public SolarSystem(String solarName){
    SOLAR_NAME = solarName;
  }

  //Add a planet object to the planet array
  public void addPlanet(String name, double mass, double distance){
    planets.add(new Planet(name,mass,distance));


  }


  //Go through planet array and get the information about each planet
  //return a string with this information
  public String toString(){
    String fullString = SOLAR_NAME+"\n";
    for(Planet planet : planets ){
      fullString += String.format("Planet %s has a mass of %s Earths,"+
      " is %sAU from its star, and orbits in %s"+
      " years\n", planet.getName(),planet.getMass(),planet.getAU(),
      planet.getOrbitalPeriod());
    }
    return fullString;
  }

  //Go through each planet and display the information in a table format
  public String toTable(){
    String fullTable = String.format("%-20s%-20s%-20s%-20s%n","Name","Mass","Distance","Period (years)");
    for(Planet planet : planets){
      fullTable += String.format("%-20s%-20s%-20s%-20s%n",planet.getName(),planet.getMass(),planet.getAU(),
      planet.getOrbitalPeriod());

    }
    return fullTable;
  }


}
