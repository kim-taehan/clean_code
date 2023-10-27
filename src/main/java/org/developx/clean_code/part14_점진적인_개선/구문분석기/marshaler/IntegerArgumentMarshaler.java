package org.developx.clean_code.part14_점진적인_개선.구문분석기.marshaler;

import org.developx.clean_code.part14_점진적인_개선.구문분석기.ArgsException;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.developx.clean_code.part14_점진적인_개선.구문분석기.ArgsException.ErrorCode.INVALID_INTEGER;
import static org.developx.clean_code.part14_점진적인_개선.구문분석기.ArgsException.ErrorCode.MISSING_INTEGER;

public class IntegerArgumentMarshaler implements ArgumentMarshaler {

    private int intValue = 0;

    public void set(Iterator<String> currentArgument) throws ArgsException {

        String parameter = null;
        try {
            parameter = currentArgument.next();
            intValue = Integer.parseInt(parameter);
        } catch (NoSuchElementException e) {
            throw new ArgsException(MISSING_INTEGER);
        } catch (NumberFormatException e) {
            throw new ArgsException(INVALID_INTEGER, parameter);
        }
    }

    public static int getValue(ArgumentMarshaler am) {
        if (am != null && am instanceof IntegerArgumentMarshaler)
            return ((IntegerArgumentMarshaler) am).intValue;
        else
            return 0;
    }
}