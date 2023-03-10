package tag;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Iterator;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class CustomerTag extends SimpleTagSupport {
	private int min;
	private int max;
	private int value;

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	StringWriter sw = new StringWriter();

	public void doTag() throws JspException, IOException {
		if ((Integer) min != null || (Integer) max != null) {
			/* Use message from attribute */
			JspWriter out = getJspContext().getOut();
			String rating="<img alt=\"sai \" src=\"image/rating.JPG\">";
			String nRating="<img alt=\"sai \" src=\"image/not_rating.JPG\">";
			for (int i=min;i<max;i++) {
			
				if(value>0)out.println(rating);
				else out.println(nRating);
				value--;
			}
			
		} else {
			/* use message from the body */
			getJspBody().invoke(sw);
			getJspContext().getOut().println(sw.toString());
		}
	}

}
