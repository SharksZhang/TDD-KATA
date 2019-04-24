package day2.fizzbuzz;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FizzBuzzTest {
    @Test
    void shouldReturnNumberWhenGivenNormalNumber (){
        assertEquals(new FizzBuzz().play(1), "1");
    }

    @Test
    void shouldReturnNumberWhenGivenNormalNumber2(){
        assertEquals(new FizzBuzz().play(2), "2");
    }

    @Test
    void shouldReturnFizzWhenDivisibleBy3(){
        assertEquals(new FizzBuzz().play(3), "Fizz");
    }

    @Test
    void shouldReturnBuzzWhenDivisibleBy5(){
        assertEquals(new FizzBuzz().play(5), "Buzz");
    }

    @Test
    void shouldReturnBuzzWhenDivisibleBy5And3(){
        assertEquals(new FizzBuzz().play(15), "FizzBuzz");
    }
    @Test
    void shouldReturnFizzWhenContains3(){
        assertEquals(new FizzBuzz().play(13), "Fizz");
    }
    @Test
    void shouldReturnBuzzWhenContains5(){
        assertEquals(new FizzBuzz().play(52), "Buzz");
    }
}
