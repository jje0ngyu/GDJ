package ex07_override;

public class Americano extends Espresso {
	
	private int extraWater;
	
	
	//* 빈 공란에 ctrl + spacebar를 활용하여 오버라이드를 자동완성할 수 있다.
	//* 여기서는 'taste():void - Override method in 'Espresso'
	//* 혹은 Source탭에서 Overrinde를 생성할 수 있다.
	@Override
	public void taste() {
		// TODO 해야 할 일을 적어 둠
		System.out.println("덜 쓰다");
	}
	

}
