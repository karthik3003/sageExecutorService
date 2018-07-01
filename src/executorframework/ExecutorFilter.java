package executorframework;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorFilter {
	
	public static void main(String args[]) throws FileNotFoundException {
		
		Scanner sc = new Scanner(new File("input.txt"));
		ArrayList<String> list = new ArrayList<>();
		while(sc.hasNext()) {
			list.add(sc.nextLine());
		}
		ExecutorService es = Executors.newFixedThreadPool(5);
		
		List<Future<String>> resultList = new ArrayList<>();
		
		for(int i=0; i<list.size(); i++) {
			FindLongLines fl = new FindLongLines(list.get(i));
			Future<String> result = es.submit(fl);
            resultList.add(result);
			
			
		}
		for(Future<String> future : resultList)
        {
              try
              {
                  System.out.println("Future result is - " + " - " + future.get() + "; And Task done is " + future.isDone());
              }
              catch (InterruptedException | ExecutionException e)
              {
                  e.printStackTrace();
              }
          }
          //shut down the executor service now
          es.shutdown();
    }
	
	
}
	

	


