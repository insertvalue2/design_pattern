package adapter;

public class MyHouse {
	
	// 집에 기능으로 함수 설계 
	// 전기 콘센트 220v 사용 
	public static void homeConnect(IElectronic220v iElectronic220v) {
		iElectronic220v.connect(); 
	}
	
	public static void main(String[] args) {
		
		// 1. 에어컨 220v
		// 2. 헤어드라이기 110v
		// 3. 청소기 110v  
		
		// 추상화 과정  (위 object 3개의 공통기능을 생각해 보자)  
		// 공통 기능을 인터페이스로 추상화 
		// connect() 기능을 생각해 볼 수 있다 (사용하려면 전기가 필요 -> 연결하다)
		
		// 문제 인식 
		// 친구가 결혼 축하 선물로 헤어드라이기와 청소기를 일제 제품을 선물 하였다. 
		// 문제는 전부 110v 전압으로만 동작하는 가전 기기이다. 
		// 한국에 표준 전압은 220v 이기 때문에 바로 connect 동작을 처리하면 
		// 기기에 문제가 발생한다. 
		// 현실 세계에서는 adapter 를 구매해서 알맞은 전압으로 
		// 낮춘 이후에 가전 제품을 사용해야 한다. !!!
		// 이것을 모델링해서 프로그랭 세상으로 반영해 보자. 
		
		// 실행 순서  
		//1. 110v , 220v 인터페이스를 선언하고 추상 메서드 connect 를 선언해 보자.
		//1-1. IElectornic110v 생성, IElectornic220v 설계 
		//2. 우리가 원래 하던 방식인 
		//    에어컨, 헤어드라이기, 청소기 클래스를 설계하고 IElectornic110v 구현 하자 
		//2-2. 에어컨, 헤어드라이기, 청소기 설계 및 구현 
		
		// 사용해 보기 
		AirConditionner airConditionner = new AirConditionner(); 
		// 집에 전기 콘센트에 연결해 보자. 
		homeConnect(airConditionner);
		
		HairDryer dryer = new HairDryer(); 
		// 집에 전기 콘센트에 연결해 보자.
		// homeConnect(dryer);  연결 불가 
		
		Cleaner cleaner = new Cleaner(); 
		// homeConnect(cleaner); 연결 불가  
		
		
		// Adapter 클래를 만들어 보자 
		// ElectronicAdapter 설계 
		ElectronicAdapter adapter1 = new ElectronicAdapter(cleaner);
		ElectronicAdapter adapter2 = new ElectronicAdapter(dryer);
		
		// 집의 전기 콘센트에 연결해 보자. 
		homeConnect(adapter1); 
		homeConnect(adapter2); 

		
	}
}
