package DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import VO.categoryVo;
import VO.keywordVo;

public class categoryDao {

	public void insert(categoryVo catVo) {
		// TODO Auto-generated method stub
		Session session = null;
		try{
			
			
			
			SessionFactory sessionfactory=new Configuration().configure().buildSessionFactory();	
				session=sessionfactory.openSession();
				Transaction t=session.beginTransaction();
				
				System.out.println("test");
					session.save(catVo);
					
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
		// TODO Auto-generated method stub
		
		Session session = null;
		List ls=null;
		try{
			
			
			
			SessionFactory sessionfactory=new Configuration().configure().buildSessionFactory();	
				session=sessionfactory.openSession();
				Transaction t=session.beginTransaction();
				
				System.out.println("test");
				Query q=session.createQuery("from categoryVo");
					ls=q.list();
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
		
		return ls;
	}

	
	public List searchCat(categoryVo catName) {
		// TODO Auto-generated method stub
		Session session = null;
		List ls=null;
		try{
			
			
			
			SessionFactory sessionfactory=new Configuration().configure().buildSessionFactory();	
				session=sessionfactory.openSession();
				Transaction t=session.beginTransaction();
				
				System.out.println("test");
				Query q=session.createQuery("select catName where catId ='"+catName.getCatId()+"'");
					ls=q.list();
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
		
		return ls;
	}

}
