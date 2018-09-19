package com.devi.nexus;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class NexusListData implements Serializable {

    private String id;
    private String repositoryName;
    private String group;
    private String name;
    private String version;
    private String format;
}
