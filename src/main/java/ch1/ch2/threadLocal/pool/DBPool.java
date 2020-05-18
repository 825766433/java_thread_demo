package ch1.ch2.threadLocal.pool;

import java.sql.Connection;
import java.util.LinkedList;

public class DBPool {

    //容器，连接池，用来存放连接
    private static LinkedList<Connection> connectionLinkedList = new LinkedList<>();

    //限制连接池的大小，创建连接池的时候，初始化大小
    public DBPool(int initSize) {
        if(initSize>0){
            for (int i = 0; i < initSize; i++) {
                connectionLinkedList.addLast(SqlConnectImpl.fetchConnection());
            }
        }
    }

    //释放连接方法 ,并唤醒其他的线程拿取连接
    public void releaseConnection(Connection connection){
        //释放先锁上线程池
        if (connection!=null){
            synchronized (connectionLinkedList){
                connectionLinkedList.addLast(connection);
                connectionLinkedList.notifyAll();
            }
        }
    }

    //获取连接
    Connection fetchConnection(long mills) throws InterruptedException {
        //获取先锁上线程池
        synchronized (connectionLinkedList){
            //永久等待
            if(mills<0){
                    //如果这个连接池里面没有了连接，已经为空了，则进行等待，否则就从头部返回一个连接。
                    while(connectionLinkedList.isEmpty()){
                        connectionLinkedList.wait();
                    }
                    return connectionLinkedList.removeFirst();
            }else{//mills>0
                //记录未来时间（超时时间）
                long futrue = System.currentTimeMillis() + mills;
                //等待时间
                long remaining = mills;
                //线程池为空，但是超时时间大于0
                while(connectionLinkedList.isEmpty() && remaining>0){
                    connectionLinkedList.wait(remaining);
                    //重新计算等待时长，等待之后，将超时时间变小，最后会形成，remaining<0,这时，也就跳出了wait
                    remaining = futrue - System.currentTimeMillis();
                }
                Connection connection = null;
                //如果等待时间到了，如果线程池不为空，则返回线程，如果线程池为空，则返回null；
                if(!connectionLinkedList.isEmpty()){
                    connection = connectionLinkedList.removeFirst();
                }
                return connection;
            }
        }
    }

}
