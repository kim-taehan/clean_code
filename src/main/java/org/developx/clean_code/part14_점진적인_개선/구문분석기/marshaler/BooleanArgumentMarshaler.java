package org.developx.clean_code.part14_점진적인_개선.구문분석기.marshaler;

import org.developx.clean_code.part14_점진적인_개선.구문분석기.ArgsException;

import java.util.Iterator;

public class BooleanArgumentMarshaler implements ArgumentMarshaler {
    private boolean booleanValue = false;

    public void set(Iterator<String> currentArgument) throws ArgsException {
        booleanValue = true;
    }

    public static boolean getValue(ArgumentMarshaler am) {
        if (am != null && am instanceof BooleanArgumentMarshaler)
            return ((BooleanArgumentMarshaler) am).booleanValue;
        else
            return false;
    }
}