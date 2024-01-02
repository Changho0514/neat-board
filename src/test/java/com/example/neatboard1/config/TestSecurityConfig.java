package com.example.neatboard1.config;

import com.example.neatboard1.domain.UserAccount;
import com.example.neatboard1.repository.UserAccountRepository;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.event.annotation.BeforeTestMethod;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;

@Import(SecurityConfig.class)
public class TestSecurityConfig {

    @MockBean
    private UserAccountRepository userAccountRepository;

    // 테스트용 계정 정보
    @BeforeTestMethod // Spring Test를 할 때 불러올 수 있게 해줌.
    public void securitySetUp(){
        given(userAccountRepository.findById(anyString())).willReturn(Optional.of(UserAccount.of(
            "chTest",
                "pw",
                "ch-test@email.com",
                "ch-test",
                "test memo"
        )));
    }
}
