package Model;

import java.util.*;

import Exception.SlotAlreadyOccupiedException;

public class ParkingLot {
	private static int MAX_CAPACITY = 100000;
	private int capacity;
	private Map<Integer, Slot> slots;

	public int getCapacity() {
		return capacity;
	}

	public Map<Integer, Slot> getSlots() {
		return slots;
	}

	public ParkingLot(final int capacity) {
		if (capacity > MAX_CAPACITY || capacity <= 0) {
//	      throw new ParkingLotException("Invalid capacity given for parking lot.");
		}
		this.capacity = capacity;
		this.slots = new HashMap<>();
	}

	public Slot park(final Car car, final Integer slotNumber) {
		final Slot slot = getSlot(slotNumber);
		if (!slot.isSlotFree()) {
			throw new SlotAlreadyOccupiedException();
		}
		slot.assignCar(car);
		return slot;
	}

	private Slot getSlot(Integer slotNumber) {
		// TODO Auto-generated method stub
		return null;
	}
}
