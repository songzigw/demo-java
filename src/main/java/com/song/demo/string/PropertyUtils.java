package com.song.demo.string;

import java.beans.PropertyDescriptor;

import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.DynaBean;
import org.apache.commons.beanutils.PropertyUtilsBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PropertyUtils {
    private static final Logger log = LoggerFactory.getLogger(PropertyUtils.class);

    public static final void copyProperties(Object dest, Object orig) {
        PropertyUtilsBean propUtil = BeanUtilsBean.getInstance()
                .getPropertyUtils();
        if (dest == null) {
            throw new IllegalArgumentException("No destination bean specified");
        }
        if (orig == null) {
            throw new IllegalArgumentException("No origin bean specified");
        }
        PropertyDescriptor[] origDescriptors = propUtil
                .getPropertyDescriptors(orig);
        for (int i = 0; i < origDescriptors.length; i++) {
            String name = origDescriptors[i].getName();
            if (propUtil.isReadable(orig, name)
                    && propUtil.isWriteable(dest, name)) {
                try {
                    Object value = propUtil.getSimpleProperty(orig, name);
                    if (dest instanceof DynaBean) {
                        ((DynaBean) dest).set(name, value);
                    } else {
                        propUtil.setSimpleProperty(dest, name, value);
                    }
                } catch (Exception e) { // Refactor here
                    if (log.isDebugEnabled()) {
                        log.debug("Error writing to '" + name + "' on class '"
                                + dest.getClass() + "'", e);
                    }
                }
            }
        }
    }

}
