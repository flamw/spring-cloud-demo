package cn.com.xbed.test.proxy.statics;

/**
 * @Date 2020/1/3 16:19
 * @Created by huangfl
 */
public class ManProxy implements IPerson {
    private IPerson iPerson;

    public IPerson getiPerson() {
        return iPerson;
    }

    public void setiPerson(IPerson iPerson) {
        this.iPerson = iPerson;
    }

    @Override
    public void say() {
        if (iPerson != null) {
            System.out.println("manproxy...........");
            iPerson.say();
        }
    }
}
