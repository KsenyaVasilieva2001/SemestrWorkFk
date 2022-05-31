package ru.kpfu.itis.skatingblog.security.filters;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;
import ru.kpfu.itis.skatingblog.dto.SignUpForm;
import ru.kpfu.itis.skatingblog.dto.UserDto;
import ru.kpfu.itis.skatingblog.models.User;
import ru.kpfu.itis.skatingblog.services.UserService;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;
import java.util.Optional;

@Component
public class GoogleFilter extends GenericFilterBean {

    private final UserService userService;

    @Autowired
    public GoogleFilter(UserService userService) {
        this.userService = userService;
    }

    @SneakyThrows
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        HttpSession session = ((HttpServletRequest) servletRequest).getSession();

        if (authentication != null && session.getAttribute("user") == null && authentication instanceof OAuth2AuthenticationToken) {
            DefaultOidcUser authUser = (DefaultOidcUser) authentication.getPrincipal();
            Map<String, Object> attributes = authUser.getAttributes();

            SignUpForm signUpForm = SignUpForm.builder()
                    .email((String) attributes.get("email"))
                    .firstName((String) attributes.get("given_name"))
                    .lastName((String) attributes.get("family_name"))
                    .password("")
                    .build();
            User user;
            Optional<User> optionalUserDto = userService.findUserByEmail(signUpForm.getEmail());
            if (!optionalUserDto.isPresent()) {

                userService.registerUser(signUpForm);
                user = userService.findUserByEmail(signUpForm.getEmail()).get();
            } else {
                user = optionalUserDto.get();
            }

            session.setAttribute("authUser", user);
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }
}
