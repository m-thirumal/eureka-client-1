/**
 * 
 */
package in.thirumal.config;

import java.util.IntSummaryStatistics;

import org.springframework.stereotype.Component;

/**
 * @author thirumal
 *
 */
@Component
public class FeignFallbackFactory implements ClientFeign {

//	@Override
//	public ClientFeign create(Throwable cause) {
//		String httpStatus = cause instanceof FeignException ? Integer.toString(((FeignException) cause).status()) : "";
//		return new ClientFeign() {
//			@Override
//			public IntSummaryStatistics getSummaryStatistics() {
//				System.out.println(httpStatus);
//				if (cause instanceof FeignException) {
//					System.out.println("Client is not available or something");
//					return IntStream.range(0, 0).summaryStatistics();
//				} else {
//					System.out.println("Other exception");
//					return IntStream.range(0, 0).summaryStatistics();
//				}
//			}
//		};
//	}

	@Override
	public IntSummaryStatistics getSummaryStatistics() {
		// TODO Auto-generated method stub
		return null;
	}

//
//	  FeignDecorators decorators = FeignDecorators.builder()
//            .withFallbackFactory(FeignFallback::new)
//            .build();
}
