package Grammar.Generic_Around;

import java.util.*;

class Student{
    String name;
    public Student(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }
}

class Instance{
    public static void main(String[] args) {
        Student student = new Student("donk");
        Student student1 = new Student("niko");
        Student student2 = new Student("dick");
        HashSet<Student> students = new HashSet<>();
        students.add(student);
        students.add(student1);
        students.add(student2);
        for(Student stu : students){
            System.out.println(stu);
        }
        Iterator<Student> iterator = students.iterator();
        while(iterator.hasNext()){
            Student stu = iterator.next();
            System.out.println(stu);
        }
        HashMap<String, Student> map = new HashMap<>();
        map.put("donk",student);
        map.put("niko",student1);
        map.put("dick",student2);
        Set<Map.Entry<String, Student>> entrySet = map.entrySet();
        for(Map.Entry<String, Student> entry : entrySet){
            System.out.println(entry.getKey() + "-" + entry.getValue());
        }
        Iterator<Map.Entry<String, Student>> iterator1 = entrySet.iterator();
        while(iterator1.hasNext()){
            Map.Entry<String, Student> entry = iterator1.next();
            System.out.println(entry.getKey() + "-" + entry.getValue());
        }
    }
}