package com.joezhou.work.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author JoeZhou
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account implements Serializable {
    private Integer id;
    private String username;
    private String password;
}