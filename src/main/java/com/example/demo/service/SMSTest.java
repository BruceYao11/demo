package com.example.demo.service;

import gnu.io.CommPortIdentifier;
import org.springframework.boot.web.server.PortInUseException;
import gnu.io.SerialPort;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class SMSTest {
    public static synchronized SerialPort getSerialPort(String comName, int speed) {
        SerialPort serialPort = null;
        try {
            //Enumeration portList = CommPortIdentifier.getPortIdentifiers();
            CommPortIdentifier portId = CommPortIdentifier.getPortIdentifier(comName);
            serialPort = (SerialPort)portId.open("com.eccom.sms", 1997);
            serialPort.setFlowControlMode(SerialPort.FLOWCONTROL_RTSCTS_IN);
            serialPort.setSerialPortParams(speed, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
            return serialPort;
        }
        catch (PortInUseException e) {
            //log.error("短信串口启动异常", e);
            System.out.println("串口被占用");
            return null;
        }catch(Exception e){
            //log.error("短信串口启动异常", e);
            e.printStackTrace();
            return null;
        }
    }


    public static void main(String[] args) {
        Map<String, List<String>> mpSMS = new LinkedHashMap<String,List<String>>();
        List<String>lstContent = new ArrayList<String>();
        lstContent.add("短信测试abcd1");
//		lstContent.add("短信测试abcd2");
//		lstContent.add("短信测试abcd3");
//		lstContent.add("短信测试abcd4");
//		lstContent.add("短信测试abcd5");
        mpSMS.put("13816679488", lstContent);
        long l = System.currentTimeMillis();
        SMSTest.getSerialPort("COM3", 9600);
        System.out.println(System.currentTimeMillis()-l);
    }
}
