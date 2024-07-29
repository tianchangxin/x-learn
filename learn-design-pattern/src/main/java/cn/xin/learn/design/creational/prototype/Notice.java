package cn.xin.learn.design.creational.prototype;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.util.Date;

/**
 * @author tiancx
 * @description: 通知
 * @date 2024年07月29日
 */
@Data
@Slf4j
public class Notice implements Cloneable,Serializable{
    private User user;
    private String title;
    private String content;
    private Date date;

    /**
     * 浅克隆
     */
//    @Override
//    protected Notice clone() throws CloneNotSupportedException {
//        return (Notice) super.clone();
//    }

    /**
     * 深克隆
     */
    @Override
    protected Notice clone() throws CloneNotSupportedException {
        try {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(outputStream);
            //序列化时，对象的所有属性层级关系会被序列化自动处理
            oos.writeObject(this);
            oos.close();
            //从内存中读取数据
            byte[] bb = outputStream.toByteArray();
            InputStream in = new ByteArrayInputStream(bb);
            ObjectInputStream ois = new ObjectInputStream(in);
            Object clone = ois.readObject();
            ois.close();
            return (Notice) clone;
        } catch (Exception e) {
            log.error("clone error", e);
            e.printStackTrace();
        }
        return null;
    }
}
