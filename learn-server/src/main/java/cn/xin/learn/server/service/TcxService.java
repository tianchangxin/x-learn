package cn.xin.learn.server.service;

import org.springframework.stereotype.Service;

/**
 * @author xin
 * @description: 用户服务类
 * @date 2025年04月05日
 */
@Service
public class TcxService {
    public final static TcxService instance = new TcxService();

    public TcxService() {
        System.out.println("TcxService init");
    }

    /**
     * 展示
     */
    public void show() {
        System.out.println("TcxService show");
    }

    public static void main(String[] args) {
        TcxService service = TcxService.instance;
        TcxService service2 = TcxService.instance;

    }


}
