package vendingMachine;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class TestDriver {
	
	
	static public void Menu() {
		System.out.println("\t\tDRIVER for the vending machine");
		
		System.out.println("\t0. coin()");
		System.out.println("\t1. small_cup()");
		System.out.println("\t2. large_cup()");
		System.out.println("\t3. sugar()");
		System.out.println("\t4. tea()");
		System.out.println("\t5. insert_large_cups(int n)");
		System.out.println("\t6. insert_small_cups(int n)");
		System.out.println("\t7. set_price(int p)");
		System.out.println("\t8. cancel()");
		System.out.println("\t9. dispose()");
		
		System.out.println("\nTesting-related methods");
		System.out.println("a. Show_variables()");
		System.out.println("b. Test Vending Machine with TS.txt");
		System.out.println("q. Quit Vending Machine class driver");
	}
	
	static public void testWithTestSuite(BufferedReader read) throws NumberFormatException, IOException {
		String testCase;
		int nOfSmallCup;
		int nOfLargeCup;
		int sizeOfCup;
		int price;
		int result;
		int currentvalue;
				
		while ((testCase = read.readLine()) != null) {
			VendingMachine vendingMachine = new VendingMachine();
			
			if(testCase.startsWith("$$")) {
				System.out.println("End of the file");
				break;
			}
			
			String[] test = testCase.split(": ");
			String testNumber = test[0];
			String operations = test[1];
			
			System.out.println(testNumber+": " + operations);
			
			Pattern p_set_price = Pattern.compile("set_price -?[0-9][0-9]?[0-9]?");
			Matcher m_set_price = p_set_price.matcher(operations);
			
			Pattern p_insert_small_cups = Pattern.compile("insert_small_cups -?[0-9][0-9]?[0-9]?");
			Matcher m_insert_small_cups = p_insert_small_cups.matcher(operations);
			
			Pattern p_insert_large_cups = Pattern.compile("insert_large_cups -?[0-9][0-9]?[0-9]?");
			Matcher m_insert_large_cups = p_insert_large_cups.matcher(operations);
						
			Pattern p_coin = Pattern.compile("coin");
			Matcher m_coin = p_coin.matcher(operations);
			
			Pattern p_small_cup = Pattern.compile("small_cup");
			Matcher m_small_cup = p_small_cup.matcher(operations);
			
			Pattern p_large_cup = Pattern.compile("large_cup");
			Matcher m_large_cup = p_large_cup.matcher(operations);
			
			Pattern p_sugar = Pattern.compile("sugar");
			Matcher m_sugar = p_sugar.matcher(operations);
			
			Pattern p_tea = Pattern.compile("tea");
			Matcher m_tea = p_tea.matcher(operations);
			
			Pattern p_cancel = Pattern.compile("cancel");
			Matcher m_cancel = p_cancel.matcher(operations);
			
			Pattern p_dispose = Pattern.compile("dispose");
			Matcher m_dispose = p_dispose.matcher(operations);
			
			while(!operations.equals("")) {
				if(operations.startsWith("set_price") && m_set_price.find()) {
					String settemp = m_set_price.group(0);
					String[] parameterOfSetPrice = settemp.split(" ");
					operations = operations.substring(settemp.length()+1, operations.length());
					
					result = vendingMachine.set_price(Integer.parseInt(parameterOfSetPrice[1]));					
					sizeOfCup = vendingMachine.show_sizeofcup();
					nOfLargeCup = vendingMachine.show_nOfLargeCup();
					nOfSmallCup = vendingMachine.show_nOfSmallCup();
					price = vendingMachine.show_price();
					currentvalue = vendingMachine.show_currentvalue();
					
					System.out.print("return value=" + result + " state=");
					vendingMachine.show_state();
					System.out.print(" price=" + price);
					System.out.print(" k=" + nOfLargeCup);
					System.out.print(" k1=" + nOfSmallCup);
					System.out.print(" t=" + currentvalue);
					System.out.print(" s=" + sizeOfCup);
					System.out.println();
					
					
				}
				
				else if(operations.startsWith("insert_small_cups") && m_insert_small_cups.find()) {
					String smallcuptemp = m_insert_small_cups.group(0);
					String[] parameterOfInsertSmallCups = smallcuptemp.split(" ");
					
					operations = operations.substring(smallcuptemp.length()+1, operations.length());
					
					result = vendingMachine.insert_small_cups(Integer.parseInt(parameterOfInsertSmallCups[1]));
					sizeOfCup = vendingMachine.show_sizeofcup();
					nOfLargeCup = vendingMachine.show_nOfLargeCup();
					nOfSmallCup = vendingMachine.show_nOfSmallCup();
					price = vendingMachine.show_price();
					currentvalue = vendingMachine.show_currentvalue();
					
					System.out.print("return value=" + result + " state=");
					vendingMachine.show_state();
					System.out.print(" price=" + price);
					System.out.print(" k=" + nOfLargeCup);
					System.out.print(" k1=" + nOfSmallCup);
					System.out.print(" t=" + currentvalue);
					System.out.print(" s=" + sizeOfCup);
					System.out.println();
				}
				
				else if(operations.startsWith("insert_large_cups") && m_insert_large_cups.find()) {
					String largecuptemp = m_insert_large_cups.group(0);
					String[] parameterOfInsertLargeCups = largecuptemp.split(" ");
					
					operations = operations.substring(largecuptemp.length()+1, operations.length());
					
					result = vendingMachine.insert_large_cups(Integer.parseInt(parameterOfInsertLargeCups[1]));
					sizeOfCup = vendingMachine.show_sizeofcup();
					nOfLargeCup = vendingMachine.show_nOfLargeCup();
					nOfSmallCup = vendingMachine.show_nOfSmallCup();
					price = vendingMachine.show_price();
					currentvalue = vendingMachine.show_currentvalue();
					
					System.out.print("return value=" + result + " state=");
					vendingMachine.show_state();
					System.out.print(" price=" + price);
					System.out.print(" k=" + nOfLargeCup);
					System.out.print(" k1=" + nOfSmallCup);
					System.out.print(" t=" + currentvalue);
					System.out.print(" s=" + sizeOfCup);
					System.out.println();
				}
				
				else if(operations.startsWith("coin") && m_coin.find()) {
					String cointemp = m_coin.group(0);
					operations = operations.substring(cointemp.length()+1, operations.length());
					
					
					result = vendingMachine.coin();
					sizeOfCup = vendingMachine.show_sizeofcup();
					nOfLargeCup = vendingMachine.show_nOfLargeCup();
					nOfSmallCup = vendingMachine.show_nOfSmallCup();
					price = vendingMachine.show_price();
					currentvalue = vendingMachine.show_currentvalue();
					
					System.out.print("return value=" + result + " state=");
					vendingMachine.show_state();
					System.out.print(" price=" + price);
					System.out.print(" k=" + nOfLargeCup);
					System.out.print(" k1=" + nOfSmallCup);
					System.out.print(" t=" + currentvalue);
					System.out.print(" s=" + sizeOfCup);
					System.out.println();
				}
				
				else if(operations.startsWith("small_cup") && m_small_cup.find()) {
					String smallcuptemp = m_small_cup.group(0);
					operations = operations.substring(smallcuptemp.length()+1, operations.length());
					
					
					result = vendingMachine.small_cup();
					sizeOfCup = vendingMachine.show_sizeofcup();
					nOfLargeCup = vendingMachine.show_nOfLargeCup();
					nOfSmallCup = vendingMachine.show_nOfSmallCup();
					price = vendingMachine.show_price();
					currentvalue = vendingMachine.show_currentvalue();
					
					System.out.print("return value=" + result + " state=");
					vendingMachine.show_state();
					System.out.print(" price=" + price);
					System.out.print(" k=" + nOfLargeCup);
					System.out.print(" k1=" + nOfSmallCup);
					System.out.print(" t=" + currentvalue);
					System.out.print(" s=" + sizeOfCup);
					System.out.println();
				}
				
				else if(operations.startsWith("large_cup") && m_large_cup.find()) {
					String largecuptemp = m_large_cup.group(0);
					operations = operations.substring(largecuptemp.length()+1, operations.length());
					
					
					result = vendingMachine.large_cup();
					sizeOfCup = vendingMachine.show_sizeofcup();
					nOfLargeCup = vendingMachine.show_nOfLargeCup();
					nOfSmallCup = vendingMachine.show_nOfSmallCup();
					price = vendingMachine.show_price();
					currentvalue = vendingMachine.show_currentvalue();
					
					System.out.print("return value=" + result + " state=");
					vendingMachine.show_state();
					System.out.print(" price=" + price);
					System.out.print(" k=" + nOfLargeCup);
					System.out.print(" k1=" + nOfSmallCup);
					System.out.print(" t=" + currentvalue);
					System.out.print(" s=" + sizeOfCup);
					System.out.println();
				}
				
				else if(operations.startsWith("sugar") && m_sugar.find()) {
					String sugartemp = m_sugar.group(0);
					operations = operations.substring(sugartemp.length()+1, operations.length());
					
					
					result = vendingMachine.sugar();
					sizeOfCup = vendingMachine.show_sizeofcup();
					nOfLargeCup = vendingMachine.show_nOfLargeCup();
					nOfSmallCup = vendingMachine.show_nOfSmallCup();
					price = vendingMachine.show_price();
					currentvalue = vendingMachine.show_currentvalue();
					
					System.out.print("return value=" + result + " state=");
					vendingMachine.show_state();
					System.out.print(" price=" + price);
					System.out.print(" k=" + nOfLargeCup);
					System.out.print(" k1=" + nOfSmallCup);
					System.out.print(" t=" + currentvalue);
					System.out.print(" s=" + sizeOfCup);
					System.out.println();
				}
				
				else if(operations.startsWith("tea") && m_tea.find()) {
					String teatemp = m_tea.group(0);
					operations = operations.substring(teatemp.length()+1, operations.length());
					
					
					result = vendingMachine.tea();
					sizeOfCup = vendingMachine.show_sizeofcup();
					nOfLargeCup = vendingMachine.show_nOfLargeCup();
					nOfSmallCup = vendingMachine.show_nOfSmallCup();
					price = vendingMachine.show_price();
					currentvalue = vendingMachine.show_currentvalue();
					
					System.out.print("return value=" + result + " state=");
					vendingMachine.show_state();
					System.out.print(" price=" + price);
					System.out.print(" k=" + nOfLargeCup);
					System.out.print(" k1=" + nOfSmallCup);
					System.out.print(" t=" + currentvalue);
					System.out.print(" s=" + sizeOfCup);
					System.out.println();
				}
				
				else if(operations.startsWith("cancel") && m_cancel.find()) {
					String canceltemp = m_cancel.group(0);
					operations = operations.substring(canceltemp.length()+1, operations.length());
					
					
					result = vendingMachine.cancel();
					sizeOfCup = vendingMachine.show_sizeofcup();
					nOfLargeCup = vendingMachine.show_nOfLargeCup();
					nOfSmallCup = vendingMachine.show_nOfSmallCup();
					price = vendingMachine.show_price();
					currentvalue = vendingMachine.show_currentvalue();
					
					System.out.print("return value=" + result + " state=");
					vendingMachine.show_state();
					System.out.print(" price=" + price);
					System.out.print(" k=" + nOfLargeCup);
					System.out.print(" k1=" + nOfSmallCup);
					System.out.print(" t=" + currentvalue);
					System.out.print(" s=" + sizeOfCup);
					System.out.println();
				}
				
				else if(operations.startsWith("dispose") && m_dispose.find()) {
					String disposetemp = m_dispose.group(0);
					operations = operations.substring(disposetemp.length()+1, operations.length());
					result = vendingMachine.dispose();
					sizeOfCup = vendingMachine.show_sizeofcup();
					nOfLargeCup = vendingMachine.show_nOfLargeCup();
					nOfSmallCup = vendingMachine.show_nOfSmallCup();
					price = vendingMachine.show_price();
					currentvalue = vendingMachine.show_currentvalue();
					
					System.out.print("return value=" + result + " state=");
					vendingMachine.show_state();
					System.out.print(" price=" + price);
					System.out.print(" k=" + nOfLargeCup);
					System.out.print(" k1=" + nOfSmallCup);
					System.out.print(" t=" + currentvalue);
					System.out.print(" s=" + sizeOfCup);
					System.out.println();
				}
			}
		}	
		
	}
	
	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		String scInput;
		char menuInput;
		
		int nOfSmallCup;
		int nOfLargeCup;
		int sizeOfCup;
		int price;
		int currentvalue;
		
		VendingMachine mainVendingMachine = new VendingMachine();
		
		FileReader TS = new FileReader(new File("TS.txt"));
		BufferedReader read = new BufferedReader(TS);
		
		while(true) {
			Menu();
			scInput = sc.next();
			menuInput = scInput.charAt(0);
			
			switch(menuInput) {
			case '0': 
				System.out.println("coin() method");
				System.out.println("The value returned by the method : " + mainVendingMachine.coin());
				System.out.println("Press any key to continue\n");
				System.in.read();
				break;
			
			case '1': 
				System.out.println("small_cup() method");
				System.out.println("The value returned by the method : " + mainVendingMachine.small_cup());
				System.out.println("Press any key to continue\n");
				System.in.read();
				break;
			
			case '2': 
				System.out.println("large_cup() method");
				System.out.println("The value returned by the method : " + mainVendingMachine.large_cup());
				System.out.println("Press any key to continue\n");
				System.in.read();
				break;
			
			case '3': 
				System.out.println("sugar() method");
				System.out.println("The value returned by the method : " + mainVendingMachine.sugar());
				System.out.println("Press any key to continue\n");
				System.in.read();
				break;
			
			case '4': 
				System.out.println("tea() method");
				System.out.println("The value returned by the method : " + mainVendingMachine.tea());
				System.out.println("Press any key to continue\n");
				System.in.read();
				break;
			
			case '5': 
				int nlarge;	// number of cups to be inserted
				System.out.println("insert_large_cups(int n) method");
				System.out.print("Enter value of parameter n : ");
				nlarge = sc.nextInt();
				System.out.println("The value returned by the method : " + mainVendingMachine.insert_large_cups(nlarge));
				System.out.println("Press any key to continue\n");
				System.in.read();
				break;
			
			case '6': 
				int nsmall;	// number of cups to be inserted
				System.out.println("insert_small_cups(int n) method");
				System.out.print("Enter value of parameter n : ");
				nsmall = sc.nextInt();
				System.out.println("The value returned by the method : " + mainVendingMachine.insert_small_cups(nsmall));
				System.out.println("Press any key to continue\n");
				System.in.read();
				break;
			
			case '7': 
				int nprice;	// number of cups to be inserted
				System.out.println("set_price(int n) method");
				System.out.print("Enter value of parameter n : ");
				nprice = sc.nextInt();
				System.out.println("The value returned by the method : " + mainVendingMachine.set_price(nprice));
				System.out.println("Press any key to continue\n");
				System.in.read();
				break;
			
			case '8': {
				System.out.println("cancel() method");
				System.out.println("The value returned by the method : " + mainVendingMachine.cancel());
				System.out.println("Press any key to continue\n");
				System.in.read();
				break;
			}
			case '9': {
				System.out.println("dispose() method");
				System.out.println("The value returned by the method : " + mainVendingMachine.dispose());
				System.out.println("Press any key to continue\n");
				System.in.read();
				break;
			}
			case 'a':					
				sizeOfCup = mainVendingMachine.show_sizeofcup();
				nOfLargeCup = mainVendingMachine.show_nOfLargeCup();
				nOfSmallCup = mainVendingMachine.show_nOfSmallCup();
				price = mainVendingMachine.show_price();
				currentvalue = mainVendingMachine.show_currentvalue();
				
				mainVendingMachine.show_state();
				System.out.print(" price=" + price);
				System.out.print(" k=" + nOfLargeCup);
				System.out.print(" k1=" + nOfSmallCup);
				System.out.print(" t=" + currentvalue);
				System.out.print(" s=" + sizeOfCup);
				System.out.println();
				break;
			case 'b': {
				testWithTestSuite(read);
				break;
			}
			case 'q': {
				return;
			}
			}
		}
	}
}
