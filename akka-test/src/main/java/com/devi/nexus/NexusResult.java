package com.devi.nexus;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class NexusResult implements Serializable {
    private String tid;
    private String action;

    private String method;

    private NexusResultItem result;

}
