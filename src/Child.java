public class Child extends Parent {
    String name;
    public Child(){
        System.out.println(3);
    }
    public Child(String name){
        System.out.println(4);
        Parent parent = new Parent(name);
    }
}
