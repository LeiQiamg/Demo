package com.hello.demo.util.demo;


import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.apache.poi.ss.formula.functions.T;

/**
 * 三线程ABC循环打印
 * @author leiqiang
 * @date 2021/6/10
 */
public class LockSupport {

    private static Lock lock = new ReentrantLock();
    //创建不同线程的队列便于唤醒
    private static Condition cA = lock.newCondition();
    private static Condition cB = lock.newCondition();
    private static Condition cC = lock.newCondition();
    //创建门栓-保证打印顺序
    private static CountDownLatch countDownLatchB = new CountDownLatch(1);
    private static CountDownLatch countDownLatchC = new CountDownLatch(1);

    public static void main(String[] args) {
        Thread threadA = new Thread(() -> {
            lock.lock();
            try {
                for (int i = 0; i < 10; i++) {
                    System.out.print("A");
                    //唤醒B队列的线程进行打印
                    cB.signal();
                    //放开B线程的门栓
                    if (i == 0) {
                        countDownLatchB.countDown();
                    }
                    //让A线程进入等待
                    cA.await();
                }
                //最后一次唤醒B线程让所有线程都结束
                cB.signal();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        });
        Thread threadB = new Thread(()->{
            try {
                countDownLatchB.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.lock();
            try {
                for (int i = 0; i < 10; i++) {
                    System.out.print("B");
                    //唤醒C队列的线程进行打印
                    cC.signal();
                    //放开C线程的门栓
                    if (i == 0) {
                        countDownLatchC.countDown();
                    }
                    //让B线程进入等待
                    cB.await();
                }
                cC.signal();
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        });
        Thread threadC = new Thread(()->{
            try {
                countDownLatchC.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.lock();
           try {
               for (int i = 0; i < 10; i++) {
                   System.out.print("C");
                   //唤醒A队列的线程进行打印
                   cA.signal();
                   //让C线程进入等待
                   cC.await();
               }
               //最后唤醒A
               cA.signal();
           }catch (Exception e){

           }finally {
               lock.unlock();
           }
        });
        threadA.start();
        threadB.start();
        threadC.start();
    }
}
