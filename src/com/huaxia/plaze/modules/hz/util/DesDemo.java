/**
 * 
 */
package com.huaxia.plaze.modules.hz.util;

import java.io.IOException;
import java.net.URLEncoder;
import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

/**
 * @author xiongjy
 * 
 */
public class DesDemo {

	 /**
     * 密钥算法
     * */
    private final static String DES_ALGORITHM = "DES/CBC/PKCS5Padding";
    public static final String KEY_ALGORITHM = "DES";
    private final static String DEFAULT_CHARSET_NAME = "GBK";
    private static final byte[] DES_IV = initIv();
    
    /**
     * 初始向量的方法, 全部为0。针对DES算法,IV值一定是64位的(8字节).
     */
    private static byte[] initIv() {
        int blockSize = 8;
        byte[] iv = new byte[blockSize];
        for (int i = 0; i < blockSize; ++i) {
            iv[i] = 0;
        }
        return iv;
    }
    
	 /**
     * Description 根据键值进行解密
     * @param data
     * @param key
     * @return
     * @throws IOException
     * @throws Exception
     */
    public static String decrypt(String data, String key) throws Exception {
        if (data == null)
            return null;
        //解密对象从16进制装换成byte
        byte[] buf = decodeHex(data.toCharArray());
        byte[] result = decrypt(buf, key.getBytes(DEFAULT_CHARSET_NAME));
        return new String(result, DEFAULT_CHARSET_NAME);
    }
    
    /**
     * Description 根据键值进行解密
     *
     * @param data
     * @param key
     *            加密键byte数组
     * @return
     * @throws Exception
     */
    private static byte[] decrypt(byte[] data, byte[] key) throws Exception {
        // 从原始密钥数据创建DESKeySpec对象
        Key securekey = generateKey(key);
        //参数
        IvParameterSpec iv = new IvParameterSpec(DES_IV);
        // Cipher对象实际完成解密操作
        Cipher cipher = Cipher.getInstance(DES_ALGORITHM);
        // 用密钥初始化Cipher对象
        cipher.init(Cipher.DECRYPT_MODE, securekey, iv);

        return cipher.doFinal(data);
    }
    
    /**
     * 转换密钥
     *
     * @param key
     *    二进制密钥
     * @return Key 密钥
     * */
    private static Key generateKey(byte[] key) throws Exception {
        // 实例化Des密钥
        DESKeySpec dks = new DESKeySpec(key);
        // 实例化密钥工厂
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(KEY_ALGORITHM);
        // 生成密钥
        SecretKey secretKey = keyFactory.generateSecret(dks);
        return secretKey;
    }

    public static byte[] decodeHex(char[] data) throws Exception {

        int len = data.length;

        if ((len & 0x01) != 0) {
            throw new Exception("Odd number of characters.");
        }

        byte[] out = new byte[len >> 1];

        // two characters form the hex value.
        for (int i = 0, j = 0; j < len; i++) {
            int f = toDigit(data[j], j) << 4;
            j++;
            f = f | toDigit(data[j], j);
            j++;
            out[i] = (byte) (f & 0xFF);
        }

        return out;
    }
    
    public static int toDigit(char ch, int index) throws Exception {
        int digit = Character.digit(ch, 16);
        if (digit == -1) {
            throw new Exception("Illegal hexadecimal character " + ch + " at index " + index);
        }
        return digit;
    }

    
	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {

		String  encrypt = "";
		System.out.println("decrypt:" + decrypt(encrypt, "Hmzx6566Db"));
		
	}

}
