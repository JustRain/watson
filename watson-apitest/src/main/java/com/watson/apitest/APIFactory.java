package com.watson.apitest;

import com.watson.apitest.dubbo.DubboTest;
import com.watson.apitest.http.HttpTest;
import com.watson.apitest.socket.SocketTest;
import lombok.extern.slf4j.Slf4j;

/**
 * @author chong.xu
 * @Description: TODO
 * @date 2019/4/115:46 PM
 */
@Slf4j
public class APIFactory {

    /**
     * 创建dubbo协议远程服务
     * @param clazz 要创建的class
     * @param dubboAddress  zookeeper
     * @param <T>
     * @return 调用远程服务创建好的class
     */
    public  static <T> T createDubboTest (Class<T> clazz,String dubboAddress){
        return (T) DubboTest.getInstance().getService(clazz, dubboAddress);
    }

    /**
     * 创建dubbo协议远程服务
     * @param clazz 要创建的class
     * @param dubboAddress  zookeeper
     * @param <T>
     * @return 调用远程服务创建好的class
     */
    public  static <T> T createDubboTest (Class<T> clazz,String dubboAddress,int timeOut){
        return (T) DubboTest.getInstance().getService(clazz, dubboAddress,timeOut);
    }


    public static HttpTest createHttpTest(){
        return  HttpTest.getInstance();

    }

    public static SocketTest createSocketTest(String address,int port){
        return new SocketTest(address,port);
    }

}
