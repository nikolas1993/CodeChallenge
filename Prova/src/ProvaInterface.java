
public interface ProvaInterface {
	default void a(String s) {
		System.out.println(s);
	}
	
	abstract void b(String c);
	abstract void c();
}
