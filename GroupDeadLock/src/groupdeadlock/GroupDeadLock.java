package groupdeadlock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 *
 * @author Saengaroun Saengduangchan & mmilutinovic1313
 */
public class GroupDeadLock {
   // Creat lock objects
   public static Lock lock1 = new Lock() {
       @Override
       public void lock() {
           throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       }

       @Override
       public void lockInterruptibly() throws InterruptedException {
           throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       }

       @Override
       public boolean tryLock() {
           throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       }

       @Override
       public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
           throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       }

       @Override
       public void unlock() {
           throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       }

       @Override
       public Condition newCondition() {
           throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       }
   };
   public static Lock lock2 = new Lock() {
       @Override
       public void lock() {
           throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       }

       @Override
       public void lockInterruptibly() throws InterruptedException {
           throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       }

       @Override
       public boolean tryLock() {
           throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       }

       @Override
       public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
           throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       }

       @Override
       public void unlock() {
           throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       }

       @Override
       public Condition newCondition() {
           throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       }
   };
   // Create and Start Threads
   public static void main(String args[]) {
      ThreadDemo1 t1 = new ThreadDemo1();
      ThreadDemo2 t2 = new ThreadDemo2();
      t1.start();
      t2.start();
   }
   
   private static class ThreadDemo1 extends Thread {
      public void run() {
         synchronized (lock1) {
            System.out.println("Thread 1: Holding lock 1...");
            try { 
                Thread.sleep(10); 
            }
            catch (InterruptedException e) {
            // provide exception details
            e.addSuppressed(e);
            }
            System.out.println("Thread 1: Waiting for lock 2...");
            
            synchronized (lock2) {
               System.out.println("Thread 1: Holding lock 1 & 2...");
            }
         }
      }
   }
   
   private static class ThreadDemo2 extends Thread {
      public void run() {
         synchronized (lock2) {
            System.out.println("Thread 2: Holding lock 2...");
            
            try { 
                Thread.sleep(10); 
            }
            catch (InterruptedException e) {
            // provide exception details
            e.addSuppressed(e);
            }
            System.out.println("Thread 2: Waiting for lock 1...");
            
            synchronized (lock1) {
               System.out.println("Thread 2: Holding lock 1 & 2...");
            }
         }
      }
   } 
}
