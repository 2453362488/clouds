package com.example.api.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data       // getset
@ToString
@Accessors(chain = true)    // 链式风格 例如new Dept().setName("").setName();
public class Dept implements Serializable {

    private String name;

}
