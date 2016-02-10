import java.util.ArrayList;
import java.util.Arrays;


public class ClassScores {
      public int[] findMode(int[] scores) {
    	  Arrays.sort(scores);
    	  int count = 0; 
    	  int highestcount = 0;

    	  ArrayList<Integer> mode = new ArrayList<Integer>();
    	  ArrayList<Integer> finalmode = new ArrayList<Integer>();
    	  mode.add(0);
    	  for (int i = 0; i < scores.length - 1; i++){
    		  if (scores[i] == scores[i+1]){
    			  count++;
    			  mode.add(count);	  
    		  }else{
    			  count = 0;
    			  mode.add(count);
    		  }
    	  }
    	  
    	  	int[] intmode = new int[mode.size()];
    	    for (int i=0; i < intmode.length; i++){
    	        intmode[i] = mode.get(i).intValue();
    	    }
    	    
    	    for (int i = 0; i < intmode.length; i++){
    	    	if (highestcount < intmode[i]){
    	    		highestcount = intmode[i];
    	    	}
    	    }
    	    
    	    for (int i = 0; i < intmode.length; i++){
    	    	if (highestcount == intmode[i]){
    	    		finalmode.add(scores[i]);
    	    	}
    	    }
    	    
    	    int[] intfinalmode = new int[finalmode.size()];
    	    for (int i=0; i < intfinalmode.length; i++){
    	        intfinalmode[i] = finalmode.get(i).intValue();
    	    }

    	  return intfinalmode;
      }
      
      public static void main(String [] args){
    	  ClassScores tester = new ClassScores();
    	  int [] scores = {92, 56, 14, 73, 22, 38, 93, 45, 55 };
    	  tester.findMode(scores);
    	  for (int i = 0; i < tester.findMode(scores).length; i++){
    		  System.out.println(tester.findMode(scores)[i] + " ");
    		  
    	  }
      }
   }

