import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;

public class MemberCheck {
      public String[] whosDishonest(String[] club1, String[] club2, String[] club3) {
    	  HashSet<String> club1Visit = new HashSet<String>();
    	  HashSet<String> club2Visit = new HashSet<String>();
    	  HashSet<String> club3Visit = new HashSet<String>();
    	  TreeSet<String> doups = new TreeSet<String>();
    	  
    	  for (int i = 0; i < club1.length; i++){
    		  club1Visit.add(club1[i]);
    	  }
    	  for (int i = 0; i < club2.length; i++){
    		  club2Visit.add(club2[i]);
    	  }
    	  for (int i = 0; i < club3.length; i++){
    		  club3Visit.add(club3[i]);
    	  }
    	  
    	  List<String> club2Ind = new ArrayList<String>(club2Visit);
    	  List<String> club3Ind = new ArrayList<String>(club3Visit);
    	  
    	  for (int i = 0; i < club2Ind.size(); i++){    	  
    		  if (club1Visit.contains(club2Ind.get(i))){
    			  doups.add(club2Ind.get(i));
    		  }
    	  }
    	  
    	  for (int i = 0; i < club3Ind.size(); i++){
    		  if (club1Visit.contains(club3Ind.get(i))){
    			  doups.add(club3Ind.get(i));
    		  }
    		  if (club2Visit.contains(club3Ind.get(i))){
    			  doups.add(club3Ind.get(i));
    		  }
    	  }
    	  
    	  List<String> outputList = new ArrayList<String>(doups);
    	  String[] output = new String[doups.size()];
    	  
    	  for (int i = 0; i < doups.size(); i++){
    		  output[i] = outputList.get(i);
    	  }
    	  
    	  return output; 
      }
      
      public static void main(String[] args){
    	  MemberCheck test = new MemberCheck();
    	  String[] club1 = {"JOHN","JOHN","FRED","PEG"};
    	  String[] club2 = {"PEG","GEORGE"};
    	  String[] club3 = {"GEORGE","DAVID"};
    	  String[] liars = test.whosDishonest(club1, club2, club3);
    	  System.out.println(Arrays.toString(liars));
      }
   }
