package servlet.user.db;

public class UserDb {

    public static String DeleteUser(String username) {
        String sql = "DELETE FROM `as_user_db`.`UserTable` WHERE (`username` = '" + username + "');";
        return sql;
    }

    public static String SelectUser(String username) {
        String sql = "SELECT * FROM as_user_db.UserTable WHERE username = '" + username + "'";
        return sql;
    }

    public static String InsertUser() {
        String sql = "INSERT INTO as_user_db.UserTable (id,username, password,avatar,phone,mcc,email) VALUES (?, ?, ?, ?, ?, ?, ?);";
        return sql;
    }

}
