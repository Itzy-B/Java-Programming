public class Bill {
    private Doctor doctor;
    private Patient patient;
    private double amountDue;
    public Bill(Patient patient, Doctor doctor){
        this.doctor=doctor;
        this.patient=patient;
        this.amountDue=doctor.officeVisitFee;
    }
    public double getAmountDue(){
        return amountDue;
    }
    @Override
    public String toString(){
        return "Patient: "+patient.name+"/Doctor: "+doctor.name+"/amount due: "+amountDue;
    }
}
