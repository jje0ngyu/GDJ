package ex02_loop;

public class Ex04_continue {

	public static void main(String[] args) {
		
		// continue문 (중요도 "최하")
		// 반복문의 시작 지점으로 이동한다.
		// 실행에서 제외할 코드가 있는 경우에 사용한다.
		// * continue는 대체 코드 (필수x). 많이 사용하면 '나쁜 코드'
		
		// while () {
		//     a;
		//     b;
		//     c;
		//     continue;  // a b c 만 실행하고 다시 while()문으로 이동한다.
		//     d;
		//     e;
		//     g;
		
		// 1 ~ 100 중에서 3의 배수를 제외하고 모두 더하기
		int total = 0;
		int n = 0;
		
		while (n < 100) {
			
			n++;
			if ( n % 3 == 0) {
				continue;  // 3의 배수가 되면, 아래 total에 합산되지 않고 다시 위로 올라가여, 
			}			   // (n < 100)가 될 때까지 n++;를 진행하여, 그 다음 수인 4,7,10...이 됨.
			
			total += n;
			
			System.out.println(total);
		}
		
		// continue 없이 코드를 만드는 건 언제나 가능하다.
		// *위의 코드와 동일한 값.
		int sum = 0;
		int m = 0;
		while ( m < 100 ) {
			m++;
			if ( m % 3 != 0 ) {
				sum += m;
			}
		System.out.println(sum);
		}

	}

}
