// Base class vehicle
//
// David John
// March 2021


public class Vehicle {

    //constructor
    public Vehicle() {
        Vtag = "NA";
        Vvin = "NA";
        Vpurchaseyear = 0;
        Vpurchaseyear = 0;
    }

    public static enum Venum  {car, truck, motorcycle, moped}; //list? access?

    protected String Vtag; //
    protected String Vvin;
    protected double Vpurchaseprice;
    protected int  Vpurchaseyear;


    //1) create Vehicle constructor
    public Vehicle(String Vtag, String Vvin, double Vpurchaseprice, int Vpurchaseyear){
        this.Vtag = Vtag;
        this.Vvin = Vvin;
        this.Vpurchaseprice = Vpurchaseprice;
        this.Vpurchaseyear = Vpurchaseyear;
    }

    //2) create getters and setters for the data memebers get tag

    public String getTag(){
        return Vtag;
    }

    public String getVin(){
        return Vvin;
    }

    public int getPurchaseYear(){
        return Vpurchaseyear;
    }

    public double getPurchasePrice(){
        return Vpurchaseprice;
    }



    public void setVtag(String Vtag){
        this.Vtag = Vtag;
    }

     //2.1) getTax should compute the basic vehicle tax based on purchase price

    public double getTax(){
        double priceNoYrs = (double)(Vpurchaseprice)*(.055);
        double priceWithTax = 0;
        for(int i =1; i<=10; i++){
            priceWithTax =  priceNoYrs * ((i)*(.1));
        }

        return priceWithTax;
    }

    //3) override toString method to print the vehicle info
    public String toString(){
        return "Vehicle Tag: " + getTag() + " Vin: " + getVin() + " Purchase Price: " + getPurchasePrice() + " Purchase Year:" + getPurchaseYear();
    }

    public String getType(){
        return "Vehicle";
    }


}
