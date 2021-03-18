public class Truck extends Vehicle {

    private double Tweight;

    //1) create a parameterized constructor
    //1.1) call Vehicle constructor

    public Truck(String Vtag, String Vvin, double Vpurchaseprice, int Vpurchaseyear, double Tweight){
        super.Vtag = Vtag;
        super.Vvin = Vvin;
        super.Vpurchaseprice = Vpurchaseprice;
        super.Vpurchaseyear = Vpurchaseyear;
        this.Tweight = Tweight;

    }

    //2) override getType and getTax to compute tax for Truck as described in the project description

    public String getType(){
        return Venum.truck.toString();

    }

    public double getTax(){
        double truckTax = super.getTax() + 50.75;

        if(Tweight>2.00){
            truckTax = truckTax + ((Tweight)*(100.00));
        }

        return truckTax;
    }

   //3) override toString
   public String toString(){
       return "TRUCK Vehicle Tag: " + getTag() + " Vin: " + getVin() + " Purchase Price: " + getPurchasePrice() + " Purchase Year:" + getPurchaseYear();
   }

}
