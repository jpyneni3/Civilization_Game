import java.util.Scanner;
public class Civilization {
    //global variables
    private static boolean playing = true; //necessary to start and end the game
    private static Scanner scan = new Scanner(System.in); //to recieve inputs from user
    private static String leaderName = new String();
    private static String civName = new String();
    private static String[]cities = new String[5]; //array of cities
    private static int attacks;
    private static double gold = 20.5;
    private static double resources = 30.0;
    private static int happiness = 10;
    private static int militaryUnits;
    private static int techPoints;
    private static String firstCity;
    private static int cityCount;


    public static void main(String[] args) {
        while (playing) {
             //Your game code here

            //Use this to break out of the game loop.
            //Feel free to move it around.
            System.out.println("CIVILIZATION");
            System.out.print("Welcome! Please enter the number");
            System.out.println(" for the civilization that you want to lead");
            civSelect(); //method to have the user select the civilization he or she wants to lead
            System.out.println("\nHello "+leaderName+", let's get started on building the "+civName+" civilization!");
            settleFirstCity();
            playing = false;
        }

        System.out.println("Game Over!");
    }

    public static void civSelect() {
    	System.out.print("1.American\n2.Zulu\n3.English\n4.Chinese\n");
        int i = scan.nextInt();
        scan.nextLine();
        if (i==1){
            leaderName= "George Washington";
            civName= "American";
        }
        else if (i==2){
            leaderName= "Shaka";
            civName="Zulu";
        }
        else if (i==3){
            leaderName="Queen Elizabeth";
            civName="English";
        }
        else if (i==4){
            leaderName="Wu Zetian";
            civName="Chinese";
        }
        else {
            System.out.println("Incorrect number, please try again!");
            civSelect();
        }
    }
    public static void settleFirstCity(){
      System.out.println(leaderName+ ", what would you like to name your first city?");
      firstCity=scan.nextLine();
      cities[0]=firstCity;
      cityCount++;
      nextTurn();
    }
    public static void printProperties(){
      System.out.println("Here is a list of your properties, "+leaderName);
      System.out.println();
      System.out.print("Cities: ");
      for (int i=0; i<cityCount-1; i++){
        System.out.print(cities[i]+", ");
        }
        System.out.println(cities[cityCount-1]);
      System.out.println("Number of Attacks: "+attacks);
      System.out.println("Gold: "+gold);
      System.out.println("Resources: "+resources);
      System.out.println("Happiness: "+happiness);
      System.out.println("Military Units: "+militaryUnits);
      System.out.println("Technology Points: "+techPoints);
      System.out.println();
    }
    public static void nextTurn(){
      checkWin();
      if (playing==false){
        return;
      }
      printProperties();
      System.out.println(leaderName+", you have 6 options of what you can do next. Please select an option by entering the corresponding number to that action.");
      System.out.println("1.Settle a City\n2.Demolish a City\n3.Build Milita\n4.Research Technology\n5.Attack Enemy City\n6.End Turn");
      int i= scan.nextInt();
      scan.nextLine();
      if (i==1){
          settleCity();
      }
      else if (i==2){
        demCity();
      }
      else if (i==3){
        buildMilitia();
            }
      else if (i==4){
        researchTech();
      }
      else if (i==5){
        attackCity();
                }
      else if (i==6){
            addProperties();
            nextTurn();
                }
      else {
      System.out.println("Incorrect number, please try again!");
      retryTurn();
                }



    }
    public static void retryTurn(){
      System.out.println(leaderName+", you have 6 options of what you can do next. Please select an option by entering the corresponding number to that action.");
      System.out.println("1.Settle a City\n2.Demolish a City\n3.Build Milita\n4.Research Technology\n5.Attack Enemy City\n6.End Turn");
      int i= scan.nextInt();
      if (i==1){
          settleCity();
      }
      else if (i==2){
        demCity();
      }
      else if (i==3){
        buildMilitia();
            }
      else if (i==4){
        researchTech();
      }
      else if (i==5){
        attackCity();
                }
      else if (i==6){
           addProperties();
           nextTurn();
                }
      else {
      System.out.println("Incorrect number, please try again!");
      retryTurn();
    }
  }
    public static void checkWin(){
      if (techPoints==20||attacks==10){
        playing=false;
      }
    }
    public static void addProperties(){//this method will be at the end of the turn methods to add the values that the user gets after every turn
      resources+=1.0;
      if(happiness>20){
        resources+=5*cityCount;
      }
      gold+=3*cityCount;
      if (resources%2==0){
        happiness+=1;
      }
      if (resources%2!=0){
        happiness-=3;
      }
    }
    public static void settleCity(){
      if (cityCount==5){
        System.out.println("You have the maximum number of cities!\nRetry!");
        retryTurn();
        }
      else if(gold<15.5){
        System.out.println("You don't have enough gold. Turn over");
        addProperties();
        nextTurn();
      }
      else{
        System.out.println(leaderName+", you have selected to settle a new city");
        System.out.println("Here is a list of your cities: ");
        for (int i=0; i<cityCount-1; i++){
          System.out.print(cities[i]+", ");
          }
        System.out.println(cities[cityCount-1]);
        System.out.println("What do you want to name your new city?");
        cities[cityCount]=scan.nextLine();
        cityCount++;
        gold-=15.5;
        addProperties();
        nextTurn();
          }

    }
    public static void demCity(){
      System.out.println(leaderName+", you have selected to demolish one of your cities");
      if (cityCount==1){
        System.out.println("You only have one city, which you cannot destroy. Please select another action");
        retryTurn();
      }
      else{
      System.out.println("Here is a list of your cities");
      for (int i=0; i<cityCount; i++){
        System.out.print(i+1+"."+cities[i]+" ");
        System.out.println();
      }
      System.out.println("Input the number of the city you wish to demolish");
      int city= scan.nextInt();
      if (city==cityCount){
        cities[city-1]=null;
        cityCount--;
        resources+=1.5;
        addProperties();
        nextTurn();
      }
      else if(city<cityCount) {
      for (int i=city; i<cityCount; i++){
        cities[i-1]=cities[city];
      }
      cityCount--;
      resources+=1.5;
      addProperties();
      nextTurn();
    }
      else {
      System.out.println("The city you selected does not exist. Please try again.");
      demCity();
    }
  }
}
    public static void buildMilitia(){
      if (gold<5||resources<3){
        System.out.println("You do not have enough gold and/or resources for this action. Your turn is over");
        addProperties();
        nextTurn();
      }
      else{
        gold-=5;
        resources-=3;
        militaryUnits+=1;
        addProperties();
        nextTurn();
      }
    }
    public static void researchTech(){
      if (gold<50||resources<2){
        System.out.println("You do not have enough gold and/or resources for this action. Your turn is over");
        addProperties();
        nextTurn();
      }
      else{
        gold-=50;
        resources-=2;
        techPoints+=1;
        addProperties();
        nextTurn();
      }

    }
    public static void attackCity(){
      if (militaryUnits<6){
        System.out.println("You do not have enough militia for this action. Your turn is over");
        addProperties();
        nextTurn();
      }
      else{
        militaryUnits-=6;
        happiness-=3;
        gold+=10;
        attacks++;
      }
      addProperties();
      nextTurn();
    }
}
