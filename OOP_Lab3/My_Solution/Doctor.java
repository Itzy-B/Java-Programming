package My_Solution;

public class Doctor extends Person{
    private String speciality;
    private double officeVisitFee;

    public Doctor(String name, int age, String speciality, double officeVisitFee) {
        super(name, age);
        this.speciality = speciality;
        this.officeVisitFee = officeVisitFee;
    }

    public String getSpeciality(){
        return speciality;
    }

    public double getOfficeVisitFee(){
        return officeVisitFee;
    }

    public void setSpeciality(String speciality){
        this.speciality = speciality;
    }

    public void setOfficeVisitFee(double officeVisitFee){
        this.officeVisitFee = officeVisitFee;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj==null) return false; 

            if (obj instanceof Doctor) {
                Doctor other = (Doctor) obj;
                return this.speciality.equals(other.speciality) && this.officeVisitFee == other.officeVisitFee;
            } else {
                return false;
            }
    }
}
