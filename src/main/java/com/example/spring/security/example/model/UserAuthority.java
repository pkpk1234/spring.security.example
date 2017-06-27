package com.example.spring.security.example.model;

import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by pkpk1234 on 2017/6/27.
 */
@Entity
@ToString
@NoArgsConstructor
public class UserAuthority implements GrantedAuthority {
    @Id
    @GeneratedValue
    private Long id;

    private String authority;

    public UserAuthority(String authority) {
        this.authority = authority;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
