import java.util.Arrays;
public class asn1_b
{
   
    private static final int SIZE = 110;
    
    public static int[] addition(int[] n1, int[] n2)
    {
        int[] addition = new int [SIZE]; int carryDigit = 1;
        int counter = SIZE; int digit1  = 0; int digit2 = 0;
        
        while(counter > 0){

        	int sumOfIndex = 0;
                       
            if(carryDigit == 0)
            	sumOfIndex = 1;
            	carryDigit = 1;
            
            digit1 = n1[counter-1];
            digit2 = n2[counter-1];
            
            sumOfIndex = sumOfIndex + digit1 + digit2;

           
            if(sumOfIndex >= 10)
            	carryDigit = 0;
            
           
            addition[counter - 1] = sumOfIndex % 10;
            
            counter --;
        }
       
        return addition;
    }
   
    public static void output(int[] num)
    {
        int zerosInArray = 0; // A variable to identify the zeros in the array - 0 for indicating the 
        						//that the current number in the array  is zero
        int i = 0;
        
        while(i < SIZE) 
        {
           
            while(zerosInArray == 0) //Keep looping till a number other than zero is found 
            {
                // If the number is a 0, remove it
                
            	if(num[i] != 0) // if the number in the array is not zero 
            		zerosInArray = 1; // set the zerosInArray to 1 to exit the loop and print the numbers

            	else
                	i++; //Otherwise, keep skipping the zeros in the array
            }
           
          //Print the numbers that are stored in the array (non-zeros)
            String output = "";
            output = i < SIZE ? Integer.toString(num[i]) : "2"; 
            System.out.print(output);
            
            i++;
        }
        System.out.println("");
    }
    

    
    public static int[] lucas(int n)
    {
   
	    int[]res = new int[2*SIZE];
	
	   
	    if(n == 0)
	    {
	    	res[SIZE -1] = 2;
	    	res[SIZE*2 -1] = -1;
	    	return res;
	    }
	    
	    
	    if(n == 1)
	    {
	    	  res[SIZE -1] = 1;
	    	  res[SIZE*2 -1] = 2;
	    	  return res;
	    }
	   
	      res = lucas(n-1);
	      int[]temp = new int[SIZE];
	      int[]ln = new int[SIZE];
	      int[]ln_1 = new int[SIZE];
	      ln = Arrays.copyOfRange(res, 0, SIZE );
	      ln_1 = Arrays.copyOfRange(res, SIZE, 2*SIZE );
	      temp = addition(ln, ln_1);
	      System.arraycopy(temp,0, res, 0,SIZE);
	      System.arraycopy(ln,0, res, SIZE,SIZE);
	      return res;
    }
   
    public static void main(String[] args)
    {
		System.out.println("Leen's Lucas Numbers Calculator");
    	for(int i = 0; i <= 25; i++) {
            System.out.print("L(" + i*20 + ") = ");
            int[]res = new int[2*SIZE];
            res = lucas(i*20);
           
            int []ln = Arrays.copyOfRange(res, 0, SIZE );
           
            output(ln);
       }
    }
}