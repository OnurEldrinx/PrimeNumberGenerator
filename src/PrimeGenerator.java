import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PrimeGenerator {

    private JTextArea textArea;
    private JButton generateButton;
    private ArrayList<Integer> primes;
    private int lastGeneratedPrime;
    private static int counter;
    private static int clickCounter;


    public PrimeGenerator(){

        primes = new ArrayList<>(){};

        //Create first 20 primes;
        counter = 0;

        while (primes.size() < 20) {

            if (isPrime(counter)) {

                primes.add(counter);

            }

            counter++;


        }


        JFrame frame = new JFrame("Question 2");

        textArea = new JTextArea();
        textArea.setBounds(20,80,350,150);

        JScrollPane scroll = new JScrollPane(textArea);
        scroll.setBounds(20,80,350,150);

        generateButton = new JButton("Generate Next Prime");
        generateButton.setBounds(100,20,200,50);
        generateButton.setFocusPainted(false);

        generateButton.addActionListener(e->generatePrime(frame));



        frame.add(generateButton);
        frame.add(scroll);


        frame.getContentPane().setBackground(Color.LIGHT_GRAY);
        frame.setSize(400,300);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setVisible(true);

        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

    }

    public void generatePrime(Frame frame){

        if(clickCounter<20){

            textArea.append(primes.get(clickCounter).toString() + "\n");
            clickCounter++;

        }else {


            try {

                lastGeneratedPrime = primes.get(clickCounter - 1);
                textArea.setText("");
                primes.clear();
                generateTwentyPrimes(lastGeneratedPrime);
                clickCounter = 0;
                throw new BigPrimeException("Big Prime Number!");


            } catch (BigPrimeException e) {

                JOptionPane.showMessageDialog(frame,e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);

            }



        }


    }

    public void generateTwentyPrimes(int lastGeneratedPrime){

        counter = lastGeneratedPrime + 1;

        while (primes.size() < 20) {

            if (isPrime(counter)) {

                primes.add(counter);

            }

            counter++;


        }

    }



    static boolean isPrime(int n)
    {

        if (n <= 1) {
            return false;
        }

        for (int i = 2; i < n; i++){
            if (n % i == 0){
                return false;
            }
        }

        return true;
    }



}
