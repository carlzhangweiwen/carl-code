package com.carl.carlapp.wx;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class CoreServlet extends HttpServlet 
{
    public CoreServlet() {
        super();
    }
    public void destroy() {
        super.destroy(); 
    }
 
    /**
     * 验证url和token
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        // 微信加密签名
        String signature = request.getParameter("signature");
        // 时间戮
        String timestamp = request.getParameter("timestamp");
        // 随机数
        String nonce = request.getParameter("nonce");
        // 随机字符串
        String echostr = request.getParameter("echostr"); 
         
        PrintWriter out = response.getWriter();
        // 通过检验 signature 对请求进行校验，若校验成功则原样返回 echostr，表示接入成功，否则接入失败
       if(SignUtil.checkSignature(signature, timestamp, nonce)){
           out.print(echostr);
       }
 
       out.close();
       out = null; 
    }
 
    /**
     *用户向公众平台发信息并自动返回信息
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
         
    }
 
    public void init() throws ServletException {
    }
}