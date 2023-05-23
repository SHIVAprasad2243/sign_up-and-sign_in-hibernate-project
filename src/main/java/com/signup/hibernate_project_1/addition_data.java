package com.signup.hibernate_project_1;
import java.util.InputMismatchException;

import com.signup.hibernate_project_1.Scan;
import com.sign_in.hibernate_project_1.*;

public class addition_data extends Scan {

	public static void option() {
		// TODO Auto-generated method stub
      
		System.out.println("1.for sinup   2.login");
		
		
			
			int op=sc.nextInt();
		switch (op) {
		case 1:
			System.out.println("welcome to sinup page");
			
			User_detais.userDetails();
			System.out.println("suceesfully registered");
		
			User_signin.sigin();
			
			
			break;
		case 2:
		
			User_signin in=new User_signin();
			in.sigin();
			break;
		default:
			System.out.println("select valid option i.e 1  or 2");
			option();
		    	break;
		 }
	}
		

}
