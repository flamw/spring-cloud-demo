package cn.com.xbed.test.proxy.statics;

import cn.com.xbed.test.proxy.statics.IPerson;

/**
 * @Date 2020/1/3 16:16
 * @Created by huangfl
 */
public class Man implements IPerson {
    @Override
    public void say() {
        System.out.println("man say.....");
    }
}
