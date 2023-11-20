public class Doctor extends Person{
    private String specialty;
    public double officeVisitFee;
    public Doctor(String name, int age, String specialty, double officeVisitFee){
        super(name,age);
        this.specialty =specialty;
        this.officeVisitFee=officeVisitFee;
    }
    public String getSpecialty(){
        return specialty;
    }
    public double getOfficeVisitFee(){
        return officeVisitFee;
    }
    public void setSpecialty(String specialty){
        this.specialty=specialty;
    }
    public void setOfficeVisitFee(double officeVisitFee){
        this.officeVisitFee=officeVisitFee;
    }
    @Override
    public boolean equals(Object obj) {
        if (obj==null) return false; 

            if (obj instanceof Doctor) {
                Doctor other = (Doctor) obj;
                return this.specialty.equals(other.specialty) && this.officeVisitFee == other.officeVisitFee;
            } else {
                return false;
            }
    }
    @Override
    public String toString(){
        return "name: "+ name + " age: " + age + " specialy: " + specialty + " office visit fee: " + officeVisitFee;
    }
    public static void main(String[] args) {
        Doctor doctor= new Doctor("John Doctor", 50, "surgeon", 11100.20);
        System.out.println(doctor.toString());
        if(doctor.equals(doctor)){
            System.out.println("Success");
        }
    }
}