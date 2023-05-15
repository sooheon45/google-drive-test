package googledrivetest.domain;

import googledrivetest.infra.AbstractEvent;
import java.util.*;
import lombok.Data;

@Data
public class FileIndexed extends AbstractEvent {

    private Long id;
    private Long fileId;
}
