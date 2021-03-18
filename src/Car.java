// Car class which inherits (extends) the Vehicle class
// Cars have additional information:
//      model name
//      window tint
//      number of doors

public class Car extends Vehicle {

    private String CmodelName;
    private boolean Cwindowtint;
    private int Cnumdoors;


    //1) Car parametrized constructor
    // 1.1)call Vehicle constructor
      public Car(String Vtag, String Vvin, double Vpurchaseprice, int Vpurchaseyear, String CmodelName, boolean Cwindowtint, int Cnumdoors){
          super();
          super.Vtag = Vtag;
          super.Vvin = Vvin;
          super.Vpurchaseprice = Vpurchaseprice;
          super.Vpurchaseyear = Vpurchaseyear;
          this.CmodelName = CmodelName;
          this.Cwindowtint = Cwindowtint;
          this.Cnumdoors = Cnumdoors;
      }

    //2) override Vehicle method getType, getTax

    public String getType(){
        return Venum.car.toString();
    }

    //2.1) getTax should compute the tax for Car as described in the project description
    public double getTax(){
        double newTaxPayment = super.getTax() + 17.45;
        if(Cwindowtint == true){
            newTaxPayment = newTaxPayment + 15;
        }

        if(Cnumdoors > 2){
            newTaxPayment = newTaxPayment + ((double)(Cnumdoors)* (4.73));
        }

        return newTaxPayment;
    }


    //3) override toString method
    public String toString(){
        return "CAR Vehicle Tag: " + getTag() + " Vin: " + getVin() + " Purchase Price: " + getPurchasePrice() + " Purchase Year:" + getPurchaseYear();
    }


}
