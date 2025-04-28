package listeners;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

public class RetryLisener implements IAnnotationTransformer {
	@Override
	public void transform(final ITestAnnotation annotation, final Class testClass, final Constructor testConstructor,
			final Method testMethod) {
		annotation.setRetryAnalyzer(retry.Retry.class);//retry will work only if we have a test case that has failed
	}

}
