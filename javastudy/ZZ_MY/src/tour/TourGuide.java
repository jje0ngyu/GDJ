package tour;

public class TourGuide {
	
	private Tour tour;
		
	public TourGuide(Tour tour) {
		super();
		this.tour = tour;
	}

	// 메소드

	public void sightseeing() {		
		tour.sightseeing();
	}
	public void leisure() {
		tour.leisure();
	
	}
}
