import java.io.*;
import java.lang.Thread;
import java.util.Random;

// https://medium.com/javarevisited/do-you-know-why-local-variables-are-thread-safe-in-java-latest-e4f98e013ac
// https://github.com/kanastasov/MultithreadingJava/blob/master/1_StartingThread/src/implementsRunnable/Application.java
// https://mkyong.com/swing/java-swing-hello-world-example/
// https://stackoverflow.com/questions/541487/implements-runnable-vs-extends-thread-in-java/15226278#15226278
// https://www.geeksforgeeks.org/implement-runnable-vs-extend-thread-in-java/
// https://www.geeksforgeeks.org/thread-sleep-method-in-java-with-examples/
// https://github.com/harblaith7/Docker-AWS-Crash-Course/blob/main/package.json
// https://docs.docker.com/language/java/deploy/

class ExtendsThread extends Thread {

    public Integer ClassID;
    public Integer ClassID2;
      
    public void run() 
    { 
    
        ClassID = new Random().nextInt(1000);
        Integer LocalID = new Random().nextInt(1000);   
        System.out.println("Run method executed by child Thread (begin) ClassID=" + ClassID + ";LocalID="+LocalID);
         
        try {
            //sleep is static method of Thread class 
            Thread.sleep(ClassID);
        } catch (InterruptedException e){
            //TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        System.out.println("Run method executed by child Thread   (end) ClassID=" + ClassID + ";LocalID="+LocalID); 
    } 

    public static void main(String[] args) 
    { 
        ExtendsThread t1 = new ExtendsThread();
        ExtendsThread t2 = new ExtendsThread();
        
        // Main thread instead of the child thread
        //t1.run(); 
        // Main thread instead of the child thread
        
        // Child Thread 
        t1.start(); 
        // Child Thread 
                
        // Main thread
        try {
                Thread.sleep(100);
                System.out.println("Main method executed by main thread");
        }
        catch (Exception e) {     
            // catching the exception
            System.out.println(e);
        }
        // Main thread 
        
        // Child Thread 
        t2.start();
        // Child Thread   
    } 
}
