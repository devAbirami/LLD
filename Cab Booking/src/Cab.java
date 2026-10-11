import java.util.ArrayList;

public class Cab {
    private int id;
    private char currentLocation='A';
    private int earnings =0;
    private int availableTime = 0;
    private final ArrayList<Ride> rides = new ArrayList<>();

    public Cab(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public char getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(char currentLocation) {
        this.currentLocation = currentLocation;
    }

    public int getEarnings() {
        return earnings;
    }

    public void setEarnings(int earnings) {
        this.earnings = earnings;
    }

    public int getAvailableTime() {
        return availableTime;
    }

    public void setAvailableTime(int availableTime) {
        this.availableTime = availableTime;
    }

    public ArrayList<Ride> getRides() {
        return rides;
    }

    @Override
    public String toString() {
        return "Cab Details {" +
                "Cab ID: " + id +
                ", Current Location: " + currentLocation +
                ", Total Earnings: " + earnings +
                ", Available From: " + availableTime +
                "}\n";
    }
}
