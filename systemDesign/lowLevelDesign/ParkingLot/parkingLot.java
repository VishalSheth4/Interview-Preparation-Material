class parkingLot{
    List<ParkingFloor> parkingFloors;
    List<Entrance> entrance;
    List<Exit> exits;

    Address address;
    String parkingLotName;

    public boolean isParkingSpaceAvailableForVehicle(Vehicle vehicle);
    public boolean updateParkingAttendant(ParkingAttendant ParkingAttendant, int gateId);
}

class ParkingFloor{
    int levelId;
    boolean isFull;
    List<ParkingSpace> parkingSpaces;
    ParkingDisplayboard parkingDisplayBoard;
}

class Gate{
    int gateId;
    ParkingAttendant ParkingAttendant;
}

class Entrance extends Gate{
    public ParkingTicket getParkingTicket(Vehicle vehicle);
}

class Exit extends Gate{
    public ParkingTicket payForParking(ParkingTicket parkingTicket, PaymentType paymentType);
}

class Address{
    String country;
    String state;
    String city;
    String street;
    String pincode;
}

class ParkingSpace{
    int spaceId;
    boolean isFree;
    double costPerhour;
    Vehicle vehicle;
    ParkingSpaceType parkingSpaceType;
}

class ParkingDisplayboard {
    Map<ParkingSpaceType, Integer> freeSpotsAvailableMap;
    public void updateFreeSpotsAvailable(ParkingSpaceType parkingSpaceType, int spaces);
}

class Account{
    String name;
    String email;
    String password;
    String empId;
    Stirng address;
}

class Admin extends Account{
    public boolean addParkingFloor(ParkingLot parkingLot, ParkingFloor parkingfloor);
    public boolean addParkingSpace(ParkingFloor floor, ParkingSpace parkingSpace);
    public boolean addParkingDisplayboard(ParkingFloor floor, ParkingSpace);
}

class ParkingAttendant extends Account{
    Payment paymentService;
    public boolean processVehicleEntry(Vehicle vehicle);
    public PaymentInfo processPayment(ParkingTicket parkingTicket, PaymentType paymentType);
}

class Vehicle{
    String liscenseNumber;
    VehicleType vehicleType;
    ParkingTicket parkingTicket;
    PaymentInfo paymentInfo;
}

class ParkingTicket{
    int ticketId;
    int levelId;
    int spaceId;
    Date vehicleEntryDateTime;
    Date vehcielExitDateTime;
    ParkingSpaceType parkingSpaceType;
    double totalCost;
    ParkingVehicleStatus parkingTicketStatus;

    public void updateTotalCost();
    public void updateVehicleExitTime(vehcielExitDateTime);
}

public enum PaymentType{
    CASH, CREDIT_CARD, DEBIT_CARD, UPI;
}

public enum ParkingSpaceType{
    BIKE_PARKING , CAR_PARKING , TRUCK_PARKING;
}

class Payment{
    public PaymentInfo makePayment(ParkingTicket parkingTicket , PaymentType paymentType);
}

class enum VehicleType{
    BIKE , CAR , TRUCK;
}

public enum ParkingTicketStatus{
    PAID , ACTIVE;
}

public enum PaymentStatus{
    UNPAID , PENDING , ACTIVE , CANCELLED , REFUNDED , COMPLETED;
}