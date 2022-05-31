package vn.codegym.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.InMemoryTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import vn.codegym.service.impl.UserDetailsServiceImpl;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig  extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private DataSource dataSource;



//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
//    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();

//         Các trang không yêu cầu login
        http.authorizeRequests().antMatchers("/", "/login", "/log-out").permitAll();

//         Trang /userInfo yêu cầu phải login với vai trò ROLE_USER hoặc ROLE_ADMIN.
//         Nếu chưa login, nó sẽ redirect tới trang /login.
        http.authorizeRequests().antMatchers("/services").access("hasAnyRole('ROLE_USER', 'ROLE_ADMIN','ROLE_SUPER_ADMIN')");

//         Trang chỉ dành cho ADMIN
        http.authorizeRequests().antMatchers("/contracts/*","/customers/*","/services/*","/contracts-detail/*").access("hasAnyRole('ROLE_ADMIN','ROLE_SUPER_ADMIN')");
        http.authorizeRequests().antMatchers("/contracts/*","/customers*/","/services/*","/employees/*").access("hasRole(('ROLE_SUPER_ADMIN'))");

//         Khi người dùng đã login, với vai trò XX.
//         Nhưng truy cập vào trang yêu cầu vai trò YY,
//         Ngoại lệ AccessDeniedException sẽ ném ra.
        http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403-page");

//         Cấu hình cho Login Form.
        http.authorizeRequests().and().formLogin()//
                // Submit URL của trang login
                .loginProcessingUrl("/j_spring_security_check") // Submit URL
                // trang login tự làm
                .loginPage("/login")//
                // mặc định khi log in thành công sẽ vào đây
                .defaultSuccessUrl("/employees")//
                //lỗi thì sẽ vào đây
                .failureUrl("/login?error=true")//
                //username lấy ra từ trong html name đăng nhập
                .usernameParameter("username")//
                //password cũng thế
                .passwordParameter("password")
                // Cấu hình cho Logout Page.
                //log out tự xây dựng và khi log out thành công sẽ đi vào method này
                .and().logout()
                .logoutUrl("/log-out")
                .logoutSuccessUrl("/log-out-success");

        // Cấu hình Remember Me. và thời gian ghi nhớ lấy từ bean dưới
        http.authorizeRequests().and() //
                .rememberMe().tokenRepository(this.persistentTokenRepository()) //
                .tokenValiditySeconds(60 * 60); // 1h

    }
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean // khởi tạo bean token để ghi nhớ phiên đăng nhập
    public PersistentTokenRepository persistentTokenRepository() {
        InMemoryTokenRepositoryImpl memory = new InMemoryTokenRepositoryImpl();
        return memory;
    }
}
