package com.devi.nexus;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Data
@ToString
public class NexusResultItem implements Serializable {

    private Boolean success;
    private List<NexusResultItemData> data;

}
