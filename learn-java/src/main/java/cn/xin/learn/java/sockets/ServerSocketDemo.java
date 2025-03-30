package cn.xin.learn.java.sockets;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * @author xin
 * @description: 服务端
 * @date 2025年02月16日
 */
public class ServerSocketDemo {
    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(9999);
             Socket socket = server.accept();
             InputStream is = socket.getInputStream();
             OutputStream os = socket.getOutputStream();

             Scanner scanner = new Scanner(is)) {
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(os, "gbk"), true);
            pw.println("hello");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
