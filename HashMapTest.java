package ssafyalgo0130;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class HashMapTest {

	public static void main(String[] args) {
		HashMap<Character, Character> map = new HashMap<>();
//		map.put('(', ')');
//		map.put('<', '>');
//		map.put('{', '}');
//		map.put('[', ']');
		char []ch = {'(','<','{','['};
		map.put(ch[0], ')');
		map.put(ch[1], '>');
		map.put(ch[2], '}');
		map.put(ch[3], ']');
		
		System.out.println(map.size());
		Set<Character> keys = map.keySet();
		Iterator<Character> it = keys.iterator();
		while(it.hasNext()) {
			char c = it.next();
			char v = map.get(c);
			System.out.println(c+" "+ v);
		}
		
		System.out.println(map.get('<'));
		System.out.println(map.containsKey('<'));
		
		for (int i = 0; i < ch.length; i++) {
			System.out.println(ch[i] + " " + map.get(ch[i]));
		}
	}

}
