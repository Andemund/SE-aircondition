package testSocket;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;

import org.json.JSONObject;

public class Client {
    private static final String IP_ADDR = "192.168.43.28";//��������ַ
    private static final int PORT = 12345;//�������˿ں�

    public static void main(String[] args) {
        System.out.println("�ͻ�������...");
        System.out.println("�����յ����������ַ�Ϊ \"OK\" ��ʱ��, �ͻ��˽���ֹ\n");
        Scanner in=new Scanner(System.in);
        while (true) {
            Socket socket = null;
            try {
                //����һ�����׽��ֲ��������ӵ�ָ�������ϵ�ָ���˿ں�
                socket = new Socket(IP_ADDR, PORT);
                //��ȡ������������
                DataInputStream input = new DataInputStream(socket.getInputStream());
                //��������˷�������
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                conditioner air=new conditioner();
                System.out.println("type: ");
                air.setType(in.nextInt());
                System.out.println("room:");
                air.setRoom(in.nextInt());
                System.out.println("switch:");
                air.set_switch(in.nextInt());
                System.out.println("temperature:");
                air.setTemperature(in.nextInt());
                System.out.println("wind:");
                air.setWind(in.nextInt());
                JSONObject jsonObject=new JSONObject(air);

                out.writeUTF(jsonObject.toString()+"\n");

                String ret = input.readUTF();
                System.out.println("�������˷��ع�������: " + ret);
                // ����յ� "OK" ��Ͽ�����
                if ("OK".equals(ret)) {
                    System.out.println("�ͻ��˽��ر�����");
                    Thread.sleep(500);
                    break;
                }

                out.close();
                input.close();
            } catch (Exception e) {
                System.out.println("�ͻ����쳣:" + e.getMessage());
            } finally {
                if (socket != null) {
                    try {
                        socket.close();
                    } catch (IOException e) {
                        socket = null;
                        System.out.println("�ͻ��� finally �쳣:" + e.getMessage());
                    }
                }
            }
        }
    }
}

