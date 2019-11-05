import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(44);
		list.add(55);
		
		/*Iterator<Integer> iter = list.iterator();
		while(iter.hasNext()) {
			//list.add(4);
			System.out.println(iter.next());
		}*/
		List<Integer> other = Collections.synchronizedList(list);
		Thread t1=new Thread(() ->  {
			other.add(88);
			other.add(33);
		});
		
		Thread t2 = new Thread(() ->{
			other.add(28);
			other.add(113);
		});
		
		t1.start();
		t2.start();
		System.out.println(other);
	}

}
