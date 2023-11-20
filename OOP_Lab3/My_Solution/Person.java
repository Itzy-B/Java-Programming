package My_Solution;

public abstract class Person {
    
    private String name;
    private int age;

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    } 

    //Accessor
    public int getAge(){
        return age;
    }

    public String getName(){
        return name;
    }

    //Mutator

    public void setAge(int age){
        this.age = age;
    }

    public void setName(String name){
        this.name = name;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
    
        if (obj == null || getClass() != obj.getClass()) return false;
    
        if (obj instanceof Person) {
            Person person = (Person) obj;
            return age == person.age && name.equals(person.name);
        } else {
            return false;
        }
    }

    @Override
    public String toString(){
        return "name: "+ name + " age: " + age;
    }
}
