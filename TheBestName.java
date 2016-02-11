import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;


public class TheBestName {

	public class LengthAlpha implements Comparator<String> {
		
		public int compare(String o1, String o2) {
			if (o1.length() != o2.length()) {
				return o1.length() - o2.length();
			} else {
				return o1.compareTo(o2);
			}
		}
		
	}
	
	public String[] sort(String[] names) {
		
		int[] namecount = new int[names.length];
		for (int i = 0; i < names.length; i++){
			String uppernamesi = names[i].toUpperCase();
			char[] chari = uppernamesi.toCharArray();
			for (int j = 1; j < names[i].length(); j++){
				namecount[i] += (int) chari[j];		
			}
		}
		
		String[] namecountString = new String[names.length];
		for (int i = 0; i < names.length; i++){
			namecountString[i] = String.valueOf(namecount[i]);
		}
		
		TreeMap<Integer, String> order = new TreeMap<Integer, String>();
		for (int i = 0; i < names.length; i++){
			order.put(namecount[i], names[i]);
		}
		
		String[] subfinalorder = new String[names.length];
		
		Set set = order.entrySet();
	    Iterator iterator = set.iterator();
	      while(iterator.hasNext()) {
	         Map.Entry mentry = (Map.Entry)iterator.next();
	         System.out.print("key is: "+ mentry.getKey() + " & Value is: ");
	         System.out.println(mentry.getValue());
	      }
		return namecountString;

	}
	
	public static void main(String[] args) {
		TheBestName test = new TheBestName();
		String[] input1 = {"Astrachan", "Azhar",  "Rodger", "John"};
		System.out.println(Arrays.toString(input1));
		String[] output1 = test.sort(input1);
		System.out.println(Arrays.toString(output1));
		
		String[] input2 = {"Clinton", "Cruz", "Rubio", "Sanders", "Trump"};
		System.out.println(Arrays.toString(input2));
		String[] output2 = test.sort(input2);
		System.out.println(Arrays.toString(output2));
	}
}
