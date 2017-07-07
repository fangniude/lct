package com.winnertel.em.standard.snmp.gui.formatter;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.model.OperationObject;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import org.apache.commons.collections.SequencedHashMap;
import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DefaultMibBeanIdFormatter extends MibBeanIdFormatter {
    public DefaultMibBeanIdFormatter(IApplication aApplication, String aPattern) {
        super(aApplication, aPattern);
    }


    public OperationObject format(SnmpMibBean aMibBean, SequencedHashMap aRowData) {
        String result = fPattern;
        int columnCount = aRowData.size();
        // replace field values
        for (int i = 0; i < columnCount; i++) {
            result = StringUtils.replace(result, "${f:" + aRowData.get(i) + "}", (String) aRowData.getValue(i));
        }
        // replace strings
        String sPattern = "\\$\\{s:[^\\}]*\\}";
        Matcher tMatcher = Pattern.compile(sPattern).matcher(result);
        while (true) {
            if (!tMatcher.find()) {
                break;
            }
            String key = result.substring(tMatcher.start() + 4, tMatcher.end() - 1);
            result = tMatcher.replaceFirst(fApplication.getActiveDeviceManager().getGuiComposer().getString(key));
            tMatcher.reset(result);
        }

        OperationObject oo = new OperationObject();
        oo.setName(result);

        return oo;
    }
}
