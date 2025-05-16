package Grammar.For_And_Iterator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Instance{
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(new Dog("donk",666));
        list.add(new Dog("sd",123));
        Iterator iterator = list.iterator();
//        while(iterator.hasNext()){
//            Object obj = iterator.next();
//            System.out.println(obj);
//        }
        while (iterator.hasNext()) {
            Object obj =  iterator.next();
            System.out.println(obj);
        }
        System.out.println("===========");
//        for(Object dog : list){
//            System.out.println(dog);
//        }
        for (Object o : list) {
            System.out.println(o);
        }
    }
}

class Dog{
    private String name;
    private int age;

    public Dog(String name,int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
