package scheduler;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

/*
 	ServletContextListener 인터페이스
 	
 	1. 웹 애플리케이션(프로젝트)의 LifeCycle을 가진다. (웹 애플리케이션과 함께 동작)
 	2. contextInitialized() : 웹 애플리케이션 시작할 때 동작
 	3. contextDestroyed()   : 웹 애플리케이션 종료할 때 동작
 	
 */

@WebListener	// 나는 리스너입니다!
public class StudentListener implements ServletContextListener {
	
	// field
	private Scheduler scheduler;
	
	// constructor
	// Scheduler scheduler 생성
    public StudentListener() {
        SchedulerFactory factory = null;
        try {
        	factory = new StdSchedulerFactory();
        	scheduler = factory.getScheduler();
        } catch (Exception e) {
        	e.printStackTrace();
        }
    }

    // contextDestroyed() 메소드
    // scheduler 종료
    public void contextDestroyed(ServletContextEvent arg0)  { 
    	try {
    		if (scheduler != null) {
    			scheduler.shutdown(); // scheduler 메소드를 닫아주는 코드! close() 가 아니다!
    		}
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }

    //contextInitialized() 메소드
    // Job, Trigger 생성
    // scheduler에 Job, Trigger 등록
    // scheduler 시작
    public void contextInitialized(ServletContextEvent arg0)  { 
         
    	/*
    	 	Cron Expresson (크론식)
    	 			- www.cronMaker.com 참고해 볼 것
    	 	
    	 	1. 구성
    	 		초  분  시  일  월  요일 [연도] (*역순)
    	 	
    	 	2.  상세
    	 		1) 초   : 0 ~ 59
    	 		2) 분   : 0 ~ 59
    	 		3) 시   : 0 ~ 23
    	 		4) 일   : 1 ~ 31
    	 		5) 월   : 0 ~ 11 또는 JAN, FEB, MAR, APR, MAY, JUN, JUL, AUG, SEP, OCT, NOV, DEC
    	 		6) 요일 : 1(MON) ~ 7(SUN)   또는 MON, TUE, WED, THR, FRI, SAT, SUN
    	 		
    	 	3. 작성
    	 		1) * : 매번
    	 		2) ? : 설정 없음 (일, 요일에서 사용)
    	 		3) / : 주기
    	 				 A/B : A부터 B마다 동작
    	 				 		*EX) 0/1 : 0초(분,시...)부터 1초(분,시...)마다 동작 (1초마다 동작)
    	 	4. 작성 예시
    	 		1) 매일   10초마다 : 0/10 * * * * ?     (매분, 매시간, 매일, 요일에 상관없이 10초마다)
    	 		2) 매일    1분마다 : 0 0/1 * * * ?      (매시간, 매일, 요일에 상관없이 1분 0초마다)
    	 		3) 금요일 12시마다 : 0 0 12 ? * FRI     (매월, 며칠인지 상관없이 금요일 12시 0분 0초마다)
    	 		4) 주말   12시마다 : 0 0 12 ? * SAT,SUN (매월, 며칠인지 상관없이 토요일,일요일 12시 0분 0초마다) 
    	 	
    	 */
    	
    	try {
    		
    		// 1. Job 생성
    		JobDetail job = JobBuilder.newJob(StudentTop3Job.class)
    				.withIdentity("job1", "group1")
    				.build();
    		
    		// 2. Trigger 생성
    		Trigger trigger = TriggerBuilder.newTrigger()
    				.withIdentity("trigger1", "group1")
    				.startNow()
    				.withSchedule(CronScheduleBuilder.cronSchedule("0/30 * * * * ?"))	// 30초마다
    				.build();
    				
    		// 3. scheduler에 Job, Trigger 등록
    		scheduler.scheduleJob(job, trigger);
    		
    		// 4. scheduler 실행
    		scheduler.start();
    		//* thread로 별도로 동작하기 때문에, 메소드가 start()로 시작한다 ~
    		
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
    }
	
}
























