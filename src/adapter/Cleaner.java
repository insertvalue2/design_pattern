package adapter;

public class Cleaner implements IElectornic110v {

	@Override
	public void connect() {
		System.out.println("청소기 연결 110v On");
	}
	
}
