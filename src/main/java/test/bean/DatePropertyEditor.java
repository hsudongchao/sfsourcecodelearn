package test.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DatePropertyEditor extends PropertyEditorSupport
{
	private static final Logger logger = LoggerFactory.getLogger(DatePropertyEditor.class);
	private String format = "yyyy-MM-dd";
	public void setFormat(String format) {
		this.format = format;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException
	{
		logger.info("text : " + text);
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		try {
		    Date d = sdf.parse(text);
		    this.setValue(d);
		}
		catch(ParseException e) {
			logger.error("error : " + e.getMessage(), e);
		}
	}
}
