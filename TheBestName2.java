import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Name implements Comparator<Name>, Comparable<Name>{
	private String name;
	private int word;
	Name(){
	}
	
	Name(String n, int w){
		name = n;
		word = w;
	}
	
	public String getName(){
		return name;
	}
	
	public int compareTo(Name a){
		return (this.name).compareTo(a.name);
	}
	
	public int compare(Name a, Name b){
		return b.word - a.word;
	}
}

public class TheBestName {
	public String[] sort(String[] names) {
  	  ArrayList<String> nameArray = new ArrayList<String>();
  	  int johnCount = 0;
  	  for (int i = 0; i < names.length; i++){
  		  nameArray.add(names[i]);
  	  }
  	  
  	  for (int i = 0; i < names.length; i++){
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
  			  nameCount[i] += (int) chari[j];
  		  }
  	  }
  	  
  	  List<Name> list = new ArrayList<Name>();
  	  for (int i = 0; i < names.length; i++){
  		  list.add(new Name(nameArray.get(i),nameCount[i]));
  	  }
  	  Collections.sort(nameArray);
  	  
  	  String[] finalList = new String[nameArray.size() + johnCount];
  	  for (int i = 0; i < johnCount; i ++){
  		  finalList[i] = "JOHN";
  	  }
  	  
  	  Collections.sort(list, new Name());
  	  int ii = 0;
  	  for (Name a: list){
  		  finalList[johnCount + ii] = a.getName();
  		  ii++;
  	  }
  	  
  	  return finalList;
  	  
    }
}
