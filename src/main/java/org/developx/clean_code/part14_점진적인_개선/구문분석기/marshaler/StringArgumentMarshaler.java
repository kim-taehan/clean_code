package org.developx.clean_code.part14_점진적인_개선.구문분석기.marshaler;

import org.developx.clean_code.part14_점진적인_개선.구문분석기.ArgsException;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.developx.clean_code.part14_점진적인_개선.구문분석기.ArgsException.ErrorCode.MISSING_STRING;

public class StringArgumentMarshaler implements ArgumentMarshaler {

    private String stringValue = "";

    @Override
    public void set(Iterator<String> currentArgument) throws ArgsException {
        try {
            stringValue = currentArgument.next();
        } catch (NoSuchElementException e) {
            throw new ArgsException(MISSING_STRING);
        }
    }

    public static String getValue(ArgumentMarshaler am) {
        if (am != null && am instanceof StringArgumentMarshaler)
            return ((StringArgumentMarshaler) am).stringValue;
        else
            return "";
    }
}
