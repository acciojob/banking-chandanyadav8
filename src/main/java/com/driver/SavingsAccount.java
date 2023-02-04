package com.driver;

public class SavingsAccount extends BankAccount{
    double rate;
    double maxWithdrawalLimit;
    int withdrawcount=0;

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public double getMaxWithdrawalLimit() {
        return maxWithdrawalLimit;
    }

    public void setMaxWithdrawalLimit(double maxWithdrawalLimit) {
        this.maxWithdrawalLimit = maxWithdrawalLimit;
    }

    public int getWithdrawcount() {
        return withdrawcount;
    }

    public void setWithdrawcount(int withdrawcount) {
        this.withdrawcount = withdrawcount;
    }

    public SavingsAccount(String name, double balance, double maxWithdrawalLimit, double rate) {
        // minimum balance is 0 by default
        super(name,balance,0);
        this.rate=rate;
        this.maxWithdrawalLimit=maxWithdrawalLimit;

    }
    public void withdraw(double amount) throws Exception {
        // Might throw the following errors:
        // 1. "Maximum Withdraw Limit Exceed" : If the amount exceeds maximum withdrawal limit
        // 2. "Insufficient Balance" : If the amount exceeds balance
        withdrawcount++;
        if(withdrawcount>maxWithdrawalLimit)
            throw new Exception("Maximum Withdraw Limit Exceed");
        if(getBalance()-amount<getMinBalance())
            throw new Exception("Insufficient Balance");
        double remaining=getBalance()-amount;
         setBalance(remaining);


    }

    public double getSimpleInterest(int years){
        // Return the final amount considering that bank gives simple interest on current amount
        double intrst=getBalance()*rate;
        double yrs=intrst*years;
        return getBalance()+yrs;


    }

    public double getCompoundInterest(int times, int years){
        // Return the final amount considering that bank gives compound interest on current amount given times per year
        double compoundInterest = getBalance() * Math.pow((1 + rate / (100*times)), times * years);
        //  return compoundInterest;
        return getBalance()*Math.pow((1 + rate/(100*times)), times*years);

    }

}
