package DivideAndConquer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class leetcode241_DifferentWaysToAddParenthese {
	
	private HashMap<String, List<Integer>> hm = new HashMap<String, List<Integer>>();

	public List<Integer> diffWaysToCompute(String input) {
		if (hm.containsKey(input))
			return hm.get(input);
		List<Integer> res = new ArrayList<Integer>() ;
		for(int i =0 ; i < input.length(); i++){
			char ch = input.charAt(i);
			if (ch == '+' || ch == '-' || ch == '*') {
				//采用分治法，以此运算符为界，分别计算该符号左边和右边的数
//				List<Integer> left = diffWaysToCompute(input.substring(0, i));
//				List<Integer> right = diffWaysToCompute(input.substring(i+1, input.length()));
				//diffWaysToCompute(input.substring(0, i))用来保存以i位置的运算符为界，左边的所有计算可能结果
				//diffWaysToCompute(input.substring(i+1, input.length()))用来保存以i位置的运算符为界，右边式子的所有计算可能结果
				for (Integer l : diffWaysToCompute(input.substring(0, i))){
					for( Integer r : diffWaysToCompute(input.substring(i+1, input.length()))){
						if (ch =='+'){
							res.add(l+r);
						}else if(ch == '-'){
							res.add(l-r);
						}else {
							res.add(l*r);
						}
					}
				}
				
			}
		}
		if (res.size()==0)
            res.add(Integer.valueOf(input));
		hm.put(input, res);
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Integer a = new Integer(1);
//		Integer b = new Integer(8);
//		List<Integer> c = new ArrayList<Integer>();
//		c.add(a);
//		c.add(b);
//		for (Integer i : c){
//			System.out.println(i);
//		}
//		System.out.println(a+b);
	}

}
