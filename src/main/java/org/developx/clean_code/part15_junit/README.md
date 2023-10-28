## jUnit 
> 리펙토링은 코드가 어느 수준에 이를때까지 수많은 시행착오를 반복하는 작업이다.

### jUnit ComparisonCompactor 원본
```java
public class ComparisonCompactorOrigin {
    private static final String ELLIPSIS = "...";
    private static final String DELTA_END = "]";
    private static final String DELTA_START = "[";
    private int fContextLength;
    private String fExpected;
    private String fActual;
    private int fPrefix;
    private int fSuffix;

    public ComparisonCompactorOrigin(int contextLength, String expected, String actual) {
        fContextLength = contextLength;
        fExpected = expected;
        fActual = actual;
    }

    public String compact(String message) {
        if (fExpected == null || fActual == null || areStringsEqual()) {
            return String.format("%s%s", fExpected, fActual);
        }
        findCommonPrefix();
        findCommonSuffix();
        String expected = compactString(fExpected);
        String actual = compactString(fActual);
        return String.format("%s%s", expected, actual);
    }

    private String compactString(String source) {
        String result = DELTA_START + source.substring(fPrefix, source.length() - fSuffix + 1) + DELTA_END;
        if (fPrefix > 0) {
            result = computeCommonPrefix() + result;
        }
        if (fSuffix > 0) {
            result = result + computeCommonSuffix();
        }
        return result;
    }

    private void findCommonPrefix() {
        fPrefix = 0;
        int end = Math.min(fExpected.length(), fActual.length());
        for (; fPrefix < end; fPrefix++) {
            if (fExpected.charAt(fPrefix) != fActual.charAt(fPrefix)) {
                break;
            }
        }
    }

    private void findCommonSuffix() {
        int expectedSuffix = fExpected.length() - 1;
        int actualSuffix = fActual.length() - 1;
        for (; actualSuffix >= fPrefix && expectedSuffix >= fPrefix; actualSuffix--, expectedSuffix--) {
            if (fExpected.charAt(expectedSuffix) != fActual.charAt(actualSuffix)) {
                break;
            }
        }
        fSuffix = fExpected.length() - expectedSuffix;
    }

    private String computeCommonPrefix() {
        return (fPrefix > fContextLength ? ELLIPSIS : "") + fExpected.substring(Math.max(0, fPrefix - fContextLength), fPrefix);
    }

    private String computeCommonSuffix() {
        int end = Math.min(fExpected.length() - fSuffix + 1 + fContextLength, fExpected.length());
        return fExpected.substring(fExpected.length() - fSuffix + 1, end) + (fExpected.length() - fSuffix + 1 < fExpected.length() - fContextLength ? ELLIPSIS : "");
    }

    private boolean areStringsEqual() {
        return fExpected.equals(fActual);
    }
}
```
## ComparisonCompactor 리펙토링 작업
### 멤버 변수 앞에 붙인 접두어 f를 제거한다.
```java
public class ComparisonCompactorOrigin {
    private int contextLength;
    private String expected;
    private String actual;
    private int prefix;
    private int suffix; 
}
```

### 캡슐화되지 않은 조건문 
```java
public class ComparisonCompactorOrigin {
    private boolean shuldNotCompact() {
        return expected == null || actual == null || areStringsEqual();
    }
}
```

### 이름을 구분하도록 함 (다른 의미가 있는데 동일한 이름을 붙일 필요는 없다.) 
```java
public class ComparisonCompactorOrigin {
    String compactExpected = compactString(expected);
    String compactActual = compactString(actual);
}
```

### 부정문은 긍정문보다 이해하기 힘들다 
```java
public class ComparisonCompactorOrigin {

    public String compact(String message) {
        if (canBeCompacted()) {
            findCommonPrefix();
            findCommonSuffix();
            String compactExpected = compactString(expected);
            String compactActual = compactString(actual);
            return String.format("%s%s", expected, actual);
        }
        else {
            return String.format("%s%s", fExpected, fActual);
        }
    }
}
```

### 함수 이름 변경 
```java
public class ComparisonCompactorOrigin {
    public String formatCompactedComparison(String message) {
        if (canBeCompacted()) {
            findCommonPrefix();
            findCommonSuffix();
            String compactExpected = compactString(expected);
            String compactActual = compactString(actual);
            return String.format("%s%s", expected, actual);
        }
        else {
            return String.format("%s%s", fExpected, fActual);
        }
    }
}
```

### 하는 일에 따른 함수 분리
```java
public class ComparisonCompactorOrigin {
    private String compactExpected;
    private String compactActual;
    
    public String formatCompactedComparison(String message) {
        if (canBeCompacted()) {
            compactExpectedAndActual();
            return String.format("%s%s", expected, actual);
        }
        else {
            return String.format("%s%s", fExpected, fActual);
        }
    }
    
    private void compactExpectedAndActual() {
        findCommonPrefix();
        findCommonSuffix();
        compactExpected = compactString(expected);
        compactActual = compactString(actual);
    }
}
```

### 함수 동작방식 일치시키기
```java
public class ComparisonCompactorOrigin {
    private String compactExpected;
    private String compactActual;
    private int prefix;
    private int suffix;

    private void compactExpectedAndActual() {
        prefix = findCommonPrefix();
        suffix = findCommonSuffix();
        compactExpected = compactString(expected);
        compactActual = compactString(actual);
    }

    private int findCommonPrefix(){...}
    private int findCommonSuffix(){...}
}
```

### 숨겨진 시간 결합
> 잘못된 순서로 호출하면 정상적으로 수행되지 않는다.

```java
public class ComparisonCompactorOrigin {
    private String compactExpected;
    private String compactActual;
    private int prefix;
    private int suffix;

    private void compactExpectedAndActual() {
        prefix = findCommonPrefix();
        suffix = findCommonSuffix(prefix);
        compactExpected = compactString(expected);
        compactActual = compactString(actual);
    }

    private int findCommonPrefix(){...}
    private int findCommonSuffix(int prefixIndex){...}
}
```

### 숨겨진 시간 결합2
> 잘못된 순서로 호출하면 정상적으로 수행되지 않는다.

```java
public class ComparisonCompactorOrigin {
    private String compactExpected;
    private String compactActual;
    private int prefix;
    private int suffix;

    private void compactExpectedAndActual() {
        findCommonPrefixAndSuffix();
        compactExpected = compactString(expected);
        compactActual = compactString(actual);
    }

    private int findCommonPrefixAndSuffix(){
        findCommonPrefix();

        int expectedSuffix = fExpected.length() - 1;
        int actualSuffix = fActual.length() - 1;
        for (; actualSuffix >= fPrefix && expectedSuffix >= fPrefix; actualSuffix--, expectedSuffix--) {
            if (fExpected.charAt(expectedSuffix) != fActual.charAt(actualSuffix)) {
                break;
            }
        }
        fSuffix = fExpected.length() - expectedSuffix;
    }
    private void findCommonPrefix(){...}
}
```