package ex02_loop;

public class Review_Page {

	public static void main(String[] args) {
		
			
		// 1 ~ 100 중에서 3의 배수를 제외하고 모두 더하기
		int total = 0;
		int n = 0;
		
		while (n < 100) {
			n++;
			if ( n % 3 == 0 ) {
				continue;
			}
			total += n;
			
			System.out.println(total);
		}
		
		//
		int sum = 0;
		int m = 0;
		while ( m < 100 ) {
			m++;
			if ( m % 3 != 0) {
				sum += m;
			}
			System.out.println(sum);
		}
		
		// 10% 확률로 "대박", 90% 확률로 "쪽박"
		if (Math.random() < 0.1) {
			System.out.println("대박");
		} else {
			System.out.println("쪽박");
		}
		
	}

}
