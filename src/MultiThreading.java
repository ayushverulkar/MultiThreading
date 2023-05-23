import java.io.*;
import java.util.Scanner;

public class MultiThreading {


    public static void main(String[] args)  throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of threads: ");
        int limit = 1000000000;
        int n = sc.nextInt();
        int start = 1;
        int end = limit/n;


        for(int i=1;i<=n;i++){
            File file = new File("C:\\Users\\Asus\\IdeaProjects\\multithreading2\\file"+i+".txt");
            PrintStream stream = new PrintStream(file);
            System.setOut(stream);
            Thread th = new Thread(new Thread1(start,end,i));
            th.start();
            try{
                th.join();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            start = end+1;
            end = (i+1)*limit/n;
        }

    }
}

class Thread1 implements Runnable {
    int minValue;
    int maxValue;
    int id;

    public Thread1(int s,int e,int id){
        this.maxValue=e;
        this.minValue=s;
        this.id=id;
    }
    @Override
    public void run()  {
        long startTime = System.currentTimeMillis();
        for (int i=minValue;i<=maxValue;i++){
            System.out.println(i );

        }
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println("time: "+elapsedTime/(1000*60)+" minutes");
    }
}