package com.app.lock;

public class Rooms {
    private String roomNumber;
    private boolean isBooked;

    public Rooms(String roomNumber) {
        this.roomNumber = roomNumber;
        this.isBooked = false;
    }

    public synchronized void book(String user) {
        if (!isBooked) {
            System.out.println(user + " is booking room " + roomNumber);
            isBooked = true;
            System.out.println(user + " successfully booked room " + roomNumber);
        } else {
            System.out.println("Room " + roomNumber + " is already booked!");
        }
    }

    public String getRoomNumber() {
        return roomNumber;
    }
}
