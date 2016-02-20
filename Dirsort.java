import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;


public class Dirsort implements Comparator<Dirsort>{
	
	Dirsort(){
	}
	
	private String dirs;
	private int numdeep;
	
	Dirsort(String d, int n){
		dirs = d;
		numdeep = n;
	}
	
	public String getDir(){
		return dirs;
	}
	
	@Override
 	public int compare(Dirsort o1, Dirsort o2) {
 		int returnval;
 		if (o1.numdeep < o2.numdeep){
 			returnval = -1;
 		}else if (o1.numdeep == o2.numdeep){
 			returnval = o1.dirs.compareTo(o2.dirs);
 		}else{
 			returnval = 1;
 		}
 		return returnval;
 	}
	
     public String[] sort(String[] dirs) {
         int[] dirsLength = new int[dirs.length];
         List<String> initialList = new ArrayList<String>();
         for (int i = 0; i < dirs.length; i++){
        	 String[] ind = dirs[i].split("/");
        	 dirsLength[i] = ind.length;
        	 initialList.add(dirs[i]);
         }
         
         
         List<Dirsort> dirsortList = new ArrayList<Dirsort>();
         for (int i = 0; i < initialList.size(); i++){
        	 dirsortList.add(new Dirsort(initialList.get(i),dirsLength[i]));
         }
         
         Collections.sort(dirsortList, new Dirsort());
         
         String[] sortedList = new String[dirs.length];
         for (int i = 0; i < dirs.length; i++){
        	 sortedList[i] = dirsortList.get(i).getDir();
         }
         
         return sortedList;
     }


     
     public static void main(String[] args){
    	 Dirsort test1 = new Dirsort();
    	 String[] input1 = {"/","/usr/","/usr/local/","/usr/local/bin/","/games/","/games/snake/","/homework/","/temp/downloads/"};
    	 System.out.println(Arrays.toString(input1));
    	 String[] output1 = test1.sort(input1);
    	 System.out.println(Arrays.toString(output1));
     }
  }
