package cn.enjoy.pool;

import java.sql.Connection;
import java.util.LinkedList;

/**
 * 实现数据库连接池
 */
public class DBPool {

    private static LinkedList<Connection> pool = new LinkedList<Connection>();

    public DBPool(int initalSize){
        if (initalSize > 0) {
            for (int i = 0; i < initalSize; i++) {
                pool.addLast(SqlConnectImpl.fetchConnection());
            }
        }
    }

    //在mills时间内还拿不到数据库连接，就返回一个null
    public Connection fetchConn(long mills) throws InterruptedException {
        synchronized (pool) {
            if (mills < 0) {
                while (pool.isEmpty()) {
                    pool.wait();
                }
                return pool.removeFirst();
            }else {
                long overtime = System.currentTimeMillis() + mills;
                long remain = mills;
                while (pool.isEmpty() && remain > 0) {
                    pool.wait(remain);
                    remain = overtime - System.currentTimeMillis();
                }
                Connection result = null;
                if (!pool.isEmpty()) {
                    result = pool.removeFirst();
                }
                return result;
            }
        }
    }

    //放回数据库连接
    public void releaseConn(Connection conn){
        if (conn != null) {
            synchronized (pool){
                pool.addLast(conn);
                pool.notifyAll();
            }
        }
    }

}
