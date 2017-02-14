/***
Description: Write a Java application using the NetBeans IDE that 
utilizes primitive data types, operators, expressions, statements, 
blocks, and control flow.
***/
package lcpn87languagebasics;

/**
 *
 * @author Carlie
 */
public class Lcpn87LanguageBasics {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Declaring variables & setting initial values
        byte sample1 = 0x3a;
        byte sample2 = 58;
        short heartRate = 85;
        long deposits = 135002796;
        float acceleration = 9.584f;
        float mass = 14.6f;
        double distance = 129.763001;
        boolean lost = true;
        boolean expensive = true;
        int choice = 1;
        char integral = '\u222B';
        char letter1 = 'a';
        char letter2 = 97;
        String greeting = "Hello";
        String name = "Karen";
        
        //check if samples are equal
        if(sample1 == sample2)
            System.out.println("The samples are equal.");
        else
            System.out.println("The samples are not equal.");
        //check if heart rate is normal
        if(heartRate >= 40 && heartRate <= 80)
            System.out.println("Heart rate is normal.");
        else
            System.out.println("Heart rate is not normal.");
        //check how rich user is
        if(deposits >= 100000000)
            System.out.println("You are exceedlingly wealthy.");
        else
            System.out.println("Sorry you are so poor.");
        //calculate force
        double force = mass * acceleration;
        System.out.println("force = "+force);
        System.out.println(distance+" is the distance");
        //check if lost item is expensive
        if(lost == true && expensive == true)
            System.out.println("I am really sorry! I will get the manager.");
        if(lost == true && expensive == false)
            System.out.println("Here is coupon for 10% off.");
        //perform switch/case to see what choice is
        switch(choice)
        {
            case 1:
                System.out.println("You chose 1.");
                break;
            case 2:
                System.out.println("You chose 2.");
                break;
            case 3:
                System.out.println("You chose 3.");
                break;
            default:
                System.out.println("You made an unknown choice");
                break;
        }
        //show char integral
        System.out.printf("%c is an integral.\n", integral);
        //see if letter1 & letter2 are the same
        System.out.printf(letter1 + " and " + letter2);
        if(letter1 == letter2)
            System.out.printf(" are the same.");
        else
            System.out.printf(" are not the same.");
        //for loop to count from 5 to 10
        for(int i=5;i<=10;i++)
            System.out.println("i = " + i);
        //while loop that continues while age is less than 6 and increments
        int age = 0;
        while(age < 6)
        {
            System.out.println("age = " + age);
            age++;
        }
        //greeting + name string
        System.out.println(greeting + " " + name);
    }
    
}
