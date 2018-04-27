public class PhoneTest {
	public static void main(String[] args) {
		IPhone iPhoneTen = new IPhone("X", 100, "Verizon", "Opening");
		Galaxy S9 = new Galaxy("S9", 100, "Sprint", "Ding Dong");
		iPhoneTen.displayInfo();
		System.out.println(iPhoneTen.ring());
		System.out.println(iPhoneTen.unlock());
		S9.displayInfo();
		System.out.println(S9.ring());
		System.out.println(S9.ring());	
	}
}