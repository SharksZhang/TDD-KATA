package day3.fizzbuzz;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FizzBuzzTest {

    @Test
    void shouldReturnNormalNumGivenNormalNum() {
        assertEquals(new FizzBuzz().play(1), "1");
    }
    @Test
    void shouldReturnNormalNumGivenNormalNum2() {
        assertEquals(new FizzBuzz().play(2), "2");
    }

    @Test
    void shouldReturnFizzGivenDivisibleBy3() {
        assertEquals(new FizzBuzz().play(3), "Fizz" );
    }

    @Test
    void shouldReturnFizzGivenDivisibleBy5() {
        assertEquals(new FizzBuzz().play(5), "Buzz");
    }

    @Test
    void shouldReturnFizzGivenDivisibleBy5And3() {
        assertEquals(new FizzBuzz().play(15), "FizzBuzz");
    }

    @Test
    void shouldReturnFizzGivenContains3() {
        assertEquals(new FizzBuzz().play(13), "Fizz");
    }
    @Test
    void shouldReturnFizzGivenContains5() {
        assertEquals(new FizzBuzz().play(52), "Buzz");
    }

    @Test
    void shouldReturnFizzGivenContains5And3() {
        assertEquals(new FizzBuzz().play(53), "FizzBuzz");
    }






}
