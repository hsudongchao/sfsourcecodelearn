package test.convert;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class String2DateConverter implements Converter<String, Date>
{
	private static final Logger logger = LoggerFactory.getLogger(String2DateConverter.class);
	@Override
	public Date convert(String source)
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
		    return sdf.parse(source);
		}
		catch(Exception e) {
			logger.error("error : " + e.getMessage(), e);
			return null;
		}
	}
}
