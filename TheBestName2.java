import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Bob implements Comparator<Bob>, Comparable<Bob>{
	private String name;
	private int word;
	
	Bob(){
	}
	
	Bob(String n, int w){
		name = n;
		word = w;
	}
	
	public String getName(){
		return name;
	}
	
	public int getCount(){
		return word;
	}
	
	public int compareTo(Bob a){
		return a.word - this.word;
	}
	
	public int compare(Bob a, Bob b){
		if (a != b){
			return b.word - a.word;
		}else{
			return (b.name).compareTo(a.name);
		}
	}
}

public class TheBestName {
	public String[] sort(String[] names) {
  	  ArrayList<String> nameArray = new ArrayList<String>();
  	  int johnCount = 0;
  	  for (int i = 0; i < names.length; i++){
  		  nameArray.add(names[i]);
  	  }
  	  
  	  for (int i = 0; i < nameArray.size(); i++){
  		  if (nameArray.contains("JOHN")){
  			  nameArray.remove("JOHN");
  			  johnCount++;
  		  }
  	  }
  	  
  	  int[] nameCount = new int[nameArray.size()];

  	  
  	  for (int i = 0; i < nameArray.size(); i++){
  		  String uppernamesi = nameArray.get(i).toUpperCase();
  		  char[] chari = uppernamesi.toCharArray();
  		  for (int j = 1; j < nameArray.get(i).length(); j++){
  			  int b = (int) chari[j] - 64;
  			  nameCount[i] += b;
  		  }
  	  }
  	  
  	  List<Bob> list = new ArrayList<Bob>();
  	  for (int i = 0; i < nameArray.size(); i++){
  		  list.add(new Bob(nameArray.get(i),nameCount[i]));
  	  }
  	  Collections.sort(list);
  	  
  	  String[] finalList = new String[nameArray.size() + johnCount];
  	  int[] finalListCount = new int[nameArray.size() + johnCount];
  	  for (int i = 0; i < johnCount; i++){
  		  finalListCount[i] = 007;
  	  }
  	  for (int i = 0; i < johnCount; i ++){
  		  finalList[i] = "JOHN";
  	  }
  	  
  	  Collections.sort(list, new Bob());
  	  int ii = 0;
  	  for (Bob a: list){
  		 finalList[johnCount + ii] = a.getName();
  		 ii++;
  	 }
  	  
  	  return finalList;
  	  
    }
	public static void main(String[] args) {
		TheBestName test = new TheBestName();
		String[] input1 = {"VOLODYA", "STEPAN", "PETRO", "IHOR", "IVAN", "OLEG"};
		System.out.println(Arrays.toString(input1));
		String[] output1 = test.sort(input1);
		System.out.println(Arrays.toString(output1));
		
		String[] input2 = {"Clinton", "Cruz", "Rubio", "Sanders", "Trump", "JOHN"};
		System.out.println(Arrays.toString(input2));
		String[] output2 = test.sort(input2);
		System.out.println(Arrays.toString(output2));
	}

	
}
