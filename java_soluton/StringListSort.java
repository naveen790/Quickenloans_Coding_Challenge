import java.util.*;
import java.io.*;

public class StringListSort {

	//merge sort function to sort the list
	public static void mergesort(ArrayList<String> list, int min, int max){
		if (min >= max) 
		{
			return;
		}	

		int middle = (min + max) / 2;
		mergesort(list, min, middle);
		mergesort(list, middle + 1, max);
		int mid = middle + 1;
		while (mid <= max)
		{
			/**
			 * convert the strings to lowercase before comparing so 
			 * "HI" is same as "hi" or "Hi" or "hI" 
			 */
			if (list.get(min).toLowerCase().compareTo(list.get(mid).toLowerCase())<0) 
			{
				min++;
			}
			else 
			{
				String Temp = list.get(mid);
				for (int k = mid-1; k >= min; k--) 
				{
					list.set(k+1,list.get(k));
				}
				list.set(min, Temp);
				min++;
				mid++;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		ArrayList<String> stringlist = new ArrayList<String>();
		int count,i;
		String temp;
		System.out.println("Enter the number of strings in input list: \n ");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String input = reader.readLine();
		try{
            count = Integer.parseInt(input); //read the input from user and check if it is an integer if not throw an exception
        }catch (NumberFormatException e)
        {
            System.out.println("Invalid input. Please enter an integer value only");
            return;
        }
		System.out.println("Enter " + count + " Strings: ");
		for(i=0;i<count;i++){
			temp = reader.readLine(); //read each string entered by user and add it to the list
			stringlist.add(temp);
		}
		System.out.println("Before sorting list: \n");
		for(i=0;i<count;i++){
			System.out.print(stringlist.get(i)+",");
		}
		//call mergesort to sort the list
		mergesort(stringlist,0,count-1);
		System.out.println("\n After sorting list: \n");
		for(i=0;i<count;i++){
			System.out.print(stringlist.get(i)+",");
		}
	}

}

