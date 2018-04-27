public class IPhone extends Phone implements Ringable {
	public IPhone(String versionNumber, int batteryPercentage, String carrier, String ringTone) {
		super(versionNumber, batteryPercentage, carrier, ringTone);
	}
	@Override
	public String ring() {
		return "This iPhone " + this.getVersionNumber() + " have the ringtone " + this.getRingTone();
	}
	@Override
	public String unlock() {
		return "Unlock your phone using facial recognition";
	}
	public void displayInfo() {
		System.out.println("This iPhone " + this.getVersionNumber() + " from the carrier " + this.getCarrier());
	}
}