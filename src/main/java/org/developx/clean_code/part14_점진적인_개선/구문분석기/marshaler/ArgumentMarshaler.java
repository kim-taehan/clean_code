package org.developx.clean_code.part14_점진적인_개선.구문분석기.marshaler;

import org.developx.clean_code.part14_점진적인_개선.구문분석기.ArgsException;

import java.util.Iterator;

public interface ArgumentMarshaler {
    void set(Iterator<String> currentArgument) throws ArgsException;
}
