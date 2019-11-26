package test.convert;

import org.junit.Test;
import org.springframework.core.convert.support.DefaultConversionService;

import java.util.Date;

public class ConvertTest
{
	@Test
	public void test_string2DateConvert() {
		DefaultConversionService conversionService = new DefaultConversionService();
		conversionService.addConverter(new String2DateConverter());
		String source = "2019-11-26 19:41:22";
		Date date = conversionService.convert(source, Date.class);
		System.out.println(date);
	}
}
