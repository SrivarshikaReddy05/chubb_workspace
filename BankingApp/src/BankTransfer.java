import java.io.*;
import java.util.*;

class Transaction {
    String senderName, senderCountry, senderIfsc;
    long senderAcc;
    double senderBal, transferAmt;
    String mode;
    String receiverName, receiverCountry, receiverIfsc;
    long receiverAcc;

    Transaction(String[] data) {
        senderName = data[0];
        senderCountry = data[1];
        senderAcc = Long.parseLong(data[2]);
        senderIfsc = data[3];
        senderBal = Double.parseDouble(data[4]);
        transferAmt = Double.parseDouble(data[5]);
        mode = data[6];
        receiverName = data[7];
        receiverCountry = data[8];
        receiverAcc = Long.parseLong(data[9]);
        receiverIfsc = data[10];
    }
}

public class BankTransfer {
    public static void main(String[] args) {
        String fileName = "D:/chubb_workspace/BankingApp/src/transactions.txt";
        double totalPaidByHDFC = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            System.out.printf("%-10s %-10s %-10s %-10s %-15s %-15s %-10s\n",
                              "Sender", "Bank", "Amount", "Mode", "Receiver", "Receiver IFSC", "Status");
            System.out.println("------------------------------------------------------------------------------------------");

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                Transaction t = new Transaction(data);

                if (t.transferAmt <= 0) {
                    System.out.printf("%-10s %-10s %-10.2f %-10s %-15s %-15s %-10s\n",
                                      t.senderName, t.senderIfsc.substring(0,4), t.transferAmt,
                                      t.mode, t.receiverName, t.receiverIfsc, "Invalid Amt");
                    continue;
                }

                if (t.senderBal < t.transferAmt) {
                    System.out.printf("%-10s %-10s %-10.2f %-10s %-15s %-15s %-10s\n",
                                      t.senderName, t.senderIfsc.substring(0,4), t.transferAmt,
                                      t.mode, t.receiverName, t.receiverIfsc, "Insufficient");
                    continue;
                }

                // Successful transfer
                t.senderBal -= t.transferAmt;
                if (t.senderIfsc.startsWith("HDFC")) {
                    totalPaidByHDFC += t.transferAmt;
                }

                System.out.printf("%-10s %-10s %-10.2f %-10s %-15s %-15s %-10s\n",
                                  t.senderName, t.senderIfsc.substring(0,4), t.transferAmt,
                                  t.mode, t.receiverName, t.receiverIfsc, "Success");
            }

            System.out.println("------------------------------------------------------------------------------------------");
            System.out.println("Total amount paid by HDFC Bank: ₹" + totalPaidByHDFC);

        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
