import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.awt.*;
import java.util.Scanner;
import javax.swing.*;

import java.io.FileOutputStream;
import java.io.PrintWriter;


public class Main {

    public static Scanner workOnFile(ArrayList inventory){
        FileOutputStream myFile = null;
        Scanner scan = new Scanner(System.in);

        //try and catch to see if the file is not found
        try {
            myFile = new FileOutputStream("src/inputFile.csv", true);
        }
        catch (FileNotFoundException e){
            System.out.println("Could not open input file - ending program");
            System.exit(1);
        }

        PrintWriter printing = new PrintWriter(myFile);

        String VehicleTag = "NA";
        String VehicleVin = "NA";
        double VehiclePurchPrice = 0.0;
        int VehiclePurchYear = 0;
        int numDoors = 0;
        double weight = 0;
        boolean tint = false;

        //2) create an input file of Vehicles,Cars andTrucks in comma separated values (CSV) format

        for(int i = 1; i<=2; i++){
            System.out.println("Enter vehicle " + i + " information:");

            System.out.println("Enter tag:");
            VehicleTag = scan.next();

            System.out.println("Enter vin:");
            VehicleVin = scan.next();

            System.out.println("Enter purchase price:");
            VehiclePurchPrice = scan.nextDouble();

            System.out.println("Enter purchase year:");
            VehiclePurchYear = scan.nextInt();

            System.out.println("If your vehicle a vehicle, car, or truck");
            String vehicleType = scan.next();

            if(vehicleType.equals("car")){
                System.out.println("Does the car have a tint? (y/n)");
                if(scan.nextLine().equals("y")){
                    tint = true;
                }
                else{
                    tint = false;
                }


                System.out.println("How many doors does your car have?");
                numDoors = scan.nextInt();

                printing.println("Car, " + VehicleTag + ", " +  VehicleVin + ", " +  VehiclePurchPrice + ", " + VehiclePurchYear + ", " + vehicleType + ", " + tint + ", " + numDoors);
                inventory.add(new Car(VehicleTag, VehicleVin, VehiclePurchPrice, VehiclePurchYear,
                        vehicleType, tint, numDoors));
                Vehicle vehi = new Car(VehicleTag, VehicleVin, VehiclePurchPrice, VehiclePurchYear,
                        vehicleType, tint, numDoors);

                DisplayTaxResult(vehi, inventory);


            }
            else if(vehicleType.equals("truck")){
                System.out.println("What is the weight of the truck?");
                weight  = scan.nextDouble();


                printing.println("Truck, " + VehicleTag + ", " +  VehicleVin + ", " +  VehiclePurchPrice + ", " + VehiclePurchYear + ", " + vehicleType + ", " + weight);
                inventory.add(new Truck(VehicleTag, VehicleVin, VehiclePurchPrice, VehiclePurchYear, weight));
                Vehicle vehi = new Truck(VehicleTag, VehicleVin, VehiclePurchPrice, VehiclePurchYear, weight);

                DisplayTaxResult(vehi, inventory);
            }
            else{
                printing.println("Vehicle, " + VehicleTag + ", " +  VehicleVin + ", " +  VehiclePurchPrice + ", " + VehiclePurchYear + ", " + vehicleType);
                inventory.add(new Vehicle(VehicleTag, VehicleVin, VehiclePurchPrice, VehiclePurchYear));
                Vehicle vehi = new Vehicle(VehicleTag, VehicleVin, VehiclePurchPrice, VehiclePurchYear);

                DisplayTaxResult(vehi, inventory);
            }




        }


        printing.close();

        return scan;
    }


    //4) for each vehicle in the inventory print the tag and the tax

    public static void DisplayTaxResult(Vehicle myV, ArrayList inventory){

        final String DASH = "-";

        // create the JTextArea and fill it with content
        JTextArea theText = new JTextArea(inventory.size()+2,25); //create the text area
        theText.setFont(new Font("monospaced", Font.BOLD, 20));
        theText.setForeground(Color.GREEN);
        theText.setBackground(Color.LIGHT_GRAY);

        // add specific text about inventory to JTextArea
        theText.append(String.format("%-12s%-10s%10s%n","V. type","V. tag","Tax Due"));
        theText.append(String.format("%32s%n%n",DASH.repeat(32)));

       // Vehicle myV = new Vehicle();
        //inventory.add(myV);
        for(int i = 0; i<1; i++){
            theText.append(String.format("%-12s%-10s%,10.2f%n",
                    myV.getType(),myV.getTag(), myV.getTax()));
        }

        // create the JPanel and add the JTextArea to it
        JPanel mainPanel = new JPanel();
        mainPanel.add(theText); //add the text area to the panel

        // set up JFrame with a few members set and
        // add JPanel content to it
        final JFrame theFrame = new JFrame();
        theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        theFrame.setTitle("Vehicle Taxes Due\n");
        theFrame.setSize(500, 500);
        theFrame.setLocation(550, 400);
        theFrame.getContentPane().add(mainPanel);
        theFrame.pack();
        theFrame.setVisible(true);

    }

    public static void main(String[] args) {
        //1) create an inventory of type ArrayList of vehicles
        ArrayList<Vehicle> inventory = new ArrayList < Vehicle >();

        inventory.add(new Car("bmt147", "lkjlkjlklj12231231lkjl", 15173.17, 2005,
                "pinto", true, 4));
        inventory.add(new Vehicle("xrc761","oojojjpjp09809",3500.00, 2015));
        inventory.add(new Truck("abc698", "iuyj08-9j", 35165.88, 2019, 4));



        //calling methods
        Main.workOnFile(inventory);


       //Main.DisplayTaxResult(inventory);

        //3) put vehicles in the inventory (read from a file and add), the followin lines are examples






    }


}
