package logic;

import java.util.*;

import logic.Statement.StatementType;

public class StringAnalysis {

	public String removeSemiColon(String entry){
		if (entry != null && entry.length() > 0 && entry.charAt(entry.length()-1)==';') {
      		entry = entry.substring(0, entry.length()-1);
  		}
    return entry;
	}
	public Statement analyzeLine(String entry){
		String line = removeSemiColon(entry);
		Statement s = new Statement();
		if(line.indexOf("=") != -1){ //this is a assignment
			String[] words = line.split("\\="); //split the string based on =
			for(int i = 0; i < words.length; i++){
				words[i] = words[i].trim(); //eliminate the spaces after each word
			}
			String[] split_prop_name = words[0].split("\\.");
			s.name = split_prop_name[0];  
			s.property = split_prop_name[1];
			s.value = words[1];
			s.type = StatementType.ASSIGNMENT;
			
		}
		else{
			int leftParent = line.indexOf("(");
			int rightParent = line.indexOf(")");
			String output = line.substring(leftParent + 1, rightParent);
			String[] words = line.split("\\="); //split the string based on =
			String[] split_prop_name = words[0].split("\\.");
			s.value = output;
			s.type = StatementType.METHOD;
			s.name = split_prop_name[0].trim();  
			s.property = split_prop_name[1].substring(0, split_prop_name[1].indexOf("(")).trim();
		}
		return s;
	}

	public ArrayList<Statement> analyzeString(String inputText){
		ArrayList<Statement> statements = new ArrayList<Statement>();
		for(String line : inputText.split("\n")){
			statements.add(analyzeLine(line));
		}
		return statements;
	}
}