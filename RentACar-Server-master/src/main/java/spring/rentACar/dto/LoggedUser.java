package spring.rentACar.dto;


import spring.rentACar.entity.User;

public class LoggedUser {
    private User user;
    private String token;

    public LoggedUser(User user, String token) {
        this.user = user;
        this.token = token;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
