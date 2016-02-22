import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class SortByFreqs implements Comparator<SortByFreqs>{
	
	SortByFreqs(){
	}
	
	private int freq;
	private String data;
	
	SortByFreqs(String d, int f){
		data = d;
		freq = f;
	}
	
	public String getData(){
		return data;
	}
	
	@ Override
	public int compare(SortByFreqs o1, SortByFreqs o2){
		int returnval;
		if (o2.freq < o1.freq){
			returnval = -1;
		}else if (o1.freq == o2.freq){
			returnval = o1.data.compareTo(o2.data);
		}else{
			returnval = 1;
		}
		return returnval; 
	}
	
	
      public String[] sort(String[] data) {
    	  HashSet<String> noDoups = new HashSet<String>();
    	  for (int i = 0; i < data.length; i++){
    		  noDoups.add(data[i]);
    	  }
    	  
    	  List<String> noDoupsList = new ArrayList<String>(noDoups);
    	  int[] doupCount = new int [noDoupsList.size()];
    	  for (int i = 0; i < noDoupsList.size(); i++){
    		  for (int j = 0; j < data.length; j++){
    			  if (noDoupsList.get(i).equals(data[j])){
    				  doupCount[i] ++;
    			  }
    		  }
    	  }
    	  
    	  List<SortByFreqs> sortList = new ArrayList<SortByFreqs>();
    	  for(int i = 0; i < noDoupsList.size(); i++){
    		  sortList.add(new SortByFreqs(noDoupsList.get(i), doupCount[i]));
    	  }
    	  
    	  Collections.sort(sortList, new SortByFreqs());
    	  
    	  String[] sortedList = new String[noDoupsList.size()];
    	  for (int i = 0; i < noDoupsList.size(); i++){
    		  sortedList[i] = sortList.get(i).getData();
    	  }
    	  
    	  return sortedList;
      }
      
      public static void main(String[] args){
    	  SortByFreqs test = new SortByFreqs();
    	  String[] input = {"apple", "pear", "cherry", "apple", "pear", "apple", "banana"};
    	  System.out.println(Arrays.toString(input));
    	  String[] output = test.sort(input);
    	  System.out.println(Arrays.toString(output));
      }
   }
