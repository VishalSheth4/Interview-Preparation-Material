package Exception;

public class ParkingLotException extends RuntimeException{
	public ParkingLotException(String msg){
		System.out.println(msg);
	}
}
