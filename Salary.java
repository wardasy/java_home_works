public class Salary {     
	public static void main(String[] args){
		 Employee E=new Employee(50000);
		 System.out.print("salary is " + E.getName() + ": " + E.ComputeSalary()+"\n");
		
		 E = new SalesEmployee(6000,10);
		 System.out.print("salary is " + E.getName() + ": " + E.ComputeSalary()+"\n");

		 Manager M=new Manager(7000, (float)4.5);
		 System.out.print("salary is " + M.getName() + ": " + M.ComputeSalary()+"\n");

		 SalesEmployee Sale_E= new SalesEmployee((float) 8000.00 ,(float) 4.5);
		 System.out.print("salary is " + Sale_E.getName() + ": " + Sale_E.ComputeSalary()+"\n");

		 SalesManager Sale_M= new SalesManager((float) 4343.30 ,(float) 3,(float) 3);
		 System.out.print("salary is " + Sale_M.getName() + ": " + Sale_M.ComputeSalary()+"\n");

	 }
}
		
