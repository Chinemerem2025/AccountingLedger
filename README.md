# AccountingLedgerApp
Application to recode daily debit and credit for both business and individual use

## Content
1.	Description
2.	Images of the App Screens
3.	Interesting code
# Description
Accounting Ledger is a Java application that records daily debit and credit for both business and individual use. It is designed for businesses or individuals to record deposits and payments (debit) of their day-to-day transactions.  
 When the application starts, the user is presented with a Main Menu that offers four options: Deposit, Make Payment, Ledger, and Exit. If the user selects either the Deposit or Make Payment option, all entries will be saved in a CSV file. 
If the user chooses the Ledger option, it will open a LedgerMenu option where the user can view all entries, deposit, or payment entries in the CSV file. In the Ledger Menu, there is an option to view a report. If the user chooses to view report, the ReportMenu will open, providing options to filter the information by Month-to-Date, Previous Month, Year-to-Date, Previous Year, or by Vendor.
# Images
![image](https://github.com/user-attachments/assets/cf118b1d-d855-4cee-9ecd-afb11f7059b4)
# Main Menu & Ledger Menu
![image](https://github.com/user-attachments/assets/e7cc871d-2343-48c7-92dd-ea417b31ed1d)
# Main Menu, Ledger Menu & Report Menu
![image](https://github.com/user-attachments/assets/9ee1d7dd-ad99-4188-ac54-8cfbf0c18fa9)
# Ledger Menu Option A in Action
![image](https://github.com/user-attachments/assets/6fea8870-c37b-46e1-b242-6ea71c5bd146)

## Interesting code
I am using the code for (Transactions t : Ledger.viewAllTransactions()) to loop through the list returned by the viewAllTransactions method in the Ledger class. This allows me to filter and process transactions in other methods—both inside and outside the Ledger  class—without needing to create a new list.
By reusing the returned list directly, my report methods stay clean, concise, and easier to read. This approach avoids unnecessary duplication and keeps my code efficient.
# // Method to Display all Transactions
![image](https://github.com/user-attachments/assets/5b3ff2f3-79b3-4943-89cb-3bd7943aff6e)
# Examples
![image](https://github.com/user-attachments/assets/9caa6e57-a5dd-4586-99fa-f6ac7d37ca2f)

