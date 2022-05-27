package hall;


/**
 * Implementation of the Compound Pattern
 * Author: Joshua Hall (10787004)
 * Last Modified: 4/22/2022
 */
public class App 
{
    public static void main(String[] args) {

        //instantiate fan class
        CeilingFanCommand fanCommand = new CeilingFanCommand();
        fanCommand.button1.on();
        fanCommand.button1.off();
        System.out.println("-----------------------");

        fanCommand.button2.on();
        fanCommand.button2.off();
        System.out.println("-----------------------");

        fanCommand.button3.on();
        fanCommand.button3.off();
        System.out.println("-----------------------");

        fanCommand.button4.on();
        fanCommand.button4.on();
        fanCommand.button4.on();
        fanCommand.button4.on();
        fanCommand.button4.on();
        fanCommand.button4.on();
        fanCommand.button4.off();

        System.out.println("-----------------------");
        fanCommand.button3.on();
        fanCommand.button4.on();
        fanCommand.button4.on();
        fanCommand.button3.off();

    }

}
