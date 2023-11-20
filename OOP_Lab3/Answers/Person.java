public abstract class Person {
    public int age;
    public String name;
    public Person(String name, int age){
        this.name=name;
        this.age=age;
    }
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public void setName(){
        this.name = name;
    }
    public void setAge(){
        this.age =age;
    }
    @Override
    public boolean equals(Object obj) {
        if (obj==null)
            return false; 
        if(getClass() !=obj.getClass())
            return false;
        Person other = (Person)obj;
        return name.equals(other.name)&& age==other.age;
    }
    @Override
    public String toString(){
        return "name: "+ name + "/age: " + age;
    }
   
}
