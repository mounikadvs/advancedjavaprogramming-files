import java.util.List;
import java.util.concurrent.RecursiveTask;

public class RecursiveSum extends RecursiveTask<Integer>{
	public RecursiveSum(List<Integer> list, int start, int end) {
		this.list = list;
		this.start = start;
		this.end = end;
	
	}

	private List<Integer> list;
	private int start;
	private int end;
	private static final int THRESHOLD=10;

	@Override
	protected Integer compute() {
		if((end-start)<=THRESHOLD) {
			int sum=0;
			for(int i=start;i<=end;i++) {
				sum+=list.get(i);
			}
			return sum;
			
			
		}else {
			int mid=start + (end-start)/2;
			RecursiveSum left = new RecursiveSum(list, start, mid);
			RecursiveSum right = new RecursiveSum(list, mid+1, end);
			left.fork();
			return left.join() + right.compute();
		}
		
	}

}
