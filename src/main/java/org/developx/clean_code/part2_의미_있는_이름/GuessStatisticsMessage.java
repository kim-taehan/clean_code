package org.developx.clean_code.part2_의미_있는_이름;

import lombok.RequiredArgsConstructor;

import java.util.Arrays;

import static lombok.AccessLevel.*;

public class GuessStatisticsMessage {

    private String number;
    private String verb;
    private String pluralModifier;

    public String make(char candidate, int count) {
        createPluralDependentMessageParts(count);
        return String.format(
                "There %s %s %s%s",
                verb, number, candidate, pluralModifier
        );
    }

    private void createPluralDependentMessageParts(int count) {
        MessageState.fromValue(count).run();
    }

    @RequiredArgsConstructor(access = PRIVATE)
    private static enum MessageState implements Runnable {
        ZERO(0 ){
            @Override
            public void run() {
                // ...
            }
        },
        ONE(1){
            @Override
            public void run() {
                // ...
            }
        },
        ETC(Integer.MAX_VALUE){
            @Override
            public void run() {
                // ...
            }
        };
        private final int value;

        public static MessageState fromValue(int value) {
            return Arrays.stream(MessageState.values())
                    .filter(messageState -> messageState.value == value)
                    .findFirst()
                    .orElseGet(() -> ETC);
        }
    }
}
