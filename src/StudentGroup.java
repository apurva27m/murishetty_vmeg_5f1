import java.util.*;

/**
 * A fix-sized array of students
 * array length should always be equal to the number of stored elements
 * after the element was removed the size of the array should be equal to the number of stored elements
 * after the element was added the size of the array should be equal to the number of stored elements
 * null elements are not allowed to be stored in the array
 * 
 * You may add new methods, fields to this class, but DO NOT RENAME any given class, interface or method
 * DO NOT PUT any classes into packages
 *
 */
public class StudentGroup implements StudentArrayOperation {

	private Student[] students;
	
	/**
	 * DO NOT remove or change this constructor, it will be used during task check
	 * @param length
	 */
	public StudentGroup(int length) {
		this.students = new Student[length];
	}

	@Override
	public Student[] getStudents() {
		if(this.students == null) throw new IllegalArgumentException();
		else return this.students;
	}
	
	@Override
	public void setStudents(Student[] students) {
		// Add your implementation here
		if( this.getStudents() == null) throw new IllegalArgumentException();
		this.students = students;
	}

	@Override
	public Student getStudent(int index) {
		// Add your implementation here
		if(index > this.getStudents().length || index < 0) throw new IllegalArgumentException();
		return this.getStudents()[index];
	}

	@Override
	public void setStudent(Student student, int index) {
		// Add your implementation here
		
		if(index > this.getStudents().length || index < 0 || student == null) throw new IllegalArgumentException();
		this.getStudents()[index] = student; 
	}

	@Override
	public void addFirst(Student student) {
		// Add your implementation here
		if(student == null) throw new IllegalArgumentException();
         Student[] temp = new Student[this.getStudents().length+1];
		 temp[0] = student;
		 for(int i = 1; i < temp.length; i++)
			 temp[i] = this.students[i-1];
		 this.students = temp;
		
	}

	@Override
	public void addLast(Student student) {
		// Add your implementation here
		if(student == null) throw new IllegalArgumentException();
         ArrayList<Student> temp = new ArrayList<>();
		 for(int i = 0; i < this.getStudents().length; i++)
			 if(this.getStudents()[i] != null) temp.add(this.getStudents()[i]);
		 temp.add(student);
		 this.students = temp.toArray(new Student[temp.size()]);
	}

	@Override
	public void add(Student student, int index) {
		// Add your implementation here
		if(student == null || index < 0 || index > this.getStudents().length) throw new IllegalArgumentException();
         ArrayList<Student> temp = new ArrayList<>();
		 for(int i = 0; i < index; i++)
			 if(this.getStudents()[i] != null) temp.add(this.students[i]);
		 temp.add(student);
		 for(int i = index; i < this.students.length; i++)
			 if(this.getStudents()[i] != null) temp.add(this.students[i]);
		 this.students = temp.toArray(new Student[temp.size()]);
	}

	@Override
	public void remove(int index) {
		// Add your implementation here
		if(index < 0 || index > this.students.length) throw new IllegalArgumentException();
         Student[] temp = new Student[this.getStudents().length-1]; 
		 int c = 0;
		 for(int i = 0; i < this.getStudents().length; i++)
			 if(i != index) temp[c++] = this.getStudents()[i];
		 this.students = temp;
	}

	@Override
	public void remove(Student student) {
		// Add your implementation here
		if(student == null) throw new IllegalArgumentException();
         Student[] temp = new Student[this.students.length-1]; 
		 int c = 0;
		 for(int i = 0; i < this.getStudents().length; i++)
			 if(!this.getStudents()[i].equals(student)) temp[c++] = this.getStudents()[i];
		 this.students = temp;
	}

	@Override
	public void removeFromIndex(int index) {
		// Add your implementation here
		if(index < 0 || index > this.students.length) throw new IllegalArgumentException();
		 Student[] temp = new Student[index]; 
		 int c = 0;
		 for(int i = 0; i < index; i++)
			 temp[i] = this.getStudents()[i];
		 this.students = temp;
	}

	@Override
	public void removeFromElement(Student student) {
		// Add your implementation here
		if(student == null) throw new IllegalArgumentException();
           int ind = this.getStudentIndex(student);
		   ArrayList<Student> temp = new ArrayList<>();
		   for(int i = 0; i < ind; i++)
			   temp.add(this.students[i]);
		   this.students = temp.toArray(new Student[temp.size()]);
	}

	@Override
	public void removeToIndex(int index) {
		// Add your implementation here
		if(index < 0 || index > this.students.length) throw new IllegalArgumentException();
         ArrayList<Student> temp = new ArrayList<>(); 
		 for(int i = index; i < this.getStudents().length; i++)
			 temp.add(this.getStudents()[i]);
		 this.students = temp.toArray(new Student[temp.size()]);
		
	}

	@Override
	public void removeToElement(Student student) {
		// Add your implementation here
				   if(student == null) throw new IllegalArgumentException();
           int ind = this.getStudentIndex(student);
		   ArrayList<Student> temp = new ArrayList<>();
		   for(int i = ind; i < this.students.length; i++)
			   temp.add(this.students[i]);
		   this.students = temp.toArray(new Student[temp.size()]);
	}

	@Override
	public void bubbleSort() {
		// Add your implementation here
		for(int i = 0; i < this.students.length; i++)
		  {
			  
	          for(int j = 0; j < this.students.length-i-1; j++)
			  {
                   if(this.students[j].getFullName().compareTo(this.students[j+1].getFullName()) > 0)
				   {
					   Student temp = this.students[j];
					   this.students[j] = this.students[j+1];
					   this.students[j+1] = temp;
				   }
			  }	   
		  }
	}

	@Override
	public Student[] getByBirthDate(Date date) {
		// Add your implementation here
		if(date == null) throw new IllegalArgumentException();
           ArrayList<Student> temp = new ArrayList<>();
		   for(Student s : this.getStudents())
		   {
		       if(s.getBirthDate().compareTo(date) == 0)
				   temp.add(s);
		   }
		   return  temp.toArray(new Student[temp.size()]);
	}

	@Override
	public Student[] getBetweenBirthDates(Date firstDate, Date lastDate) {
		// Add your implementation here
		if(firstDate == null || lastDate == null) throw new IllegalArgumentException();
         ArrayList<Student> temp = new ArrayList<>();
		   for(Student s : this.students)
		   {
		       if(s.getBirthDate().after(firstDate) && s.getBirthDate().before(lastDate))
				   temp.add(s);
		   }
		   return  temp.toArray(new Student[temp.size()]); 
	}

	@Override
	public Student[] getNearBirthDate(Date date, int days) {
		// Add your implementation here
		if(date == null) throw new IllegalArgumentException();
           ArrayList<Student> temp = new ArrayList<>();
		   Calendar cal = this.getCalendar(date);
		   cal.add(Calendar.DATE, days);
           date = cal.getTime();
		   for(Student s : this.students)
		   {
		       if(s.getBirthDate().before(date))
				   temp.add(s);
		   }
		   return  temp.toArray(new Student[temp.size()]); 
	}

	@Override
	public int getCurrentAgeByDate(int indexOfStudent) {
		// Add your implementation here
		if(indexOfStudent == 0) throw new IllegalArgumentException();
		   int year = Calendar.getInstance().get(Calendar.YEAR);
           return year - this.students[indexOfStudent].getBirthDate().getYear();
	}

	@Override
	public Student[] getStudentsByAge(int age) {
		// Add your implementation here
		ArrayList<Student> temp = new ArrayList<>();
		  for(int i = 0; i < this.students.length; i++)
		  {
		      if(getCurrentAgeByDate(i) == age)
				  temp.add(this.students[i]);
		  }
          return  temp.toArray(new Student[temp.size()]);
	}

	@Override
	public Student[] getStudentsWithMaxAvgMark() {
		// Add your implementation here
		double maxavg = 0;
		  for(Student s : this.students)
			  if(s.getAvgMark() > maxavg) maxavg = s.getAvgMark();
		  ArrayList<Student> temp = new ArrayList<>();
		  for(Student s : this.students)
			  if(s.getAvgMark() == maxavg)  temp.add(s);
		  return  temp.toArray(new Student[temp.size()]);
	}

	@Override
	public Student getNextStudent(Student student) {
		// Add your implementation here
		if(student == null) throw new IllegalArgumentException();
           this.bubbleSort();
		   int i;
		   for(i = 0; i < this.students.length; i++)
			   if(this.students[i].equals(student)) break;
		   return this.students[i+1];
	}
	
	private int getStudentIndex(Student student) {
         if(student == null) throw new IllegalArgumentException();
		 for(int i = 0; i < this.students.length; i++)
			 if(this.students[i].equals(student)) return i;
		 return -1;
    }

	private int getDiffYears(Date first, Date last) {
            return first.getYear() - last.getYear();
	}

	private Calendar getCalendar(Date date) {
          Calendar aDay = Calendar.getInstance();
          aDay.setTime(date);
		  return aDay;
	}
	
}
