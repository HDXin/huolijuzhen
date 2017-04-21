package com.sudaotech.huolijuzhen.util;

import org.junit.Test;

public class RandomUtilsTest {
	
	
	@Test
	public void randomNumStrTest(){
		
		for(int i=0;i<20;i++){
			System.out.println(RandomUtils.randomNumsStr(5));
		}
		
	}

}
