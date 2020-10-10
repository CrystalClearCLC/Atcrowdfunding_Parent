import com.clc.atcrowdfunding.util.MD5Util;
import com.clc.atcrowdfunding.util.StringUtil;
import org.junit.Test;

/**
 * Copyright (C), 2017-2020
 * Author: CrystalClear
 * Date: 2020/10/4 18:40
 * FileName: MD5Test
 * Description: MD5Test
 */

public class MD5Test {
    @Test
    public void test() {
        System.out.println(MD5Util.digest("123"));
    }
}
