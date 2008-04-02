/*
 * $Id: DoubleConverter.java,v 1.6 2003/09/26 21:32:40 rlubke Exp $
 */

/*
 * Copyright 2003 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package javax.faces.convert;


import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;


/**
 * <p>{@link Converter} implementation for <code>java.lang.Double</code>
 * (and double primitive) values.</p>
 */

public class DoubleConverter implements Converter {


    // ------------------------------------------------------- Converter Methods
    /**
     * @throws ConverterException {@inheritDoc}
     * @throws NullPointerException {@inheritDoc}
     */ 
    public Object getAsObject(FacesContext context, UIComponent component,
                              String value) {

        if (context == null || component == null) {
            throw new NullPointerException();
        }
        
        // If the specified value is null or zero-length, return null
        if (value == null) {
            return (null);
        }
        value = value.trim();
        if (value.length() < 1) {
            return (null);
        }
        
        try {
            return (Double.valueOf(value));
        } catch (Exception e) {
            throw new ConverterException(e);
        }


    }

    /**
     * @throws ConverterException {@inheritDoc}
     * @throws NullPointerException {@inheritDoc}
     */ 
    public String getAsString(FacesContext context, UIComponent component,
                              Object value) {

        if (context == null || component == null) {
            throw new NullPointerException();
        }
        
        // If the specified value is null or zero-length, return a 
        // zero-length String
        if ((value == null) || value.equals("")) {
            return "";
        }
        
        try {
            return (Double.toString(((Double) value).doubleValue()));
        } catch (Exception e) {
            throw new ConverterException(e);
        }

    }


}
