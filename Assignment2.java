import java.util.Scanner;

class A{

	//convert string types to binary version which is bit long
	private static String convertStringToBinary(String input, int bit) {
		StringBuilder result = new StringBuilder();
        char[] chars = input.toCharArray();
        for (char aChar : chars) {
            result.append(
                    String.format("%8s", Integer.toBinaryString(aChar)).replaceAll(" ", "0")); 
            
        }

   	 String last = result.toString() ;
        while(last.length()<bit) {
        	 last = "0"+ last;
        }
        
      
        return last.toString();
	}
	
	
	//convert integer types to binary version which is bit long
	public static String convert(String value,int bit) {
		int newVal = Integer.parseInt(value);
		String newVall = Integer.toBinaryString(newVal);
		int counter=newVall.length();
		
		
		
		while(bit>counter) {
			
			if(counter%8==0) {
			  counter++;
			  newVall = "0 " + newVall;
			  
			  }
			counter++;
			newVall = "0" + newVall;
			
			}
		
		
		return newVall;
		
	}
	
	//get all inputs
	public void getInput() {
		
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Give the type of input? int=0, string=1,double=2");
		int type1=scan.nextInt();
		System.out.println("Give the type of input? or=0, and=1, xor=2, "
				+ "complement=3, right shift=4, left shift=5");
		int type2=scan.nextInt();
		
		
		
		
		if(type1==2) {
			System.out.println("First Double Number: ");
			double doub1= scan.nextDouble();
			System.out.println("Second Double Number: ");
			double doub2= scan.nextDouble();
			String one = Long.toBinaryString(Double.doubleToRawLongBits(doub1));
			String two=Long.toBinaryString(Double.doubleToRawLongBits(doub2));
			for(int i=0;i<one.length();i++) {
				if(one.length()%8!=0)
					one="0"+one;
				else
					break;
			}
			
			for(int i=0;i<two.length();i++) {
				if(two.length()%8!=0)
					two="0"+two;
				else 
					break;
			}
			
			
			if(type2==2) {
				
				String resultd="";
				String a="";
				String b="";
				int m=0;
				int n=0;
				int counter=0;
				
				
				for(int i=0;i<one.length();i++) {
					
					
					
					if(i%8==0&&i!=0) {
						for(int j=7;j>=0;j--) {
							if(b.charAt(j)=='1')
								m+=Math.pow(2, counter);
							if(a.charAt(j)=='1')
								n+=Math.pow(2, counter);
							counter++;
						}
							resultd+=xor(convert(Integer.toString(m),8),convert(Integer.toString(n),8))+" ";
						
							counter=0;
							if(i!=63) {
								
								m=0;
								n=0;
								a="";
								b="";
							
							}
						
				}
					a+=one.charAt(i);
					b+=two.charAt(i);
					
					if(i==63) {
						for(int j=7;j>=0;j--) {
							if(b.charAt(j)=='1')
								m+=Math.pow(2, counter);
							if(a.charAt(j)=='1')
								n+=Math.pow(2, counter);
							counter++;
							}
						resultd+=xor(convert(Integer.toString(m),8),convert(Integer.toString(n),8))+" ";
				}}
				System.out.println(one);
				System.out.println(two);
				System.out.println("-----------------------------------------");
				System.out.println("result: "+resultd);
				
			}
			
			
			
			if(type2==1) {
				
				String resultd="";
				String a="";
				String b="";
				int m=0;
				int n=0;
				int counter=0;
				
				
				for(int i=0;i<one.length();i++) {
					
					
					
					if(i%8==0&&i!=0) {
						for(int j=7;j>=0;j--) {
							if(b.charAt(j)=='1')
								m+=Math.pow(2, counter);
							if(a.charAt(j)=='1')
								n+=Math.pow(2, counter);
							counter++;
						}
							resultd+=and(convert(Integer.toString(m),8),convert(Integer.toString(n),8))+" ";
						
							counter=0;
							if(i!=63) {
								
								m=0;
								n=0;
								a="";
								b="";
							
							}
						
				}
					a+=one.charAt(i);
					b+=two.charAt(i);
					
					if(i==63) {
						for(int j=7;j>=0;j--) {
							if(b.charAt(j)=='1')
								m+=Math.pow(2, counter);
							if(a.charAt(j)=='1')
								n+=Math.pow(2, counter);
							counter++;
							}
						resultd+=and(convert(Integer.toString(m),8),convert(Integer.toString(n),8))+" ";
				}}
				
				System.out.println(one);
				System.out.println(two);
				System.out.println("-----------------------------------------");
				System.out.println("result: "+resultd);
				
			}
			
			
			
			
			
			
			
			
			
			if(type2==0) {
				
				String resultd="";
				String a="";
				String b="";
				int m=0;
				int n=0;
				int counter=0;
				
				
				for(int i=0;i<one.length();i++) {
					
					
					
					if(i%8==0&&i!=0) {
						for(int j=7;j>=0;j--) {
							if(b.charAt(j)=='1')
								m+=Math.pow(2, counter);
							if(a.charAt(j)=='1')
								n+=Math.pow(2, counter);
							counter++;
						}
							resultd+=or(convert(Integer.toString(m),8),convert(Integer.toString(n),8))+" ";
						
							counter=0;
							if(i!=63) {
								
								m=0;
								n=0;
								a="";
								b="";
							
							}
						
				}
					a+=one.charAt(i);
					b+=two.charAt(i);
					
					if(i==63) {
						for(int j=7;j>=0;j--) {
							if(b.charAt(j)=='1')
								m+=Math.pow(2, counter);
							if(a.charAt(j)=='1')
								n+=Math.pow(2, counter);
							counter++;
							}
						resultd+=or(convert(Integer.toString(m),8),convert(Integer.toString(n),8))+" ";
				}}
				System.out.println(one);
				System.out.println(two);
				System.out.println("-----------------------------------------");
				System.out.println("result: "+resultd);
				
			}
			
		}
		
		
		if(type1==0 && type2==3) {
			System.out.println("Integer Number: ");
			int int1= scan.nextInt();
			System.out.println(complement(Integer.toString(int1)));
			System.exit(0);
			
		}
		
		
		if(type1==0 && type2==4 || type2==5) {
			System.out.println("Integer Number: ");
			int int1= scan.nextInt();
			System.out.println("Shift Number: ");
			int int2= scan.nextInt();

			if(type2 == 4) {
				System.out.println(rs(Integer.toString(int1),int2));
				System.exit(0);
			} else if(type2 == 5) {
				System.out.println(ls(Integer.toString(int1),
						int2));
				System.exit(0);
			}
			
		}
		
		if(type1==0) {
			System.out.println("First Integer Number: ");
			int int1= scan.nextInt();
			System.out.println("Second Integer Number: ");
			int int2= scan.nextInt();
			
				if(type2==0) {
					System.out.println(or(Integer.toBinaryString(int1),
							Integer.toBinaryString(int2)));
				}
				if(type2==1) {
					System.out.println(and(Integer.toBinaryString(int1),
							Integer.toBinaryString(int2)));
					
				}
				if(type2==2) {
					System.out.println(xor(Integer.toString(int1),
							Integer.toString(int2)));
					
				}
				
		}
		
		if(type1==1) {
			System.out.println("First String: ");
			String first=scan.next();
			System.out.println("Second String: ");
			String second = scan.next();
			String print1="" ;
			String print2="";
			
			int max = first.length();
			if(second.length()>first.length())
				max=second.length();
			
			
			
			if(type2==2) {
				String first1 = convertStringToBinary(first,(max*8));
				String second1 = convertStringToBinary(second,(max*8));
				String bit11="";
				String bit22="";
				String resultt="";
				System.out.println("first:"+first1);
				System.out.println("second:"+second1);
				for(int i=0;i<(max*8);i++) {
					if(i%8==0 && i!=0) {
						print1+=bit11;
						print2+=bit22;
						resultt +=xor(bit11,bit22)+" ";
						bit11="";
						bit22="";
						
					}
					 bit11 = bit11 + first1.charAt(i);
					 bit22 = bit22 + second1.charAt(i);
					
					if(i==(max*8-1)) {

						resultt +=xor(bit11,bit22)+" ";
					}
					
					
				}
				System.out.println(print1);
				System.out.println(print2);
				System.out.println("-----------------------------------");
				System.out.println(resultt);
				
		
			
			}
			
			
			
			
			if(type2==0) {
				String firstt = convertStringToBinary(first,(max*8));
				String secondd = convertStringToBinary(second,(max*8));
				String bit1="";
				String bit2="";
				String result="";
				System.out.println("first:"+firstt);
				System.out.println("second:"+secondd);
				for(int i=0;i<(max*8);i++) {
					if(i%8==0 && i!=0) {
						print1+=bit1;
						print2+=bit2;
						result +=or(bit1,bit2)+" ";
						bit1="";
						bit2="";
						
					}
					 bit1 = bit1 + firstt.charAt(i);
					 bit2 = bit2 + secondd.charAt(i);
					
					if(i==(max*8-1)) {

						result +=or(bit1,bit2)+" ";
					}
					
					
				}
				System.out.println(print1);
				System.out.println(print2);
				System.out.println("--------------------------------");
				System.out.println(result);
			}
				
				if(type2==1) {
					String first1 = convertStringToBinary(first,(max*8));
					String second1 = convertStringToBinary(second,(max*8));
					String bit11="";
					String bit22="";
					String resultt="";
					System.out.println("first:"+first1);
					System.out.println("second:"+second1);
					for(int i=0;i<(max*8);i++) {
						if(i%8==0 && i!=0) {
							print1+=bit11;
							print2+=bit22;
							resultt +=and(bit11,bit22)+" ";
							bit11="";
							bit22="";
							
						}
						 bit11 = bit11 + first1.charAt(i);
						 bit22 = bit22 + second1.charAt(i);
						
						if(i==(max*8-1)) {

							resultt +=and(bit11,bit22)+" ";
						}
						
						
					}
					System.out.println(print1);
					System.out.println(print2);
					System.out.println("--------------------------------------------------");
					System.out.println(resultt);
					
			
				
				}
				
			
			
			
		}
			
			
			}
		
	
	public static String or(String first, String second) {
		
		
		int firstt=0;
		int secondd=0;
		int result=0;
		int maxBit=first.length();
		if(second.length()>first.length())
			maxBit=second.length();
		int counter=0;
			for(int i=(maxBit-1);i>=0;i--) {
				if(first.charAt(i)=='1')
					firstt+=(int)Math.pow(2, counter);
				if(second.charAt(i)=='1')
					secondd+=(int)Math.pow(2, counter);
				counter++;
			}
			result = firstt | secondd;
			return convert(Integer.toString(result),8);
		
		

	}
	
	
	public static String and(String first, String second) {
		
		int firstt=0;
		int secondd=0;
		int result=0;
		int maxBit=first.length();
		if(second.length()>first.length())
			maxBit=second.length();
		
			int counter=0;
			for(int i=(maxBit-1);i>=0;i--) {
				if(first.charAt(i)=='1')
					firstt+=(int)Math.pow(2, counter);
				if(second.charAt(i)=='1')
					secondd+=(int)Math.pow(2, counter);
				counter++;
			}
			result = firstt & secondd;
			return convert(Integer.toString(result),8);
		
		
		
	
	
	}
	
	
	
	public static String xor(String first, String second) {
		int firstt=0;
		int secondd=0;
		int result=0;
		int maxBit=first.length();
		if(second.length()>first.length())
			maxBit=second.length();
		
			int counter=0;
			for(int i=(maxBit-1);i>=0;i--) {
				if(first.charAt(i)=='1')
					firstt+=(int)Math.pow(2, counter);
				if(second.charAt(i)=='1')
					secondd+=(int)Math.pow(2, counter);
				counter++;
			}
			result = firstt & secondd;
			return convert(Integer.toString(result),8);
		
		
		
	}
	
	
	
	public static String complement(String first) {
		int result= ~ Integer.parseInt(first); 
		
		
		String print = "~" +convert(first,32) + " = "+ 
					convert(Integer.toString(result),32) +" = " + result ;
				
		
		return print;
	}
	
	
	
	
	public static String rs(String first, int second) {
		int number = Integer.parseInt(first);
		int num = number >> second;
		
		String print = number + " >> " + second + " = " + 
						convert(Integer.toString(num),32) + " = " + num;
		
		return print;
	}
	
	
	
	public static String ls(String first, int second) {
		int number = Integer.parseInt(first);
		int num = number << second;
		
		String print = number + " << " + second + " = " + 
						convert(Integer.toString(num),32) + " = " + num;
		
		return print;
	}
}



public class Assignment2 {

	public static void main(String[] args) {
		A a = new A();
		a.getInput();
		
	}

}
