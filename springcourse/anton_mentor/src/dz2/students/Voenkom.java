package dz2.students;

public interface Voenkom {
    default Student[] searchPrizivnik(Student[] students){
        int count = 0;
        for(int i = 0;i<students.length;i++){
            if(students[i]!=null && students[i].getAge()>18) count++;
        }
        Student[] prizivniki = new Student[count];
        for(int i = 0;i<students.length;i++){
            if(students[i]!=null && students[i].getAge()>18) prizivniki[i]=students[i];
        }
        return prizivniki;
    }
}
