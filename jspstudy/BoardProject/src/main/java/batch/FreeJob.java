package batch;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import domain.Free;
import repository.FreeDAO;

public class FreeJob implements Job {

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		
		List<Free> top = FreeDAO.getInstance().selectFreesTop();
		
		for(Free f : top) {
			System.out.println(f.getWriter() + "(조회수: " + f.getHit() + ")");
		}
		
		// Top 저장하기
		try {
			File file = new File("C:\\GDJ","top.txt");
			if(file.exists()) {
				file.delete();
				file.createNewFile();
			}
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}

}
