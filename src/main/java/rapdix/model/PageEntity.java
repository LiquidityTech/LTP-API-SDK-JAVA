package rapdix.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PageEntity<T> {
    private Integer page;
    private Integer pageSize;
    private Integer pageNum;
    private Integer totalSize;
    private List<T> list;
}
