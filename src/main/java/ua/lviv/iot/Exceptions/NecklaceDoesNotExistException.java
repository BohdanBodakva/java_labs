package ua.lviv.iot.Exceptions;

public class NecklaceDoesNotExistException extends Exception{
    public NecklaceDoesNotExistException(){
        super("Firstly you must make a necklace!");
    }
}
