package com.devi.txt;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Data
@ToString
public class EmailInfo implements Serializable {

    private String id;

    private String name;

    private String email;

    private List<EmailInfo> ou;

}
