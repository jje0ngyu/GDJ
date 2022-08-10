package tour;

public class Main {

	public static void main(String[] args) {
		
		Tour tour1 = new KoreaTour();
		TourGuide guide1 = new TourGuide(tour1);
		
		guide1.sightseeing();
		guide1.leisure();
		
		Tour tour2 = new GuamTour();
		TourGuide guide2 = new TourGuide(tour2);
		guide2.sightseeing();
		guide2.leisure();

	}

}
