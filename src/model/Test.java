package model;

import java.lang.reflect.Field;
import java.util.Hashtable;

public class Test {
	
	public static void main(String[] args) {
		MinhaCasaMinhaVida m = new MinhaCasaMinhaVida();
		
//		System.out.println(m.getNameTable());
		
//		for (String string : m.getNameTables()) {
//			System.out.println(string);
//		}
		
		Hashtable<String, Object> hashTable = new Hashtable<String, Object>();
		hashTable.put("test1", 1);
		hashTable.put("test2", 2);
		hashTable.put("lulaLadrao", 3);
		hashTable.put("meuNome", "Luan Leite Leão");
		m.setFieldsTables(hashTable);
		
		System.out.println(m.toString());
//	
	}

}
