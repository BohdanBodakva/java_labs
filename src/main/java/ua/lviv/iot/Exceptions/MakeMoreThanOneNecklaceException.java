package ua.lviv.iot.Exceptions;

public class MakeMoreThanOneNecklaceException extends Exception{
    public MakeMoreThanOneNecklaceException(){
        super("Tou cannot make more than one necklace!");
    }
}
