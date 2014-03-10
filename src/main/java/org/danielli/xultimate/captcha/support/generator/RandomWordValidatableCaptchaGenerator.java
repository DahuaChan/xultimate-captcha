package org.danielli.xultimate.captcha.support.generator;

import org.danielli.xultimate.captcha.CaptchaException;
import org.danielli.xultimate.captcha.config.Captcha;
import org.danielli.xultimate.util.math.RandomNumberUtils;

/**
 * 提供指定长度的随机验证码提供器组件。
 *
 * @author Daniel Li
 * @since 6 December 2012
 * @param <UA> 用户回答的答案的所属类型。
 */
public class RandomWordValidatableCaptchaGenerator<UA> extends AbstractValidatableCaptchaGenerator<String, String, UA> {

	protected static final int DEFAULT_LENGTH = 4;
	
    private int length;
    private char[] srcChars;
    
    public RandomWordValidatableCaptchaGenerator() {
    	this.length = DEFAULT_LENGTH;
    	this.srcChars = new char[] { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'k', 'm', 'n', 'p', 'r', 'w', 'x', 'y', '2', '3', '4', '5', '6', '7', '8' };
    }
    
    public RandomWordValidatableCaptchaGenerator(int length, char[] srcChars) {
    	this.length = length;
    	this.srcChars = srcChars;
    }
	
	@Override
	public Captcha<String, String> createCaptcha() throws CaptchaException {
		try {
			StringBuilder capText = new StringBuilder();
	        for (int i = 0; i < length; i++) {
	        	capText.append(srcChars[RandomNumberUtils.nextInt(srcChars.length)]);
	        }
	        String value = capText.toString();
	        return createCaptcha(value, value);
		} catch (Exception e) {
			throw new CaptchaException(e.getMessage(), e);
		}
	}
}
