package com.synphoo.java.test.ascii;

public class MD5Test {  
  
    /** 
     * @param args 
     */  
    public static void main(String[] args) {  
          
         //加密 
        //System.out.println(encrypt("frontdev"));//加密后:129%141%138%137%143%127%128%145%  
        //解密：129%141%138%137%143%127%128%145%
        System.out.println(decrypt("129%141%138%137%143%127%128%145%"));//解密后: frontdev
    }  
      
    /** 
       *用户名解密 
       *@param ssoToken 字符串 
       *@return String 返回加密字符串 
      */  
      public static String decrypt(String ssoToken)  
      {  
        try  
        {  
          String name = new String();  
          java.util.StringTokenizer st=new java.util.StringTokenizer(ssoToken,"%");  
          while (st.hasMoreElements()) {  
            int asc =  Integer.parseInt((String)st.nextElement()) - 27;  
            name = name + (char)asc;//ascii转字符  
          }  
  
          return name;  
        }catch(Exception e)  
        {  
          e.printStackTrace() ;  
          return null;  
        }  
      }  
  
      /** 
       *用户名加密 
       *@param ssoToken 字符串 
       *@return String 返回加密字符串 
      */  
      public static String encrypt(String ssoToken)  
      {  
        try  
        {  
          byte[] _ssoToken = ssoToken.getBytes("ISO-8859-1");  //[102, 114, 111, 110, 116, 100, 101, 118]
          String name = new String();  
         // char[] _ssoToken = ssoToken.toCharArray();  
          for (int i = 0; i < _ssoToken.length; i++) {  
              int asc = _ssoToken[i];  
              _ssoToken[i] = (byte) (asc + 27);  
              name = name + (asc + 27) + "%";  //逐个字符加密
          }  
          return name;  //加密后: 129%141%138%137%143%127%128%145%
        }catch(Exception e)  
        {  
          e.printStackTrace() ;  
          return null;  
        }  
      }  
}
