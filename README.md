# befitting-harbor-9010
[FinEase](https://user-images.githubusercontent.com/119488008/236867253-f23c70ce-0b9f-46a9-a4de-f3dcb9a69000.png)

[ER-Diagram](https://drive.google.com/file/d/1Cv4nlHJhECcYgYeCuqAOrCWtUzpRLVQ5/view?usp=sharing)

Users of this project
-> Adminstrator
-> Customer

Tech Stack : 
1) Java
2) Hibernet
3) SQL

The Roles of Accountant:

1) Login using his/her username and password
2) View information about all customers
3) Viewing particular customer details by customer_id
4) View information about all accounts
5) Viewing particular account details by account_number
6) Change the status of account from active to inoperative if no trsnaction for last 24
   months and vice versa
7) view all inoperative accounts
8) view all closed accounts
9) Can see the transaction report for a day range for all accounts.
10) Logout his account

The Roles of the Customer:

1) Can register with new account using information customer_id, name, mobile,
  address, username, password
2) Login his account
3) update details like name, mobile, address (but not username)
4) can change password
5) Sign in to account
6) Open account saving/loan account
7) Deposite & withdraw money to saving/loan account
8) Transfer the money from his account to another account (using account number
   only)
9) Checking the transaction history for a date range
10) close his saving/loan account
11) Logout his account
