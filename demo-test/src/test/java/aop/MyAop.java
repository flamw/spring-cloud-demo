package aop;

public class MyAop {

    public int div(int i, int j) {
        System.out.println("div方法开始执行");
        return i / j;
    }
}
