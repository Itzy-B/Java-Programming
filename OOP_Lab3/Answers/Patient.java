public class Patient extends Person {
    private String identificationNumber;
    public Patient(String name, int age, String identificationNumber) {
        super(name, age);
        this.identificationNumber=identificationNumber;
    }
    public String getIdentificationNumber(){
        return identificationNumber;
    }
    public void setIdentificationNumber(String identificationNumber){
        this.identificationNumber=identificationNumber;
    }
    @Override
    public boolean equals(Object obj) {
        if (obj==null)
            return false; 
        if(getClass() !=obj.getClass())
            return false;
        Patient other = (Patient)obj;
        return identificationNumber.equals(other.identificationNumber);
    }
    @Override
    public String toString(){
        return "name: "+ name + "/age: " + age+"/identification number: "+identificationNumber;
    }
    public static void main(String[] args) {
        Patient patient=new Patient("John Sick", 4, "5ICk");
        System.out.println(patient.toString());
        patient.setIdentificationNumber("Noadko24");
        System.out.println(patient.toString());
        if(patient.equals(patient)){
            System.out.println("Success");
        }
    }
}
