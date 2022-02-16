import java.io.IOException;

public class Main {
	static class Student{
		String classname;
		public Student(String classname){
			this.classname = classname;
		}
	}
	public static void main(String[] args) throws IOException {
		
		var student = new Student("ciao");
//		Person p = null;
//		checkPerson(p);
//		System.out.println(p);
//		p = new Person("Mary");
//		checkPerson(p);
//		System.out.println(p);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		ProvaInterface p = new ProvaInterface() {
//			
//			@Override
//			public void c() {
//				// TODO Auto-generated method stub
//				
//			}
//			
//			@Override
//			public void b(String c) {
//				// TODO Auto-generated method stub
//				
//			}
//		};
//		
//		List<String> l = new ArrayList<String>();
//		
//		l.forEach(new Consumer<String>() {
//
//			@Override
//			public void accept(String t) {
//				// TODO Auto-generated method stub
//				
//			}
//		});
		
		
	}
	
	public static Person checkPerson(Person p) {
		if(p == null) {
			p = new Person("Joe");
		} else{
			p.setName("Joe");
		}
		return p;
	}
}
