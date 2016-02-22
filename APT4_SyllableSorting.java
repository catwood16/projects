import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SyllableSorting implements Comparator<SyllableSorting> {
	SyllableSorting(){
	}
	
	public String word;
	
	SyllableSorting(String w){
		word = w;
	}
	
	public String getWord(){
		return word;
	}
	
	public String[] getSyllables(){
		
	  Matcher m = Pattern.compile("[^aeiou]+[aeiou]+").matcher(word);
  	  
  	  List<String> syllablesList = new ArrayList<String>();
  	  int s = 0;
  	  while(m.find()){
  		  syllablesList.add(word.substring(s, m.end()).trim());
  		  s = m.end();
  	  }
  	  
  	  Collections.sort(syllablesList);
  	  
  	  String[] syllableString = new String[syllablesList.size()];
  	  for (int i = 0; i < syllablesList.size(); i++){
  		  syllableString[i] = syllablesList.get(i);
  	  }
  	  return syllableString;
		
	}
	
	public String[] getSyllablesUnSort(){
		
		  Matcher m = Pattern.compile("[^aeiou]+[aeiou]+").matcher(word);
	  	  
	  	  List<String> syllablesList = new ArrayList<String>();
	  	  int s = 0;
	  	  while(m.find()){
	  		  syllablesList.add(word.substring(s, m.end()).trim());
	  		  s = m.end();
	  	  }
	  	  
	  	  String[] syllableString = new String[syllablesList.size()];
	  	  for (int i = 0; i < syllablesList.size(); i++){
	  		  syllableString[i] = syllablesList.get(i);
	  	  }
	  	  return syllableString;
			
		}
	
	@Override
	public int compare(SyllableSorting a, SyllableSorting b){
		int returnval = 0;
		if (a.getSyllables().length <= b.getSyllables().length){
			for (int i = 0; i < a.getSyllables().length; i++){
				if (a.getSyllables()[i].compareTo(b.getSyllables()[i]) == 0) {
					returnval = 0;
				}else {
					returnval = a.getSyllables()[i].compareTo(b.getSyllables()[i]);
					break;
				}
			}
		}else {
			for (int i = 0; i < b.getSyllables().length; i++){
				if (a.getSyllables()[i].compareTo(b.getSyllables()[i]) == 0) {
					returnval = 0;
				}else {
					returnval = a.getSyllables()[i].compareTo(b.getSyllables()[i]);
					break;
				}
			}
		}
		if (returnval == 0){
			if (a.getSyllablesUnSort().length == b.getSyllablesUnSort().length){
				for (int i = 0; i < a.getSyllablesUnSort().length; i++){
					if (a.getSyllablesUnSort()[i].compareTo(b.getSyllablesUnSort()[i]) == 0) {
						returnval = 0;
					}else {
						returnval = a.getSyllablesUnSort()[i].compareTo(b.getSyllablesUnSort()[i]);
						break;
					}
				}
			}else if (a.getSyllables().length < b.getSyllables().length){
				returnval = -1;
			}else {
				returnval = 1;
			}
		}
		return returnval;
	}
	
      public String[] sortWords(String[] words) {
    	  
    	  List<SyllableSorting> syllableList = new ArrayList<SyllableSorting>();
    	  for (int i = 0; i < words.length; i++){
    		  syllableList.add(new SyllableSorting(words[i]));
    	  }
    	  
    	  Collections.sort(syllableList, new SyllableSorting());
    	  
    	  String[] sortedList = new String[syllableList.size()];
    	  for (int i = 0; i < syllableList.size(); i++){
    		  sortedList[i] = syllableList.get(i).getWord();
    	  }
    	  
    	  return sortedList; 
    	  
      }
      
      public static void main(String[] args){
    	  SyllableSorting test = new SyllableSorting();
    	  String[] input1 = {"babaa", "baaba"};
    	  String[] output1 = test.sortWords(input1);
    	  System.out.print(Arrays.toString(output1));
      }
   }
