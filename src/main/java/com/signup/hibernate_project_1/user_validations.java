package com.signup.hibernate_project_1;

import java.util.regex.Pattern;

public class user_validations {
	public static void validate(int id) {
		if(String.valueOf(id).length()==5)
		{
			System.out.println("valid id");
		}
		else
		{
			System.out.println("enter the 5 digit id");
			User_detais.enter_id();
			
		}
		
	}

	public void validate(String name) {
		// TODO Auto-generated method stub
		if(name.equals(name.toUpperCase()))
		{		
			System.out.println("u entered valid format");
		}
		else
		{
			System.out.println("please enter the name uppercase format only");
		User_detais.enter_name();
		}
	}
	
	public static boolean validatepass(String password)
	{
	
			// TODO Auto-generated method stub
			if(password.length()<5)
			{
//				System.out.println("re-enter the password");
				return false;
				
			}
			if(!password.matches(".*[a-z].*"))
			{
//				System.out.println("re-enter the password");
				return false;
				
			}
			if(!password.matches(".*[A-Z].*"))
				
			{
//				System.out.println("re-enter the password");
				return false;
			}
			if(!password.matches(".*[!@#$%^&*()'',.{}?/|].*"))
	       { 
//				System.out.println("re-enter the password");
				return false;
				
	        }
			
			else
				return true;
		}

	
		// TODO Auto-generated method stub
	    


//		public static boolean validateMobileNumber(String number) {
//			// TODO Auto-generated method stub
//			
//		        return Pattern.matches(MOBILE_NUMBER_PATTERN, number);
//		    }
		
	    
		public static boolean validateMobileNumber(String number) 
		{
			String MOBILE_NUMBER_PATTERN = "^[9|8|7|6]\\d{9}$";
			
		       return Pattern.matches(MOBILE_NUMBER_PATTERN, number);
		    }

		public void validateGmail(String gmail) {
			// TODO Auto-generated method stub
			if(gmail.endsWith("@gmail.com"))
			{
				if(gmail.length()>10)
				{
					System.out.println("vaid gmail");
				}
				else
				{
					System.out.println("invalid gmail format");
				}
			}
			else
			{
				System.out.println("gmail ends with @gmail.com");
				User_detais.enter_gmail();
			}
			
		}
		
		}
	

