package com.huaxia.plaze.util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import sun.misc.BASE64Decoder;

public class ImageGenUtil {
	
	public static boolean generate(String base64, String fileSavePath) {
		if (base64 == null) {
			return false;
		}

		BASE64Decoder decoder = new BASE64Decoder();
		OutputStream output = null;
		try {
			byte[] bytes = decoder.decodeBuffer(base64);
			for (int i = 0; i < bytes.length; ++i) {
				if (bytes[i] < 0) {
					int tmp41_39 = i;
					byte[] tmp41_37 = bytes;
					tmp41_37[tmp41_39] = (byte) (tmp41_37[tmp41_39] + 256);
				}
			}

			output = new FileOutputStream(fileSavePath);
			output.write(bytes);
			output.flush();
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			if (output != null)
				try {
					output.close();
				} catch (IOException localIOException2) {
				}
		}
	}
}