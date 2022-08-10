package quiz07_song;

public class Singer {
	
	private String name;
	private Song[] songs;	// 보유 노래
	private int idx;
	
	public Singer(String name, int cnt) {
		super();
		this.name = name;
		songs = new Song[cnt];
	}
	
	public void addSong (Song song) {
		if (idx == songs.length) {
			return;	// 곡이 가득 찼으므로 반환
		}
		songs[idx++] = song;
	}
	
	public void info() {
		System.out.println("가수이름 " + name);
		System.out.println("대표곡");
		for(int i = 0; i < idx; i++) {
			System.out.println(songs[i]);
		}
	}


	
	

}
