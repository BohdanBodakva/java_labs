package ua.lviv.iot.lab5_6.Exceptions;

public class MakeMoreThanOneNecklaceException extends Exception{
    public MakeMoreThanOneNecklaceException(){
        super("Tou cannot make more than one necklace!");
    }
}
