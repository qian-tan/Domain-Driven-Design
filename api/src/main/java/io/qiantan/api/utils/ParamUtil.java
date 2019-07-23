package io.qiantan.api.utils;

import io.qiantan.utils.StringUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

/**
 * @author: yujiacheng
 * @date: 2019/6/2312:32 AM
 */
public abstract class ParamUtil {

    public ParamUtil() {
    }

    public static void isBlank(String string, String msg) {
        if (StringUtil.isNotBlank(string)) {
            throw new IllegalArgumentException(msg);
        }
    }

    public static void notBlank(String string, String msg) {
        if (StringUtil.isBlank(string)) {
            throw new IllegalArgumentException(msg);
        }
    }

    public static void notEmpty(Collection collection, String msg) {
        if (null == collection || collection.isEmpty()) {
            throw new IllegalArgumentException(msg);
        }
    }

    public static void nonBlankElements(Collection<String> collection, String elementMsg) {
        Iterator var2 = collection.iterator();

        while(var2.hasNext()) {
            String str = (String)var2.next();
            notBlank(str, elementMsg);
        }

    }

    public static void nonNull(Object object, String msg) {
        if (null == object) {
            throw new IllegalArgumentException(msg);
        }
    }

    public static void isNull(Object object, String msg) {
        if (null != object) {
            throw new IllegalArgumentException(msg);
        }
    }

    public static void expectTrue(boolean boolExpression, String falseMsg) {
        if (!boolExpression) {
            throw new IllegalArgumentException(falseMsg);
        }
    }

    public static void expectFalse(boolean boolExpression, String trueMsg) {
        if (boolExpression) {
            throw new IllegalArgumentException(trueMsg);
        }
    }

    public static void expectAnyFalse(String msg, Boolean... booleans) throws IllegalArgumentException {
        if (Arrays.stream(booleans).allMatch((t) -> {
            return t;
        })) {
            throw new IllegalArgumentException(msg);
        }
    }

    public static void expectInRange(Collection collection, int minElements, int maxElements, String outRangeMsg) {
        int elements = collection.size();
        if (elements < minElements || elements > maxElements) {
            throw new IllegalArgumentException(outRangeMsg);
        }
    }

    public static void expectInRange(String string, int minLength, int maxLength, String msg) {
        if (StringUtil.isBlank(string) || string.length() < minLength || string.length() > maxLength) {
            throw new IllegalArgumentException(msg);
        }
    }

    public static void expectDateStrWithPattern(String sDate, String pattern, String msg) {
        Date outDate = null;
        if (StringUtil.isBlank(sDate)) {
            throw new IllegalArgumentException(msg);
        } else if (!StringUtil.isBlank(pattern)) {
            SimpleDateFormat df = new SimpleDateFormat(pattern);

            try {
                df.parse(sDate);
            } catch (ParseException var6) {
                throw new IllegalArgumentException(msg);
            }
        }
    }
}