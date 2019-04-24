package day1.fizzbuzz;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FizzBuzzTest {
    @Test
    void shouldReturnNumber(){
        assertEquals(new FizzBuzz().play(1), "1");
    }

    @Test
    void shouldReturnNumber2(){
        assertEquals(new FizzBuzz().play(2), "2");
    }

    @Test
    void shouldReturnFizzGivenDivisibleBy3(){
        assertEquals(new FizzBuzz().play(3), "Fizz");
    }

    @Test
    void shouldReturnBuzzGivenDivisibleBy5(){
        assertEquals(new FizzBuzz().play(5), "Buzz");
    }

    @Test
    void shouldReturnFizzBuzzGivenDivisibleBy3And5(){
        assertEquals(new FizzBuzz().play(15), "FizzBuzz");
    }

    @Test
    void shouldReturnFizzGivenIntContains3(){
        assertEquals(new FizzBuzz().play(13), "Fizz");
    }

    @Test
    void shoudReturnBuzzGivenIntContains5(){
        assertEquals(new FizzBuzz().play(59), "Buzz");
    }
}
