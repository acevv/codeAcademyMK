package org.test.student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	AddressDAO addressDAO = new AddressDAOImpl();
//    	System.out.println(addressDAO.createAddressTable());
    	
    	StudentDAO studentDAO = new StudentDAOImpl();
//    	System.out.println(studentDAO.createStudentTable());
    	
    	Address add = new Address(3, "Ilindenska", "11", "Skopje");
//    	addressDAO.createAddress(add);
    	
    	Student st1 = new Student("333", "Ognen", "Ilioski", add.getId(), "CS");
//    	studentDAO.createStudent(st1);
    	
    	studentDAO.getAllStudents();
//    	addressDAO.getAddressById(1);
    }
}
