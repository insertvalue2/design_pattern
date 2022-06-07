package adapter;

// adapter 패턴 활용 
// 대한 민국 표준 전압 220v 
public class ElectronicAdapter implements IElectronic220v {
	
	// adapter 패턴을 설계 하는 방법 
	
	//1. 포함관계 
	private IElectornic110v electornic110v; 
	
	//2.  생성자를 통해서 의존 주입 받을 수 있도록 설계 한다. 
	public ElectronicAdapter(IElectornic110v electornic110v) {
		this.electornic110v = electornic110v;  
	}
	
	@Override
	public void connect() {
		// IElectronic220v 추상 메서드인 connect 메서드에서
		// IElectornic110v connect 메서드를 호출 한다. 
		electornic110v.connect();
		// 그럼 어떻게 활용할 수 있을까??? 
	}

}
