package vendingMachine;

public class VendingMachine {
	private int x;				
	private int price;			
	private int k;				
	private int k1;				
	private int t;				
	private int s;				

	public VendingMachine() {
		k1 = 0;					
		k = 0;
		t = 0;
		price = 0;
		x = 1;
	}
	
	// method for testing, show price with value 'price'
	public int show_price() {
		return price;
	}
	
	// method for testing, show # of large cups with value 'k'
	public int show_nOfLargeCup() {
		return k;
	}
	
	// method for testing, show # of small cups with value 'k1'
	public int show_nOfSmallCup() {
		return k1;
	}
	
	// method for testing, show current value with value 't'
	public int show_currentvalue() {
		return t;
	}
	
	// method for testing, show size of cup with value 's'
	public int show_sizeofcup() {
		return s;
	}
	
	// method for testing, show current state with value 'x'
	public void show_state() {
		switch(x) {
		case 1:
			System.out.print("Idle");
			break;
		case 2:
			System.out.print("Coin_Inserted");
			break;
		case 3:
			System.out.print("Sugar");
			break;
		case 4:
			System.out.print("no_small_cup");
			break;
		case 5:
			System.out.print("no_large_cup");
			break;
		case 6:
			System.out.print("exit");
			break;
			default:
				break;
		}
	}
	
	public final int coin() {							// when state is Idle, if 
		if (x == 1) {
			if ((t + 25 >= price) && (price > 0)) {
				s = 0;									// cup size not selected
				t = 0;									// set current value to 0
				x = 2;									// then goto coin inserted
				return 1;
			} else if (t + 25 < price) {					// when state is Idle and value after inserting coin is still less then price 
				t = t + 25;								// then add value to 25 and remain in Idle
				return 1;
			}
		} else if ((x > 1) && (x < 6)) {					// when state is not in Idle, then return coin
			System.out.print("RETURN COIN");
			System.out.print("\n");
			return 1;
		}
		return 0;
	}

	public final int small_cup() {		// when state is coins_inserted or sugar,
		if ((x == 2) || (x == 3)) {		// set cup to small
			s = 2;
			return 1;
		}
		return 0;
	}

	public final int large_cup() {		// when state is coins_inserted or sugar,
		if ((x == 2) || (x == 3)) {		// set cup to large
			s = 1;
			return 1;
		}
		return 0;
	}

	public final int sugar() {			// when state is coins_inserted or sugar,
		if ((x == 2) || (x == 3)) {		// if sugar button is pressed then goto Sugar else goto coins_inserted
			if (x == 2) {
				x = 3;
			} else {
				x = 2;
			}
			return 1;
		}
		return 0;
	}

	public final int tea() {
		if ((x == 2) || (x == 3)) {
			if ((x == 2) && (k1 > 1) && (s == 2)) {			// No Sugar && # of Small cup > 1 && Small Cup Selected then goto Idle
				System.out.print("DISPOSE SMALL CUP OF TEA");
				System.out.print("\n");
				k1 = k1 - 1;
				x = 1;
				return 1;
			} else if ((x == 2) && (k > 1) && (s == 1)) {	// No Sugar && # of Large cup > 1 && Large Cup Selected then goto Idle
				System.out.print("DISPOSE LARGE CUP OF TEA");
				System.out.print("\n");
				k = k - 1;
				x = 1;
				return 1;
			} else if ((x == 2) && (k == 1) && (s == 1)) {    // No Sugar && # of Large cup == 1 && Large Cup Selected then goto no Large cups
				System.out.print("DISPOSE LARGE CUP OF TEA");
				System.out.print("\n");
				k = k - 1;
				x = 5;
				return 1;
			} else if ((x == 2) && (k1 == 1) && (s == 2)) {   // No Sugar && # of Small cup == 1 && Small Cup Selected then goto no small cups
				System.out.print("DISPOSE SMALL CUP OF TEA");
				System.out.print("\n");
				k1 = k1 - 1;
				x = 4;
				return 1;
			} else if ((x == 3) && (k1 == 1) && (s == 2)) {	// Sugar && # of Small cup == 1 && Small Cup Selected  then goto no small cups
				System.out.print("DISPOSE SMALL CUP OF TEA WITH SUGAR");
				System.out.print("\n");
				k1 = k1 - 1;
				x = 4;
				return 1;
			} else if ((x == 3) && (k == 1) && (s == 1)) {	// Sugar && # of Large cup == 1 && Large Cup Selected then goto no large cups
				System.out.print("DISPOSE LARGE CUP OF TEA WITH SUGAR");
				System.out.print("\n");
				k = k - 1;
				x = 5;
				return 1;
			}
			if ((x == 3) && (k1 > 1) && (s == 2)) {			// Sugar && # of small cup > 1 && Small Cup Selected then goto Idle
				System.out.print("DISPOSE SMALL CUP OF TEA WITH SUGAR");
				System.out.print("\n");
				k1 = k1 - 1;
				x = 1;
				return 1;
			} else if ((x == 3) && (k > 1) && (s == 1)) {	// Sugar && # of Large cup > 1 && Large Cup Selected then goto Idle
				System.out.print("DISPOSE LARGE CUP OF TEA WITH SUGAR");
				System.out.print("\n");
				k = k - 1;
				x = 1;
				return 1;
			}
			return 0;
		}
		return 0;
	}

	public final int insert_large_cups(int n) {	// when state is Idle and argument is > 0 then add number of small cup with n
		if ((x == 1) && (n > 0)) {				// and when state is no large cups and > 0 then k1 is argument then goto Idle
			k = k + n;
			return 1;
		} else if ((x == 5) && (n > 0)) {
			k = n;
			x = 1;
			return 1;
		}
		return 0;
	}

	public final int insert_small_cups(int n) {	// when state is Idle and argument is > 0 then add number of small cup with n
		if ((x == 1) && (n > 0)) {				// and when state is no small cups and > 0 then k1 is argument then goto Idle
			k1 = k1 + n;
			return 1;
		} else if ((x == 4) && (n > 0)) {
			k1 = n;
			x = 1;
			return 1;
		}
		return 0;
	}

	public final int set_price(int p) {			// when state is Idle and argument is > 0 then set price with p
		if ((x == 1) && (p > 0)) {
			price = p;
			return 1;
		}
		return 0;
	}

	public final int cancel() {					// when state is coins_inserted or sugar, then goto Idle
		if ((x == 2) || (x == 3)) {
			System.out.print("RETURN COINS");
			System.out.print("\n");
			x = 1;
			return 1;
		}
		return 0;
	}

	public final int dispose() {					// when state is Idle, then goto out
		if ((x == 1)) {
			System.out.print("SHUT DOWN");
			System.out.print("\n");
			x = 6;
			return 1;
		}
		return 0;
	}
}
