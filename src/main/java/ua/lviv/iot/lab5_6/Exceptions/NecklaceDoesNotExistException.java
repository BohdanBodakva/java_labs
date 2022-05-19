package ua.lviv.iot.lab5_6.Exceptions;

public class NecklaceDoesNotExistException extends Exception{
    public NecklaceDoesNotExistException(){
        super("Firstly you must make a necklace!");
    }
}
