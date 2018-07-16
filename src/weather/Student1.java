package  weather;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;


public class Student1 extends HttpServlet {

	public String gettid() {
		return tid;
	}

	public void settid(String tid) {
		this.tid = tid;
	}

	public String getque() {
		return que;
	}

	public void setque(String que) {
		this.que = que;
	}



	public void setanw(String anw) {
		this.anw = anw;
	}

	

	public String tid;
	public String que;
	public String opt1;
	public String opt2;
	public String opt3;
	public String opt4;
	public String anw;
	public Student1() {
		
	}
	public Student1(String tid, 
			String que, String opt1, 
			String opt2, String opt3,String opt4,String anw) {
		this.tid = tid;
		this.que = que;
		this.anw = anw;
		this.opt1 = opt1;
		this.opt2 = opt2;
		this.opt3 = opt3;
		this.opt4 = opt4;
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
doPost(request, response);
}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
		try {
			DBConnection b =new DBConnection();
			Random r = new Random();
			int[] i={-1,-1,-1,-1,-1};
			for(int j=0;j<=4;j++)
			{
				i[j]=r.nextInt(57);
				for(int n=0;n<j;n++)
				{
					if(i[n]==i[j])
					{
						j--;
					}
				}
			}
			
		/*	for(int j=0;j<5;j++)
			{
			System.out.println(i[j]);
			}*/
			String sql="select * from ware where tid="+i[0];
			System.out.println(sql);
			
			ResultSet rs = b.executeQuery(sql);
			
			Student1 s1=new Student1();
			Student1 s2=new Student1();
			Student1 s3=new Student1();
			Student1 s4=new Student1();
			int j=1;
			response.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();
			JSONObject obj1 = new JSONObject();
			while(rs.next()){
				
				s1.tid=rs.getString("tid");
				s1.que=rs.getString("que");
				s1.opt1=rs.getString("opt1");
				s1.opt2=rs.getString("opt2");
				s1.opt3=rs.getString("opt3");
				s1.opt4=rs.getString("opt4");
				s1.anw=rs.getString("anw");
				
				obj1.put("que", s1.que);
				obj1.put("anw", s1.anw);
				obj1.put("A", s1.opt1);
				obj1.put("B", s1.opt2);
				obj1.put("C", s1.opt3);
				obj1.put("D", s1.opt4);
				System.out.println(obj1.toString());
			
				j++;
			}
			
			 sql="select * from ware where tid="+i[1];
			 rs = b.executeQuery(sql);
			JSONObject obj2 = new JSONObject();
			while(rs.next()){
				
				s2.tid=rs.getString("tid");
				s2.que=rs.getString("que");
				s2.opt1=rs.getString("opt1");
				s2.opt2=rs.getString("opt2");
				s2.opt3=rs.getString("opt3");
				s2.opt4=rs.getString("opt4");
				s2.anw=rs.getString("anw");
				
				obj2.put("que", s2.que);
				obj2.put("anw", s2.anw);
				obj2.put("A", s2.opt1);
				obj2.put("B", s2.opt2);
				obj2.put("C", s2.opt3);
				obj2.put("D", s2.opt4);
				System.out.println(obj2.toString());
				
				j++;
			}
			 sql="select * from ware where tid="+i[2];
			 rs = b.executeQuery(sql);
			JSONObject obj3 = new JSONObject();
			while(rs.next()){
				
				s3.tid=rs.getString("tid");
				s3.que=rs.getString("que");
				s3.opt1=rs.getString("opt1");
				s3.opt2=rs.getString("opt2");
				s3.opt3=rs.getString("opt3");
				s3.opt4=rs.getString("opt4");
				s3.anw=rs.getString("anw");
				
				obj3.put("que", s3.que);
				obj3.put("anw", s3.anw);
				obj3.put("A", s3.opt1);
				obj3.put("B", s3.opt2);
				obj3.put("C", s3.opt3);
				obj3.put("D", s3.opt4);
				System.out.println(obj3.toString());
				
				j++;
			}
			
			 sql="select * from ware where tid="+i[3];
			 rs = b.executeQuery(sql);
			JSONObject obj4 = new JSONObject();
			while(rs.next()){
				
				s4.tid=rs.getString("tid");
				s4.que=rs.getString("que");
				s4.opt1=rs.getString("opt1");
				s4.opt2=rs.getString("opt2");
				s4.opt3=rs.getString("opt3");
				s4.opt4=rs.getString("opt4");
				s4.anw=rs.getString("anw");
				
				obj4.put("que", s4.que);
				obj4.put("anw", s4.anw);
				obj4.put("A", s4.opt1);
				obj4.put("B", s4.opt2);
				obj4.put("C", s4.opt3);
				obj4.put("D", s4.opt4);
				System.out.println(obj4.toString());
				
				j++;
			}
			JSONObject obj = new JSONObject();
			obj.put("obj1", obj1);
			obj.put("obj2", obj2);
			obj.put("obj3", obj3);
			obj.put("obj4", obj4);
			out.print(obj.toString());
			out.flush();
			out.close();
			b.close();
		}
		/*	String sql = "select * into student(id,name,age,dept,address) values('1507','Tom',20,'1','1')";
			
			b.execute(sql);
			ResultSet rs = b.executeQuery("select * from student");
			
			ArrayList<Student1> list = new ArrayList();
			while(rs.next()){
				String id = rs.getString(1);
				String name = rs.getString(2);
				int age = rs.getInt(3);
				String dept = rs.getString(4);
				String address = rs.getString(5);
				Student1 t = new Student1();
				list.add(t);
			}
			b.close();
			
			int j=0;
			int[] ques= {-1,-1,-1,-1};
			while(j<4) {
				int randnumber = r.nextInt(list.size());
				System.out.println(randnumber);
				//if not exist 
				ques[j] = randnumber;
				j++;
			}
			
			for(int k=0;k<4;k++) {
				Student1 s = list.get(k);
				System.out.println(s.gettid());
				System.out.println(s.getque());
			}
			
		}*/catch(Exception e){
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args){
		/*try {
			DBConnection b =new DBConnection();
			Random r = new Random();
			int[] i={-1,-1,-1,-1,-1};
			for(int j=0;j<=4;j++)
			{
				i[j]=r.nextInt(10);
				for(int n=0;n<j;n++)
				{
					if(i[n]==i[j])
					{
						j--;
					}
				}
			}
			
			for(int j=0;j<5;j++)
			{
			System.out.println(i[j]);
			}
			String sql="select * from ware where tid="+i[0]+" or tid="+i[1]+" or tid="+i[2]+" or tid="+i[3]+" or tid="+i[4];
			System.out.println(sql);
			
			ResultSet rs = b.executeQuery(sql);
			ArrayList<Student1> list = new ArrayList();
			Student1 s1=new Student1();
			Student1 s2=new Student1();
			Student1 s3=new Student1();
			Student1 s4=new Student1();
			int j=1;
			while(rs.next()){
				
				s1.tid=rs.getString("tid");
				s1.que=rs.getString("que");
				s1.opt1=rs.getString("opt1");
				s1.opt2=rs.getString("opt2");
				s1.opt3=rs.getString("opt3");
				s1.opt4=rs.getString("opt4");
				s1.anw=rs.getString("anw");
				JSONObject obj = new JSONObject();
				obj.put("µÚ"+j+"Ìâ", s1.que);
				obj.put("A", s1.opt1);
				obj.put("B", s1.opt2);
				obj.put("C", s1.opt3);
				obj.put("D", s1.opt4);
				System.out.println(obj.toString());
				j++;
			}
	
			b.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}*/
		
	}

}
