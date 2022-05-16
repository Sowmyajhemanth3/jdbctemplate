package com.src.mn;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.src.bean.Student;
import com.src.dao.StudentDAOInterface;

public class MainClass {
	
	public static void main(String[] args)
	{
		Scanner sc= new Scanner(System.in);
		ApplicationContext context= new ClassPathXmlApplicationContext("applicationContext.xml");
		
		StudentDAOInterface sdao= (StudentDAOInterface) context.getBean("sdao");

		int choice=0;
		System.out.println("*********Student Management System********");
		do {
			
			System.out.println("choose from following options:");
			System.out.println("1.add\n 2.Delete \n 3.Update \n4.All students\n 5.Search student by id\n 6.Exit");
			choice=sc.nextInt();
			
			switch(choice)
			{
			case 1:
			{
				System.out.println("enter student stdid ");
				String id=sc.next();
				System.out.println("enter student password ");
				String pwd= sc.next();
				System.out.println("enter student name ");
				String name=sc.next();
				System.out.println("enter student address ");
				String address=sc.next();
				System.out.println("enter student age ");
				int age=sc.nextInt();
				System.out.println("enter student mobile ");
				long mob=sc.nextLong();
				Student s = new Student(id,pwd,name,age,address,mob);
				int result=sdao.insertStudent(s);		
				if(result>0)
				{
					System.out.println("values inserted successfully");
				}
				else
				{
					System.out.println("values cannot be inserted");
				}
				
				break;
			}
	
			case 2:
			{
				System.out.println("enter student stdid ");
				String id=sc.next();
			
				Student s = new Student();
				s.setStdid(id);
				int result=sdao.deleteStudent(s);		
				if(result>0)
				{
					System.out.println("values updated successfully");
				}
				else
				{
					System.out.println("values cannot be updated");
				}
				
				break;
			}
			case 3:
			{
				System.out.println("enter student stdid ");
				String id=sc.next();
				System.out.println("enter student password ");
				String pwd= sc.next();
				System.out.println("enter student name ");
				String name=sc.next();
				System.out.println("enter student address ");
				String address=sc.next();
				System.out.println("enter student age ");
				int age=sc.nextInt();
				System.out.println("enter student mobile ");
				long mob=sc.nextLong();
				Student s = new Student(id,pwd,name,age,address,mob);
				int result=sdao.editStudent(s);		
				if(result>0)
				{
					System.out.println("values updated successfully");
				}
				else
				{
					System.out.println("values cannot be updated");
				}
				
				break;
				
			}
			case 4:
			{

				List<Student> students=sdao.getAllStudents();	
				
				for(Student s:students)
				{
					System.out.println(s);
				}
				break;	
			}
			case 5:
			{
				System.out.println("enter student stdid ");
				String id=sc.next();
			
				
				
				List<Student> student=sdao.getStudentById(id);
				
				for(Student s:student)
				{
					System.out.println(s);
				}
				
				break;
			}
			case 6:
			{
				System.out.println("bye bye to STUDENT MANAGEMENT SYSTEM");
			}
			default:System.out.println("it is invalid entry");
			}
			}while(choice!=6);
			}
		
	}



