package com.isanthree.spring5;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class JDKProxy {
    public static void main(String[] args) {
        Class[] interfaces = {UserDao.class};
        UserDaoImpl userDao = new UserDaoImpl();
        UserDao dao = (UserDao)Proxy.newProxyInstance(JDKProxy.class.getClassLoader(), interfaces, new UserDaoProxy(userDao));
        int result = dao.add(1, 2);
        System.out.println("result: " + result);
    }
}

/**
 * 创建代理对象代码
 */
class UserDaoProxy implements InvocationHandler {

    /**
     * 传递被代理对象，进行有参构造传递
     */
    private Object object;
    public UserDaoProxy(Object object) {
        this.object = object;
    }

    /**
     * 增强的逻辑；
     * UserDaoProxy 创建之后，这个方法就会被调用。
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        // 被增强的方法执行之前
        System.out.println("被代理对象的方法执行之前..." + method.getName() + " : 传递的参数..." + Arrays.toString(args));

        // 被增强的方法执行
        System.out.print("执行被代理对象的方法：");
        Object res = method.invoke(object, args);

        // 被增强的方法执行之后
        System.out.println("被代理对象的方法执行之后..." + object);

        return res;
    }
}
