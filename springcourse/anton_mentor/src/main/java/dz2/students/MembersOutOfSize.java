package dz2.students;

public class MembersOutOfSize extends Exception {
    @Override
    public String getMessage() {
        return "Превышено количество студентов в группе!!!";
    }
}
