package com.joezhou.work.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author JoeZhou
 */
@Data
public class Account implements Serializable {
    private Integer id;
    private String username;
    private String password;
}