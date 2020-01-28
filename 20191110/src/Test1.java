class UserError extends Exception {
    public UserError (String message) {
        super(message);
    }
}
class PasswordError extends Exception {
    public PasswordError (String message) {
        super(message);
    }
}
public class Test1 {
    private static String userName = "admin";
    private static String password = "123456";
    public static void main(String[] args) {
        try {
            login("admin","123456");
        } catch (PasswordError | UserError passwordError) {
            passwordError.printStackTrace();
        }
    }
    public static void login(String userName,String password) throws UserError, PasswordError {
        if (! Test1.userName.equals(userName)) {
            //处理用户名错误
            throw new UserError("用户名错误");
        }
        if (! Test1.password.equals(password))  {
            //处理密码错误
            throw new PasswordError("密码错误");
        }
        System.out.println("登录成功");
    }
}
