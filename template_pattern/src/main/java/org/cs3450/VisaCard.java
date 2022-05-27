package org.cs3450;

public class VisaCard extends Card {
    public VisaCard(CustVisa customer) {
        cardNum = customer.number;
        expMM = customer.month;
        expYY = customer.year;
    }

    public boolean isNumOfDigitsValid() {
        return (cardNum.length() == 13) || (cardNum.length() == 16);
    }

    public boolean isValidPrefix() {
        String prefix = cardNum.substring(0, 1);
        return prefix.equals("4");
    }
}

