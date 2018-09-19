package com.devi.nexus;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@ToString
@Data
public class NexusResultItemData implements Serializable {
    private String id;
    private String name;
}
