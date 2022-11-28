package com.gdu.movie.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gdu.movie.domain.MovieDTO;
import com.gdu.movie.mapper.MovieMapper;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieMapper movieMapper;
	
	@Override
	public List<MovieDTO> getMoives() {
		return movieMapper.selectAllMovies();
	}
	
	@Override
	public List<MovieDTO> getSearchMoives(HttpServletRequest request) {
		String column = request.getParameter("column");
		String searchText = request.getParameter("searchText");

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("column", column);
		map.put("searchText", searchText);
		
		List<MovieDTO> movies = movieMapper.selectMoviesByQuery(map);
		
		return movies;
	}
	
	@Override
	public void  getMoiveCnt(HttpServletRequest request) {
		request.setAttribute("count", movieMapper.selectAllMoviesCount());
	}
	
}
