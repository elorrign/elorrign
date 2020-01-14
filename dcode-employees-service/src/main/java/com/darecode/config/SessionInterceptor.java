package com.darecode.config;

/*@Slf4j
public class SessionInterceptor extends HandlerInterceptorAdapter {

	private static final long MAX_INACTIVE_SESSION_TIME = 5 * 10000;

	@Autowired
	private HttpSession session;

	@Autowired
	private GoogleTokenVerifier googleVerifier;
	
	@Override
	public boolean preHandle(final HttpServletRequest request, final HttpServletResponse response, final Object handler)
			throws Exception {
		log.info("Pre handle method - check handling start time");
		long startTime = System.currentTimeMillis();
		request.setAttribute("executionTime", startTime);
		GoogleUser user = googleVerifier.readUserInformation(request.getHeader("Authorization"));
		if (user != null) {
			session = request.getSession();
			log.info("Time since last request in this session: {} ms",
					System.currentTimeMillis() - request.getSession().getLastAccessedTime());
			session.setAttribute("user", user);
			if (System.currentTimeMillis() - session.getLastAccessedTime() > MAX_INACTIVE_SESSION_TIME) {
				log.warn("Logging out, due to inactive session");
//				SecurityContextHolder.clearContext();
				request.logout();
//				response.sendRedirect("/spring-security-rest-full/logout");
				response.sendRedirect("/logout");
			}
		}
		return true;
	}

	@Override
	public void postHandle(final HttpServletRequest request, final HttpServletResponse response, final Object handler,
			final ModelAndView model) throws Exception {
		log.info("Post handle method - check execution time of handling");
		long startTime = (Long) request.getAttribute("executionTime");
		log.info("Execution time for handling the request was: {} ms", System.currentTimeMillis() - startTime);
	}

}*/
