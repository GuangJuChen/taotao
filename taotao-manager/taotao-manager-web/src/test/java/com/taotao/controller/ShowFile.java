package com.taotao.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ShowFile { 
     public static void main(String args[]){  
         String infname="D:/Documents/Pictures/images/img10.jpg";
         try{ 
             File fin=new File(infname);        //转入的文件对象
             BufferedReader in = new BufferedReader(new FileReader(fin));  //打开输入流
             String s; 
             while((s = in.readLine()) != null){//读字符串
                 System.out.println(s);          //写出      
             } 
             in.close(); //关闭缓冲读入流及文件读入流的连接     
         }catch (FileNotFoundException e1){           //异常处理
             e1.printStackTrace();
         }catch(IOException e2){    
             e2.printStackTrace();
         } 
     } 
 }