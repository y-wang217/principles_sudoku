package debug.unit_tests;

import game.logic.NumbersGeneratorV2;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;

public class UnitTest1 {
    @Test
    void testRowSum() {
        int sum = 0;
        int[][] board = new int[9][9];
        NumbersGeneratorV2 test = new NumbersGeneratorV2();
        board = test.getBoard();
        for (int i = 0; i < board[0].length; i++) {
            sum = 0;
            for (int j = 0; j < board[1].length; j++) {
                sum += board[i][j];
            }
            assertFalse(sum != 45);
        }
    }
    
    @Test
    void testColumnSum() {
        int sum = 0;
        int[][] board = new int[9][9];
        NumbersGeneratorV2 test = new NumbersGeneratorV2();
        board = test.getBoard();
        for (int i = 0; i < board[1].length; i++) {
            sum = 0;
            for (int j = 0; j < board[0].length; j++) {
                sum += board[j][i];
            }
            assertFalse(sum != 45);
        }
    }
    
    @Test
    void testIsNegative() {
        int[][] board = new int[9][9];
        NumbersGeneratorV2 test = new NumbersGeneratorV2();
        board = test.getBoard();
        for (int i = 0; i < board[0].length; i++) {
            for (int j = 0; j < board[1].length; j++) {
                assertFalse(board[j][i] < 1);
            }
        }
    }
}
