package vasyaclerk;

import java.util.HashMap;

public class Line {

    public static final int TWENTY_FIVE_BILL = 25;
    public static final int FIFTY_BILL = 50;

    public static String Tickets(int[] peopleInLine) {
        //Your code is here...
        BillRepository r = new BillRepository();

        if (peopleInLine.length == 0) {
            return "YES";
        }

        for (int bill : peopleInLine) {
            if (!r.checkChange(bill - TWENTY_FIVE_BILL)) {
                return "NO";
            }
            r.addBill(bill);
        }
        return "YES";

    }


    static class BillRepository extends HashMap<Integer, Integer> {
        public boolean checkChange(int change) {
            change = costSpecificBill(change, FIFTY_BILL);
            change = costSpecificBill(change, TWENTY_FIVE_BILL);
            if (change != 0) {
                return false;
            }
            return true;

        }

        int getBillCount(int bill) {
            if (!containsKey(bill)) {
                put(bill, 0);
            }
            return get(bill);
        }

        void addBill(int bill) {
            put(bill, getBillCount(bill) + 1);
        }

        private void removeBill(int specificBill) {
            put(specificBill, get(specificBill) - 1);
        }


        int costSpecificBill(int change, int specificBill) {
            while (change >= specificBill && specificBillExist(specificBill)) {
                change -= specificBill;
                removeBill(specificBill);
            }
            return change;
        }

        private boolean specificBillExist(int specificBill) {
            return containsKey(specificBill) && get(specificBill) > 0;
        }
    }
}