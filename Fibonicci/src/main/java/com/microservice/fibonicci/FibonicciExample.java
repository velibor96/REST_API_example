package com.microservice.fibonicci;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FibonicciExample {
	
	@GetMapping("fibonicci/{number}")
	public ArrayList<Integer> fibonicciExample(@PathVariable Integer number){
		
		ArrayList<Integer> help = new ArrayList<Integer>();
		Integer firstNumber = 0;
		Integer secondNumber = 1;
		Integer summe = 0;
		boolean isBegin = true;
		
		for(int i = 0 ; i < 99999; ++i)
		{
			if(isBegin)
			{
				if (number<0) break;
				isBegin = false;
				help.add(firstNumber);
				if(number==0) break;
				help.add(secondNumber);
				summe = firstNumber + secondNumber;
				help.add(summe);
			}else
			{
				summe = firstNumber + secondNumber;
				if (summe<=number)
				{
				help.add(summe);
				}else
				{
					break;
				}
			}
			firstNumber = secondNumber;
			secondNumber = summe;
		}
		
		return help;
	}
	
}
