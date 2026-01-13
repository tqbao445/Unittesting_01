
package com.tqbao.mathutility.test.core;

import com.tqbao.mathutility.core.MathUtil;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


@RunWith(value = Parameterized.class)
/// câu lệnh này của JUNIT báo hiệu rằng sẽ cần loop qua tập data dể
///lấy cập data input/extected nhồi vào test
public class MathUtilDDTTest {
    
    //ta sẽ trả về mảng 2 ciều gồm nhiều cập Expected input
    @Parameterized.Parameters
    ///JUni sẽ ngầm chạy loop qua từng dòng
    ///của mảng để lấy ra đc cập data input/expected
    public static Object[][] intitData() {
        return new Integer[][] {
            {0,1},
            {1,1},
            {2,2},
            {3,6},
            {4,24},
            {5,720}
        };
    }
    
    ///giả sử loop qua từng dòng của mảng, ta vẫn cần gán từngf value của cột
    ///vào biến tương ứng input, expected để lát nhồi
    ///
    @Parameterized.Parameter(value = 0)
    public int input;
    @Parameterized.Parameter(value = 1)
    public long expected;
    
    @Test
    public void testGeFactorialGivenRightArgumentReturnsWell() {
        Assert.assertEquals(expected, MathUtil.getFactorial(input));
    }
}
