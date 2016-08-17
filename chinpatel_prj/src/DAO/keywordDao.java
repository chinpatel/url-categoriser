package DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import VO.keywordVo;

public class keywordDao {

	public void insert(keywordVo key) {
		// TODO Auto-generated method stub
		Session session = null;
		try{
			
			
			
			SessionFactory sessionfactory=new Configuration().configure().buildSessionFactory();	
				session=sessionfactory.openSession();
				Transaction t=session.beginTransaction();
				
				System.out.println("test");
					session.save(key);
					
					t.commit();
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally
		{
			// session.flush();
			// session.close();
		}
		
		
	}

	public List showall() {
		Session session = null;
		List ls1=null;
		
		System.out.println(ls1);
		try{
			
			
			
			SessionFactory sessionfactory=new Configuration().configure().buildSessionFactory();	
				session=sessionfactory.openSession();
				Transaction t=session.beginTransaction();
				
				System.out.println("test");
				Query q2=session.createQuery("from keywordVo");
				System.out.println("hi");
					ls1=q2.list();
					System.out.println("bye");
					t.commit();
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally
		{
			// session.flush();
			// session.close();
		}
		
		return ls1;
	}


}
