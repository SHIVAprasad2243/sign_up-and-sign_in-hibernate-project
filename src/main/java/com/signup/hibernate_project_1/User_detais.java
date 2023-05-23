package com.signup.hibernate_project_1;
import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

 class Scan{
	static Scanner sc=new Scanner(System.in);
	static user_validations u=new user_validations();
	static Dto_user ref=new Dto_user();
	
	
}






public class User_detais extends Scan {
	

	public static void userDetails() {
		// TODO Auto-generated method stub
		enter_id();
		enter_name();
		enter_password();
		enter_number();
		enter_gmail();
			
		System.out.println("enter the age");
		int age=sc.nextInt();
		ref.setAge(age);
		
		System.out.println(" enter the gender");
		String gender=sc.next();
		ref.setGender(gender);
		
		
		
		System.out.println("enter the otp");
		int otp=sc.nextInt();
		ref.setOtp(otp);
		
//		Dto_user s=new Dto_user();
//		Dao.user_detais(s);
		
		
		
		
		
//		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("shiva");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
//		Dto_user s=new Dto_user();
//		User_detais.userDetails();
		et.begin();
	    em.persist(ref);
	    
		et.commit();
		
		
		
		
	}

	public static void enter_gmail() {
		// TODO Auto-generated method stub
		System.out.println("enter the gmail");
		String gmail=sc.next();
		u.validateGmail(gmail);
		ref.setGmail(gmail);
		
	}

	public static void enter_number() {
		// TODO Auto-generated method stub
		System.out.println("enter number");
		String number=sc.next();
		try {
			if(u.validateMobileNumber(number)) {
				System.out.println("valid mobile number pattern");
				ref.setNumber(number);
			}
			else {
				System.out.println("please enter the 10 digt number and start with 9,8,7,6 ");
				enter_number();
			}
		
		}
		catch(Exception e){
			e.printStackTrace();
			enter_number();
		}
		
	
		
	}

	public static void enter_password() {
		// TODO Auto-generated method stub

		System.out.println("enter password");
		String password=sc.next();
		if(u.validatepass(password)) {
			System.out.println("valid password pattern");
			ref.setPassword(password);
		}
		else
		{
			System.out.println("password contain atleast one uppercase, one lowercase, number,symbal and length should be more then 4 charecters ");
		enter_password();
		}
		
			
	}

	public static void enter_name() {
		// TODO Auto-generated method stub
		System.out.println("enter name");
		String name=sc.next();
		u.validate(name);
		ref.setName(name);
	}

	public static void enter_id() {
		// TODO Auto-generated method stub
		System.out.println("enter id");
		int id=sc.nextInt();
		u.validate(id);
		ref.setId(id);
		
		
	}

}
