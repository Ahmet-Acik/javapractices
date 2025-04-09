package org.ahmet;

import org.ahmet.optional_Impl.OptionalImplement;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class OptionalImplementTest {

    @Test
    public void testOptionalOfNullableWithNull() {
        String value = null;
        String result = Optional.ofNullable(value).orElse("Default Value");
        assertEquals("Default Value", result);
    }

    @Test
    public void testOptionalOfNullableWithNonNull() {
        String value = "Hello";
        String result = Optional.ofNullable(value).orElse("Default Value");
        assertEquals("Hello", result);
    }

    @Test
    public void testOptionalOrElseGetWithMethodReference() {
        String value = null;
        String result = Optional.ofNullable(value).orElseGet(OptionalImplement::getDefaultValue);
        assertEquals("Default Value", result);
    }

    @Test
    public void testOptionalIfPresent() {
        String value = "Hello";
        Optional<String> optionalValue = Optional.ofNullable(value);
        optionalValue.ifPresent(val -> assertEquals("Hello", val));
    }

    @Test
    public void testOptionalOrElseThrow() {
        String value = null;
        assertThrows(IllegalArgumentException.class, () -> {
            Optional.ofNullable(value).orElseThrow(() -> new IllegalArgumentException("Value cannot be null"));
        });
    }

    @Test
    public void testOptionalMap() {
        String value = "hello";
        String result = Optional.ofNullable(value).map(String::toUpperCase).orElse("Default Value");
        assertEquals("HELLO", result);
    }

    @Test
    public void testOptionalFlatMap() {
        Optional<String> optionalString = Optional.of("hello");
        Optional<String> optionalUpperCase = optionalString.flatMap(val -> Optional.of(val.toUpperCase()));
        assertTrue(optionalUpperCase.isPresent());
        assertEquals("HELLO", optionalUpperCase.get());
    }

    @Test
    public void testOptionalFilter() {
        Optional<String> filteredValue = Optional.of("hello").filter(val -> val.startsWith("h"));
        assertTrue(filteredValue.isPresent());
        assertEquals("hello", filteredValue.get());
    }

    @Test
    public void testOptionalIsPresent() {
        String value = null;
        boolean isPresent = Optional.ofNullable(value).isPresent();
        assertFalse(isPresent);
    }

    @Test
    public void testOptionalOrElse() {
        String value = null;
        String defaultValue = Optional.ofNullable(value).orElse("Default Value");
        assertEquals("Default Value", defaultValue);
    }

    @Test
    public void testOptionalOrElseGetWithLambda() {
        String value = null;
        String orElseGetValue = Optional.ofNullable(value).orElseGet(() -> "Generated Default Value");
        assertEquals("Generated Default Value", orElseGetValue);
    }

    @Test
    public void testOptionalOrElseThrowWithCustomException() {
        String value = null;
        assertThrows(OptionalImplement.CustomException.class, () -> {
            Optional.ofNullable(value).orElseThrow(() -> new OptionalImplement.CustomException("Custom exception: Value cannot be null"));
        });
    }

    @Test
    public void testOptionalOf() {
        String value = "Hello";
        Optional<String> optionalValue = Optional.of(value);
        assertTrue(optionalValue.isPresent());
        assertEquals("Hello", optionalValue.get());
    }

    @Test
    public void testOptionalOfWithNull() {
        String value = null;
        assertThrows(NullPointerException.class, () -> {
            Optional.of(value);
        });
    }

    @Test
    public void testOptionalEmpty() {
        Optional<String> emptyOptional = Optional.empty();
        assertFalse(emptyOptional.isPresent());
    }

    @Test
    public void testOptionalIfPresentOrElse() {
        String value = "Hello";
        StringBuilder result = new StringBuilder();
        Optional.ofNullable(value).ifPresentOrElse(result::append, () -> result.append("Default Value"));
        assertEquals("Hello", result.toString());
    }

    @Test
    public void testOptionalIfPresentOrElseWithNull() {
        String value = null;
        StringBuilder result = new StringBuilder();
        Optional.ofNullable(value).ifPresentOrElse(result::append, () -> result.append("Default Value"));
        assertEquals("Default Value", result.toString());
    }

    @Test
    public void testOptionalStream() {
        String value = "Hello";
        Optional<String> optionalValue = Optional.ofNullable(value);
        assertEquals(1, optionalValue.stream().count());
        assertEquals("Hello", optionalValue.stream().findFirst().orElse("Default Value"));
    }

    @Test
    public void testOptionalStreamWithEmpty() {
        String value = null;
        Optional<String> optionalValue = Optional.ofNullable(value);
        assertEquals(0, optionalValue.stream().count());
        assertEquals("Default Value", optionalValue.stream().findFirst().orElse("Default Value"));
    }

    @Test
    public void testOptionalToString() {
        String value = "Hello";
        Optional<String> optionalValue = Optional.ofNullable(value);
        assertEquals("Optional[Hello]", optionalValue.toString());
    }


    @Test
    public void testOptionalToStringWithEmpty() {
        String value = null;
        Optional<String> optionalValue = Optional.ofNullable(value);
        assertEquals("Optional.empty", optionalValue.toString());
    }

    @Test
    public void testOptionalEquals() {
        String value = "Hello";
        Optional<String> optionalValue1 = Optional.ofNullable(value);
        Optional<String> optionalValue2 = Optional.ofNullable(value);
        assertTrue(optionalValue1.equals(optionalValue2));
    }

    @Test
    public void testOptionalEqualsWithDifferentValues() {
        String value1 = "Hello";
        String value2 = "World";
        Optional<String> optionalValue1 = Optional.ofNullable(value1);
        Optional<String> optionalValue2 = Optional.ofNullable(value2);
        assertFalse(optionalValue1.equals(optionalValue2));
    }


}