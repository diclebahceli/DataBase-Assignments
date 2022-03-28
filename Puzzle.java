import java.util.LinkedList;
import java.util.Scanner;

/*
 * @author Dicle Bahçeli
 * @since 1.11.2021
 * 
 */


class Sum{
	private static LinkedList<Character> uniques = new LinkedList<Character>();
	private static String fi,si,ai;
	private static String f2,s2,a2;
	public static String [] list  = new String [3];
	
	
public void puzzleSolve(int k, LinkedList<Character> S, LinkedList<Character> U) {
		
		
		
		for (int i = 0; i < U.size(); i++) {
			
			S.set(k, U.get(0));
			U.remove(0);
			//System.out.println(S + " and k: " + U);

			if (k == 0) {
				//System.out.println(S);
				change(S);
				isSolve(S);
				fi=list[0];
				si=list[1];
				ai=list[2];
				
			} else {
//				System.out.println("puzzledaki " + S);
//				System.out.println("uniques puzzle " + uniques);
				change(S);
				puzzleSolve(k - 1, S, U);

			}
			

			U.add(S.get(k));
			// int size2 = S.size();
			// for (int j = 0; j < size2; j++) {

			
			//System.out.println("u: " + U);
			// S.remove(0);
			// }
		}
}







public LinkedList<Character> findUniques() {
	String arr[] = { f2, s2, a2 };

	for (int j = 0; j < arr.length; j++) {
		for (int i = 0; i < arr[j].length(); i++) {
			if (Sum.uniques.contains(arr[j].charAt(i)))
				continue;
			Sum.uniques.add(arr[j].charAt(i));
		}
		
	}
	if(uniques.size()>10) {
		System.out.println("Out of range");
		return null;
	}
	return uniques;
}
	
	


public void getInput() {
	Scanner scan = new Scanner(System.in);
	System.out.println("Enter 1st value:	");
	String f=scan.nextLine();
	System.out.println("Enter 2nd value:	");
	String s=scan.nextLine();
	System.out.println("Enter output value:	");
	String a=scan.nextLine();
	
	
	if(f.length()<2 || f.length()>6) {
		System.out.println("Invalid 1st value.");
		return;}
	if(s.length()<2 || s.length()>6) {
		System.out.println("Invalid 2nd value.");
		return;}
	if(f.length()<2 || f.length()>6) {
		System.out.println("Invalid output value.");
		return;}
	list[0]=f;
	list[1]=s;
	list[2]=a;
	
	fi=f;
	si=s;
	ai=a;
	f2=f;
	s2=s;
	a2=a;
	
	
	
	

}


public static void isSolve(LinkedList<Character> S) {
	int f1, s1, a1;
	//System.out.println("bu mu "+fi+ " " + s2 +" " + a2);
	f1 = Integer.parseInt(fi);
	s1 = Integer.parseInt(si);
	a1 = Integer.parseInt(ai);
	//System.out.println(f1+" "+s1 +" "+ a1);
	if (f1 + s1 == a1) {
		System.out.println("searching...found! ");
		System.out.println(f2 +":	" + f1);
		System.out.println(s2+":	"+s1);
		System.out.println(a2+":	"+a1);

}
}

public static void change(LinkedList<Character> S) {
	
	for (int j = 0; j<S.size(); j++) {
		if (f2.contains(uniques.get(j).toString())) {
			//System.out.println("fi nin ilk hali " + fi +" ve f2: " + f2 + "unique:" +uniques.get(j));
			 fi = fi.replace(uniques.get(j), S.get(j));
			 //System.out.println("fi nin son hali " + fi);
			//System.out.println(S);
			 //System.out.println(S.get(j));
		}

		if (s2.contains(uniques.get(j).toString())) {
			 si = si.replace(uniques.get(j), S.get(j));

		}

		if (a2.contains(uniques.get(j).toString())) {
			 ai = ai.replace(uniques.get(j), S.get(j));

		}
		//System.out.println(fi +" and "+si+" and "+ai);
		
	}

	//System.out.println("bitti");
	

	
}

}
public class Puzzle {

	public static void main(String[] args) {
		LinkedList<Character> S = new LinkedList<Character>();
		 LinkedList<Character> U = new LinkedList<Character>();
			
			char b = '0';

			for (char i = 0; i < 10; i++) {
				U.add(b);
				b++;
			}
			Sum s = new Sum();
			s.getInput();
			for(int i=0;i<s.findUniques().size();i++)
				S.add(s.findUniques().get(i));
			s.puzzleSolve(s.findUniques().size()-1, S, U);

			
	}

}
