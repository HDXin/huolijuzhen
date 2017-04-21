package com.sudaotech.huolijuzhen.util.formula;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class FormulaTest {

	public static void main(String[] args) {
		
         //基础数据
         Map<String, BigDecimal> values = new HashMap<String, BigDecimal>();
         values.put("dddd", BigDecimal.valueOf(20));

         //需要依赖的其他公式
         Map<String, String> formulas = new HashMap<String, String>();
         formulas.put("eeee", "#{dddd}*20");

         //需要计算的公式
         String expression = "#{eeee}*-12+13-#{dddd}+24.00";
        // String expression1 = "12+(-13)-#{dddd}+24+(7*2)/2";

         BigDecimal result = FormulaParser.parse(expression, formulas, values);
         
         System.out.println(result);
         
     }
 }