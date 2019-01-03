package com.devi.tool.netease;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class QrCodeTest {


    public static void main(String[] args) throws Exception {

        String content = "http://www.baidu.com";
        String path = "d://";

        MultiFormatWriter multiFormatWriter = new MultiFormatWriter();//Zxing是Google提供的关于条码

        Map hints = new HashMap();
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        BitMatrix bitMatrix = multiFormatWriter.encode(content, BarcodeFormat.QR_CODE, 400, 400, hints);//这里是照片的大小
        File file1 = new File(path, "my.jpg");
        MatrixToImageWriter.writeToFile(bitMatrix, "jpg", file1);
        System.out.println("运行完成");


        MultiFormatReader formatReader = new MultiFormatReader();
        File file = new File("D:/my.jpg");
        BufferedImage image = null;
        try {
            image = ImageIO.read(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(image)));
        Hashtable hints2 = new Hashtable();
        hints2.put(EncodeHintType.CHARACTER_SET, "utf-8");
        Result result = formatReader.decode(binaryBitmap, hints2);
        System.err.println("解析结果：" + result.toString());
        System.out.println(result.getBarcodeFormat());
        System.out.println(result.getText());


    }

}
