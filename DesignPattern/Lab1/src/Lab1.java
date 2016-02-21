import java.util.ArrayList;
import java.util.List;


public class Lab1 {
	public static void main(String[] args) 
	{
		List<A> listA = new ArrayList<A>();
		processElements(listA);

		List<B> listB = new ArrayList<B>();
		processElements(listB);

		List<C> listC = new ArrayList<C>();
		processElements(listC);
	}
	public static void processElements(List<? super B> list){
	    list.add(new A());
	    list.add(new B());
	    list.add(new C());
	}
}
class A { }
class B extends A { }
class C extends A { }