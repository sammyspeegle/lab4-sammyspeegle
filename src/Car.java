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
        // 1.1)ccall Vehicle constructor

    //2) override Vehicle method getType, getTax
    //2.1) getTax should compute the tax for Car as described in the project description
    //3) override toString method
    public String toString(){
        return "Car:  "+super.Vtag;
    }
}
