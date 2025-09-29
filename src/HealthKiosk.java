import java.util.Scanner;
import java.util.Random;

public class HealthKiosk {
    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        // TASK 1
        System.out.println("Welcome to Ashesi Health Kiosk");
        System.out.println("Please select one of these services(P/L/T/C): ");
        char services=input.next().charAt(0);
        services=Character.toUpperCase(services);
        switch(services){
            case 'P':
                System.out.println("Go to: Pharmacy Desk");
                break;
            case 'L':
                System.out.println("Go to: Lab Desk");
                break;
            case 'T':
                System.out.println("Go to: Triage Desk");
                break;
            case 'C':
                System.out.println("Go to: Counseling Desk");
                break;
            default:
                System.out.println("Invalid service code");
        }

        // TASK 2
        double metricValue=0;
        double bmi=0;
        System.out.println("BMI=1\nDosage round-up=2\nSimple trig helper=3\n");
        System.out.println("Choose health metric: ");
        int healthMetric=input.nextInt();
        if(healthMetric == 1){
            System.out.println("Please enter your weight(kg): ");
            double weight=input.nextDouble();
            System.out.println("Please enter your height(m): ");
            double height=input.nextDouble();
            bmi=weight/Math.pow(height,2);
            metricValue=bmi;
            bmi=Math.round(bmi*10)/10.0;
            if(bmi<18.5){
                System.out.println("BMI: "+ bmi +" Category:Underweight");
            }else if(bmi>=18.5 && bmi <=24.9){
                System.out.println("BMI: " +bmi +" Category:Normal");
            }else if(bmi>=25 && bmi<=29.9){
                System.out.println("BMI: "+bmi +" Category:Overweight");
            }else{
                System.out.println("BMI: "+bmi +" Category:Obese");
            }
        }
        else if(healthMetric==2){
            System.out.println("Please enter the required dosage(mg): ");
            double dosage=input.nextDouble();
            double dispense=250;
            double numberOfTablets=Math.ceil(dosage/dispense);
            int numberOfTablets2= (int)numberOfTablets;
            metricValue=numberOfTablets2;
            System.out.println("The total number of tablets is "+ numberOfTablets2);
        }
        else if(healthMetric==3){
            System.out.println("Please enter an angle in degrees: ");
            double angleDegrees=input.nextDouble();
            double radians=Math.toRadians(angleDegrees);
            double sinValue=Math.sin(radians);
            double cosValue=Math.cos(radians);
            metricValue=Math.round(Math.sin(radians)*100);
            System.out.println("The sin of the angle is "+ (Math.round(sinValue*1000)/1000.0));
            System.out.println("The cos of the angle is "+ (Math.round(cosValue*1000)/1000.0));

        }

        // TASK 3
        char randomChar=(char) ('A'+(int)(Math.random()*26));
        Random rand=new Random();
        int num1= rand.nextInt(7)+3;
        int num2=rand.nextInt(7)+3;
        int num3=rand.nextInt(7)+3;
        int num4=rand.nextInt(7)+3;
        String id=""+randomChar+ num1+ num2+ num3+ num4;
        System.out.println("Student ID: "+ id);
        if(id.length() !=5){
            System.out.println("Invalid length");
        }else if(!Character.isLetter(id.charAt(0))){
            System.out.println("First character must be a letter");
        }else if(!(Character.isDigit(id.charAt(1)) && Character.isDigit(id.charAt(2)) && Character.isDigit(id.charAt(3)) && Character.isDigit(id.charAt(4)))){
            System.out.println("Invalid last 4 numbers");
        }
        else{
            System.out.println("ID OK");
        }


        //TASK 4
        input.nextLine();
        System.out.println("Please enter your first name: ");
        String name=input.nextLine();
        char firstChar=Character.toUpperCase(name.charAt(0));
        char shiftedLetter=(char)('A'+(firstChar-'A'+ 2) % 26);

        String lastTwo=id.substring(3);
        int roundedMetric=(int)Math.round(metricValue);
        String code= ""+shiftedLetter+lastTwo+"-"+roundedMetric;
        System.out.println("Display Code: "+code);

        // TASK 5
        System.out.println("Summary: ");
        switch(services){
            case 'P':
                System.out.println("PHARMACY | ID= " + id + " | Code= "+ code);
                break;
            case 'T':
                System.out.println("TRIAGE | ID= " + id + " | BMI= " + bmi + " | Code= " + code);
                break;
            case 'L':
                System.out.println("LAB | ID= " + id +" | Code= " + code);
                break;
            case 'C':
                System.out.println("COUNSELING | ID= " + id + " | Code= " + code);
                break;
        }



    }
}
