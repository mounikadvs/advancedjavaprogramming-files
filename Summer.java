import java.util.concurrent.Callable;

public class Summer implements Callable<Integer> {
	public Summer(int start, int end) {
		this.start = start;
		this.end = end;
	}
	private int start;
	private int end;
	
	@Override
	public Integer call() throws Exception{
		int sum=0;
		for(int i=start;i<=end;i++) {
			sum+=i;
			System.out.println(Thread.currentThread()+ ":"+i);
		}
		return sum;
	}
	

}
