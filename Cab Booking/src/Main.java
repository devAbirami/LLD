import java.util.ArrayList;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean display = true;
        int option;
        char pickupPoint;
        char dropPoint;
        int startTime;
        ArrayList<Cab> cabList = new ArrayList<>();
        int id = 1;
        while (id < 5) {
            cabList.add(new Cab(id++));
        }
        id = 1;
        do {
            System.out.println("Enter your option\n" +
                    "1. Book Ride\n" +
                    "2. View Ride Details\n" +
                    "3. Exit\n");
            option = sc.nextInt();
            switch (option) {
                case 1:
                    boolean cabAssigned = false;
                    Cab assignedCab = null;
                    System.out.println("Enter ride details\n" +
                            "1. Enter pickup point");
                    pickupPoint = sc.next().charAt(0);
                    if(pickupPoint<'A' || pickupPoint>'F'){
                        System.out.println("Sorry. Cab service not available for this pickup point.");
                        break;
                    }
                    System.out.println("2. Enter drop point");
                    dropPoint = sc.next().charAt(0);
                    if(dropPoint<'A' || dropPoint>'F'){
                        System.out.println("Sorry. Cab service not available for this drop point.");
                        break;
                    }
                    System.out.println("3. Enter start time");
                    startTime = sc.nextInt();
                    if(pickupPoint==dropPoint){
                        System.out.println("Pickup and drop location cannot be the same");
                        break;
                    }
                    Ride ride = new Ride(id++, pickupPoint, dropPoint, startTime);
                    for (Cab cab : cabList) {
                        if (cab.getCurrentLocation() == pickupPoint && cab.getAvailableTime() <= ride.getStartTime()) {
                            if(assignedCab!=null){
                                assignedCab = assignedCab.getEarnings()>cab.getEarnings()? cab:assignedCab;
                            }else{
                                assignedCab = cab;
                                cabAssigned = true;
                            }
                        }
                    }
                    if (!cabAssigned){
                        int minDistance=7;
                        for (Cab cab : cabList) {
                            if (Math.abs(cab.getCurrentLocation()-pickupPoint)<=minDistance && cab.getAvailableTime() <= ride.getStartTime()) {
                                if(Math.abs(cab.getCurrentLocation()-pickupPoint)==minDistance) {
                                    assignedCab = assignedCab.getEarnings() > cab.getEarnings() ? cab : assignedCab;
                                }else{
                                    assignedCab = cab;
                                }
                                minDistance = Math.abs(assignedCab.getCurrentLocation() - pickupPoint);
                                cabAssigned = true;
                            }
                        }
                    }
                    if(cabAssigned){
                        ride.setCabId(assignedCab.getId());
                        ride.setStartTime(startTime);
                        ride.setEndTime(ride.getStartTime() + Math.abs(dropPoint - pickupPoint));
                        ride.setCurrentEarnings(assignedCab.getEarnings() + ride.getRate());
                        assignedCab.getRides().add(ride);
                        assignedCab.setAvailableTime(ride.getEndTime());
                        assignedCab.setEarnings(ride.getCurrentEarnings());
                        assignedCab.setCurrentLocation(dropPoint);
                        System.out.println("Cab " + assignedCab.getId() + " is alloted.\n" +
                                ride.toString());
                    }else{
                        System.out.println("No cab is available now.");
                    }
                    break;
                case 2:
                    System.out.println("Enter the ID of the cab to view ride details");
                    int findId=sc.nextInt();
                    if(findId<1 || findId>4){
                        System.out.println("Invalid cab ID"); break;
                    }
                    ArrayList<Ride> rides = null;
                    for(Cab cab:cabList){
                        if(cab.getId()==findId){
                            System.out.println(cab);
                            rides = cab.getRides();
                        }
                    }
                    if (rides==null) {
                        System.out.println("No rides yet");
                    } else {
                        System.out.println(rides);
                    }
                    break;
                case 3:
                    display=false;
            }
        } while (display);
    }
}
