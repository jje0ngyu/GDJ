package com.gdu.movie.batch;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.gdu.movie.domain.MovieDTO;
import com.gdu.movie.mapper.MovieMapper;

@EnableScheduling
@Component
public class MovieJob {

	@Autowired
	private MovieMapper movieMapper;
	
	@Scheduled(cron = "0 0/1 * * * *")
	public void execute() throws Exception {
		
		List<MovieDTO> comedy = movieMapper.selectComedyMovies();
		
		
		File file = new File("코미디.txt");
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
			bw.write("제목 " + comedy.title() + "\n");
			bw.write("장르 " + comedy.genre() + "\n");
			bw.write("개요 " + comedy.description() + "\n");
			bw.write("평점 " + comedy.star() + "\n");
			bw.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
