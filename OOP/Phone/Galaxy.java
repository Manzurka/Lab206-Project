public class Galaxy extends Phone implements Ringable {
	public Galaxy(String versionNumber, int batteryPercentage, String carrier, String ringTone) {
		super(versionNumber, batteryPercentage, carrier, ringTone);
	}
	@Override
	public String ring() {
		return "This Galaxy " + this.getVersionNumber() + " have the ringtone " + this.getRingTone();
	}
	@Override
	public String unlock() {
		return "Unlock your phone using your finger print or passcode";
	}
	@Override
	public void displayInfo() {
		System.out.println("This Galaxy " + this.getVersionNumber() + " from carrier " + this.getCarrier());
	}
}
