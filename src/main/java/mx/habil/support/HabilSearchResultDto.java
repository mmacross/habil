package mx.habil.support;

import java.util.List;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode(callSuper=false)
public class HabilSearchResultDto<T> extends HabilDto{
	private static final long serialVersionUID = 20150113666L;
	
	private @Getter @Setter Long count;
	private @Getter @Setter List<T> rows;
}
