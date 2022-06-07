package adapter;

public class AirConditionner implements IElectronic220v {

	@Override
	public void connect() {
		System.out.println("에어콘 연결 220v On");
	}

}
