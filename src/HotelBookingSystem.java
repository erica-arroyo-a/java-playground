import java.text.SimpleDateFormat;
import java.util.*;

class Room {
    private int roomNumber;
    private String roomType;
    private double price;
    private boolean isAvailable;

    public Room(int roomNumber, String roomType, double price) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.price = price;
        this.isAvailable = true;  // By default, a room is available
    }

    // Getters and setters
    public int getRoomNumber() {
        return roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public double getPrice() {
        return price;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void bookRoom() {
        this.isAvailable = false;
    }

    public void cancelBooking() {
        this.isAvailable = true;
    }

    @Override
    public String toString() {
        return "Room Number: " + roomNumber + ", Type: " + roomType + ", Price: $" + price + ", Available: " + isAvailable;
    }
}

class Reservation {
    private static int reservationCounter = 1;
    private int reservationId;
    private String customerName;
    private int roomNumber;
    private Date checkInDate;
    private Date checkOutDate;

    public Reservation(String customerName, int roomNumber, Date checkInDate, Date checkOutDate) {
        this.reservationId = reservationCounter++;
        this.customerName = customerName;
        this.roomNumber = roomNumber;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    // Getters and setters
    public int getReservationId() {
        return reservationId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    @Override
    public String toString() {
        return "Reservation ID: " + reservationId + ", Customer: " + customerName + ", Room Number: " + roomNumber +
                ", Check-In: " + checkInDate + ", Check-Out: " + checkOutDate;
    }
}


class Hotel {
    private List<Room> rooms;
    private List<Reservation> reservations;

    public Hotel() {
        this.rooms = new ArrayList<>();
        this.reservations = new ArrayList<>();
    }

    // Add room to the hotel
    public void addRoom(int roomNumber, String roomType, double price) {
        Room room = new Room(roomNumber, roomType, price);
        rooms.add(room);
    }

    // Check availability of rooms
    public Room checkAvailability(int roomNumber) {
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber && room.isAvailable()) {
                return room;
            }
        }
        return null;
    }

    // Book a room
    public Reservation bookRoom(String customerName, int roomNumber, Date checkInDate, Date checkOutDate) {
        Room room = checkAvailability(roomNumber);
        if (room != null) {
            room.bookRoom();  // Mark the room as booked
            Reservation reservation = new Reservation(customerName, roomNumber, checkInDate, checkOutDate);
            reservations.add(reservation);
            return reservation;
        }
        return null;  // Room not available
    }

    // Cancel a reservation
    public boolean cancelReservation(int reservationId) {
        for (Reservation reservation : reservations) {
            if (reservation.getReservationId() == reservationId) {
                Room room = getRoomByNumber(reservation.getRoomNumber());
                room.cancelBooking();  // Mark the room as available
                reservations.remove(reservation);
                return true;
            }
        }
        return false;
    }

    // Get a room by its number
    private Room getRoomByNumber(int roomNumber) {
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber) {
                return room;
            }
        }
        return null;
    }

    // List all rooms
    public void listRooms() {
        for (Room room : rooms) {
            System.out.println(room);
        }
    }

    // List all reservations
    public void listReservations() {
        for (Reservation reservation : reservations) {
            System.out.println(reservation);
        }
    }
}


public class HotelBookingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Hotel hotel = new Hotel();

        // Add some rooms to the hotel
        hotel.addRoom(101, "Single", 100.0);
        hotel.addRoom(102, "Double", 150.0);
        hotel.addRoom(103, "Suite", 250.0);

        while (true) {
            System.out.println("\n--- Hotel Booking System ---");
            System.out.println("1. View Rooms");
            System.out.println("2. Book Room");
            System.out.println("3. View Reservations");
            System.out.println("4. Cancel Reservation");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    hotel.listRooms();
                    break;
                case 2:
                    // Book a room
                    System.out.print("Enter customer name: ");
                    String customerName = scanner.nextLine();
                    System.out.print("Enter room number: ");
                    int roomNumber = scanner.nextInt();
                    System.out.print("Enter check-in date (yyyy-MM-dd): ");
                    String checkInDateString = scanner.next();
                    System.out.print("Enter check-out date (yyyy-MM-dd): ");
                    String checkOutDateString = scanner.next();

                    // Parse dates
                    try {
                        Date checkInDate = new SimpleDateFormat("yyyy-MM-dd").parse(checkInDateString);
                        Date checkOutDate = new SimpleDateFormat("yyyy-MM-dd").parse(checkOutDateString);
                        Reservation reservation = hotel.bookRoom(customerName, roomNumber, checkInDate, checkOutDate);
                        if (reservation != null) {
                            System.out.println("Booking Successful! Reservation ID: " + reservation.getReservationId());
                        } else {
                            System.out.println("Sorry, the room is not available.");
                        }
                    } catch (Exception e) {
                        System.out.println("Invalid date format.");
                    }
                    break;
                case 3:
                    // View reservations
                    hotel.listReservations();
                    break;
                case 4:
                    // Cancel reservation
                    System.out.print("Enter reservation ID to cancel: ");
                    int reservationId = scanner.nextInt();
                    if (hotel.cancelReservation(reservationId)) {
                        System.out.println("Reservation cancelled successfully.");
                    } else {
                        System.out.println("Reservation not found.");
                    }
                    break;
                case 5:
                    System.out.println("Exiting the system.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }
}
