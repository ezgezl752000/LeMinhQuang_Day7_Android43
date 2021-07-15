package Presenter;

public class LoginPresenter {
    models.iLogin iLogin;

    public LoginPresenter(models.iLogin iLogin) {
        this.iLogin = iLogin;
    }

    public void onLogin(String username, String password){
        if(username.equals("admin") && password.equals("password"))
            iLogin.onLoginSuccess("Đăng nhập thành công");
        else iLogin.onLoginError("Đăng nhập thất bại");
    }
}
