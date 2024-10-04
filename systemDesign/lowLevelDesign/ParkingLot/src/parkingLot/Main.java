package parkingLot;

public class Main {

	public static void main(String[] args) {
		final OutputPrinter outputPrinter = new OutputPrinter();

		if (isInteractiveMode(args)) {
//			new InteractiveMode(commandExecutorFactory, outputPrinter).process();
		} else if (isFileInputMode(args)) {
//			new FileMode(commandExecutorFactory, outputPrinter, args[0]).process();
		} else {
//			throw new InvalidModeException();
		}
	}

	private static boolean isFileInputMode(final String[] args) {
		return args.length == 1;
	}

	private static boolean isInteractiveMode(final String[] args) {
		return args.length == 0;
	}
}
