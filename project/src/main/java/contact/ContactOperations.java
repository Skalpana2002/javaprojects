package contact;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class ContactOperations {
//	public static void Entity() {
//		EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
//		EntityManager manager = factory.createEntityManager();
//		EntityTransaction transaction = manager.getTransaction();
//	}
	public static void addContact() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter name");
		String name = sc.next();
		System.out.println("Enter email");
		String email= sc.next();
		System.out.println("enter phone number");
		int phonenumber = sc.nextInt();
		
		ContactTable ct = new ContactTable();
		ct.setName(name);
		ct.setEmail(email);
		ct.setPhonenumber(phonenumber);
		
		transaction.begin();
		manager.persist(ct);
		transaction.commit();
	}
	public static void delete() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter name");
		String name = sc.next();
		
		Query q = manager.createQuery("delete ContactTable ct where ct.name=?1" );
		q.setParameter(1, name);
		
		transaction.begin();
		q.executeUpdate();
		transaction.commit();
		
	}
	public static void display_Email() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
		EntityManager manager = factory.createEntityManager();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("enter emial");
		String email = sc.next();
		Query q = manager.createQuery("select ct from ContactTable ct where email=?1");
		q.setParameter(1, email);
		List<ContactTable> contact = q.getResultList();
		
		for(ContactTable ct  :contact)
		{
			System.out.println(ct.getId()+" "+ct.getName()+" "+ct.getEmail()+" "+ct.getPhonenumber());
			System.out.println("==============");
		}
	}
	public static void display() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
		EntityManager manager = factory.createEntityManager();
		
		Query q = manager.createQuery("select ct from ContactTable ct");
		List<ContactTable> contact = q.getResultList();
		
		for(ContactTable ct  :contact)
		{
			System.out.println(ct.getId()+" "+ct.getName()+" "+ct.getEmail()+" "+ct.getPhonenumber());
			System.out.println("==============");
		}
	}
	public static void update() {
		Scanner sc = new Scanner(System.in);
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		System.out.println("enter id : ");
		int id = sc.nextInt();
		System.out.println("enter new email : ");
		String  email=sc.next();
		System.out.println("Enter new phonenumber : ");
		int phonenumber =sc.nextInt();
		System.out.println("enter new name : ");
		String name= sc.next();
		
		
		Query q = manager.createQuery("update ContactTable ct set ct.email=?1, ct.phonenumber=?2, ct.name=?3 where ct.id=?4 ");
		q.setParameter(1, email);
		q.setParameter(2, phonenumber);
		q.setParameter(3, name);
		q.setParameter(4, id);
		
		transaction.begin();
		q.executeUpdate();
		transaction.commit();
	}
	
	

}
