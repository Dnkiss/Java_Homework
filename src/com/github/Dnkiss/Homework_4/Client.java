package com.github.Dnkiss.Homework_4;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Client {
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        DatagramSocket client = null;

        try {
            client = new DatagramSocket();

            BufferedReader brIn = new BufferedReader(new InputStreamReader(System.in));
            // 从系统标准输入读入一字符串
            String readline = brIn.readLine();
            // 若从标准输入读入的字符串为 "bye"则停止循环
            while (!readline.equals("bye")) {
                byte[] sendBuf = readline.getBytes();
                InetAddress addr = InetAddress.getByName("112.103.141.73");
                int port = 22565;
                DatagramPacket sendPacket = new DatagramPacket(sendBuf, sendBuf.length, addr, port);
                client.send(sendPacket);
                System.out.println(sdf.format(new Date()) + " 向UDP服务端发送消息:" + readline);
                System.out.println();
                System.out.print("请输入需要发送给UDP服务端的消息:");
                readline = brIn.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            client.close();
        }
    }
}
