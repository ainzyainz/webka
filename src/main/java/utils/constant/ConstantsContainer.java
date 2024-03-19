package utils.constant;

public class ConstantsContainer {

    public static final String GET_ALL_STUDENT_QUERY = "select s from Student s";

    public static final String GET_SEARCH = "from Student where name = :value or  surname = :value or address = :value or age = :value or mark = :value";
    public static final String FROM_STUDENT = "from Student";

    public static final String CREATE_FAILED_MSG = "Create failed. Nothing found";
    public static final String CREATE_SUCCESS_MSG = "Entity created";

    public static final String READ_FAILED_MSG = "Read failed. Nothing found";
    public static final String READ_SUCCESS_MSG = "Read the entity";

    public static final String UPDATE_FAILED_MSG = "Update failed. Nothing found";
    public static final String UPDATE_SUCCESS_MSG = "Updated the entity";

    public static final String DELETE_FAILED_MSG = "Delete failed. Nothing found";
    public static final String DELETE_SUCCESS_MSG = "Deleted the entity";

    public static final String START_GET_ALL_STUDENT = "Method getAllStudents is start";
    public static final String GET_ALL_STUDENT_SUCCESSFUL = "Method getAllStudents successful";

    public static final String EMPTY_VALUE = " ";
    public static final String VALUE = "value";
    public static final String LIST_OF_STUDENTS_EMPTY = "list of students is empty";

    public static final Integer ROW_IN_PAGE = 5;
    public static final String STRING_NULL = "0";
    public static final String MARK_IS_NULL = "-1";
    public static final String PAGE = "page";
    public static final Double PAGE_COEFFICIENT = 1.0;

    private ConstantsContainer() {}
}
