package cn.enjoy.rmi;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class Server {


    public static void main(String[] args) throws Exception{
        //接口实例化
        IOrder iOrder = new IOrderImpl();
        //本地的服务注册到6666端口中
        LocateRegistry.createRegistry(6666);
        //把刚才的实例绑定到本地端口上的一个路径
        Naming.bind("rmi://localhost:6666/order",iOrder);
        System.out.println("服务器已经启动了");


    }
}
