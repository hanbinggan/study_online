package cn.edu.upc.study_online.dao.object;


import org.springframework.stereotype.Component;

/**
 * Created by songqiaolin on 2017/3/26.
 */
@Component
public class AdminDo {
    private Long id;
    private String name;
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
