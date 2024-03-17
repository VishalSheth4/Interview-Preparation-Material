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