package xyz.cymedical.tools.jun;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.jbarcode.JBarcode;
import org.jbarcode.encode.EAN13Encoder;
import org.jbarcode.paint.EAN13TextPainter;
import org.jbarcode.paint.WidthCodedPainter;
import org.jbarcode.util.ImageUtil;

/**
*	@author Junisyoan;
*	日期：2019年1月31日
*	时间：下午2:20:50
*	类说明：生成条形码
*/
public class BarCodeTools {

	private static Random numGen = new Random();
	private static char[] numbers = ("0123456789").toCharArray();
	
	/**
	 * 生成随机码
	 * @param length	条形码长度
	 * @return	条形码
	 */
	public static final String randomNumStr(int length) {
		if (length < 1) {
			return null;
		}
		char[] randBuffer = new char[length];
		for (int i = 0; i < randBuffer.length; i++) {
			randBuffer[i] = numbers[numGen.nextInt(9)];
		}
		return new String(randBuffer);
	}

	/**
	 * 生成条形码图片
	 * @param savePath	保存的地址
	 * @param jbarCode	条形码
	 * @param imgFormat	图片格式
	 * @return	存储条形码的完整路径加图片名字
	 */
	public static final String createBarCode(String savePath, String jbarCode, String imgFormat) {
		try {
			BufferedImage bi = null;
			int len = jbarCode.length();
			// 实例化JBarcode
			// 这里三个参数，必要填写
			JBarcode jbarcode13 = new JBarcode(
					EAN13Encoder.getInstance(), 
					WidthCodedPainter.getInstance(),
					EAN13TextPainter.getInstance());
			// 获取到前12位
			String barCode = jbarCode.substring(0, len - 1);
			// 获取到校验位
//			String code = jbarCode.substring(len - 1, len);
//			String checkCode = jbarcode13.calcCheckSum(barCode);
//			if (!code.equals(checkCode)) {
//				return "EN-13 条形码最后一位校验码 不对，应该是： " + checkCode;
//			}
			
			/*
			 * 最重要的是这里的设置，如果明白了这里的设置就没有问题 如果是默认设置， 那么设置就是生成一般的条形码 如果不是默认 设置，那么就可以根据自己需要设置
			 */
			// 尺寸，面积，大小
			jbarcode13.setXDimension(Double.valueOf(0.8).doubleValue());
			// 条形码高度
			jbarcode13.setBarHeight(Double.valueOf(30).doubleValue());
			// 宽度率
			jbarcode13.setWideRatio(Double.valueOf(20).doubleValue());
			// 是否校验最后一位，默认是false
			jbarcode13.setShowCheckDigit(true);
			// 生成二维码
			bi = jbarcode13.createBarcode(barCode);
			// 定义图片名称
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
			String imgName = sdf.format(new Date()) + "_" + jbarCode;
			// 保存二维码图片
			FileOutputStream fileOutputStream = null;
			String imgPath = savePath + imgName + "." + imgFormat;
			try {
				try {
					savePath = URLDecoder.decode(savePath, "UTF-8");
				} catch (UnsupportedEncodingException uee) {
					uee.printStackTrace();
					savePath = "C://barcode//images//";
				}
				File dirFile = new File(savePath);

				if (!dirFile.exists()) {
					dirFile.mkdirs();
				}
				fileOutputStream = new FileOutputStream(imgPath);
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
			ImageUtil.encodeAndWrite(bi, imgFormat, fileOutputStream, 96, 96);
			fileOutputStream.close();
			// 返回路径
			return imgPath;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
