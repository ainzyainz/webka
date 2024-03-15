package utils;

public class Constants {
    public static final String CREATE_FAILED_MSG = "Create failed. Nothing found";
    public static final String CREATE_SUCCESS_MSG = "Entity created";

    public static final String READ_FAILED_MSG = "Read failed. Nothing found";
    public static final String READ_SUCCESS_MSG = "Read the entity";

    public static final String UPDATE_FAILED_MSG = "Update failed. Nothing found";
    public static final String UPDATE_SUCCESS_MSG = "Updated the entity";

    public static final String DELETE_FAILED_MSG = "Delete failed. Nothing found";
    public static final String DELETE_SUCCESS_MSG = "Deleted the entity";

    public static final String FIND_EMAIL_SUCCESS = "Read the entity by email";
    public static final String FIND_EMAIL_FAILED = "Read failed. Email not found";

    public static final String FIND_NAME_SUCCESS = "Read the entity by name";
    public static final String FIND_NAME_FAILED = "Read failed. Name not found";
    
    public static final String CUSTOMER_EMAIL_QUERY = "SELECT * from customer where email = ";
    public static final String STORAGE_NAME_QUERY = "SELECT * from storage WHERE name = ";
}
