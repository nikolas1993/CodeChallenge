import java.util.Collection;
import java.util.List;

public class Bar extends Foo {
	public void foo(Collection args) {
		System.out.println("Hello world");
	}
	
	public void foo(List  args) {
		System.out.println("Ola mundo");
	}
	
	public void bar() {
		System.out.println("Ciao mondo");
	}
}
