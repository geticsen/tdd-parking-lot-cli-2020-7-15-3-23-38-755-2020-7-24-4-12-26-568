package com.oocl.cultivation;

public class ParkingCarTicket {
    private boolean isUsed = false;
    private String ticketMessage = "";

    public boolean isUsed() {
        return isUsed;
    }

    public void setUsed(boolean used) {
        isUsed = used;
    }

    public String getTicketMessage() {
        return ticketMessage;
    }

    public void setTicketMessage(String ticketMessage) {
        this.ticketMessage = ticketMessage;
    }
}
