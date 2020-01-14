package com.darecode.config;

//public class JWTAuthenticationFilter {extends BasicAuthenticationFilter{

//private GoogleTokenVerifier tokenVerifier;
	
//	public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
//		super(authenticationManager);
//		tokenVerifier = new GoogleTokenVerifier();
//	}







//	@Override
//	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
//			throws IOException, ServletException {
//	
//		
//		HttpServletRequest req = (HttpServletRequest) request;
//		GoogleUser user = tokenVerifier.readUserInformation(req.getHeader("Authorization"));
//		req.getSession().setAttribute("user", user);
//		chain.doFilter(request, response);
//		
//	}
	
//	@Override
//	protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
//			throws IOException, ServletException {
//		GoogleUser user = tokenVerifier.readUserInformation(req.getHeader("Authorization"));
//		req.getSession().setAttribute("user", user);
//		chain.doFilter(req, res);
//	}


//}
