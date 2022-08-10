package exam02;

import java.util.HashSet;
import java.util.Set;

public class Iterator {

	public static void Iterator_Used_HashSet() {
		Set<String> set = new HashSet<String>();
		
		set.add("제육");
		set.add("닭갈비");
		set.add("돈까스");
		set.add("김치찌개");
		
		java.util.Iterator<String> itr = set.iterator();
		
		while (itr.hasNext()) {
			String element = itr.next();
			System.out.println(element);
		}
	}
	
	public static void main(String[] args) {
		Iterator_Used_HashSet();

	}

}
