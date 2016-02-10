import java.util.Arrays;

public class ClientsList {
       public String[] dataCleanup(String[] names) {
    	   for (int i = 0; i < names.length; i++){
    		   boolean output = names[i].matches("(.*),(.*)");
    		   
    		   if (output){
    			   String[] intername = names[i].split(", ");
    			   names[i] = intername[0] + " " + intername[1];
    		   }else{
    			   String[] intername = names[i].split(" ");
    			   names[i] = intername[1] + " " + intername[0];
    		   }
    	   }
    	   Arrays.sort(names);
    	   
    	   for (int i = 0; i < names.length; i++){
    		   String[] intername = names[i].split(" ");
    		   names[i] = intername[1] + " " + intername[0];
    	   }
    	   //ArrayList<String> nameslist = new ArrayList<String>(Arrays.asList(names));
    	   
    	   return names;
}

       public static void main(String[] args){
    	   ClientsList tester = new ClientsList();
    	   String[] names = {"Joe Smith", "Brown, Sam", "Miller, Judi"};
    	   String[] newnames = tester.dataCleanup(names);
    	   for (int i = 0; i < names.length; i++){
    		   System.out.println(newnames[i] + " ");
    		   
    	   }
       }
   }
