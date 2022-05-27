package org.cs3450;

public class MasterCard extends Card {
    public MasterCard(CustMaster customer) {
        cardNum = customer.number;
        expMM = customer.month;
        expYY = customer.year;
    }

    public boolean isNumOfDigitsValid() {
        return cardNum.length() == 16;
    }

    public boolean isValidPrefix() {
        String prefix = cardNum.substring(0, 1);
        String nextChar = cardNum.substring(1, 2);
        String validChars = "12345";
        return (prefix.equals("5")) && (validChars.contains(nextChar));
    }
}
