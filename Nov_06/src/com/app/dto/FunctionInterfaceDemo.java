
package com.app.dto;

import java.util.*;
import java.util.function.*;

public class FunctionInterfaceDemo {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Account> acctList = new ArrayList<>();

        System.out.print("Enter number of accounts: ");
        int n = sc.nextInt();
        sc.nextLine(); // clear buffer

        // 🔹 Take account details from console
        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Account " + (i + 1));
            System.out.print("Enter name: ");
            String name = sc.nextLine();
            System.out.print("Enter account number: ");
            String accNo = sc.nextLine();
            System.out.print("Enter balance: ");
            double bal = sc.nextDouble();
            sc.nextLine(); // clear buffer

            acctList.add(new Account(name, accNo, bal));
        }

        System.out.println("\n=== All Accounts Entered ===");
        acctList.forEach(a -> System.out.println(a.name() + " | " + a.accNo() + " | " + a.bal()));

        // 🔹 Functional Interfaces
        Predicate<Account> highBalance = a -> a.bal() > 50000;
        Consumer<Account> display = a -> System.out.println(a.name() + " → " + a.bal());
        Function<Account, String> accMap = a -> a.name() + ":" + a.accNo();

        System.out.println("\n=== Filtered Accounts (Balance > 50000) ===");
        for (Account a : acctList) {
            if (highBalance.test(a)) {
                display.accept(a);
            }
        }

        // 🔹 Sort by Account Number (without streams)
        acctList.sort(Comparator.comparing(Account::accNo));
        System.out.println("\n=== Sorted by Account Number ===");
        for (Account a : acctList) {
            System.out.println(a.name() + " → " + a.accNo());
        }

        // 🔹 Sort by Balance
        acctList.sort(Comparator.comparingDouble(Account::bal));
        System.out.println("\n=== Sorted by Balance ===");
        for (Account a : acctList) {
            System.out.println(a.name() + " → " + a.bal());
        }

        // 🔹 Create map (Account object → Account number)
        Map<Account, String> accMapList = new HashMap<>();
        for (Account a : acctList) {
            accMapList.put(a, a.accNo());
        }

        System.out.println("\n=== Map (Account → Account No) ===");
        for (Map.Entry<Account, String> e : accMapList.entrySet()) {
            System.out.println("Key: " + e.getKey().name() + " | Value: " + e.getValue());
        }

        // 🔹 Function Example: Map account → name:accNo
        System.out.println("\n=== Function Output (name:accNo) ===");
        for (Account a : acctList) {
            System.out.println(accMap.apply(a));
        }

        sc.close();
    }
}
