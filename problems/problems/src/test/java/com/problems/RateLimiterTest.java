package com.problems;

import static org.junit.Assert.assertEquals;

import java.util.stream.Stream;

import com.problems.r.RateLimiter;
import com.problems.r.RequestObject;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
public class RateLimiterTest {
    
    private static RateLimiter rl;
    private static int counter = 1;
    @BeforeAll
    public static void init() {
        rl = new RateLimiter();
    }

    public static Stream<Arguments> data() {
        return Stream.of(
            Arguments.of(new RequestObject() {{customerID="A";maxAllowedRequest=2;maxBucketSize=5000;}},true),
            Arguments.of(new RequestObject() {{customerID="A";maxAllowedRequest=2;maxBucketSize=5000;}},true),
            Arguments.of(new RequestObject() {{customerID="A";maxAllowedRequest=2;maxBucketSize=5000;}},false),
            Arguments.of(new RequestObject() {{customerID="B";maxAllowedRequest=2;maxBucketSize=5;}},true)
        );
    }


    @ParameterizedTest
    @MethodSource("data")
    public void isRequestAllowedTest(RequestObject input, boolean expected) {
        assertEquals(input.customerID +" "+counter++, expected, rl.doRequest(input));
    }
}