package com.chemyoo.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.chemyoo.bean.Stores;

public class Tset {
	
	public static Map<Integer,String> storename =new HashMap<Integer,String>();
    public static List<String> useraccount =new ArrayList <String>();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Stores store=new Stores();
		try {
			storename.put(1, "213213");
			useraccount.add("12345");
			Class c=Class.forName(store.getClass().getName());
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		
		}
		storename.clear();
		useraccount.clear();
		storename.size();
		useraccount.size();
		

	}

}
