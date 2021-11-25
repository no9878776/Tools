//package BeanTool;
//
//import org.soul.commons.log.Log;
//import org.soul.commons.log.LogFactory;
//import org.springframework.beans.BeansException;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.ApplicationContextAware;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//import org.springframework.web.context.request.ServletWebRequest;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.util.Map;
//
///**
// * Spring Bean工具类，同时它负责spring上下文注入
// *
// *
// */
//public class SpringTool implements ApplicationContextAware {
//
//	private static final Log LOG = LogFactory.getLog(ApplicationContextAware.class);
//	private static ApplicationContext appContext;
//
//	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
//		org.soul.commons.spring.utils.SpringTool.appContext = applicationContext;
//		LOG.debug("初始化Spring上下文成功。");
//	}
//
//	/**
//	 * 获取 ApplicationContext
//	 */
//	public static ApplicationContext getApplicationContext() {
//		//		if (null == appContext) {
//		//			appContext = ContextLoader.getCurrentWebApplicationContext();
//		//		}
//		return appContext;
//	}
//
//	/**
//	 * 获取 Bean
//	 *
//	 * @param beanName bean 名称
//	 * @return
//	 */
//	public static Object getBean(String beanName) {
//		checkApplicationContext();
//		return getApplicationContext().getBean(beanName);
//	}
//
//	/**
//	 * 获取 Bean
//	 *
//	 * @param clazz bean 类
//	 * @return
//	 */
//	@SuppressWarnings("unchecked")
//	public static <T> T getBean(Class<T> clazz) {
//		checkApplicationContext();
//		Map<?, ?> map = getApplicationContext().getBeansOfType(clazz);
//		return map.isEmpty() ? null : (T) map.values().iterator().next();
//	}
//
//	/**
//	 * 检查 ApplicationContext 是否注入
//	 */
//	private static void checkApplicationContext() {
//		if (null == getApplicationContext()) {
//			throw new IllegalStateException("applicaitonContext未注入");
//		}
//	}
//
//	public static HttpServletRequest getRequest() {
//		return ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();
//	}
//
//	public static HttpServletResponse getResponse() {
//		return ((ServletWebRequest)RequestContextHolder.getRequestAttributes()).getResponse();
//	}
//
//}
