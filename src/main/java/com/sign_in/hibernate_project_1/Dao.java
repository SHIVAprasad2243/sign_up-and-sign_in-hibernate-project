package com.sign_in.hibernate_project_1;


import java.sql.ResultSet;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter.DEFAULT;

import com.mysql.cj.xdevapi.Schema.Validation;
import com.signup.hibernate_project_1.Dto_user;
import com.signup.hibernate_project_1.user_validations;

public class Dao extends Scan {
	public static String mobile(String num)
	{
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("shiva");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
		Query q=em.createQuery("select e.number from Dto_user e where e.number=?1");
		q.setParameter(1, num);
		List<String>li=q.getResultList();
		for(String r:li)
		{
		  return r;
		}
	
		
		
		et.commit();
		return null;
	}

	public static String password(String mNumber) {
		// TODO Auto-generated method stub
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("shiva");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
		Query q=em.createQuery("select e.password from Dto_user e where e.number=?1 ");
		q.setParameter(1, mNumber);
		List<String>li=q.getResultList();
		for(String r:li)
		{
		  return r;
		}
	
		
		
		et.commit();
		return null;
	}
	
	
	
	static int i=0;

	public static void forgetPass(String mNumber) {
		// TODO Auto-generated method stub

		EntityManagerFactory emf=Persistence.createEntityManagerFactory("shiva");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		System.out.println("enter the password");
		String newPass=sc.next();
		
		
		if(user_validations.validatepass(newPass))
		{
//			System.out.println(newPas);
			
			String old_password=Dao.password(mNumber);
			
			
			
			
			if(newPass.equals(old_password))
			{
				System.out.println("old password is matching \nplease enter new password");
				forgetPass(mNumber);
			}
			else {
				
				et.begin();
				Query q=em.createQuery("update Dto_user e set e.password=?1 where e.number=?2");
			     q.setParameter(1, newPass);
			     q.setParameter(2, mNumber );
				i=q.executeUpdate();
				

				et.commit();
				
			
				if(i>0)
				{
					System.out.println("password succesfully updated");
//					System.out.println("welcome to login page");
					User_signin.sigin();
					
				}
				else
				{
					System.out.println("you password not succesfully  ");
					forgetPass(mNumber);
				}
				
			}
			
					
			
		}
		else
		{
//			System.out.println("password rules r not matched");
			System.out.println("password rules r not matched");
			forgetPass(mNumber);
		}

		
	
	}
	private static String old_password() {
		// TODO Auto-generated method stub
		
		
		return null;
	}



	static int c=0;

	public static int otp(String moNumber) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("shiva");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
		Query q = em.createQuery("SELECT e.otp FROM Dto_user e WHERE e.number = :mobile");
		q.setParameter("mobile", moNumber); // Replace 'mobile' with the actual value or variable

		List<Integer> otpList = q.getResultList();
		for(Integer re: otpList)
		{
			c++;
			return re;
		}
		et.commit();
		if(c==0) {
			return 0;
		}
		return -1;
	
		
	}

	public static void readAllDats(int id) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("shiva");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		

			et.begin();
			Query q=em.createQuery("select e from Dto_user e where e.id=?1");
			q.setParameter(1, id);
			List<Dto_user>l=q.getResultList();
			for(Dto_user a:l)
			{
				System.out.println("id"+a.getId()+"\t name :"+a.getName()+"\t number :"+a.getNumber()+"\t gmail "+a.getGmail());
				
			}
			
			et.commit();
			
		}

	public static int getId(String mNumber) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				EntityManagerFactory emf=Persistence.createEntityManagerFactory("shiva");
				EntityManager em=emf.createEntityManager();
				EntityTransaction et=em.getTransaction();
				

					et.begin();
					Query q=em.createQuery("select e.id from Dto_user e where e.number=?1");
					q.setParameter(1, mNumber);
					List< Integer>li=q.getResultList();
					for(Integer r:li)
					{
						return r;
						
					}
					
		
		return 0;
	}
  
	public static void deleteUserAccount(int id) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("shiva");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		try {

			et.begin();
			Query q=em.createQuery("delete from Dto_user e where e.id=?1");
			q.setParameter(1, id);
			if(q!=null)
			{
			int i=q.executeUpdate();
			if(i!=0)
			{
				System.out.println("succesfullly remove data from table");
				
			}
			et.commit();
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			if(et!=null && et.isActive())
			{
				et.rollback();
			}
		}
		finally {
			em.close();
		}
	
	}
 static int w=0;
	public static void update_Details(int id) {
		 String last=" where a.id=";
		// TODO Auto-generated method stub
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("shiva");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();

		et.begin();
		String query=query(id);
		
		String out1=query+last+"'"+id+"'";
		
		StringBuilder sb = new StringBuilder(out1);
		//int i = out1.lastIndexOf(",");
		char ch=',';
		int i = out1.lastIndexOf(ch);
		sb.deleteCharAt(i);
//		System.out.println(sb);
	String res=""+sb;
		Query q1=em.createQuery(res);
		w+=q1.executeUpdate();
		
		et.commit();
		if(i>0)
		{
			System.out.println("update succesfully");
		}
		else
		{
			System.out.println("no records updated");
		}

		
	}
	static String s="update Dto_user a set ";
//	static String last=" where a.id=";
	static String c1="',";
	public static String query(int id1) {	
//		last+=id1;
		System.out.println("enter 1. for name 2. mobile number 3.password  4.age  5. gender 6.gmail 7.for exist //no update for enter remain number(1-7)");
		int option=sc.nextInt();
		switch(option)
		{
		case 1:
			
			   name(id1);
			
			break;
		case 2:
			mobi(id1);
			
			break;
		case 3:
			pas(id1);
			
			
			break;
		case 4:
			System.out.println("enter the age");
			int age=sc.nextInt();
			s+="a.age='"+age+c1;
			query(id1);
			break;
		case 5:
			System.out.println("enter the gender");
			String g=sc.next();
			s+="a.gender='"+g+c1;
			query(id1);
			break;
		case 6:
			
			gmail(id1);
			
			break;
		case 7:
			break;
			default:
				System.out.println("no records update");
				Home.homePage(id1);
		break;
			
		}
		
		
//		s+=last;
//		System.out.println(s);
		
		
		return s;
	}

	private static void gmail(int id1) {
		// TODO Auto-generated method stub
//		System.out.println();
		System.out.println("enter the gmail");
		String gmail=sc.next();
		if(Vali.validateGmail(gmail))
		{
			s+="a.gmail='"+gmail+c1;
			query(id1);
		}
		else
		{
			System.out.println("gmail ends with @gmail.com");
			gmail(id1);
		}
		
		
	}

	private static void mobi(int id1) {
		// TODO Auto-generated method stub
		System.out.println("enter the mobile number");
		String mobile=sc.next();
		if(user_validations.validateMobileNumber(mobile))
		{
			s+="a.number='"+mobile+c1;
			query(id1);
		}
		else
		{
			System.out.println("please enter the 10 digt number and start with 9,8,7,6 ");
		mobi(id1);
		}
		
	}

	private static void pas(int id1) {
		// TODO Auto-generated method stub
		System.out.println("enter the password");
		String password1=sc.next();
		if(user_validations.validatepass(password1))
		{
			s+="a.password='"+password1+c1;
		query(id1);
			
		}
		else {
			System.out.println("password contain atleast one uppercase, one lowercase, number,symbal and length should be more then 4 charecters");
		pas(id1);
		}
		
	}

	private static void name(int id1) {
		// TODO Auto-generated method stub
		System.out.println("enter the name");
		String name1=sc.next();
		if(Vali.valid(name1))
		{
//			System.out.println("loop entry");
			s+="a.name='"+name1+c1;
			
			query(id1);
		}
		else
		{
			System.out.println("name contain only uppercases");
			name(id1);
		}
		
		
	}

	public static int id(String mNumber) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("shiva");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
		Query q=em.createQuery("select e.id from Dto_user e where e.number=number");
		List<Integer> e=q.getResultList();
		for(Integer i:e)
		{
//			System.out.println(i);
			return i;
		}
		et.commit();
		return 0;
	}


		
		
		
	

}
