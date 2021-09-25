package com.springbootsimplecaptcha.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;

import javax.imageio.ImageIO;

import cn.apiclub.captcha.Captcha;
import cn.apiclub.captcha.backgrounds.GradiatedBackgroundProducer;
import cn.apiclub.captcha.noise.CurvedLineNoiseProducer;
import cn.apiclub.captcha.text.producer.DefaultTextProducer;

public class CaptchaUtil {

	// 1. Create Captcha Object
	public static Captcha createCaptcha(int width, int height) {

		return new Captcha.Builder(width, height).addBackground(new GradiatedBackgroundProducer())
				.addText(new DefaultTextProducer())
				.addNoise(new CurvedLineNoiseProducer()).build();
	}

	// 2. convert to binary String
	public static String encodeBase64(Captcha captcha) {

		String imageData = null;

		ByteArrayOutputStream os = new ByteArrayOutputStream();
		try {
			ImageIO.write(captcha.getImage(), "png", os);
			byte[] arr = Base64.getEncoder().encode(os.toByteArray());
			imageData = new String(arr);

		} catch (IOException e) {
			e.printStackTrace();
		}
		return imageData;

	}

}
