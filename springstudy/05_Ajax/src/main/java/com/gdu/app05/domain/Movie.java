package com.gdu.app05.domain;


public class Movie {

	private int rank;		// 순위
	private String movieNm;	// 영화명
	private String openDt;	// 개봉일
	private String audiCnt;	// 당일 관객수
	private String audiAcc; // 누적 관객수
	
	public Movie() {

	}
	
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public String getMovieNm() {
		return movieNm;
	}
	public void setMovieNm(String movieNm) {
		this.movieNm = movieNm;
	}
	public String getOpenDt() {
		return openDt;
	}
	public void setOpenDt(String openDt) {
		this.openDt = openDt;
	}
	public String getAudiCnt() {
		return audiCnt;
	}
	public void setAudiCnt(String audiCnt) {
		this.audiCnt = audiCnt;
	}
	public String getAudiAcc() {
		return audiAcc;
	}
	public void setAudiAcc(String audiAcc) {
		this.audiAcc = audiAcc;
	}
	
	
	
}
