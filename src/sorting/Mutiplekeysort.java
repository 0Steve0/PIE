package sorting;
import java.util.Comparator;
/**
 * ClassName: Mutiplekeysort
 * Description: A class that implement mutiple key sort
 * Date: 2017-4-29
 *
 * Update History:
 *
 * @version 1.0
 * @author Steve Shao
 */
class Employee implements Comparator<Employee>{
	private String extension;
	private String givenname;
	private String surname;
	//constructor
	public Employee(String extension,String givenname,String surname){
		setExtension(extension);
		setGivenname(givenname);
		setSurname(surname);	
	}
	//set and get methods
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getGivenname() {
		return givenname;
	}
	public void setGivenname(String givenname) {
		this.givenname = givenname;
	}
	public String getExtension() {
		return extension;
	}
	public void setExtension(String extension) {
		this.extension = extension;
	}

	public int compare(Employee e1, Employee e2){
		//Compare surnames
		int ret=e1.getSurname().compareToIgnoreCase(e2.getSurname());
		if(ret==0)
			ret=e1.getGivenname().compareToIgnoreCase(e2.getGivenname());
		return ret;
	}
}
/*
 * test main function
 */
public class Mutiplekeysort{
	public static void main(String[] args){
		Employee employee1 = new Employee("1","camila","johnson");
		Employee employee2 = new Employee("1","camila","johnson");
		System.out.print(employee1.compare(employee1,employee2));
	}
}
