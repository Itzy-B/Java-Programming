import java.util.ArrayList;

public class BillContainer {
    private ArrayList<Bill> bills;

    public BillContainer() {
        this.bills = new ArrayList<>();
    }

    public void addBill(Bill bill) {
        this.bills.add(bill);
    }

    public double totalFee() {
        double totalFee = 0.0;
        for (Bill bill : bills) {
            totalFee += bill.getAmountDue();
        }
        return totalFee;
    }

    @Override
    public String toString() {
        String result = "";
        for (Bill bill : bills) {
            result += bill.toString() + "\n";
        }
        return result;
    }
    public static void main(String[] args) {
        Doctor doctor1=new Doctor("John Health", 33, "surgeon", 15.30);
        Doctor doctor2=new Doctor("Joe Health", 53, "surgeon", 14.20);
        Patient patient1= new Patient("Jane Sick", 2, "ediad");
        Patient patient2= new Patient("Jack Sick", 5, "dadakpo");
        Bill bill1=new Bill(patient2, doctor2);
        Bill bill2=new Bill(patient1, doctor2);
        Bill bill3=new Bill(patient2, doctor1);
        Bill bill4=new Bill(patient1, doctor1);
        BillContainer billContainer=new BillContainer();
        billContainer.addBill(bill1);
        billContainer.addBill(bill2);
        billContainer.addBill(bill3);
        billContainer.addBill(bill4);
        System.out.println(billContainer.toString());
        System.out.println(billContainer.totalFee());
    }
}
