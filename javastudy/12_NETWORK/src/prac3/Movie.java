package prac3;

import lombok.Builder;
import lombok.ToString;

@Builder
public class Movie {

	private String movieCd;  // 영화 코드
	private String movieNm;  // 영화명 
	private String openDt; 	 // 개봉일
	private String salesAcc; // 누적 매출액
	private String audiAcc;	 // 누적 관객수
	
	
	public Movie(String movieCd, String movieNm, String openDt, String salesAcc, String audiAcc) {
		super();
		this.movieCd = movieCd;
		this.movieNm = movieNm;
		this.openDt = openDt;
		this.salesAcc = salesAcc;
		this.audiAcc = audiAcc;
	}
	
	public Movie(String movieCd) {
		this.movieCd = movieCd;
		
	}

	@Override
	public String toString() {
		return "Movie [상영일=" + movieCd + ", 영화번호=" + movieNm + ", openDt=" + openDt + ", salesAcc=" + salesAcc
				+ ", 관객수=" + audiAcc + "]";
	}
	
	
	
	
	
}
