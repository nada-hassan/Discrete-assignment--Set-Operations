package SetOperations;

import java.util.Scanner;

class tester {

	public static void main(String[] args) {
		
	@SuppressWarnings("resource")
	Scanner input = new Scanner(System.in);
	SetList Universe = new SetList();
	System.out.println("Enter your Universe elements ::\nEnter '+' when you finish");
	
	String n = input.next();
	while(!(n.equals("+"))){
	  Universe.add(n);
	  n = input.next();
	}
	System.out.println("Enter a number of subsets :: ");
	
	
	int value =checkInt(); 
	while (value<=0) {
		System.out.println("you must enter a number above 0");
	value= checkInt();}


  SetList[] arr = new SetList[value];

  for(int i=0 ; i<value ; i++){
    	
		System.out.println("Enter your subset elements\nEnter '+' when you finish");
		System.out.println((i+1)+ "-"); 
		String x = input.next();
		arr[i] = new SetList();		
	while(!(x.equals("+"))){
			
			 arr[i].add(x);
			  x = input.next();
	}
	if(!arr[i].IsSubset(Universe))
			{
		System.out.println("it's not a subset of the universe,please enter again ::");
		arr[i].clear();
		i--;
			}
  }
  int flag=1;
  while(flag==1) {
    
    System.out.println("choose the number of the operation :: ");
			System.out.println("1 : union");
			System.out.println("2 : intersection");
			System.out.println("3 : Complement");
			System.out.println("4 : exit");
    
    
    int choice = checkInt();
	
	SetList Result;
	
  switch(choice){
      
   case 1 :
          System.out.println("Enter the number of the first subset :: ");
          int first1 = checkLimit(value);
          
          System.out.println("Enter the number of the second subset :: ");
          int second1 = checkLimit(value);
          
          Result =  arr[first1-1].Union(arr[second1-1]);
          System.out.println(Result.toString());
          break;
          
          
    case 2 :
             System.out.println("Enter the number of the first subset ::");
          int first2 = checkLimit(value);
          
          System.out.println("Enter the number of the second subset :: ");
          int second2 = checkLimit(value);
          
          Result = arr[first2-1].InterSection(arr[second2-1]);
          System.out.println(Result.toString());
          break;
   
   
    case 3 :
          System.out.println("Enter the number of the subset :: ");
          int sub=checkLimit(value);
          
          Result = Universe.Complement(arr[sub-1]);
          System.out.println(Result.toString());
          break;
   
    case 4 :
    	  flag=0;
    	  break;
   
    default :
   System.out.println("Your number must between 1 : 3 ");
   break;
      
        }
     }
  }
public static int checkInt() {
	  @SuppressWarnings("resource")
	Scanner input = new Scanner(System.in);
	  String m= input.next();
		while(! (Character.isDigit(m.charAt(0))
			&& m.length() == 1) ){
			System.out.println("you must enter a number, enter again ::");
			m = input.next();
		}
		return  Integer.parseInt(m);
}
public static int checkLimit(int v) {
	@SuppressWarnings("resource")
	Scanner input = new Scanner(System.in);
	int c = checkInt();
	while(c > v || c <= 0) {
		System.out.println("Your subsets numbers are between 1 : " + v +
				" , please enter again a valid subset number ::");
		c = checkInt();
	}
	  return c;
	}
	
}