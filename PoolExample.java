import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class PoolExample {

	public static void main(String[] args) {
		ExecutorService service = Executors.newFixedThreadPool(2);
		Future<Integer> f1=service.submit(new Summer(1,999));
		Future<Integer> f2=service.submit(new Summer(783,999));
		Future<Integer> f3=service.submit(new Summer(100,999));
		Future<Integer> f4=service.submit(new Summer(10,99));
		
		try {
			System.out.println(f1.get());
			System.out.println(f2.get(100,TimeUnit.SECONDS));
			System.out.println(f3.get());
			System.out.println(f4.get());
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		service.shutdown();
		

	}

}
