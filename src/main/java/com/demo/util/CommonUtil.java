package com.demo.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.text.MessageFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 通用信息
 * @author 
 *
 */
@SuppressWarnings("unchecked")
public class CommonUtil {

	/** JSON信息登录成功返回**/
	public final static String MSG_LOGIN_SUCESS = "登录成功";
	
	/** JSON信息登录失败返回**/
	public final static String MSG_LOGIN_FAIL = "登录失败";
	
	/** JSON信息退出成功返回**/
	public final static String MSG_LOGINOUT_SUCESS = "登录成功";
	
	/** JSON信息状态成功返回**/
	public final static Boolean MSG_STATUS_TRUE = true;
	
	/** JSON信息状态失败返回**/
	public final static Boolean MSG_STATUS_FALSE = false;

    /**错误信息存放文件名**/
    public final  static  String ERROR = "/error.properties";

    /**提示信息存放文件名**/
    public final  static  String MESSAGE = "/message.properties";

    /**支付信息**/
    public final  static  String WX = "/wx.properties";

    /**阿里云监控系统配置信息**/
    public final  static  String DRIUD = "/druid.properties";

    /** 超级管理员权限**/
    public final  static int SUPERPOWER = 99;
    /** 不需要登录验证得地址**/
    public final  static  String[] NOTVALIDURI = {"/pay/login/index",
            "/pay/login/managerLogin",
    };


    /**
      * 获取传入的文件名获取文件信息
      * @Author 谢晋
      * @Date 2016/9/13 9:22
      */
    public static Properties getProperties(String message){
        Properties properties = null;
        Resource resource = new ClassPathResource(message);

        try {
            properties = PropertiesLoaderUtils.loadProperties(resource);

        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.out.println("properties文件不存在！");
            e.printStackTrace();
        }

            return properties;
    }

    /**
     * 根据传入的编号获取微信信息
     * @Author 谢晋
     * @Date 2016/9/19 15:14
     */
    public static String  getWXMsg(String code){

        Properties properties = getProperties(WX);

        return properties.getProperty(code);
    }

    /**
     * 获取监控源信息
     * @Author 谢晋
     * @Date 2016/9/19 15:14
     */
    public static String  getDruidMsg(String code){

        Properties properties = getProperties(DRIUD);

        return properties.getProperty(code);
    }
    /**
      * 根据传入的编号获取提示信息
      * @Author 谢晋
      * @Date 2016/9/19 15:14
      */
    public static String  getTipMsg(String code){

        Properties properties = getProperties(MESSAGE);

        return properties.getProperty(code);
    }
    /**
     * 根据传入的编号和部分提示信息获取完成的信息
     * @param code
     * @param msg
     * @return
     */
    public static String  getTipMsg(String code, String msg){

        Properties properties = getProperties(MESSAGE);

        return MessageFormat.format(properties.getProperty(code), msg);
    }

    /**
     * 根据传入的编号获取错误信息
     * @param code
     * @return
     */
    public static String  getErrorMsg(String code){

        Properties properties = getProperties(ERROR);

        return properties.getProperty(code);
    }

    /**
     * 根据传入的编号和部分提示信息获取完成的错误信息
     * @param code 编号
     * @param msg 信息
     * @return
     */
    public static String  getErrorMsg(String code, String msg){

        Properties properties = getProperties(ERROR);

        return MessageFormat.format(properties.getProperty(code), msg);
    }

    /**
     * 判断地址是否属于可以不验证的地址
     * @param uri
     * @return
     */
    public  static  boolean checkURI(String uri){
        return  ArrayUtils.contains(NOTVALIDURI, uri);
    }

    /**
     * 判断是否为空
     * @param str
     * @return
     */
    public  static boolean isEmpty(String str){
        if (str == null || "".equals(str.trim()) || "null".equals(str.trim())) {
            return true;
        } else {
            return false;
        }
    }



    /**
     * 除去数组中的空值和签名参数
     * @param sArray 签名参数组
     * @return 去掉空值与签名参数后的新签名参数组
     */
    public static Map<String, String> paraFilter(Map<String, String> sArray) {

        Map<String, String> result = new HashMap<String, String>();

        if (sArray == null || sArray.size() <= 0) {
            return result;
        }

        for (String key : sArray.keySet()) {
            String value = sArray.get(key);
            if (value == null || value.equals("")) {
                continue;
            }
            result.put(key, value);
        }

        return result;
    }

    /**
     * 把数组所有元素排序，并按照“参数=参数值”的模式用“&”字符拼接成字符串
     * @param params 需要排序并参与字符拼接的参数组
     * @return 拼接后字符串
     */
    public static String createLinkString(Map<String, String> params) {

        List<String> keys = new ArrayList<String>(params.keySet());
        Collections.sort(keys);

        String prestr = "";

        for (int i = 0; i < keys.size(); i++) {
            String key = keys.get(i);
            String value = params.get(key);
            if("sign".equals(key)){
                continue;
            }
            if (i == keys.size() - 1) {//拼接时，不包括最后一个&字符
                prestr = prestr + key + "=" + value;
            } else {
                prestr = prestr + key + "=" + value + "&";
            }
        }

        return prestr;
    }
    /**
     * 把数组所有元素排序，并按照“参数=参数值”的模式用“&”字符拼接成字符串
     * 将加密字段也加入拼接
     * @param params 需要排序并参与字符拼接的参数组
     * @return 拼接后字符串
     */
    public static String createLinkStringSign(Map<String, String> params) {

        List<String> keys = new ArrayList<String>(params.keySet());
        Collections.sort(keys);

        String prestr = "";

        for (int i = 0; i < keys.size(); i++) {
            String key = keys.get(i);
            String value = params.get(key);
            if (i == keys.size() - 1) {//拼接时，不包括最后一个&字符
                prestr = prestr + key + "=" + value;
            } else {
                prestr = prestr + key + "=" + value + "&";
            }
        }

        return prestr;
    }
    /**
     * 获取地址
     * @param request
     * @param url
     * @return
     */
    public  static String getUrl(HttpServletRequest request , String url) throws UnsupportedEncodingException {

        String path = request.getContextPath();
        String basePath = request.getScheme()+"://"+request.getServerName()+path+"/";
//        return URLEncoder.encode(basePath + url, "utf-8");
        return basePath + url;
    }

    /**
     * 获取用户真实IP地址，不使用request.getRemoteAddr();的原因是有可能用户使用了代理软件方式避免真实IP地址,
     *
     * 可是，如果通过了多级反向代理的话，X-Forwarded-For的值并不止一个，而是一串IP值，究竟哪个才是真正的用户端的真实IP呢？
     * 答案是取X-Forwarded-For中第一个非unknown的有效IP字符串。
     *
     * 如：X-Forwarded-For：192.168.1.110, 192.168.1.120, 192.168.1.130,
     * 192.168.1.100
     *
     * 用户真实IP为： 192.168.1.110
     *
     * @param request
     * @return
     */
    public static String getIpAddress(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
    /**
     *
     * 产生随机字符串，不长于32位
     * @return 产生的随机字符串
     */
    public static String getNonceStr()
    {
        String chars = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random=new Random();
        StringBuffer str = new StringBuffer(32);
        for ( int i = 0; i < 32; i++ )  {
            int number=random.nextInt(32);
            str.append(chars.charAt(number));
        }
        return str.toString();
    }

    /**
     * 将Object转map
     * @param obj
     * @return
     */
    public static Map<String,String> objectToMap(Object obj)
            throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Map<String,String> map = new HashMap<String, String>();
        map =  BeanUtils.describe(obj);
        map = paraFilter(map);
        map.remove("class");
        return map;

    }

    /**
     * 输出xml字符
    **/
    public static String mapToXml(Map<String,String> map) {

        StringBuffer xmlBuffer = new StringBuffer();
        xmlBuffer.append("<xml>");
        for (Map.Entry<String, String> entry : map.entrySet()) {

            xmlBuffer.append("<"+entry.getKey()+"><![CDATA["+entry.getValue()+"]]></"+entry.getKey()+">");

        }
        xmlBuffer.append("</xml>");
        return xmlBuffer.toString();
    }
    /**
     * 根据xml消息体转化为Map
     *
     * @param xml
     * @param rootElement
     * @return
     * @throws DocumentException
     */
    public static Map xmlBodyTomap(String xml, String rootElement) throws DocumentException {
        org.dom4j.Document doc = DocumentHelper.parseText(xml);
        Element body = (Element) doc.selectSingleNode("/" + rootElement);
        Map vo = __buildXmlBody2map(body);
        return vo;
    }

    private static Map __buildXmlBody2map(Element body) {
        Map vo = new HashMap();
        if (body != null) {
            List<Element> elements = body.elements();
            for (Element element : elements) {
                String key = element.getName();
                if (StringUtils.isNotEmpty(key)) {
                    String type = element.attributeValue("type", "java.lang.String");
                    String text = element.getText().trim();
                    Object value = null;
                    if (String.class.getCanonicalName().equals(type)) {
                        value = text;
                    } else if (Character.class.getCanonicalName().equals(type)) {
                        value = new Character(text.charAt(0));
                    } else if (Boolean.class.getCanonicalName().equals(type)) {
                        value = new Boolean(text);
                    } else if (Short.class.getCanonicalName().equals(type)) {
                        value = Short.parseShort(text);
                    } else if (Integer.class.getCanonicalName().equals(type)) {
                        value = Integer.parseInt(text);
                    } else if (Long.class.getCanonicalName().equals(type)) {
                        value = Long.parseLong(text);
                    } else if (Float.class.getCanonicalName().equals(type)) {
                        value = Float.parseFloat(text);
                    } else if (Double.class.getCanonicalName().equals(type)) {
                        value = Double.parseDouble(text);
                    } else if (java.math.BigInteger.class.getCanonicalName().equals(type)) {
                        value = new java.math.BigInteger(text);
                    } else if (java.math.BigDecimal.class.getCanonicalName().equals(type)) {
                        value = new java.math.BigDecimal(text);
                    } else if (Map.class.getCanonicalName().equals(type)) {
                        value = __buildXmlBody2map(element);
                    } else {
                    }
                    vo.put(key, value);
                }
            }
        }
        return vo;
    }

  

    public static  boolean isPhoneNum(String phoneNum){
        String regExp = "^1[0-9]{10}$";

        Pattern p = Pattern.compile(regExp);

        Matcher m = p.matcher(phoneNum);

        return m.find();//boolean
    }
//    public  static void  main(String[] arg){
//	System.out.println(isPhoneNum("13601243575"));
//
//	}
}
