public class Ride {
    private int rideId;
    private char pickupPoint;
    private char dropPoint;
    private int Distance;
    private int rate;
    private int startTime;
    private int endTime;
    private int currentEarnings;

    public Ride(int rideId, char pickupPoint, char dropPoint, int startTime) {
        this.rideId = rideId;
        this.pickupPoint = pickupPoint;
        this.dropPoint = dropPoint;
        this.Distance = (Math.abs(dropPoint-pickupPoint))*15;
        this.rate = 100+(Distance-5)*10;
        this.startTime = startTime;
        this.endTime = startTime+Math.abs(dropPoint-pickupPoint);
    }

    public int getDistance() {
        return Distance;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setDistance(int Distance) {
        this.Distance = Distance;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public void setCurrentEarnings(int currentEarnings) {
        this.currentEarnings = currentEarnings;
    }

    public int getCurrentEarnings() {
        return currentEarnings;
    }

    public void setCabId(int id) {
    }
    @Override
    public String toString() {
        return "Ride Details {" +
                "Ride Id: " + rideId +
                ", Pickup Point: " + pickupPoint +
                ", Drop Point: " + dropPoint +
                ", Start Time: " + startTime +
                ", End Time=" + endTime +
                ", Distance: " + Distance +
                ", Rate: " + rate +
                ", Current Earnings of Cab: " + currentEarnings +
                "}\n";
    }
}
