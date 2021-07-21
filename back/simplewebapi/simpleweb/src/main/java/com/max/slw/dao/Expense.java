package com.max.slw.dao;

import java.util.Date;

public class Expense {
    int expenseid;
    int expenseall;
    int expenseneed;
    int ownerid;
    String expensetype;
    Date edate;

    public Expense(){};
    public Expense(int expenseid, int expenseall, int expenseneed, int ownerid, String expensetype, Date edate) {
        this.expenseid = expenseid;
        this.expenseall = expenseall;
        this.expenseneed = expenseneed;
        this.ownerid = ownerid;
        this.expensetype = expensetype;
        this.edate = edate;
    }

    public int getExpenseid() {
        return expenseid;
    }

    public void setExpenseid(int expenseid) {
        this.expenseid = expenseid;
    }

    public int getExpenseall() {
        return expenseall;
    }

    public void setExpenseall(int expenseall) {
        this.expenseall = expenseall;
    }

    public int getExpenseneed() {
        return expenseneed;
    }

    public void setExpenseneed(int expenseneed) {
        this.expenseneed = expenseneed;
    }

    public int getOwnerid() {
        return ownerid;
    }

    public void setOwnerid(int ownerid) {
        this.ownerid = ownerid;
    }

    public String getExpensetype() {
        return expensetype;
    }

    public void setExpensetype(String expensetype) {
        this.expensetype = expensetype;
    }

    public Date getEdate() {
        return edate;
    }

    public void setEdate(Date edate) {
        this.edate = edate;
    }
}
