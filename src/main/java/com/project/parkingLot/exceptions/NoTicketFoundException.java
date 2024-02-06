package com.project.parkingLot.exceptions;

public class NoTicketFoundException extends Exception{
    public NoTicketFoundException(String msg){
        super(msg);
    }
}
