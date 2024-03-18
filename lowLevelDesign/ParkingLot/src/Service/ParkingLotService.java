package Service;

import Exception.ParkingLotException;
import Model.Car;
import Model.ParkingLot;
import Model.ParkingStrategy;

public class ParkingLotService {
	private ParkingLot parkingLot;
	private ParkingStrategy parkingStrategy;

	public void createParkingLot(final ParkingLot parkingLot, final ParkingStrategy parkingStrategy) {
		if (this.parkingLot != null) {
			throw new ParkingLotException("Parking lot already exists.");
		}
		this.parkingLot = parkingLot;
		this.parkingStrategy = parkingStrategy;
		for (int i = 1; i <= parkingLot.getCapacity(); i++) {
			parkingStrategy.addSlot(i);
		}
	}

	private void validateParkingLotExists() {
		if (parkingLot == null) {
			throw new ParkingLotException("Parking lot does not exists to park.");
		}
	}

	public Integer park(final Car car) {
		validateParkingLotExists();
		final Integer nextFreeSlot = parkingStrategy.getNextSlot();
		parkingLot.park(car, nextFreeSlot);
		parkingStrategy.removeSlot(nextFreeSlot);
		return nextFreeSlot;
	}
}
