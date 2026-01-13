package com.tqbao.mathutility.test.core;

import com.tqbao.mathutility.core.MathUtil;
import org.junit.Assert;
import org.junit.Test;

public class MathUtilityTest {

    public MathUtilityTest() {
        //đây là class sẽ sd các hàm của thư viện JUnit
        //dể kiểm thử/Kiểm tra code chính - hàm tính giai thừa() bên 
        //class core.MathUtility

    }

    //có quy tắt đặt tên hàm kiểm thử
    //nhưng thường sẽ là nói lên mục đích của các case/tình huống kiểm thửu
    //nhưng thường sẽ là nói lên mục đích của các case/tihf huống kiểm thử
    //tình huống nào xài hàm theo kiểm thành công và thất bại
    //hàm dưới đây là tính huống test thành công, trả về ngon
    //ta sẽ xài hàm kiểu well - đưa 5! 6!, ko chơi -5!, 30!
    //@Test JUnit phối hợp vs JVM để chạy hàm này
    //      Phía hậu trường chính là public static void main()
    //      Có nhiều @Test ứng vs nhiều case khác nhau để kiểm thử các hàm tính gia thừa
    @Test
    public void testGeFactorialGivenRightArgumentReturnsWell() {
        int n = 0; //test thử tình huốn tử tế đầu vào, m phải chạy đúng
        //long expected = 1; // hi vọng 0! = 1
        //long actual = ;    //gọi hàm cần test bên core
        long actual = MathUtil.getFactorial(n);

        //so sanh vs expected
        Assert.assertEquals(1, actual); //hàm giúp ss 2 giá trị có giống nhau ko
        //nếu giống trả ra màu xanh ít nhất cho case đg test
        //nếu ko trả ra màu đỏ nếu ex và act ko giống

        Assert.assertEquals(2, MathUtil.getFactorial(2));
        Assert.assertEquals(6, MathUtil.getFactorial(3));
        Assert.assertEquals(24, MathUtil.getFactorial(4));
        Assert.assertEquals(120, MathUtil.getFactorial(5));
    }

    //hàm getF() ta thiết kế có 2 tình huống
    //1. đưa data từ 0...20 phải trả kq đúng -> done
    //2. đưa data vào cà chớn, âm or > 20, thiết kế của ta phải ném ra
    //ngoại lệ
    //TAO KÌ VỌNG NGOẠI LỆ XUẤT HIỆN TRONG TÌNH HUỐN < 0 VÀ > 20
    //rất mong ngoại lệ xuất hiện
    //nếu hàm nhận vào n < 0 và n > 20 thì hàm chạy đúng như thiết kế -> Màu xanh xuất hiện
    //nếuh hàm nhận vào n < 0 và n > 20 mà ko ném ra ngoại lệ
    // -> hàm Sai ném màu đỏ
    //test case: 
    //input: -5
    //exception; ...
    //Tình huốn ngoài dự liệu/excetion là tình huốn ko thể so sánh
    //mà chỉ có thể kiểm chứng = cách nó có xuất hiện hay ko
    //assertEquals() ko dùng cho tình huốn này
    //màu đỏ vì mén ngoại lệ ko trùng vs ngoại lệ cần kiểm chứng
//    @Test(expected = NumberFormatException.class)
//    public void testFactorialGivenWrongArgumentThrowsException() {
//        MathUtil.getFactorial(-5); // hàm @Test chạy, hay getF() chạy
//                                  //phải mé ra ngoại lệ
//    }
    @Test(expected = IllegalArgumentException.class)
    public void testFactorialGivenWrongArgumentThrowsException() {
        MathUtil.getFactorial(-5); // hàm @Test chạy, hay getF() chạy
        //phải mé ra ngoại lệ
    }

    //cách khác để bắt ngoại lệ, viêt tự nhiên hơn
    //lamda expression
    @Test
    public void testFactorialGivenWrongArgumentThrowsException_LambdaVersion() {
        //MathUtil.getFactorial(-5); // hàm @Test chạy, hay getF() chạy
        //phải mé ra ngoại lệ

        Assert.assertThrows(IllegalArgumentException.class, () -> {
            MathUtil.getFactorial(-9);
        });
    }

    @Test
    public void testFactorialGivenWrongArgumentThrowsException_TryCatch() {
        //MathUtil.getFactorial(-5); // hàm @Test chạy, hay getF() chạy
        //phải mé ra ngoại lệ

        try {
            MathUtil.getFactorial(-5);
        } catch (Exception e) {
            //bắt try-catch là JUnit sẽ ra xanh do đã chủ động kiểm soát ngoại lệ
            //nhưng ko chắc ngoại lệ mình cần có xuất hiện hay ko???
            //có đoạn code kiểm ở đây đúng ngoại lệ IllegalArgumentException xh
            Assert.assertEquals("Invalid argument. n must be bewteen 0 to 20", e.getMessage());
        }
    }

    //Kĩ thuật DDT - THAM SỐ HÓA Khi chơi vs unit test
    //ĐT viết tắt của DATA-DRIVEN TESTINg - kĩ thuật kiểm thử hướng thoe tập
    //tập data chuẩn bị là kĩ thuật tchs lời gọi hàm cần test ra 1 chỗ
    //                              data đầu vào và expexted ra 1 chỗ khác
    //                              nhồi/nạp/feed đám data này vào lời gọi hàm
    //              giúp
    //                      nhìn code test dễ dàng, trong sáng, tách biệt, việt cb data ra 1 chỗ
    //                          -> ta dễ tập trong trg việc build bộ data test
    //                      vì việc kiểm thừ đồi hỏi tính chắc chẻ nên code phải đẹp
    //                      chuẩn để dễ bảo trì JUNIT code.
    //
    /*
    Trong giới công nghiệp/các cty p/m, tập data test để ở:
    trong file Excel theo hàng cột
    trong text file (dùng tab để phân cách giá trị) dạng CSV
    nhúng trực tiếp trong code, nhưng tách so với code JUnit Test
    để trong table của database chứa toàn data để test, ko phải là database của app
     */
}
