package org.cs3450;

public class DinersCard extends Card {
    public DinersCard(CustDiner customer) {
        cardNum = customer.number;
        expMM = customer.month;
        expYY = customer.year;
    }

    public boolean isNumOfDigitsValid() {
        return cardNum.length() == 14;
    }

    public boolean isValidPrefix() {
        String prefix = cardNum.substring(0, 1);
        String nextChar = cardNum.substring(1, 2);
        String validChars = "068";  //2nd char must be a 0 or 6, or 8
        return (prefix.equals("3")) && (validChars.contains(nextChar));
    }

}  //end diners card class

