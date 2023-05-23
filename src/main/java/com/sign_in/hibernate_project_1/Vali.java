package com.sign_in.hibernate_project_1;

import com.signup.hibernate_project_1.User_detais;

public class Vali {
	
	
	
	
	
	
	
	public static boolean validateGmail(String gmail) {
		// TODO Auto-generated method stub
		if(gmail.endsWith("@gmail.com"))
		{
			if(gmail.length()>10)
			{
				return true;
			}
			else
			{
				System.out.println("invalid gmail format");
				return false;
			}
		}
		else
		{
			System.out.println("gmail ends with @gmail.com");
			return false;
		}
		
		
	}





	public static boolean valid(String name1) {
		// TODO Auto-generated method 
		if(name1.equals(name1.toUpperCase()))
		{		
//			System.out.println("u entered valid format");
			return true;
		}
		else
		{
			return false;
//			System.out.println("please enter the name uppercase format only");
//		ValiUser_detais.enter_name();
		}
	}

}
