package com.gdu.app05.service;

import com.gdu.app05.domain.Movie;

public class MovieServiceImpl implements MovieService {

	@Override
	public String getBoxOffice(String targetDt) {
		Movie movie = new Movie();
		movie.getRank();
		movie.getMovieNm();
		movie.getOpenDt();
		movie.getAudiCnt();
		movie.getAudiAcc();
		movie.toString();
		
		return movie;
	}

}
