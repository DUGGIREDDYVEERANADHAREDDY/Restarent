package Main.com;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.mapping.List;

import com.main.Contractempoyee;
import com.main.Employee;
import com.main.Perminentemployee;

public class Main {
	public SessionFactory set;
	public Session ses;
	public Transaction tax;
	   
	
	public Main()
	{
		set=new Configuration().configure("Inhrtiance.cfg.xml").buildSessionFactory();
	}
	public void insert()
	{
		ses=set.openSession();
		tax=ses.beginTransaction();
		Employee em =new Employee();
		em.setEmpid(1);
		em.setEmpname("veera");
		ses.save(em);
		tax.commit();
		System.out.println("data inserted");
	}
	public  void  conemp()
	{
		ses=set.openSession();
		tax=ses.beginTransaction();
		Contractempoyee em = new Contractempoyee();
		em.setCount(120);
		em.setDuration(1200);
		ses.save(em);
		tax.commit();
		System.out.println("data is inserted");
	}
	public void perminet()
	{
		ses =set.openSession();
		tax=ses.beginTransaction();
		Perminentemployee pe = new Perminentemployee();
		pe.setEmpname("kalavathi");
		pe.setEmpid(2);
		pe.setBonou(20);
		pe.setSalary(200);
		ses.save(pe);
		tax.commit();
		System.out.println("data is inseted");
	}
	public void retive()
	{
		ses=set.openSession();
		tax=ses.beginTransaction();
		Query q =ses.createQuery("from Perminentemployee p where p.empid=:eid");
		q.setParameter("eid", 1);
		java.util.List<Perminentemployee> pe =q.list();
		for(Perminentemployee p :pe)
		{
			System.out.println("the employee name is "+p.getEmpname());
			System.out.println("the employee id is"+p.getEmpid());
			System.out.println("the bonous"+p.getSalary());
			ses.save(p);
			tax.commit();
		}
		
	}
	
	public static void main(String[] args) {
		Main m= new Main();
		m.insert();
		m.conemp();
		m.perminet();
		//m.retive();
		
	}

}
