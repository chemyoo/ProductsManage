package com.chemyoo.qrcode.tools;

import java.io.File;
import java.io.IOException;
import java.util.Hashtable;



import com.chemyoo.org.core.MatrixToImageWriter;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;

/**
 * 生成二维码的类
 * @author Administrator
 */
public class QrTool {
 /**
  * 转成二维码的类方法
  * @param text
  */
	@SuppressWarnings("unchecked")
	public static String transToQrcode(String text,String picname,String realpath)
	{
		int width = 300;         
		int height = 300;//二维码的图片格式          
		int n=0;
		File file = new File(realpath+"/QR_CODE");
		if(!file.exists())
		{
			file.mkdir();
		}
		String filepath = file.getAbsolutePath()+"/";
		String dir=filepath+picname+".jpg";
		String format = "jpg";          
		@SuppressWarnings("rawtypes")
		Hashtable hints = new Hashtable();          //内容所使用编码         
		hints.put(EncodeHintType.CHARACTER_SET, "utf-8");          
		try {
			BitMatrix bitMatrix = new MultiFormatWriter().encode(text,                  
					BarcodeFormat.QR_CODE, width, height, hints);
		        //生成二维码         
			File outputFile = new File(dir);
		while(outputFile.exists())
		{
			dir=filepath+picname+"("+(++n)+").jpg";
			outputFile = new File(dir);
		}
		MatrixToImageWriter.writeToFile(bitMatrix, format, outputFile);  
		} catch (WriterException e1) {

			e1.printStackTrace();
		} catch (IOException e1) {

			e1.printStackTrace();
		}  
		
		System.out.println("二维码生成完成");
		
		System.out.println("生成路径："+realpath);
		if(n!=0)
			System.out.println("文件名："+picname+"("+n+").jpg");
		else
			System.out.println("文件名："+picname+".jpg");
		
		return dir;
		
		//System.out.println(text);
		
		
	
	}

}
